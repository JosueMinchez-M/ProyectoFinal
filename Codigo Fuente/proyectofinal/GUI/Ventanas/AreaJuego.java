package proyectofinal.GUI.Ventanas;
import Jugabilidad.TiempoIlimitado;
import java.awt.HeadlessException;
import proyectofinal.dados.Dado;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectofinal.tablerojuego.Tablero;

/**
 *
 * @author joshua
 */
public class AreaJuego extends javax.swing.JFrame{
    
    JButton[][] matrizBotones;
    Random rdm = new Random();
    int cantidadDados, cantidadJugadores, cantidadDinero, cantidadDineroVuelta,
        cantidadCasas, cantidadHoteles;
    int rdmDadoUno, rdmDadoDos, rdmDadoTres, sumaDados; 
    Dado Dados;
    int Filas, Columnas;
    String decisionTablero;
    Tablero tablero, tableroPrueba;
            
    public AreaJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public AreaJuego(int cantidadJugadores, int cantidadDinero, int cantidadDineroVuelta, int cantidadCasas,
            int cantidadHoteles) {
        this.cantidadJugadores = cantidadJugadores;
        this.cantidadDinero = cantidadDinero;
        this.cantidadDineroVuelta = cantidadDineroVuelta;
        initComponents();
        ocultarBotonesAreaJuego();
        btnAbrirTablero.setEnabled(false);
        btnGuardarTablero.setEnabled(false);
        lblTimer1.setEnabled(false);
        lblTimer2.setEnabled(false);
        lblMinRegresivos.setEnabled(false);
        lblSegRegresivos.setEnabled(false);
        minutos.setEnabled(false);
        segundos.setEnabled(false);
        this.setLocationRelativeTo(null);
    }
    public void ocultarBotonesAreaJuego(){
        btnIniciarJuego.setEnabled(false);
        btnAutomatico.setEnabled(false);
        btnIngresarDatos.setEnabled(false);
        ocultarBotonesAreaDado();
        ocultarOtrosBotones();
    }
    public void mostrarBotonesAreaDados(){
        btnIniciarJuego.setEnabled(false);
        btnIngresarJugadores.setEnabled(false);
        txtFila.setEnabled(true);
        txtColumna.setEnabled(true);
        cboDados.setEnabled(true);
        btnCrear.setEnabled(true);
    }
    public void ocultarBotonesAreaDado(){
        btnCrear.setEnabled(false);
        txtColumna.setEnabled(false);
        txtFila.setEnabled(false);
        cboDados.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDados = new javax.swing.JPanel();
        lblDado3 = new javax.swing.JLabel();
        lblDado2 = new javax.swing.JLabel();
        lblDado1 = new javax.swing.JLabel();
        btnLanzar = new javax.swing.JButton();
        btnIngresarJugadores = new javax.swing.JButton();
        btnIniciarJuego = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnAutomatico = new javax.swing.JButton();
        btnIngresarDatos = new javax.swing.JButton();
        btnGuardarTablero = new javax.swing.JButton();
        btnAbrirTablero = new javax.swing.JButton();
        jPanelOpciones = new javax.swing.JPanel();
        btnVerPropiedades = new javax.swing.JButton();
        btnHipotecar = new javax.swing.JButton();
        btnConstruir = new javax.swing.JButton();
        btnBancarrota = new javax.swing.JButton();
        btnTerminarTurno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFila = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtColumna = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnFinJuego = new javax.swing.JButton();
        btnLimpiarTablero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboDados = new javax.swing.JComboBox<>();
        lblTimer1 = new javax.swing.JLabel();
        lblTimer2 = new javax.swing.JLabel();
        lblMinRegresivos = new javax.swing.JLabel();
        lblSegRegresivos = new javax.swing.JLabel();
        minutos = new javax.swing.JLabel();
        segundos = new javax.swing.JLabel();
        panelArreglo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelDados.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelDados.add(lblDado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 106, 87));
        jPanelDados.add(lblDado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 106, 87));
        jPanelDados.add(lblDado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 106, 87));

        btnLanzar.setText("Lanzar");
        btnLanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarActionPerformed(evt);
            }
        });
        jPanelDados.add(btnLanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, -1, -1));

        btnIngresarJugadores.setText("Ingresar Jugadores");
        btnIngresarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarJugadoresActionPerformed(evt);
            }
        });
        jPanelDados.add(btnIngresarJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        btnIniciarJuego.setText("Iniciar Juego");
        btnIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarJuegoActionPerformed(evt);
            }
        });
        jPanelDados.add(btnIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Generar Juego");
        jPanelDados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        btnAutomatico.setText("Automatico");
        btnAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutomaticoActionPerformed(evt);
            }
        });
        jPanelDados.add(btnAutomatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, -1));

        btnIngresarDatos.setText("Ingresar Datos");
        btnIngresarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDatosActionPerformed(evt);
            }
        });
        jPanelDados.add(btnIngresarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, -1));

        btnGuardarTablero.setText("Guardar Tablero");
        btnGuardarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTableroActionPerformed(evt);
            }
        });
        jPanelDados.add(btnGuardarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        btnAbrirTablero.setText("Abrir Tablero");
        btnAbrirTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirTableroActionPerformed(evt);
            }
        });
        jPanelDados.add(btnAbrirTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        getContentPane().add(jPanelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 170, 650));

        jPanelOpciones.setBackground(new java.awt.Color(255, 255, 255));
        jPanelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVerPropiedades.setText("Ver Propiedades");
        jPanelOpciones.add(btnVerPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 176, -1));

        btnHipotecar.setText("Hipotecar Propiedad");
        jPanelOpciones.add(btnHipotecar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, -1, -1));

        btnConstruir.setText("Construir Edificios");
        jPanelOpciones.add(btnConstruir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        btnBancarrota.setText("En Bancarrota");
        jPanelOpciones.add(btnBancarrota, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 158, -1));

        btnTerminarTurno.setText("Terminar Turno");
        btnTerminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarTurnoActionPerformed(evt);
            }
        });
        jPanelOpciones.add(btnTerminarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, -1));

        jLabel2.setText("Filas:");
        jPanelOpciones.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilaActionPerformed(evt);
            }
        });
        jPanelOpciones.add(txtFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 30, -1));

        jLabel3.setText("Columnas:");
        jPanelOpciones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        txtColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColumnaActionPerformed(evt);
            }
        });
        jPanelOpciones.add(txtColumna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 30, -1));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanelOpciones.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        btnFinJuego.setText("Finalizar Juego");
        btnFinJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinJuegoActionPerformed(evt);
            }
        });
        jPanelOpciones.add(btnFinJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 140, -1));

        btnLimpiarTablero.setText("Limpiar Tablero");
        btnLimpiarTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTableroActionPerformed(evt);
            }
        });
        jPanelOpciones.add(btnLimpiarTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel1.setText("Dados:");
        jPanelOpciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        cboDados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3" }));
        cboDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDadosActionPerformed(evt);
            }
        });
        jPanelOpciones.add(cboDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        lblTimer1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTimer1.setText("00 : 00 : 00");
        jPanelOpciones.add(lblTimer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 120, 30));

        lblTimer2.setText("0000");
        jPanelOpciones.add(lblTimer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        lblMinRegresivos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMinRegresivos.setText("0");
        jPanelOpciones.add(lblMinRegresivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 30, 20));

        lblSegRegresivos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSegRegresivos.setText("0");
        jPanelOpciones.add(lblSegRegresivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 30, -1));

        minutos.setText("Minutos");
        jPanelOpciones.add(minutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, -1));

        segundos.setText("Segundos");
        jPanelOpciones.add(segundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        getContentPane().add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 980, 130));

        javax.swing.GroupLayout panelArregloLayout = new javax.swing.GroupLayout(panelArreglo);
        panelArreglo.setLayout(panelArregloLayout);
        panelArregloLayout.setHorizontalGroup(
            panelArregloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        panelArregloLayout.setVerticalGroup(
            panelArregloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        getContentPane().add(panelArreglo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTableroActionPerformed
        panelArreglo.removeAll();
        panelArreglo.repaint();
        lblDado1.setIcon(null);
        lblDado2.setIcon(null);
        lblDado3.setIcon(null);
        txtFila.setText("");
        txtColumna.setText("");
        ocultarOtrosBotones();
        mostrarBotonesAreaDados();
    }//GEN-LAST:event_btnLimpiarTableroActionPerformed
    //Boton que nos regresa a la ventana principal del juego
    private void btnFinJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinJuegoActionPerformed
       Principal ventanaPrincipal = new Principal();
       ventanaPrincipal.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnFinJuegoActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String filas = txtFila.getText();
        String columnas = txtColumna.getText();
        Filas = Integer.parseInt(filas);
        Columnas = Integer.parseInt(columnas);
        tablero.tableroBotones(panelArreglo, Filas, Columnas);
        JOptionPane.showMessageDialog(null, "EDITA LAS CASILLAS DEL BORDE DEL TABLERO CON DIRECCION A LAS AGUJAS DEL RELOJ");
        
        dadosAUsar();
        ocultarBotonesAreaDado();
        btnLimpiarTablero.setEnabled(true);
        btnIniciarJuego.setEnabled(true);
    }//GEN-LAST:event_btnCrearActionPerformed
    public void mostrarOtrosBotones(){
        btnLanzar.setEnabled(true);
        btnBancarrota.setEnabled(true);
        btnConstruir.setEnabled(true);
        btnHipotecar.setEnabled(true);
        btnTerminarTurno.setEnabled(true);
        btnVerPropiedades.setEnabled(true);
    }
    public void ocultarOtrosBotones(){
        btnLanzar.setEnabled(false);
        btnBancarrota.setEnabled(false);
        btnConstruir.setEnabled(false);
        btnHipotecar.setEnabled(false);
        btnTerminarTurno.setEnabled(false);
        btnVerPropiedades.setEnabled(false);
        btnLimpiarTablero.setEnabled(false);
    }
    private void txtColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColumnaActionPerformed
    }//GEN-LAST:event_txtColumnaActionPerformed

    private void txtFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilaActionPerformed
    }//GEN-LAST:event_txtFilaActionPerformed
   
