/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mqtt_cliente_sub;

import static java.awt.Color.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import sig_dao.ModuloConexao;

/**
 *
 * @author gmtci
 */
public class MqttSub extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    /**
     * Creates new form MqttSub
     */
    public MqttSub() {
        
        initComponents();       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jBtnConectar = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblBroker = new javax.swing.JLabel();
        jtxtBroker = new javax.swing.JTextField();
        lblHumid = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblLumi = new javax.swing.JLabel();
        lblHumids = new javax.swing.JLabel();
        jtxtTemp = new javax.swing.JTextField();
        jtxtHumids = new javax.swing.JTextField();
        jtxtLumi = new javax.swing.JTextField();
        jtxtHumid = new javax.swing.JTextField();
        lblDB = new javax.swing.JLabel();
        jtxtDB = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 127, 255));

        jPanel2.setBackground(new java.awt.Color(230, 247, 255));

        jBtnConectar.setBackground(new java.awt.Color(76, 175, 80));
        jBtnConectar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnConectar.setText("Conectar");
        jBtnConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnConectarMouseClicked(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(51, 51, 51));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("Sistema de Gerenciamento do Banco de Dados");

        lblBroker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBroker.setText("MQTT Broker:");

        jtxtBroker.setBackground(new java.awt.Color(255, 0, 51));
        jtxtBroker.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtxtBroker.setText("Desconectado");
        jtxtBroker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBrokerActionPerformed(evt);
            }
        });

        lblHumid.setBackground(new java.awt.Color(51, 51, 51));
        lblHumid.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHumid.setText("Humidade:");

        lblTemp.setBackground(new java.awt.Color(51, 51, 51));
        lblTemp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTemp.setText("Temperatura:");

        lblLumi.setBackground(new java.awt.Color(51, 51, 51));
        lblLumi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLumi.setText("Luminosidade:");

        lblHumids.setBackground(new java.awt.Color(51, 51, 51));
        lblHumids.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHumids.setText("Umidade do Solo:");

        jtxtTemp.setBackground(new java.awt.Color(230, 247, 255));
        jtxtTemp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtTemp.setForeground(new java.awt.Color(77, 77, 77));
        jtxtTemp.setText("0°");
        jtxtTemp.setBorder(null);
        jtxtTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtTempActionPerformed(evt);
            }
        });

        jtxtHumids.setBackground(new java.awt.Color(230, 247, 255));
        jtxtHumids.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtHumids.setForeground(new java.awt.Color(77, 77, 77));
        jtxtHumids.setText("0%");
        jtxtHumids.setBorder(null);
        jtxtHumids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHumidsActionPerformed(evt);
            }
        });

        jtxtLumi.setBackground(new java.awt.Color(230, 247, 255));
        jtxtLumi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtLumi.setForeground(new java.awt.Color(77, 77, 77));
        jtxtLumi.setText("-");
        jtxtLumi.setBorder(null);
        jtxtLumi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtLumiActionPerformed(evt);
            }
        });

        jtxtHumid.setBackground(new java.awt.Color(230, 247, 255));
        jtxtHumid.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jtxtHumid.setForeground(new java.awt.Color(77, 77, 77));
        jtxtHumid.setText("0%");
        jtxtHumid.setToolTipText("");
        jtxtHumid.setBorder(null);
        jtxtHumid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHumidActionPerformed(evt);
            }
        });

        lblDB.setBackground(new java.awt.Color(51, 51, 51));
        lblDB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDB.setText("Banco de Dados:");

        jtxtDB.setBackground(new java.awt.Color(255, 0, 51));
        jtxtDB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtxtDB.setText("Desconectado");
        jtxtDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblLumi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtLumi, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblHumids)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtHumids))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtTemp))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblHumid, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtHumid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBtnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblBroker)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jtxtBroker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblDB)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jtxtDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblHumid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtHumid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTemp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtHumids, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHumids, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtLumi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLumi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(415, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBroker)
                        .addComponent(jtxtBroker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDB)
                        .addComponent(jtxtDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnConectarMouseClicked
        conexao = ModuloConexao.conector();
        
        if(conexao == null){
            jtxtDB.setText("Desconectado");
            jtxtDB.setBackground(RED);
        }else{
            jtxtDB.setText("Conectado");
            jtxtDB.setBackground(GREEN);
        }
        try {
            MqttClient cliente = new MqttClient("tcp://localhost:1883", "clienteP2");
            cliente.connect();
            System.out.println("Cliente conectado com sucesso.");
            jtxtBroker.setText("Conectado");
            jtxtBroker.setBackground(GREEN);
            cliente.subscribe("data/#");

            cliente.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable thrwbl) {
                    System.out.println("Conexão perdida.");
                    jtxtBroker.setText("Desconectado");
                    jtxtBroker.setBackground(RED);
                }

                @Override
                public void messageArrived(String topic, MqttMessage mm) throws Exception {
                    LocalDateTime horaAtual = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String formattedDateTime = horaAtual.format(formatter);
                    String valor = "";
                    String type = "";
                    String msg = mm.toString();
                    switch (topic) {
                        case "data/temp":
                            valor = msg;
                            msg = msg+"º";
                            type = "Temperatura";
                            jtxtTemp.setText(msg);
                            break;
                        case "data/humi":
                            valor = msg;
                            msg = msg+"%";
                            type = "Umidade";
                            jtxtHumid.setText(msg);
                            break;
                        case "data/lumi":
                            valor = msg;
                            type = "Luminosidade";
                            if(msg.equals("1")){
                                msg = "Claro";
                            }else{
                                msg = "Escuro";
                            }
                            jtxtLumi.setText(msg);
                            break;
                        case "data/humids":
                            valor = msg;
                            msg = msg+"%";
                            type = "Umidade do Solo";
                            jtxtHumids.setText(msg);
                            break;
                    }                   
                    int status;
                    try {
                        stm = conexao.prepareStatement("insert into sensor values(null,?,?,?)");
                        stm.setString(1, formattedDateTime);
                        stm.setString(2, type);
                        stm.setString(3, valor);
                        status = stm.executeUpdate();
                        System.out.println(status);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Enviar Humidade - Erro: " + e);
                        System.out.println(e.getErrorCode());
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken imdt) {
                    System.out.println("Entrega de mensagem bem sucedida.");

                }
            });

        } catch (MqttException ex) {
            Logger.getLogger(MqttSub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnConectarMouseClicked

    private void jtxtTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtTempActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtTempActionPerformed

    private void jtxtBrokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBrokerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBrokerActionPerformed

    private void jtxtHumidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHumidsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHumidsActionPerformed

    private void jtxtLumiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtLumiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtLumiActionPerformed

    private void jtxtHumidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHumidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHumidActionPerformed

    private void jtxtDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MqttSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MqttSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MqttSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MqttSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MqttSub().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnConectar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtxtBroker;
    private javax.swing.JTextField jtxtDB;
    private javax.swing.JTextField jtxtHumid;
    private javax.swing.JTextField jtxtHumids;
    private javax.swing.JTextField jtxtLumi;
    private javax.swing.JTextField jtxtTemp;
    private javax.swing.JLabel lblBroker;
    private javax.swing.JLabel lblDB;
    private javax.swing.JLabel lblHumid;
    private javax.swing.JLabel lblHumids;
    private javax.swing.JLabel lblLumi;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
