package Interfaces.SesionAdmin;

import Clases.Eventos.Evento;
import Clases.Eventos.Reserva;
import Clases.GuardadoDatos.UtilJavaEventsReservas;
import Clases.Usuario.Cliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class ConsultarReservas extends javax.swing.JFrame {
    private Cliente clienteEncontrado;
    private Evento eventoSelected;
    private DefaultTableModel tabla = new DefaultTableModel();
    ArrayList<Reserva> reservas = new ArrayList<>(); //Inicializa la ArrayList de eventos que tenemos creada en la clase UtilJavaEventsReservas donde tenemos guardados todos los datos de las reservas
    
    
    /**
     * Creates new form ConsultarReservas
     */
    public ConsultarReservas() {
        UtilJavaEventsReservas.cargarDatosReservas();
        initComponents();
        String columnas[] = {"FechaReserva", "Evento", "Cliente", "CantidadEntradas" , "PrecioTotal"}; //Crea una variable String llamada columnas que es la que nos permite organizar como apareceran los datos en la tabla creada anteriormente.
        tabla.setColumnIdentifiers(columnas); //Establece al modelo de tabla creado antes como se organizaran las diferentes columnas creadas.
        Tabla.setModel(tabla); //Establece el modelo de la tabla creada
        Tabla.getTableHeader().setReorderingAllowed(false); //Se encarga de que no se puedan mover las columnas ni descolocarlas, es decir, que no se puedan editar las columnas.
        ComboBoxFiltrar.setSelectedItem("fechaReserva");  //El ComboBox filtra como apareceran los eventos una vez entren a la ventana. 
        rellenaTabla("fechaReserva"); //La tabla se encarga de establecer el orden en el que se filtraran los eventos la primera vez que aparezcan los datos.
        this.setVisible(true);
        
    }
        //El Metodo rellenaTabla se va a encargar de permitir como poder rellenar la tabla como dice su nombre y la que va ayudar a 
        //que cuando se cargen los datos cada uno se coloque en la columna realizada anteriormente.
    
    public void rellenaTabla(String criterio) {
        limpiaTabla();
        switch (criterio) {
            case "FechaReserva":
                reservas = UtilJavaEventsReservas.getReservasPorFecha();
                break;
            case "Evento":
                reservas = UtilJavaEventsReservas.getReservasPorEventoTitulo();
                break;
            case "Cliente":
                reservas = UtilJavaEventsReservas.getReservasPorClienteCor();
                break;
            case "CantidadEntradas":
                reservas = UtilJavaEventsReservas.getReservasPorCantidadEntradas();
                break;
            case "PrecioTotal":
                reservas = UtilJavaEventsReservas.getReservasPrecioTotal();
                break;
        }
        for (Reserva r : reservas) {
            if (r != null && r.getEvento() != null && r.getCliente() != null) {
                tabla.addRow(new Object[]{
                    r.getFechaReserva(),
                    r.getEvento().getTitulo(),
                    r.getCliente().getCorreo(),
                    r.getCantidadEntradas(),
                    r.getPrecioTotal()
                });
            }
        }
    }
        
        //Metodo que se encarga de eliminar todas las filas de la tabla una vez se cierre y una vez se cargue esta ventana se 
        //colocaran los datos de nuevo a sus posiciones gracias al metodo rellenaTabla(). 
        
       public void limpiaTabla() {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            tabla.removeRow(0);
        }
    }
       public ArrayList<Reserva> filtrarReservasPorSeleccion(String filtroseleccionado, String textobusqueda) {
           ArrayList<Reserva> reservasfiltradas = new ArrayList<>();
           for (Reserva reserva: reservas) {
               if (filtroseleccionado.equalsIgnoreCase("Todas")) {
                   reservasfiltradas.add(reserva);
               }
               if (filtroseleccionado.equalsIgnoreCase("FechaReserva")) {
                   if (reserva.getFechaReserva().equalsIgnoreCase(textobusqueda)) {
                       reservasfiltradas.add(reserva);
                   }
               }else if (filtroseleccionado.equalsIgnoreCase("Evento")) {
                   if (reserva.getEvento().getTitulo().equalsIgnoreCase(textobusqueda)) {
                       reservasfiltradas.add(reserva);
                   }
               }
           }
           return reservasfiltradas;
       }
       
       //Metodo que se encarga de actualizar los eventos una vez de ha realizado la modificacion del ComboBox y se busque el dato ya 
       //sea la Ciudad o el Tipo del evento
       
       public void actualizarReservasFiltradas() {
           String filtroseleccionado = ComboBoxFiltrar.getSelectedItem().toString();
           String textobusqueda = Textobusquedatxt.getText().trim();
           ArrayList<Reserva> reservasfiltradas = filtrarReservasPorSeleccion(filtroseleccionado, textobusqueda);
           actualizarTabla(reservasfiltradas);
           
       }
       
       //Metodo que se va a encargar de actualizar la tabla y mostrar los eventos que tengan los filtros seleccionados ya sean de Tipo o
       //de Ciudad en la tabla.
       public void actualizarTabla(ArrayList<Reserva> reservasfiltradas) {
           DefaultTableModel tabla = (DefaultTableModel) Tabla.getModel();
           tabla.setRowCount(0);
           
           for (Reserva reserva: reservasfiltradas) {
                tabla.addRow(new Object[]{reserva.getFechaReserva(), reserva.getEvento().getTitulo(), reserva.getCliente().getCorreo(), reserva.getCantidadEntradas(),reserva.getPrecioTotal()});
           }
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Textobusquedatxt = new javax.swing.JTextField();
        ComboBoxFiltrar = new javax.swing.JComboBox<>();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaEvents");

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONSULTA DE RESERVAS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 17, 710, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Tabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FechaReserva", "Evento", "Cliente", "CantidadEntradas", "PrecioTotal"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 710, 290));

        Textobusquedatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextobusquedatxtKeyReleased(evt);
            }
        });
        jPanel1.add(Textobusquedatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, -1));

        ComboBoxFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "FechaReserva", "Evento" }));
        ComboBoxFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Volver.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sergio\\OneDrive\\Documentos\\NetBeansProjects\\JavaEvents\\src\\main\\resources\\left-arrow (1).png")); // NOI18N
        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        jPanel1.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextobusquedatxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextobusquedatxtKeyReleased
        actualizarReservasFiltradas();
    }//GEN-LAST:event_TextobusquedatxtKeyReleased

    private void ComboBoxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxFiltrarActionPerformed
        actualizarReservasFiltradas();
    }//GEN-LAST:event_ComboBoxFiltrarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        UtilJavaEventsReservas.guardarDatosReservas();
        Administrador frame1 = new Administrador();
        frame1.setVisible(true); //Aparecer la pestaña
        dispose(); //Cerrar pestaña anterior
    }//GEN-LAST:event_VolverActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxFiltrar;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField Textobusquedatxt;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