//GEN-FIRST:event_bttnLanzarDadosActionPerformed
//GEN-LAST:event_bttnLanzarDadosActionPerformed

    private void btnLanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarActionPerformed
        numeroAleatorioDados();
        tablero.obtenerNumerosRandom(cantidadDados, rdmDadoUno, rdmDadoDos, rdmDadoTres);
        Dados.lanzarDados(lblDado1, lblDado2, lblDado3);
        tablero.movimientosJugabilidad();
    }//GEN-LAST:event_btnLanzarActionPerformed

    private void btnTerminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTerminarTurnoActionPerformed

    private void cboDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDadosActionPerformed
        String Dados = cboDados.getSelectedItem().toString();
        cantidadDados = Integer.parseInt(Dados);
    }//GEN-LAST:event_cboDadosActionPerformed
    //Boton ingresar jugadores, invicando a un objeto tablero con metodo de su clase
    private void btnIngresarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarJugadoresActionPerformed
        tablero = new Tablero();
        tablero.ingresarJugadores(cantidadJugadores, cantidadDinero);
        btnAutomatico.setEnabled(true);
        btnIngresarDatos.setEnabled(true);
        btnIngresarJugadores.setEnabled(false);
        btnAbrirTablero.setEnabled(true);
    }//GEN-LAST:event_btnIngresarJugadoresActionPerformed

    private void btnIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarJuegoActionPerformed
        
        int opcionTiempo;
        
        if(decisionTablero.equalsIgnoreCase("automatico")){
            btnLimpiarTablero.setEnabled(false);
            mostrarOtrosBotones();
            btnIniciarJuego.setEnabled(false);
        }else if(decisionTablero.equalsIgnoreCase("Ingresar")){
            panelArreglo.removeAll();
            panelArreglo.repaint();
            tablero.tableroBotonesCreada(panelArreglo);
            btnLimpiarTablero.setEnabled(false);
            mostrarOtrosBotones();
            btnIniciarJuego.setEnabled(false);
        }else if(decisionTablero.equalsIgnoreCase("Abrir")){
            panelArreglo.removeAll();
            panelArreglo.repaint();
            tablero.tableroBotonesCreada(panelArreglo);
            btnLimpiarTablero.setEnabled(false);
            mostrarOtrosBotones();
            btnIniciarJuego.setEnabled(false);
        }
        
        do{ //Con este Ciclo determinamos como queremos el tiempo, si lo queremos ilimitado o con cuenta regresiva
            opcionTiempo = Integer.parseInt(JOptionPane.showInputDialog("ESCRIBE EL NUMERO DE TU ELECCION \n1- Tiempo Ilimitado \n2- Tiempo Limitado"));
            if(opcionTiempo == 1){
                lblTimer1.setEnabled(true);
                lblTimer2.setEnabled(true);
                TiempoIlimitado tiempo = new TiempoIlimitado();
                tiempo.tiempoIlimitado(lblTimer1, lblTimer2);
                
            }else if(opcionTiempo == 2){
                lblMinRegresivos.setEnabled(true);
                lblSegRegresivos.setEnabled(true);
                minutos.setEnabled(true);
                segundos.setEnabled(true);
                int tiempoRegresivo = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESA LOS MINUTOS","TIEMPO DEL JUEGO", JOptionPane.QUESTION_MESSAGE));
                TiempoIlimitado tiempoLimitado = new TiempoIlimitado(tiempoRegresivo);
                tiempoLimitado.tiempoLimitado(lblMinRegresivos, lblSegRegresivos);
            }else{
                JOptionPane.showMessageDialog(null, "Seleccion no valida, intentelo de nuevo");
            }
        }while(opcionTiempo != 1 && opcionTiempo != 2);
    }//GEN-LAST:event_btnIniciarJuegoActionPerformed

    private void btnIngresarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDatosActionPerformed
        decisionTablero = "Ingresar";
        mostrarBotonesAreaDados();
        btnAutomatico.setEnabled(false);
        btnIngresarDatos.setEnabled(false);
        btnGuardarTablero.setEnabled(true);
    }//GEN-LAST:event_btnIngresarDatosActionPerformed

    private void btnAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutomaticoActionPerformed
        decisionTablero = "automatico";
        cantidadDados = 2;
        Filas = 10;
        Columnas = 10;
        dadosAUsar();
        tablero.tableroBotonesAutomatico(panelArreglo, Filas, Columnas,cantidadDineroVuelta, cantidadCasas, cantidadHoteles);
        btnAutomatico.setEnabled(false);
        btnIngresarDatos.setEnabled(false);
        btnLanzar.setEnabled(false);
        btnIniciarJuego.setEnabled(true);
        btnAbrirTablero.setEnabled(false);
    }//GEN-LAST:event_btnAutomaticoActionPerformed

    private void btnGuardarTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTableroActionPerformed

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Tablero.board", "board"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showSaveDialog(this);

            if (seleccion == APPROVE_OPTION) {
                tablero.guardarTablero(fileChooser.getSelectedFile().getPath()+".board");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarTableroActionPerformed

    private void btnAbrirTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirTableroActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Tablero.board", "board"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showOpenDialog(this);

            if (seleccion == APPROVE_OPTION) {
                System.out.println("Path: " + fileChooser.getSelectedFile().getPath());
                tablero.leerTablero(fileChooser.getSelectedFile().getPath());
            } 
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        }
        panelArreglo.removeAll();
        panelArreglo.repaint();
        btnIniciarJuego.setEnabled(true);
        btnAutomatico.setEnabled(false);
        btnIngresarDatos.setEnabled(false);
        btnAbrirTablero.setEnabled(false);
        decisionTablero = "Abrir";
        cantidadDados = Integer.parseInt(JOptionPane.showInputDialog(null, "(Cantidad 1-3 Dados)", "CANTIDAD DE DADOS", JOptionPane.QUESTION_MESSAGE));
        dadosAUsar();
    }//GEN-LAST:event_btnAbrirTableroActionPerformed
    //Metodo que nos permite determinar los dados que apareceran al principio en el tablero, en si los dados en movimiento
    public void dadosAUsar(){
        do{
        if(cantidadDados >= 1 && cantidadDados <= 3){
            numeroAleatorioDados();
            Dados.imagenDadosSeleccionados(lblDado1, lblDado2, lblDado3);
        }else{
            cantidadDados = Integer.parseInt(JOptionPane.showInputDialog("Caracter no valido, Intenta de nuevo... \n     (Cantidad 1-3 Dados) "));
            numeroAleatorioDados();
            Dados.imagenDadosSeleccionados(lblDado1, lblDado2, lblDado3);
        }
        }while(!(cantidadDados >= 1 && cantidadDados <= 3));
    }
    //Genera los numeros de los dados de forma aleatoria y se le manda al objeto para que los maneje y muestre sus imagenes
    public void numeroAleatorioDados(){
        rdmDadoUno = (int) (rdm.nextDouble()*7)+1;
        rdmDadoDos = (int) (rdm.nextDouble()*7)+1;
        rdmDadoTres = (int) (rdm.nextDouble()*7)+1;
        Dados = new Dado(cantidadDados, rdmDadoUno, rdmDadoDos, rdmDadoTres);
        
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
            java.util.logging.Logger.getLogger(AreaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AreaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AreaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AreaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AreaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirTablero;
    private javax.swing.JButton btnAutomatico;
    private javax.swing.JButton btnBancarrota;
    private javax.swing.JButton btnConstruir;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnFinJuego;
    private javax.swing.JButton btnGuardarTablero;
    private javax.swing.JButton btnHipotecar;
    private javax.swing.JButton btnIngresarDatos;
    private javax.swing.JButton btnIngresarJugadores;
    private javax.swing.JButton btnIniciarJuego;
    private javax.swing.JButton btnLanzar;
    private javax.swing.JButton btnLimpiarTablero;
    private javax.swing.JButton btnTerminarTurno;
    private javax.swing.JButton btnVerPropiedades;
    private javax.swing.JComboBox<String> cboDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JLabel lblDado1;
    private javax.swing.JLabel lblDado2;
    private javax.swing.JLabel lblDado3;
    private javax.swing.JLabel lblMinRegresivos;
    private javax.swing.JLabel lblSegRegresivos;
    private javax.swing.JLabel lblTimer1;
    private javax.swing.JLabel lblTimer2;
    private javax.swing.JLabel minutos;
    private javax.swing.JPanel panelArreglo;
    private javax.swing.JLabel segundos;
    private javax.swing.JTextField txtColumna;
    private javax.swing.JTextField txtFila;
    // End of variables declaration//GEN-END:variables

}
