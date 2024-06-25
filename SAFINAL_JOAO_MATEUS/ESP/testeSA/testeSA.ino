#include <WiFi.h>
#include <DNSServer.h>
#include <WebServer.h>
#include <WiFiManager.h>
#include <PubSubClient.h>
#include <DHT11.h>
#define MSG_BUFFER_SIZE (50)

const int PIN_AP = 33;
int huimS = 5;
WiFiClient espClient;                
PubSubClient client(espClient); 

bool shouldSaveConfig = false;
unsigned long previousMillis = 0;
DHT11 dht11(18);
unsigned int PORT = 1883;
const char* ID = "ESP32JOAO";
const char* mqttServer = "192.168.2.0"; 

char msg[MSG_BUFFER_SIZE];                  // Buffer de mensagens
float temperatureC = 35.7;                  // Variáveis para guardar as informações que 
int umidade = 23.5;   

char msgtemp[50];
char msghumi[50];
char msglumi[50];
char msghumiS[100];

WiFiManager wifiManager;

// Função de callback para tratar as informações mqtt recebidas pelo ESP32
void mqttCallback(char* topic, byte* payload, unsigned int length) {
  // message received
  Serial.println("Algo foi recebido na função de Callback");
  // Coloque aqui o código de processamento das mensagens mqtt recebidas
}

// Função callback de tratamento que indica que o ESP entrou no modo AP
void configModeCallback(WiFiManager* myWiFiManager) {
  //  Serial.println("Modo de configuração iniciado");
  Serial.println("Entrou no modo de configuração");
  Serial.println(WiFi.softAPIP());                       //imprime o IP do AP
  Serial.println(myWiFiManager->getConfigPortalSSID());  //imprime o SSID criado da rede
}

// Função callback de tratamento que indica que salvamos uma nova rede para se conectar (modo estação)
void saveConfigCallback() {
  Serial.println("Configuração salva");
  Serial.println(WiFi.softAPIP());  //imprime o IP do AP
  delay(2000);
}

// Função para gerenciar a conexão ao servidor Broker
void mqttReconnect() {
  // Código reconecte extraido do exemplo da biblioteca PubSubClient
  if (!client.connected()) {

    Serial.println("Tentando Conexão ao Broker...");
    if (client.connect("Esp32")) {
      Serial.println("MQTT Client   : [ conectado ao Broker ]");

      client.subscribe("teste");        // Exemplo de subscrição em um tópico chamado de "teste
    }
    else{
      Serial.print("Conexão falhou, rc=");                    // Caso a tentativa de conexão tenha falhado 
      Serial.print(client.state());                           // uma nova tentativa será feita a cada
      Serial.println(" tentando novamente em 5 segundos");    // 5 segundos.
      // Wait 5 seconds before retrying
      delay(1000);
    
    }
  }
}

void SerializeAndPublish() {

  if (!client.connected())  // Reconecta se a conexão ao Broker MQTT é perdida.
  { 
    mqttReconnect(); 
  }
  readTempHumi();
  readLumi();
  readHuimS();
}

void readTempHumi(){
  delay(10000);
  temperatureC = dht11.readTemperature();
  umidade = dht11.readHumidity();

  //temperature = 1.0;
  //humidity = 2;
  Serial.println("Humidade: ");
  Serial.println(umidade);
  Serial.println("Temperatura: ");
  Serial.println(temperatureC);
  sprintf(msghumi, "%.2d", umidade);
  sprintf(msgtemp, "%.f", temperatureC);

  //Serial.println(msgtemp);
  //Serial.println(msghumi);

  client.publish("data/temp", msgtemp);
  client.publish("data/humi", msghumi);
}

void readLumi(){
  delay(3000);
  int lumi = digitalRead(34);
  if(lumi == 0){
    lumi = 1;
  }else{
    lumi = 0;
  }
  Serial.println("Luminosidade: ");
  Serial.println(lumi);
  sprintf(msglumi, "%d", lumi);
  client.publish("data/lumi", msglumi);
}

void readHuimS(){
  delay(5000);
  huimS = analogRead(35);
  huimS = map(huimS,0,4095,0,100);
  Serial.println("Humidade do solo: ");
  Serial.println(huimS);
  sprintf(msghumiS, "%.2d", huimS);
  client.publish("data/humids", msghumiS);
}


void setup() {
  Serial.begin(115200);
  pinMode(PIN_AP, INPUT);
  pinMode(18, INPUT);
  pinMode(35, INPUT);
  pinMode(34, INPUT);
  pinMode(33, INPUT);

  // Função de callback para tratamento quando entrar em modo de configuração AP
  wifiManager.setAPCallback(configModeCallback);

  // Função callback para tratamento quando se conectar em uma rede, ou seja, quando passa a trabalhar em modo estação
  wifiManager.setSaveConfigCallback(saveConfigCallback);

  // Cria uma rede temporária para acessar o AP com SSID "ESP32_AP"
  wifiManager.autoConnect("ESP32_AP");

  client.setServer(mqttServer, 1883);         // Configura o servidor Broker com o IP e PORTA
  client.setCallback(mqttCallback);           // Define a função callback a ser utilizada, nesse caso a função se chama mqttCallback
}

void loop() {

  // Verifica se o botão de reset foi pressionado para entrar no modo AP
  if (digitalRead(PIN_AP) == LOW) {
    Serial.println("resetar");  //tenta abrir o portal
    if (!wifiManager.startConfigPortal("ESP32_APJOAO")) {
      Serial.println("Falha ao conectar");
      delay(2000);
      ESP.restart();
      delay(1000);
    }
    Serial.println("Conectou ESP_AP!!!");
  }

  // Verifica se o cliente mqtt está conectado ao Broker, caso contrário tenta conectar-se
  if (WiFi.status() == WL_CONNECTED) {
    if (!client.connected()) {
      mqttReconnect();
      }
    }
  client.loop();

  // Temporiza a chamada da função de Serialização JSON e Publicação de dados
  unsigned long currentMillis = millis();
  if (currentMillis - previousMillis >= 10 * 100) {
    previousMillis = currentMillis;
    SerializeAndPublish();
  }
}

  
