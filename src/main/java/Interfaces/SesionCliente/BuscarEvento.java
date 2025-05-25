package Interfaces.SesionCliente;
import Clases.Eventos.Evento;
import Clases.GuardadoDatos.UtilJavaEventsEventos;
import Clases.Usuario.Cliente;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Sergio
 */
public class BuscarEvento extends javax.swing.JFrame {
    private Cliente clienteEncontrado;
    private DefaultTableModel tabla = new DefaultTableModel();  //Crea una tabla la cual nos ayudara a realizar el filtrado de los eventos  
    ArrayList<Evento> eventos = new ArrayList<>(); //Inicializa la ArrayList de eventos que tenemos creada en la clase UtilJavaEventsEventos donde tenemos guardados todos los datos de los eventos
    /**
     * Creates new form BuscarEvento
     */
    public BuscarEvento() {
        initComponents();
        UtilJavaEventsEventos.cargarDatosEventos(); //Carga los datos de los eventos para que estos puedan mostrarse en la tabla
        String columnas[] = {"Titulo", "Tipo","Calle","Numero", "CodigoPostal", "Ciudad", "Fecha", "Hora", "Precio", "Calificacion"};  //Crea una variable String llamada columnas que es la que nos permite organizar como apareceran los datos en la tabla creada anteriormente.
        tabla.setColumnIdentifiers(columnas);  //Establece al modelo de tabla creado antes como se organizaran las diferentes columnas creadas.
        Tabla.setModel(tabla); //Establece el modelo de la tabla creada
        Tabla.getTableHeader().setReorderingAllowed(false); //Se encarga de que no se puedan mover las columnas ni descolocarlas, es decir, que no se puedan editar las columnas.
        ComboBoxFiltrar.setSelectedItem("Titulo"); //El ComboBox filtra como apareceran los eventos una vez entren a la ventana.  
        rellenaTabla("Titulo"); //La tabla se encarga de establecer el orden en el que se filtraran los eventos la primera vez que aparezcan los datos.
        this.setVisible(true);
        
    }
    
        //El Metodo rellenaTabla se va a encargar de permitir como poder rellenar la tabla como dice su nombre y la que va ayudar a 
        //que cuando se cargen los datos cada uno se coloque en la columna realizada anteriormente.
    
