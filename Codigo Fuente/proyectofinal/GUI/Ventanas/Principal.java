package proyectofinal.GUI.Ventanas;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author joshua
 */
public  class Principal extends javax.swing.JFrame {
    Random rdm = new Random();
    int cantidadJugadores, cantidadDinero, cantidadDineroVuelta, cantidadCasas, cantidadHoteles;
    int rdmDadoUno, rdmDadoDos, rdmDadoTres;
    double interesHipoteca;
    String nombreJuego;
    Editar ventanaEditar; 
    
    public Principal() {
        initComponents();
        btnCrearJuego.setEnabled(false);
        btnEditarJuego.setEnabled(false);
        btnJugar.setEnabled(true);
        
        Imagen1VentanaPrincipal();
        Imagen2VentanaPrincipal();
        this.setLocationRelativeTo(null);
    }
    public Principal(int cantidadJugadores, int cantidadDinero, int cantidadDineroVuelta, int cantidadCasas, int cantidadHoteles){
        initComponents();
        btnCrearJuego.setEnabled(false);
        btnEditarJuego.setEnabled(false);
        btnJugar.setEnabled(true);
        Imagen1VentanaPrincipal();
        Imagen2VentanaPrincipal();
        this.setLocationRelativeTo(null);
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadDinero = cantidadDinero;
        this.cantidadDineroVuelta = cantidadDineroVuelta;
        this.cantidadCasas = cantidadHoteles;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnCrearJuego = new javax.swing.JButton();
        btnEditarJuego = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnAcerca = new javax.swing.JButton();
        cboOpcionJuego = new javax.swing.JComboBox<>();
        btnManual = new javax.swing.JButton();
        jLabelImagenP1 = new javax.swing.JLabel();
        jLabelImagenP2 = new javax.swing.JLabel();
        jLabTitulo = new javax.swing.JLabel();
        jLabelPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JUEGO DE MESA");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        btnCrearJuego.setText("Crear Juego");
        btnCrearJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        btnEditarJuego.setText("Editar Juego");
        btnEditarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnJugar.setText("Ingresar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        btnRanking.setText("Ranking");
        getContentPane().add(btnRanking, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        btnAcerca.setText("Acerca de");
        btnAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        cboOpcionJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "CARGAR", "NUEVO", "JUGAR" }));
        getContentPane().add(cboOpcionJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        btnManual.setText("Manual de Usuario");
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });
        getContentPane().add(btnManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));
        getContentPane().add(jLabelImagenP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 150, 150));
        getContentPane().add(jLabelImagenP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 150));

        jLabTitulo.setFont(new java.awt.Font("URW Gothic L", 1, 24)); // NOI18N
        jLabTitulo.setText("JUEGO DE MESA");
        getContentPane().add(jLabTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, 60));

        jLabelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPrincipal.setOpaque(true);
        getContentPane().add(jLabelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 503, 322));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCrearJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearJuegoActionPerformed
        //Capturamos los datos que nos ingresa el Usuario de la Configuracion general
        nombreJuego = JOptionPane.showInputDialog(null,"INGRESA EL NOMBRE DEL JUEGO","NOMBRE DEL JUEGO", JOptionPane.QUESTION_MESSAGE);
        pedirCantidadJugadores();
        pedirCantidadDineroInicial();
        pedircantidadDineroPorVuelta();
        pedirLimiteCasas();
        pedirLimiteHoteles();
        porcentajeInteresHipoteca();
        //Guardamos en un ARCHIVO los datos de la configuracion general 
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("datosIniciales.bin", "bin"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showSaveDialog(this);

            if (seleccion == APPROVE_OPTION) {
                guardarArchivoInicial(fileChooser.getSelectedFile().getPath()+".bin", nombreJuego, 
                cantidadJugadores, cantidadDinero, cantidadDineroVuelta, cantidadCasas, cantidadHoteles, interesHipoteca);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
        btnEditarJuego.setEnabled(false);
        btnJugar.setEnabled(true);
        btnCrearJuego.setEnabled(false);
    }//GEN-LAST:event_btnCrearJuegoActionPerformed
    //Guardamos en un ARCHIVO los datos de la configuracion general 
    public void guardarArchivoInicial(String path, String nombreJuego, int cantidadJugadores, int cantidadDinero, int cantidadDineroVuelta
    , int cantidadCasas, int cantidadHoteles, double interesHipoteca){
        try{ 
            DataOutputStream crearArchivoInicio = new DataOutputStream(new FileOutputStream(path));
            crearArchivoInicio.writeUTF(nombreJuego);
            crearArchivoInicio.writeInt(cantidadJugadores);
            crearArchivoInicio.writeInt(cantidadDinero);
            crearArchivoInicio.writeInt(cantidadDineroVuelta);
            crearArchivoInicio.writeInt(cantidadCasas);
            crearArchivoInicio.writeInt(cantidadHoteles);
            crearArchivoInicio.writeDouble(interesHipoteca);
            
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR E/S");
        }
    }
    //Leemos los datos del Archivo de la configuracion general
    public void leerArchivoInicial(String path){
        try{ 
            DataInputStream leerArchivoInicio = new DataInputStream(new FileInputStream(path));
            
            nombreJuego = leerArchivoInicio.readUTF();
            cantidadJugadores = leerArchivoInicio.readInt();
            cantidadDinero = leerArchivoInicio.readInt();
            cantidadDineroVuelta = leerArchivoInicio.readInt();
            cantidadCasas = leerArchivoInicio.readInt();
            cantidadHoteles = leerArchivoInicio.readInt();
            interesHipoteca = leerArchivoInicio.readDouble();        
            
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR E/S");
        }
        
    }
    //Abrimos los datos del archivo por medio del path de donde se encuentra el archivo 
    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        String opcion = cboOpcionJuego.getSelectedItem().toString();
        if(opcion == "CARGAR"){
            try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("datosIniciales.bin", "bin"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == APPROVE_OPTION) {
                System.out.println("Path: " + fileChooser.getSelectedFile().getPath());
                leerArchivoInicial(fileChooser.getSelectedFile().getPath());
            } 
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
            ventanaEditar = new Editar(cantidadJugadores, cantidadDinero, cantidadDineroVuelta, cantidadCasas, cantidadHoteles);
            btnEditarJuego.setEnabled(true);
        }else if(opcion == "NUEVO"){
            btnEditarJuego.setEnabled(false);
            btnJugar.setEnabled(false);
            btnCrearJuego.setEnabled(true);
        }else if(opcion == "JUGAR"){
            AreaJuego juego = new AreaJuego(cantidadJugadores, cantidadDinero, cantidadDineroVuelta, cantidadCasas, cantidadHoteles);
            juego.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnEditarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarJuegoActionPerformed
        ventanaEditar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditarJuegoActionPerformed

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        ManualUsuario manualUsuario = new ManualUsuario();
        manualUsuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnManualActionPerformed

    private void btnAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaActionPerformed
        AcercaDe ventanaAcercaDe = new AcercaDe();
        ventanaAcercaDe.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAcercaActionPerformed
    //Pedimos lo Porcentaje de interes con su restriccion a algun error del Usuario
    public void porcentajeInteresHipoteca(){
        String opcion;
        do{
            opcion = JOptionPane.showInputDialog(null, "-> Selección Automática escribe (A) ó (a) \n-> Definir Cantidad escribe (P) ó (p)","PORCENTAJE INTERES HIPOTECA", JOptionPane.QUESTION_MESSAGE);
            if(opcion.equalsIgnoreCase("a")){
                interesHipoteca = 0.15;
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else if(opcion.equalsIgnoreCase("p")){
                do{
                    interesHipoteca = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingresa el Porcentaje de interés por hipoteca:\n        "
                            + "              (Entre 0.10 - 0.20) ","PORCENTAJE INTERES HIPOTECA", JOptionPane.QUESTION_MESSAGE));
                    if(interesHipoteca >= 0.1 && interesHipoteca <= 0.2){
                        JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(interesHipoteca >= 0.1 && interesHipoteca <= 0.2));
            }else{
                JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opcion.equalsIgnoreCase("a")) && !(opcion.equalsIgnoreCase("p")));
    }
    //Pedimos Limite de Hoteles segun la restriccion para lo que ingresa el Usuario
    public void pedirLimiteHoteles(){
        String opcion;
        do{
            opcion = JOptionPane.showInputDialog(null, "-> Selección Automática escribe (A) ó (a) \n-> Definir Cantidad escribe (P) ó (p)","LIMITE DE HOTELES", JOptionPane.QUESTION_MESSAGE);
            if(opcion.equalsIgnoreCase("a")){
                cantidadHoteles = 1;
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else if(opcion.equalsIgnoreCase("p")){
                do{
                    cantidadHoteles = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el Límite de hoteles:\n        "
                            + "     (Entre 1 - 2) ","LIMITE DE HOTELES", JOptionPane.QUESTION_MESSAGE));
                    if(cantidadHoteles >= 1 && cantidadHoteles <= 2){
                        JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(cantidadHoteles >= 1 && cantidadHoteles <= 2));
            }else{
                JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opcion.equalsIgnoreCase("a")) && !(opcion.equalsIgnoreCase("p")));
    }
    //Pedimos datos del Limite de Casas segun restriccion para lo que ingresa el Usuario
    public void pedirLimiteCasas(){
        String opcion;
        do{
            opcion = JOptionPane.showInputDialog(null, "-> Selección Automática escribe (A) ó (a) \n-> Definir Cantidad escribe (P) ó (p)"
            ,"LIMITE DE CASAS", JOptionPane.QUESTION_MESSAGE);
            if(opcion.equalsIgnoreCase("a")){
                cantidadCasas = 2;
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else if(opcion.equalsIgnoreCase("p")){
                do{
                    cantidadCasas = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el Límite de casas:\n        "
                            + "    (Entre 1 - 3) ","LIMITE DE CASAS", JOptionPane.QUESTION_MESSAGE));
                    if(cantidadCasas >= 1 && cantidadCasas <= 3){
                        JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(cantidadCasas >= 1 && cantidadCasas <= 3));
            }else{
                JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opcion.equalsIgnoreCase("a")) && !(opcion.equalsIgnoreCase("p")));
    }
    //Pedimos cantidad Dinero Segun la restriccion del usuario
    public void pedircantidadDineroPorVuelta(){
        String opcion;
        do{
            opcion = JOptionPane.showInputDialog(null,"-> Selección Automática escribe (A) ó (a) \n-> Definir Cantidad escribe (P) ó (p)"
            ,"DINERO POR VUELTA", JOptionPane.QUESTION_MESSAGE);
            if(opcion.equalsIgnoreCase("a")){
                cantidadDineroVuelta = 200;
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else if(opcion.equalsIgnoreCase("p")){
                do{
                    cantidadDineroVuelta = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la Cantidad de Dinero por Vuelta:\n               "
                            + "    (Entre 200 - 500) ","DINERO POR VUELTA", JOptionPane.QUESTION_MESSAGE));
                    if(cantidadDineroVuelta >= 200 && cantidadDineroVuelta <= 500){
                        JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(cantidadDineroVuelta >= 200 && cantidadDineroVuelta <= 500));
            }else{
                JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opcion.equalsIgnoreCase("a")) && !(opcion.equalsIgnoreCase("p")));
    }
    //Pedimos unicamente la cantidad de jugadores que queremos para nuestra partida
    public void pedirCantidadJugadores(){
        do{
            cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE LA CANTIDAD DE JUGADORES (DE 2-6 JUGADORES)"
            ,"JUGADORES", JOptionPane.QUESTION_MESSAGE));
            if(cantidadJugadores >= 2 && cantidadJugadores <= 6){
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(cantidadJugadores >= 2 && cantidadJugadores <= 6));
    }
    //Pedimos cantidad de Dinero inicial que tendran todos los jugadores
    public void pedirCantidadDineroInicial(){
        String opcion;
        do{
            opcion = JOptionPane.showInputDialog(null,"-> Selección Automática escribe (A) ó (a) \n-> Definir Cantidad escribe (P) ó (p)"
            ,"DINERO INICIAL JUGADORES", JOptionPane.QUESTION_MESSAGE);
            if(opcion.equalsIgnoreCase("a")){
                cantidadDinero = 1500;
                JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }else if(opcion.equalsIgnoreCase("p")){
                do{
                    cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la Cantidad de Dinero Inicial para los Jugadores:\n               "
                            + "           (Entre 1000 - 2000) ","DINERO INICIAL JUGADORES", JOptionPane.QUESTION_MESSAGE));
                    if(cantidadDinero >= 1000 && cantidadDinero <= 2000){
                        JOptionPane.showMessageDialog(null, "¡REGISTRADO CON EXITO!","INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Cantidad no valida, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }while(!(cantidadDinero >= 1000 && cantidadDinero <= 2000));
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, Intenta de nuevo...","ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }while(!(opcion.equalsIgnoreCase("a")) && !(opcion.equalsIgnoreCase("p")));
    }
    //Imagen de las etiquetas de la ventana principal imagen MonoMan
    public void Imagen1VentanaPrincipal(){
        ImageIcon ImagenPrincipal = new ImageIcon("Imagen/MonoMan.gif");
        ImageIcon ImagenPrincipalEscalada = new ImageIcon(ImagenPrincipal.getImage().getScaledInstance(jLabelImagenP1.getWidth(), jLabelImagenP1.getHeight(), Image.SCALE_DEFAULT));
        jLabelImagenP1.setIcon(ImagenPrincipalEscalada);
    }
    //Imagen de las etiquetas de la ventana principal imagen Rule
    public void Imagen2VentanaPrincipal(){
        ImageIcon ImagenPrincipal = new ImageIcon("Imagen/Rule.gif");
        ImageIcon ImagenPrincipalEscalada = new ImageIcon(ImagenPrincipal.getImage().getScaledInstance(jLabelImagenP2.getWidth(), jLabelImagenP2.getHeight(), Image.SCALE_DEFAULT));
        jLabelImagenP2.setIcon(ImagenPrincipalEscalada);
    }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcerca;
    private javax.swing.JButton btnCrearJuego;
    private javax.swing.JButton btnEditarJuego;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnManual;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboOpcionJuego;
    private javax.swing.JLabel jLabTitulo;
    private javax.swing.JLabel jLabelImagenP1;
    private javax.swing.JLabel jLabelImagenP2;
    private javax.swing.JLabel jLabelPrincipal;
    // End of variables declaration//GEN-END:variables
}
