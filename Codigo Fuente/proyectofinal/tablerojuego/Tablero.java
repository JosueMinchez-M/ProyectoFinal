package proyectofinal.tablerojuego;

import Jugabilidad.MovimientosThread;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyectofinal.casillas.Inicio;
import proyectofinal.casillas.Neutro;
import proyectofinal.casillas.Tarjeta;
import proyectofinal.casillas.Trampa;
import proyectofinal.casillas.propiedad.Estacion;
import proyectofinal.casillas.propiedad.Lugar;
import proyectofinal.casillas.propiedad.ServicioBasico;
import proyectofinal.jugadores.Jugador;



/**
 *
 * @author joshua
 */
public class Tablero implements ActionListener{
    
    JButton [][] matrizBotones;
    Jugador[] jugadores;
    Lugar [] casillaLugar, casillaLugarIngresado;
    ServicioBasico[] casillaServicio, casillaServicioCreada;
    Estacion[] casillaEstacion, casillaEstacionCreada;
    ColorCasillas[] casillaColor;
    Tamaño tamaño;
    tamañoLugares lugaresTamaño;
    Inicio casillaInicio;
    Neutro casillaNeutraCarcel, casillaNeutraDescanso;
    Trampa casillaTrampa;
    Tarjeta casillaTomaTarjeta;
    String nombrePropiedad, fichaJugador, lugar;
    Color colorGrupos;
    private int Filas,Columnas, numCasillaTrampa, numCasillaTarjeta;
    private int sumaDados;
    private int cantidadDineroVuelta, cantidadDiponiblesCasas, cantidadDisponiblesHoteles;
    private final double porcentajeHipoteca = 0.5;
    int precioLugar, precioHipoteca, cantidadCasas, cantidadHoteles, costoEstancia, precioCasa, precioHotel;
    int costoServicio, costoUsoEstacion;
    int sumaAux;
    int contadorServicio = -1, contadorEstacion = -1;
    int contador = -1, contadorMostrar = -1, contadorColor = -1, contadorMovimientos = -1;
    int lugaresInferior, lugaresIzquierda, lugaresSuperior, lugaresDerecha, sumaLugaresTablero;
    