        public void rellenaTabla(String criterio) {
        limpiaTabla();
        if (criterio.equals("Titulo")) {
            eventos = UtilJavaEventsEventos.getEventosPorTitulo();
        } else if (criterio.equals("Tipo")) {
            eventos = UtilJavaEventsEventos.getEventosPorTipo();
        }else if (criterio.equals("Calle")) {
            eventos = UtilJavaEventsEventos.getEventosPorCalle();
        }else if (criterio.equals("Número")) {
            eventos = UtilJavaEventsEventos.getEventosPorNumero();
        }else if (criterio.equals("CodigoPostal")) {
            eventos = UtilJavaEventsEventos.getEventosPorCodigoPostal();
        }else if (criterio.equals("Ciudad")) {
            eventos = UtilJavaEventsEventos.getEventosPorCiudad();
        }else if (criterio.equals("Fecha")) {
            eventos = UtilJavaEventsEventos.getEventosPorFecha();
        }else if (criterio.equals("Hora")) {
            eventos = UtilJavaEventsEventos.getEventosPorHora();
        }else if (criterio.equals("Precio")) {
            eventos = UtilJavaEventsEventos.getEventosPorPrecio();
        }else if (criterio.equals("Calificacion")) {
            eventos = UtilJavaEventsEventos.getEventosPorCalificacion();    
        }
        
        for (Evento c : eventos) {
            tabla.addRow(new Object[]{c.getTitulo(), c.getTipo(), c.getDireccion().getCalle(), c.getDireccion().getNumero(), c.getDireccion().getCodigopostal(), c.getDireccion().getCiudad(), c.getFecha(), c.getHora(), c.getPrecio(), c.getCalificacion()});
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
       
       //Metodo que se encarga de filtrar los eventos por Ciudad, por Tipo o Ambos, creando una ArrayList y añadiendo el o los eventos a
       //dicha ArrayList una vez que en el ComboBox se seleccione cualquiera de las opciones que hay.
       
       public ArrayList<Evento> filtrarEventoPorSeleccion(String filtroseleccionado, String textobusqueda) {
           ArrayList<Evento> eventosfiltrados = new ArrayList<>();
           for (Evento evento: eventos) {
               if (filtroseleccionado.equalsIgnoreCase("Ambos")) {
                   eventosfiltrados.add(evento);
               }
               if (filtroseleccionado.equalsIgnoreCase("Tipo")) {
                   if (evento.getTipo().equalsIgnoreCase(textobusqueda)) {
                       eventosfiltrados.add(evento);
                   }
               }else if (filtroseleccionado.equalsIgnoreCase("Ciudad")) {
                   if (evento.getDireccion().getCiudad().equalsIgnoreCase(textobusqueda)) {
                       eventosfiltrados.add(evento);
                   }
               }
           }
           return eventosfiltrados;
       }
       
       //Metodo que se encarga de actualizar los eventos una vez de ha realizado la modificacion del ComboBox y se busque el dato ya 
       //sea la Ciudad o el Tipo del evento
       
       public void actualizarEventosFiltrados() {
           String filtroseleccionado = ComboBoxFiltrar.getSelectedItem().toString();
           String textobusqueda = Textobusquedatxt.getText().trim();
           ArrayList<Evento> eventosfiltrados = filtrarEventoPorSeleccion(filtroseleccionado, textobusqueda);
           actualizarTabla(eventosfiltrados);
           
       }
       
       //Metodo que se va a encargar de actualizar la tabla y mostrar los eventos que tengan los filtros seleccionados ya sean de Tipo o
       //de Ciudad en la tabla.
       public void actualizarTabla(ArrayList<Evento> eventosfiltrados) {
           DefaultTableModel tabla = (DefaultTableModel) Tabla.getModel();
           tabla.setRowCount(0);
           
           for (Evento evento: eventosfiltrados) {
               tabla.addRow(new Object[]{evento.getTitulo(), evento.getTipo(), evento.getDireccion().getCalle(), evento.getDireccion().getNumero(), evento.getDireccion().getCiudad(), evento.getDireccion().getCodigopostal(), evento.getFecha(), evento.getHora(), evento.getPrecio(), evento.getCalificacion()});
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
        RegistroLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        ComboBoxFiltrar = new javax.swing.JComboBox<>();
        Textobusquedatxt = new javax.swing.JTextField();
        Reserva = new javax.swing.JButton();
        HomeBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaEvents");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RegistroLabel.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        RegistroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegistroLabel.setText("BUSCAR EVENTO");
        jPanel1.add(RegistroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 710, 60));

        Tabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Tipo", "Calle", "Numero", "CodigoPostal", "Ciudad", "Fecha", "Hora", "Precio", "Calificacion"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 710, 320));

        ComboBoxFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxFiltrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ambos", "Ciudad", "Tipo" }));
        ComboBoxFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxFiltrarActionPerformed(evt);
            }
        });
        jPanel1.add(ComboBoxFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Textobusquedatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextobusquedatxtKeyReleased(evt);
            }
        });
        jPanel1.add(Textobusquedatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, -1));

        Reserva.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Reserva.setText("Reserva");
        Reserva.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        Reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaActionPerformed(evt);
            }
        });
        jPanel1.add(Reserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 100, -1));

        HomeBoton.setBackground(new java.awt.Color(102, 102, 102));
        HomeBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home (3).png"))); // NOI18N
        HomeBoton.setBorderPainted(false);
        HomeBoton.setContentAreaFilled(false);
        HomeBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBotonActionPerformed(evt);
            }
        });
        jPanel1.add(HomeBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxFiltrarActionPerformed
        actualizarEventosFiltrados();
    }//GEN-LAST:event_ComboBoxFiltrarActionPerformed

    private void TextobusquedatxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextobusquedatxtKeyReleased
        actualizarEventosFiltrados();
    }//GEN-LAST:event_TextobusquedatxtKeyReleased

    private void ReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaActionPerformed
        
        //Una vez se presione este boton se redigira a la ventana ReservarEventos si se selecciona una fila/evento de la tabla
        //sino hay nada seleccionado saldra un mensaje de que no hay ningun evento seleccionado.
        
        int fila = Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "No hay evento seleccionado.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            String tituloEvento = Tabla.getValueAt(fila, 0).toString();
            Evento eventoEncontrado = null;
            for(Evento ev: eventos) {
                if (ev.getTitulo().equals(tituloEvento)) {
                    eventoEncontrado = ev;
                    break;
                }
            }
            if (eventoEncontrado != null) {
                ReservarEventos e = new ReservarEventos(eventoEncontrado, clienteEncontrado);
                e.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el evento seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_ReservaActionPerformed

    private void HomeBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBotonActionPerformed

        //Pasar a ventana de IniciodesesionCliente

        Clientes frame1 = new Clientes(clienteEncontrado);
        frame1.setVisible(true);
        dispose();
    }//GEN-LAST:event_HomeBotonActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarEvento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxFiltrar;
    private javax.swing.JButton HomeBoton;
    private javax.swing.JLabel RegistroLabel;
    private javax.swing.JButton Reserva;
    private javax.swing.JTable Tabla;
    private javax.swing.JTextField Textobusquedatxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
