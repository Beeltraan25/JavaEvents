package Interfaces.VentanaPrincipal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import Clases.GuardadoDatos.UtilJavaEventsClientes;
import Clases.GuardadoDatos.UtilJavaEventsEventos;
import Clases.GuardadoDatos.UtilJavaEventsReservas;
import Clases.Usuario.Cliente;
import Interfaces.Logins.IniciodesesionAdministrador;
import Interfaces.Logins.IniciodesesionCliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaEvents extends javax.swing.JFrame {
    private Cliente clienteEncontrado;
    
    
    
    public JavaEvents(Cliente client) {
        
        
        UtilJavaEventsClientes.cargarDatosClientes();  //Carga los Datos del archivo de clientes
        UtilJavaEventsEventos.cargarDatosEventos(); //Carga los Datos del archivo de eventos
        UtilJavaEventsReservas.cargarDatosReservas(); //Carga los Datos del archivo de reservas
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        JavaEventsLabel = new javax.swing.JLabel();
        BotonCliente = new javax.swing.JButton();
        BotonAdministrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaEvents");
        setLocationByPlatform(true);

        Fondo.setBackground(new java.awt.Color(102, 102, 102));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JavaEventsLabel.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        JavaEventsLabel.setForeground(new java.awt.Color(255, 255, 255));
        JavaEventsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JavaEventsLabel.setText("JAVA EVENTS");
        Fondo.add(JavaEventsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 380, 90));

        BotonCliente.setBackground(new java.awt.Color(102, 102, 102));
        BotonCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BotonCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sergio\\OneDrive\\Documentos\\NetBeansProjects\\JavaEvents\\src\\main\\resources\\user (1).png")); // NOI18N
        BotonCliente.setText("CLIENTE");
        BotonCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BotonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClienteActionPerformed(evt);
            }
        });
        Fondo.add(BotonCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, 80));

        BotonAdministrador.setBackground(new java.awt.Color(102, 102, 102));
        BotonAdministrador.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        BotonAdministrador.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sergio\\OneDrive\\Documentos\\NetBeansProjects\\JavaEvents\\src\\main\\resources\\administrator (1).png")); // NOI18N
        BotonAdministrador.setText("ADMINISTRADOR");
        BotonAdministrador.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotonAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAdministradorActionPerformed(evt);
            }
        });
        Fondo.add(BotonAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 160, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClienteActionPerformed
        
        //Pasar a ventana de IniciodesesionCliente
        
        IniciodesesionCliente frame1 = new IniciodesesionCliente(clienteEncontrado);
        frame1.setVisible(true);
        
        //Cierra la ventana que esta abierta 
        
        
        dispose();
        
    }//GEN-LAST:event_BotonClienteActionPerformed

    private void BotonAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAdministradorActionPerformed
        
        //Pasar a ventana de IniciodesesionAdministrador
        
        IniciodesesionAdministrador frame2 = new IniciodesesionAdministrador();
        frame2.setVisible(true);
        
        //Cierra la ventana que está abierta
        
        
        dispose();
        
    }//GEN-LAST:event_BotonAdministradorActionPerformed

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
            java.util.logging.Logger.getLogger(JavaEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAdministrador;
    private javax.swing.JButton BotonCliente;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel JavaEventsLabel;
    // End of variables declaration//GEN-END:variables
}