    public Tablero(){
        
    }
    //Obtener la cantidad de Dados y la sumatoria random de los dados que se activen 
    public void obtenerNumerosRandom(int cantidadDados, int rdmDadoUno, int rdmDadoDos, int rdmDadoTres){
        if(cantidadDados == 1){
            sumaDados = rdmDadoUno;
        }else if(cantidadDados == 2){
            sumaDados = rdmDadoUno+rdmDadoDos;
        }else if(cantidadDados == 3){
            sumaDados = rdmDadoUno+rdmDadoDos+rdmDadoTres;
        }
    }
    //Llama a la clase Thread donde se maneja el movimiento de las fichas en las casillas
    public synchronized void movimientosJugabilidad(){
        contadorMovimientos++;
        if(contadorMovimientos == 0){
            MovimientosThread jugador1 = new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador1.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }else if(contadorMovimientos == 1){
            MovimientosThread jugador2= new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador2.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }else if(contadorMovimientos == 2){
            MovimientosThread jugador3= new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador3.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }else if(contadorMovimientos == 3){
            MovimientosThread jugador4= new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador4.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }else if(contadorMovimientos == 4){
            MovimientosThread jugador5= new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador5.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }else if(contadorMovimientos == 5){
            MovimientosThread jugador6= new MovimientosThread(tamaño.getFilas(), tamaño.getColumnas(), sumaDados, jugadores[contadorMovimientos], matrizBotones, casillaInicio,
            casillaNeutraCarcel, casillaNeutraDescanso, casillaTrampa, casillaTomaTarjeta, casillaLugar, casillaServicio, casillaEstacion, casillaLugarIngresado,
            casillaServicioCreada, casillaEstacionCreada, lugaresTamaño.getCantidadLugaresPorFoC());
            jugador6.start();
            if(contadorMovimientos == jugadores.length-1){
                contadorMovimientos = -1;
            }
        }
    }
    //Crea el tablero Automaticamente con sus lugares y el movimiento
    public void tableroBotonesAutomatico(JPanel panel, int filas, int columnas, int cantDineroVuelta, int cantCasas, int cantHoteles){
        Filas = filas;
        Columnas = columnas;
        tamaño = new Tamaño(Filas, Columnas);
        cantidadDineroVuelta = cantDineroVuelta;
        cantidadDiponiblesCasas = cantCasas;
        cantidadDisponiblesHoteles = cantHoteles;
        matrizBotones = new JButton[tamaño.getFilas()][tamaño.getColumnas()];
        panel.setLayout(new GridLayout(tamaño.getFilas(),tamaño.getColumnas()));
        casillasFijas();
        capturarLugar();
        capturarServicio();
        capturarEstacion();
        
        for (int i = 0; i < tamaño.getFilas(); i++) {
            for (int j = 0; j < tamaño.getColumnas(); j++) {
                matrizBotones[i][j] = new JButton();
                //matrizBotones[i][j].addActionListener(this);
                matrizBotones[i][j].setSize(50, 50);
                panel.add(matrizBotones[i][j]);
            }
        }
        casillasDefinidas();
        casillasInferiorAutomaticas();
        casillasIzquierdaAutomaticas();
        casillasDerechaAutomaticas();
        casillasSuperiorAutomaticas();
        panel.updateUI();
    }
    //Permite manipular las casillas del tablero y poder ingrear los datos
    public void tableroBotones(JPanel panel, int filas, int columnas){
        Filas = filas;
        Columnas = columnas;
        tamaño = new Tamaño(Filas, Columnas);
        matrizBotones = new JButton[tamaño.getFilas()][tamaño.getColumnas()];
        panel.setLayout(new GridLayout(tamaño.getFilas(),tamaño.getColumnas()));
        casillasFijas();
        
        for (int i = 0; i < tamaño.getFilas(); i++) {
            for (int j = 0; j < tamaño.getColumnas(); j++) {
                matrizBotones[i][j] = new JButton();
                matrizBotones[i][j].addActionListener(this);
                matrizBotones[i][j].setSize(50, 50);
                panel.add(matrizBotones[i][j]);
            }
        }
        casillasDefinidas();
        casillaServicioCreada = new ServicioBasico[2];
        casillaEstacionCreada = new Estacion[2];
        casillaColor = new ColorCasillas[8];
        colorGruposFilaInferior();
        colorGruposColumnaIzquierda();
        colorGruposFilaSuperior();
        colorGruposColumnaDerecha();
        sumaLugaresTablero = lugaresInferior+lugaresIzquierda+lugaresSuperior+lugaresDerecha;
        lugaresTamaño = new tamañoLugares(sumaLugaresTablero, lugaresInferior);
        casillaLugarIngresado = new Lugar[lugaresTamaño.getSumaLugaresTablero()];
        panel.updateUI();
    }
    //Tablero que recibe todos los datos que se le envian al momento de crearlo 
    public void tableroBotonesCreada(JPanel panel){
        matrizBotones = new JButton[tamaño.getFilas()][tamaño.getColumnas()];
        panel.setLayout(new GridLayout(tamaño.getFilas(),tamaño.getColumnas()));
        casillasFijas();
        
        for (int i = 0; i < tamaño.getFilas(); i++) {
            for (int j = 0; j < tamaño.getColumnas(); j++) {
                matrizBotones[i][j] = new JButton();
                //matrizBotones[i][j].addActionListener(this);
                matrizBotones[i][j].setSize(50, 50);
                panel.add(matrizBotones[i][j]);
            }
        }
        casillasDefinidas();
        mostrarPropiedadLugarFilaInferior();
        mostrarPropiedadLugarIzquierda();
        mostrarPropiedadLugarSuperior();
        mostrarPropiedadLugarDerecha();
        mostrarSoE();
        panel.updateUI();
    }
    //Nos permite acceder a los botones en este caso casilla que hemos definido para ingresar los datos
    @Override
    public void actionPerformed(ActionEvent ae) {
        propiedadLugarFilaSuperior(ae);
        propiedadLugarFilaInferior(ae);
        propiedadLugarColumnaIzquierda(ae);
        propiedadLugarColumnaDerecha(ae);
        SoEInferior(ae);
        SoEIzquierda(ae);
        SoESuperior(ae);
        SoEDerecha(ae);
    }
    //Invoca a los objetos de las casillas 
    public void casillasFijas(){
        casillaInicio = new Inicio("INICIO", cantidadDineroVuelta);
        casillaNeutraCarcel = new Neutro("CARCEL");
        casillaNeutraDescanso = new Neutro("DESCANSO");
        casillaTrampa = new Trampa("Trampa", 4, 100, 0);
        casillaTomaTarjeta = new Tarjeta("Tarjeta", 100, 50, 4);
    }
    //Captura la cantidad de jugadores y permite el ingreso de los mismos
    public void ingresarJugadores(int cantidadJugadores, int cantidadDinero){
        jugadores = new Jugador[cantidadJugadores];
        for (int i = 0; i < jugadores.length; i++) {
            String nombreJugador = JOptionPane.showInputDialog(null,"INGRESA UN NOMBRE: "
            ,"JUGADOR " + (i+1), JOptionPane.QUESTION_MESSAGE);
            int opcionFichaJugador;
            do{
                opcionFichaJugador = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESA EL NUMERO DE TU ELECCION:\n1- ♚\n2- ☯"
                    + "\n3- ▸\n4- ⭑\n5- ❃\n6- ❤","FICHA JUGADOR " + (i+1), JOptionPane.QUESTION_MESSAGE));
                if(opcionFichaJugador >= 1 && opcionFichaJugador <=6){
                    fichaJugador(opcionFichaJugador);
                }else{
                    JOptionPane.showMessageDialog(null, "Caracter no valido, intentelo de nuevo.");
                }
            }while(!(opcionFichaJugador >= 1 && opcionFichaJugador <=6));
            jugadores[i] = new Jugador(nombreJugador, cantidadDinero, fichaJugador);
        }
    }
    //Obtiene la ficha que desea el jugador
    public void fichaJugador(int opcionFichaJugador){
        if(opcionFichaJugador == 1){
            fichaJugador = "♚";
        }else if(opcionFichaJugador == 2){
            fichaJugador = "☯";
        }else if(opcionFichaJugador == 3){
            fichaJugador = "▸";
        }else if(opcionFichaJugador == 4){
            fichaJugador = "⭑";
        }else if(opcionFichaJugador == 5){
            fichaJugador = "❃";
        }else if(opcionFichaJugador == 6){
            fichaJugador = "❤";
        }
    }
    //Casillas definidas del tablero 
    public void casillasDefinidas(){
        numCasillaTrampa = tamaño.getColumnas()/2;
        numCasillaTarjeta = tamaño.getFilas()/2;
        matrizBotones[tamaño.getFilas()-1][tamaño.getColumnas()-1].setBackground(Color.gray);
        matrizBotones[tamaño.getFilas()-1][tamaño.getColumnas()-1].setText(casillaInicio.getTipo());
        matrizBotones[tamaño.getFilas()-1][0].setBackground(Color.gray);
        matrizBotones[tamaño.getFilas()-1][0].setText(casillaNeutraCarcel.getTipo());
        matrizBotones[0][0].setBackground(Color.gray);
        matrizBotones[0][0].setText(casillaNeutraDescanso.getTipo());
        //matrizBotones[0][0].setToolTipText("DESCANSO GRATIS");
        matrizBotones[0][0].setFont(new Font("",Font.ITALIC,10));
        matrizBotones[0][tamaño.getColumnas()-1].setBackground(Color.gray);
        matrizBotones[0][tamaño.getColumnas()-1].setText("IR CARCEL");
        matrizBotones[0][tamaño.getColumnas()-1].setFont(new Font("",Font.ITALIC,10));
        matrizBotones[0][numCasillaTrampa].setBackground(Color.gray);
        matrizBotones[0][numCasillaTrampa].setText(casillaTrampa.getTipo());
        matrizBotones[tamaño.getFilas()-1][numCasillaTrampa].setBackground(Color.gray);
        matrizBotones[tamaño.getFilas()-1][numCasillaTrampa].setText(casillaTrampa.getTipo());
        matrizBotones[numCasillaTarjeta][0].setBackground(Color.gray);
        matrizBotones[numCasillaTarjeta][0].setText(casillaTomaTarjeta.getTipo());
        matrizBotones[numCasillaTarjeta][tamaño.getColumnas()-1].setBackground(Color.gray);
        matrizBotones[numCasillaTarjeta][tamaño.getColumnas()-1].setText(casillaTomaTarjeta.getTipo());
    }
    //Permite ingresar a las casillas inferiores del tablero para brindarle los datos necesarios con direccion a las agujas del reloj
    public void propiedadLugarFilaInferior(ActionEvent ae){
        for (int i = tamaño.getFilas()-1; i < tamaño.getFilas(); i++) {
            for (int j = tamaño.getColumnas()-2; j >= numCasillaTrampa+1; j--) {
                if(ae.getSource() == matrizBotones[tamaño.getFilas()-1][j]){
                    contador++;
                    datosCasillasLugar(tamaño.getFilas()-1, j);
                    casillaLugarIngresado[contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[0].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
        for (int i = tamaño.getFilas()-1; i <= tamaño.getFilas()-1; i++) {
            for (int j = numCasillaTrampa-2; j >= 1; j--) {
                if(ae.getSource() == matrizBotones[tamaño.getFilas()-1][j]){
                    contador++;
                    datosCasillasLugar(tamaño.getFilas()-1, j);
                    casillaLugarIngresado [contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[1].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
    }
    //Permite ingresar a las casillas izquierdas del tablero para brindarle los datos necesarios con direccion a las agujas del reloj
    public void propiedadLugarColumnaIzquierda(ActionEvent ae){
        for (int i = tamaño.getFilas()-2; i >= numCasillaTarjeta+1; i--) {
            for (int j = 0; j < 1; j++) {
                if(ae.getSource() == matrizBotones[i][0]){
                    contador++;
                    datosCasillasLugar(i, 0);
                    casillaLugarIngresado[contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[2].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
        for (int i = numCasillaTarjeta-2; i >= 1; i--) {
            for (int j = 0; j < 1; j++) {
                if(ae.getSource() == matrizBotones[i][0]){
                    contador++;
                    datosCasillasLugar(i, 0);
                    casillaLugarIngresado[contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[3].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
    }
    //Permite ingresar a las casillas superiores del tablero para brindarle los datos necesarios con direccion a las agujas del reloj
    public void propiedadLugarFilaSuperior(ActionEvent ae){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                if(ae.getSource() == matrizBotones[0][j]){
                    contador++;
                    datosCasillasLugar(0, j);
                    casillaLugarIngresado [contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[4].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < tamaño.getColumnas()-1; j++) {
                if(ae.getSource() == matrizBotones[0][j]){
                    contador++;
                    datosCasillasLugar(0, j);
                    casillaLugarIngresado [contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[5].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
    }//Permite ingresar a las casillas de la Derecha del tablero para brindarle los datos necesarios con direccion a las agujas del reloj
    public void propiedadLugarColumnaDerecha(ActionEvent ae){
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                if(ae.getSource() == matrizBotones[i][tamaño.getColumnas()-1]){
                    contador++;
                    datosCasillasLugar(i, tamaño.getColumnas()-1);
                    casillaLugarIngresado[contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[6].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
            for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                if(ae.getSource() == matrizBotones[i][tamaño.getColumnas()-1]){
                    contador++;
                    datosCasillasLugar(i, tamaño.getColumnas()-1);
                    casillaLugarIngresado[contador] = new Lugar("Lugar", nombrePropiedad, "Ningúno", precioLugar, precioHipoteca, false, casillaColor[7].getColorCasilla(),
                    cantidadHoteles, cantidadCasas, costoEstancia, precioCasa, precioHotel);
                }
            }
        }
    }
    //Muestra las propiedades en el tablero que se crea en el boton iniciar juego
    public void mostrarPropiedadLugarFilaInferior(){
        for (int i = tamaño.getFilas()-1; i < tamaño.getFilas(); i++) {
            for (int j = tamaño.getColumnas()-2; j >= numCasillaTrampa+1; j--) {
                if(i == tamaño.getFilas()-1 && j == tamaño.getColumnas()-2){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-1 && j == tamaño.getColumnas()-3){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-1 && j == tamaño.getColumnas()-4){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                     matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                     matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
        for (int i = tamaño.getFilas()-1; i <= tamaño.getFilas()-1; i++) {
            for (int j = numCasillaTrampa-2; j >= 1; j--) {
                if(i == tamaño.getFilas()-1 && j == numCasillaTrampa-2){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-1 && j == numCasillaTrampa-3){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-1 && j == numCasillaTrampa-4){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                     matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                     matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
    }
    //Muestra las propiedades en el tablero que se crea en el boton iniciar juego
    public void mostrarPropiedadLugarIzquierda(){
        for (int i = tamaño.getFilas()-2; i >= numCasillaTarjeta+1; i--) {
            for (int j = 0; j < 1; j++) {
                if(i == tamaño.getFilas()-2 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-3 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == tamaño.getFilas()-4 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta-2; i >= 1; i--) {
            for (int j = 0; j < 1; j++) {                //casillaLugarInferior2 = new Lugar[(numCasillaTrampa-1)-1];
                if(i == numCasillaTarjeta-2 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == numCasillaTarjeta-3 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == numCasillaTarjeta-4 && j == 0){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                     matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                     matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
    }
    //Muestra las propiedades en el tablero que se crea en el boton iniciar juego
    public void mostrarPropiedadLugarSuperior(){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                if(i == 0 && j == 1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 0 && j == 2){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 0 && j == 3){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < tamaño.getColumnas()-1; j++) {
                if(i == 0 && j == numCasillaTrampa+1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 0 && j == numCasillaTrampa+2){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 0 && j == numCasillaTrampa+3){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
    }
    //Muestra las propiedades en el tablero que se crea en el boton iniciar juego
    public void mostrarPropiedadLugarDerecha(){
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                if(i == 1 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 2 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == 3 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
        //Muestra las propiedades en el tablero que se crea en el boton iniciar juego
        for (int i = numCasillaTarjeta+1; i < tamaño.getFilas()-1; i++) {
            for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                if(i == numCasillaTarjeta+1 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == numCasillaTarjeta+2 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }else if(i == numCasillaTarjeta+3 && j == tamaño.getColumnas()-1){
                    contadorMostrar++;
                    matrizBotones[i][j].setBackground(casillaLugarIngresado[contadorMostrar].getGrupoColor());
                    matrizBotones[i][j].setText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText(casillaLugarIngresado[contadorMostrar].getNombrePropiedad() +" Precio: " + casillaLugarIngresado[contadorMostrar].getPrecioCompra() + " Dueño: " + casillaLugarIngresado[contadorMostrar].getDueñoPropiedad());
                }
            }
        }
    }
    //Metodo que sirve para editar las casillas tipo Lugar del tablero
    public void datosCasillasLugar(int i, int j){
        matrizBotones[i][j].setName("Lugar");
        nombrePropiedad = JOptionPane.showInputDialog("Que nombre le darás a éste LUGAR: ");
        precioLugar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Precio de " + nombrePropiedad +": "));
        precioHipoteca = (int) (precioLugar * porcentajeHipoteca);
        cantidadHoteles = 0;
        cantidadCasas = 0;
        costoEstancia = (int) (precioLugar * 0.25);
        precioHotel = 100;
        precioCasa = precioHotel/2;
        matrizBotones[i][j].setText(nombrePropiedad);
        matrizBotones[i][j].setToolTipText(nombrePropiedad + " Precio: " + precioLugar + " PrecioHipoteca: " + precioHipoteca);
        matrizBotones[i][j].setEnabled(false);
        
    }
    //Permite colorear los grupos de Lugares
    public void colorGrupo(int color, int i, int j){
        if(color == 1){
            colorGrupos = Color.BLUE;
            matrizBotones[i][j].setBackground(colorGrupos);
        }else if(color == 2){
            colorGrupos = Color.GREEN;
            matrizBotones[i][j].setBackground(colorGrupos);
        }else if(color == 3){
            colorGrupos = Color.PINK;
            matrizBotones[i][j].setBackground(colorGrupos);
        }else if(color == 4){
            colorGrupos = Color.RED;
            matrizBotones[i][j].setBackground(colorGrupos);
        }else if(color == 5){
            colorGrupos = Color.WHITE;
            matrizBotones[i][j].setBackground(colorGrupos);
        }else if(color == 6){
            colorGrupos = Color.ORANGE;
            matrizBotones[i][j].setBackground(colorGrupos);                        
        }else if(color == 7){
            colorGrupos = Color.magenta;
            matrizBotones[i][j].setBackground(colorGrupos);                                                
        }else if(color == 8){
            colorGrupos = Color.YELLOW;
            matrizBotones[i][j].setBackground(colorGrupos);
        }
    }
    //Obtiene el color que desea el jugador para el grupo de lugares inferiores
    public void colorGruposFilaInferior(){
        int color;
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = tamaño.getFilas()-1; i < tamaño.getFilas(); i++) {
                    for (int j = numCasillaTrampa+1; j < tamaño.getColumnas()-1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[0] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
               for (int i = tamaño.getFilas()-1; i <= tamaño.getFilas()-1; i++) {
                    for (int j = 1; j < numCasillaTrampa-1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[1] = new ColorCasillas(colorGrupos);
                    }
                } 
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        lugaresInferior = ((numCasillaTrampa-1)-1) + (tamaño.getColumnas()-1)-(numCasillaTrampa+1);
    }
    //Obtiene el color que desea el jugador para el grupo de lugares de la Columna Izquierda
    public void colorGruposColumnaIzquierda(){
        int color;
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = numCasillaTarjeta+1; i < tamaño.getFilas()-1; i++) {
                    for (int j = 0; j < 1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[2] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = 1; i < numCasillaTarjeta-1; i++) {
                    for (int j = 0; j < 1; j++) {                colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[3] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        lugaresIzquierda = ((numCasillaTarjeta-1)-1) + (tamaño.getFilas()-1)-(numCasillaTarjeta+1);
    }
    //Obtiene el color que desea el jugador para el grupo de lugares de la Fila Superior
    public void colorGruposFilaSuperior(){
        int color;
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = 0; i < 1; i++) {
                    for (int j = 1; j < numCasillaTrampa-1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[4] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = 0; i < 1; i++) {
                    for (int j = numCasillaTrampa+1; j < tamaño.getColumnas()-1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[5] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        lugaresSuperior = ((numCasillaTrampa-1)-1) + (tamaño.getColumnas()-1)-(numCasillaTrampa+1);
    }
    //Obtiene el color que desea el jugador para el grupo de lugares Columna Derecha
    public void colorGruposColumnaDerecha(){
        int color;
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = 1; i < numCasillaTarjeta-1; i++) {
                    for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                        colorGrupo(color,i,j);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[6] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        do{
            color = Integer.parseInt(JOptionPane.showInputDialog("GRUPO DE LUGARES: \n1. Azul\n2. Verde\n3. Rosado\n4. Rojo\n5. Blanco\n6. Anaranjado\n7. Morado\n8.Amarillo"));
            if(color >=1 && color <= 8){
                for (int i = numCasillaTarjeta+1; i < tamaño.getFilas()-1; i++) {
                    for (int j = tamaño.getColumnas()-1; j <= tamaño.getColumnas()-1; j++) {
                        colorGrupo(color,i,tamaño.getColumnas()-1);
                        matrizBotones[i][j].setText("LUGAR");
                        casillaColor[7] = new ColorCasillas(colorGrupos);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Caracter no valido, intentalo de nuevo.");
            }
        }while(!(color >=1 && color <= 8));
        lugaresDerecha = ((numCasillaTarjeta-1)-1) + (tamaño.getFilas()-1)-(numCasillaTarjeta+1);
    }
    //Permite el ingreso de los datos a las casillas tipo servicio basico
    public void datosCasillasServicio(int i, int j){
        contadorServicio++;
        matrizBotones[i][j].setBackground(Color.CYAN);
        nombrePropiedad = JOptionPane.showInputDialog("Ingresa el Nombre del SERVICIO: ");
        int precioServicioBasico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Precio de " +nombrePropiedad+ ": "));
        int precioHipotecaServicioBasico = (int)(precioServicioBasico*0.5);
        costoServicio = (int) (precioServicioBasico*0.40);
        matrizBotones[i][j].setText(nombrePropiedad);
        matrizBotones[i][j].setToolTipText(nombrePropiedad + " Precio: " + precioServicioBasico);
        casillaServicioCreada[contadorServicio] = new ServicioBasico("Servicio", nombrePropiedad, "", precioServicioBasico, precioHipotecaServicioBasico, false, costoServicio);
    }
    //Permite el ingreso de los datos a las casillas de tipo Estacion
    public void datosCasillasEstacion(int i, int j){
        contadorEstacion++;
        matrizBotones[i][j].setBackground(Color.CYAN);
        nombrePropiedad = JOptionPane.showInputDialog("Ingresa el Nombre de la ESTACION: ");
        int precioEstacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Precio de " +nombrePropiedad+ ": "));
        int precioHipotecaEstacion = (int)(precioEstacion*0.5);
        costoUsoEstacion = (int) (precioEstacion*0.40);
        matrizBotones[i][j].setText(nombrePropiedad);
        matrizBotones[i][j].setToolTipText(nombrePropiedad + " Precio: " + precioEstacion);
        casillaEstacionCreada[contadorEstacion] = new Estacion("Estacion", nombrePropiedad, "", precioEstacion, precioHipotecaEstacion, false, costoUsoEstacion);
    }
    //Permite el ingreso por click a la Estacion inferior
    public void SoEInferior(ActionEvent ae){
        if(ae.getSource() == matrizBotones[tamaño.getFilas()-1][numCasillaTrampa-1]){
            datosCasillasEstacion(tamaño.getFilas()-1,numCasillaTrampa-1);
            matrizBotones[tamaño.getFilas()-1][numCasillaTrampa-1].setEnabled(false);
        }
    }
    //Permite el ingreso por click al servicio basico izquierda
    public void SoEIzquierda(ActionEvent ae){
        if(ae.getSource() == matrizBotones[numCasillaTarjeta-1][0]){
            datosCasillasServicio(numCasillaTarjeta-1,0);
            matrizBotones[numCasillaTarjeta-1][0].setEnabled(false);
        }
    }
    //Permite el ingreso por click a la Estacion superior
    public void SoESuperior(ActionEvent ae){
        if(ae.getSource() == matrizBotones[0][numCasillaTrampa-1]){
            datosCasillasEstacion(0,numCasillaTrampa-1);
            matrizBotones[0][numCasillaTrampa-1].setEnabled(false);
       }
    }
    //Permite el ingreso por click al Servicio Basico columna derecha
    public void SoEDerecha(ActionEvent ae){
        if(ae.getSource() == matrizBotones[numCasillaTarjeta-1][tamaño.getColumnas()-1]){
            datosCasillasServicio(numCasillaTarjeta-1,tamaño.getColumnas()-1);
            matrizBotones[numCasillaTarjeta-1][tamaño.getColumnas()-1].setEnabled(false);
        }
    }
    //Muesta en el tablero a los Servicios Basicos y Estaciones
    public void mostrarSoE(){
        matrizBotones[tamaño.getFilas()-1][numCasillaTrampa-1].setBackground(Color.CYAN);
        matrizBotones[tamaño.getFilas()-1][numCasillaTrampa-1].setText(casillaEstacionCreada[0].getNombrePropiedad());
        matrizBotones[tamaño.getFilas()-1][numCasillaTrampa-1].setToolTipText(casillaEstacionCreada[0].getNombrePropiedad() + " Precio: " + casillaEstacionCreada[0].getPrecioCompra());
        matrizBotones[numCasillaTarjeta-1][0].setText(casillaServicioCreada[0].getNombrePropiedad());
        matrizBotones[numCasillaTarjeta-1][0].setBackground(Color.CYAN);
        matrizBotones[numCasillaTarjeta-1][0].setToolTipText(casillaServicioCreada[0].getNombrePropiedad() + " Precio: " + casillaServicioCreada[0].getPrecioCompra());
        matrizBotones[0][numCasillaTrampa-1].setText(casillaEstacionCreada[1].getNombrePropiedad());
        matrizBotones[0][numCasillaTrampa-1].setBackground(Color.CYAN);
        matrizBotones[0][numCasillaTrampa-1].setToolTipText(casillaEstacionCreada[1].getNombrePropiedad() + " Precio: " + casillaEstacionCreada[1].getPrecioCompra());
        matrizBotones[numCasillaTarjeta-1][tamaño.getColumnas()-1].setText(casillaServicioCreada[1].getNombrePropiedad());
        matrizBotones[numCasillaTarjeta-1][tamaño.getColumnas()-1].setBackground(Color.CYAN);
        matrizBotones[numCasillaTarjeta-1][tamaño.getColumnas()-1].setToolTipText(casillaServicioCreada[1].getNombrePropiedad() + " Precio: " + casillaServicioCreada[1].getPrecioCompra());
    }
    //ARCHIVO PARA GUARDAR EL OBJETO DEL TABLERO CREADO
    public void guardarTablero(String path){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path));
            salida.writeObject(casillaLugarIngresado);
            salida.writeObject(tamaño);
            salida.writeObject(lugaresTamaño);
            salida.writeObject(casillaServicioCreada);
            salida.writeObject(casillaEstacionCreada);
            salida.close();   
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR E/S");
        }
    }
    //LEE LOS DATOS QUE SE GUARDAN EN EL ARCHIVO CON EXTENCION .BOARD
    public void leerTablero(String path){
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            casillaLugarIngresado = (Lugar[]) flujoSalida.readObject();
            tamaño = (Tamaño) flujoSalida.readObject();
            lugaresTamaño = (tamañoLugares) flujoSalida.readObject();
            casillaServicioCreada = (ServicioBasico[]) flujoSalida.readObject();
            casillaEstacionCreada = (Estacion[]) flujoSalida.readObject();
            flujoSalida.close();
            JOptionPane.showMessageDialog(null, sumaLugaresTablero);
            //Mostramos en consola los datos que se leen del archivo
            for (Lugar e : casillaLugarIngresado) {
                System.out.println(e);
            }
            //Mostramos en consola los datos que se leen del archivo
            System.out.println("\nNumero de Filas = " + tamaño.getFilas());
            System.out.println("Numero de Columnas = " + tamaño.getColumnas());
            System.out.println("Numero de Lugares = " + lugaresTamaño.getSumaLugaresTablero());
            //Mostramos en consola los datos que se leen del archivo
            for (ServicioBasico e : casillaServicioCreada) {
                System.out.println(e);
                //Mostramos en consola los datos que se leen del archivo
            }
            for (Estacion e : casillaEstacionCreada) {
                System.out.println(e);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERROR E/S");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }
    public void casillasDefinidasAutomatico(){
        casillasDefinidas();
    }
    //Obtiene los datos que aparecen en la fila inferior del tablero automatico
    public void casillasInferiorAutomaticas(){
        for (int i = tamaño.getFilas()-1; i < tamaño.getFilas(); i++) {
            for (int j = numCasillaTarjeta+2; j < tamaño.getColumnas()-1; j++) {
                matrizBotones[i][j].setBackground(Color.ORANGE);
                if(i == 9 && j == 7){
                    matrizBotones[i][j].setText(casillaLugar[1].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[1].getPrecioCompra());
                }else if(i == 9 && j == 8){
                    matrizBotones[i][j].setText(casillaLugar[0].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[0].getPrecioCompra());
                }
            }
        }
        for (int i = tamaño.getFilas()-1; i < tamaño.getFilas(); i++) {
            for (int j = 2; j < numCasillaTarjeta; j++) {
                matrizBotones[i][j].setBackground(Color.GREEN);
                if(i == 9 && j == 2){
                    matrizBotones[i][j].setText(casillaLugar[4].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[4].getPrecioCompra());
                }else if(i == 9 && j == 3){
                    matrizBotones[i][j].setText(casillaLugar[3].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[3].getPrecioCompra());
                }else if(i == 9 && j == 4){
                    matrizBotones[i][j].setText(casillaLugar[2].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[2].getPrecioCompra());
                }
            }
            matrizBotones[9][1].setBackground(Color.CYAN);
            matrizBotones[9][1].setText(casillaServicio[0].getNombrePropiedad());
            matrizBotones[9][1].setToolTipText("PRECIO: " + casillaServicio[0].getPrecioCompra());
            matrizBotones[9][6].setBackground(Color.CYAN);
            matrizBotones[9][6].setText(casillaEstacion[0].getNombrePropiedad());
            matrizBotones[9][6].setToolTipText("PRECIO: " + casillaEstacion[0].getPrecioCompra());
        }
    }
    //Obtiene los datos que aparecen en la Columna izquierda del tablero automatico
    public void casillasIzquierdaAutomaticas(){
        for (int i = numCasillaTarjeta+1; i < tamaño.getFilas()-1; i++) {
            for (int j = 0; j < 1; j++) {
                matrizBotones[i][j].setBackground(Color.MAGENTA);
                if(i == 8 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[5].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[5].getPrecioCompra());
                }else if(i == 7 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[6].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[6].getPrecioCompra());
                }else if(i == 6 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[7].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[7].getPrecioCompra());
                }
            }
        }
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = 0; j < 1; j++) {
                matrizBotones[i][j].setBackground(Color.PINK);
                if(i == 3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[8].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[8].getPrecioCompra());
                }else if(i == 2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[9].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[9].getPrecioCompra());
                }else if(i == 1 && j == 0){
                    matrizBotones[i][j].setText(casillaLugar[10].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[10].getPrecioCompra());
                }
            }
            matrizBotones[4][0].setBackground(Color.CYAN);
            matrizBotones[4][0].setText(casillaServicio[1].getNombrePropiedad());
            matrizBotones[4][0].setToolTipText("PRECIO: " + casillaServicio[1].getPrecioCompra());
        }
    }
    //Obtiene los datos que aparecen en la fila Superior del tablero automatico
    public void casillasSuperiorAutomaticas(){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                matrizBotones[i][j].setBackground(Color.RED);
                if(i == 0 && j == 1){
                    matrizBotones[i][j].setText(casillaLugar[11].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[11].getPrecioCompra());
                }else if(i == 0 && j == 2){
                    matrizBotones[i][j].setText(casillaLugar[12].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[12].getPrecioCompra());
                }else if(i == 0 && j==3){
                    matrizBotones[i][j].setText(casillaLugar[13].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[13].getPrecioCompra());
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < tamaño.getColumnas()-1; j++) {
                matrizBotones[i][j].setBackground(Color.GREEN);
                if(i == 0 && j == 6){
                    matrizBotones[i][j].setText(casillaLugar[14].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[14].getPrecioCompra());
                }else if(i == 0 && j == 7){
                    matrizBotones[i][j].setText(casillaLugar[15].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[15].getPrecioCompra());
                }
            }
            matrizBotones[0][4].setBackground(Color.CYAN);
            matrizBotones[0][4].setText(casillaEstacion[1].getNombrePropiedad());
            matrizBotones[0][4].setToolTipText("PRECIO: " + casillaEstacion[1].getPrecioCompra());
            matrizBotones[0][8].setBackground(Color.CYAN);
            matrizBotones[0][8].setText(casillaServicio[2].getNombrePropiedad());
            matrizBotones[0][8].setToolTipText("PRECIO: " + casillaServicio[2].getPrecioCompra());
        }
    }
    //Obtiene los datos que aparecen en la Columna Derecha del tablero automatico
    public void casillasDerechaAutomaticas(){
        for (int i = 1; i < numCasillaTarjeta; i++) {
            for (int j = tamaño.getColumnas()-1; j < tamaño.getColumnas(); j++) {
                matrizBotones[i][j].setBackground(Color.WHITE);
                if(i == 1 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[16].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[16].getPrecioCompra());
                }else if(i == 2 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[17].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[17].getPrecioCompra());
                }else if(i == 3 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[18].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[18].getPrecioCompra());
                }
            }
        }
        for (int i = numCasillaTarjeta+1; i < tamaño.getFilas()-1; i++) {
            for (int j = tamaño.getColumnas()-1; j < tamaño.getColumnas(); j++) {
                matrizBotones[i][j].setBackground(Color.YELLOW);
                if(i == 6 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[19].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[19].getPrecioCompra());
                }else if(i == 7 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[20].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[20].getPrecioCompra());
                }else if(i == 8 && j == 9){
                    matrizBotones[i][j].setText(casillaLugar[21].getNombrePropiedad());
                    matrizBotones[i][j].setToolTipText("PRECIO: " + casillaLugar[21].getPrecioCompra());
                }
            }
            matrizBotones[4][9].setBackground(Color.CYAN);
            matrizBotones[4][9].setText(casillaEstacion[2].getNombrePropiedad());
            matrizBotones[4][9].setToolTipText("PRECIO: " + casillaEstacion[2].getPrecioCompra());
        }
    }
    //Captura los datos de los servicios basicos del tablero automático
    public void capturarServicio(){
        casillaServicio = new ServicioBasico[3];
        casillaServicio[0] = new ServicioBasico("Servicio Basico", "EMPAGUA", "", 175, (int)(175*porcentajeHipoteca), false, (int)(175*0.40));
        casillaServicio[1] = new ServicioBasico("Servicio Basico", "BUS", "", 190, (int)(190*porcentajeHipoteca), false, (int)(190*0.40));
        casillaServicio[2] = new ServicioBasico("Servicio Basico", "INDE", "", 175, (int)(175*porcentajeHipoteca), false, (int)(175*0.40));
    }
    //Captura los datos de las Estaciones del tablero automático
    public void capturarEstacion(){
        casillaEstacion = new Estacion[3];
        casillaEstacion[0] = new Estacion("Estacion", "FLOMERCA", "", 210, (int)(210*porcentajeHipoteca), false, (int)(210*0.40));
        casillaEstacion[1] = new Estacion("Estacion", "AVIATECA", "", 210, (int)(210*porcentajeHipoteca), false, (int)(210*0.40));
        casillaEstacion[2] = new Estacion("Estacion", "FEGUA", "", 190, (int)(190*porcentajeHipoteca), false, (int)(190*0.40));
    }
    //Captura los datos de los lugares que se muestran en el tablero automatico
    public void capturarLugar(){
        casillaLugar = new Lugar[22];
        casillaLugar[0] = new Lugar("Lugar", "JUTIAPA", "", 360, (int)(360*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (360*0.25), 50, 100);
        casillaLugar[1] = new Lugar("Lugar", "JALAPA", "", 390, (int)(390*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (390*0.25), 50, 100);
        casillaLugar[2] = new Lugar("Lugar", "ESCUINTLA", "", 190, (int)(190*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (190*0.25), 50, 100);
        casillaLugar[3] = new Lugar("Lugar", "RETALHULEU", "", 200, (int)(200*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (200*0.25), 50, 100);
        casillaLugar[4] = new Lugar("Lugar", "SOLOLA", "", 170, (int)(170*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (170*0.25), 50, 100);
        casillaLugar[5] = new Lugar("Lugar", "PETEN", "", 50, (int)(50*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (50*0.25), 50, 100);
        casillaLugar[6] = new Lugar("Lugar", "PROGRESO", "", 70, (int)(70*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (70*0.25), 50, 100);
        casillaLugar[7] = new Lugar("Lugar", "HUEHUETENANGO", "", 130, (int)(130*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (130*0.25), 50, 100);
        casillaLugar[8] = new Lugar("Lugar", "ALTA VEREPAZ", "", 300, (int)(300*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (300*0.25), 50, 100);
        casillaLugar[9] = new Lugar("Lugar", "QUETZALTENANGO", "", 90, (int)(90*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (90*0.25), 50, 100);
        casillaLugar[10] = new Lugar("Lugar", "GUATEMALA", "", 250, (int)(250*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (250*0.25), 50, 100);
        casillaLugar[11] = new Lugar("Lugar", "CHIMALTENANGO", "", 150, (int)(150*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (150*0.25), 50, 100);
        casillaLugar[12] = new Lugar("Lugar", "QUICHE", "", 150, (int)(150*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (150*0.25), 50, 100);
        casillaLugar[13] = new Lugar("Lugar", "IZABAL", "", 140, (int)(140*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (140*0.25), 50, 100);
        casillaLugar[14] = new Lugar("Lugar", "SAN MARCOS", "", 230, (int)(230*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (230*0.25), 50, 100);
        casillaLugar[15] = new Lugar("Lugar", "ZACAPA", "", 170, (int)(170*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (170*0.25), 50, 100);
        casillaLugar[16] = new Lugar("Lugar", "SANTA ROSA", "", 200, (int)(200*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (200*0.25), 50, 100);
        casillaLugar[17] = new Lugar("Lugar", "SACATEPEQUEZ", "", 310, (int)(310*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (310*0.25), 50, 100);
        casillaLugar[18] = new Lugar("Lugar", "SUCHITEPEQUEZ", "", 300, (int)(300*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (300*0.25), 50, 100);
        casillaLugar[19] = new Lugar("Lugar", "BAJA VERAPAZ", "", 270, (int)(270*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (270*0.25), 50, 100);
        casillaLugar[20] = new Lugar("Lugar", "TOTONICAPAN", "", 280, (int)(280*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (280*0.25), 50, 100);
        casillaLugar[21] = new Lugar("Lugar", "CHIQUIMULA", "", 170, (int)(170*porcentajeHipoteca), false, colorGrupos, 0, 0, (int) (170*0.25), 50, 100);   
    }
}
