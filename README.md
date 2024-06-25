# Sistema-de-Gerenciamento-ESP32
Sistema de coleta de informações via ESP32, conexão com banco de dados e exportação para plataforma de nuvem TAGOIO.

Neste projeto, foi proposto um Sistema Inteligente com o objetivo de gerenciar 3 sensores (DHT11, sensor fotossensível e sensor de umidade no solo) controlados pela controladora ESP32.

Ao todo, são coletadas 4 variáveis pela ESP32 - umidade do solo, luminosidade, umidade do ar e temperatura ambiente - todas elas são transmitidas via protocolo MQTT para um servidor broker que roda localmente. Através do Java, desenvolvemos um middleware capaz de capturar os dados transmitidos ao broker e exibi-los em uma interface simples, além de salvá-los no banco de dados.

O Node-RED lê os dados desse banco e os exporta para a plataforma de nuvem TAGOIO, onde podem ser exibidos em dashboards interativos.
