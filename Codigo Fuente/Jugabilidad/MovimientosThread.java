package Jugabilidad;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import proyectofinal.casillas.Inicio;
import proyectofinal.casillas.Neutro;
import proyectofinal.casillas.Tarjeta;
import proyectofinal.casillas.Trampa;
import proyectofinal.casillas.propiedad.Estacion;
import proyectofinal.casillas.propiedad.Lugar;
import proyectofinal.casillas.propiedad.ServicioBasico;
import proyectofinal.jugadores.Jugador;
import proyectofinal.tablerojuego.Tablero;

/**
 *
 * @author joshua
 */
public class MovimientosThread extends Thread{
   
    int Filas, Columnas;
    Jugador jugadores;
    Inicio casillaInicio;
    Neutro casillaNeutraCarcel, casillaNeutraDescanso;
    Trampa casillaTrampa;
    Tarjeta casillaTomaTarjeta;
    Lugar [] casillaLugar, casillaLugarIngresado;
    ServicioBasico [] casillaServicio, casillaServicioCreada;
    Estacion[] casillaEstacion, casillaEstacionCreada;
    JButton[][] matrizBotones;
    int sumaAux;
    int sumaDados;
    int cantLugaresPorFoC;
    int numCasillaTrampa, numCasillaTarjeta;
    int contadorMostrar = -1;

    public MovimientosThread(int Filas, int Columnas, int sumaDados, Jugador jugadores, JButton[][] matrizBotones, Inicio casillaInicio,
            Neutro casillaNeutraCarcel, Neutro casillaNeutraDescanso, Trampa casillaTrampa, Tarjeta casillaTomaTarjeta, Lugar[] casillaLugar,
            ServicioBasico[] casillaServicio, Estacion[] casillaEstacion, Lugar[] casillaLugarIngresado, ServicioBasico[] casillaServicioCreada,
            Estacion[] casillaEstacionCreada, int cantLugaresPorFoC) {
        this.Filas = Filas;
        this.Columnas = Columnas;
        this.sumaDados = sumaDados;
        this.jugadores = jugadores;
        this.matrizBotones = matrizBotones;
        this.casillaInicio = casillaInicio;
        this.casillaNeutraCarcel = casillaNeutraCarcel;
        this.casillaNeutraDescanso = casillaNeutraDescanso;
        this.casillaTrampa = casillaTrampa;
        this.casillaTomaTarjeta = casillaTomaTarjeta;
        this.casillaLugar = casillaLugar;
        this.casillaServicio = casillaServicio;
        this.casillaEstacion = casillaEstacion;
        this.casillaLugarIngresado = casillaLugarIngresado;
        this.casillaServicioCreada = casillaServicioCreada;
        this.casillaEstacionCreada = casillaEstacionCreada;
        this.cantLugaresPorFoC = cantLugaresPorFoC;
    }

    public int getFilas() {
        return Filas;
    }

    public void setFilas(int Filas) {
        this.Filas = Filas;
    }

    public int getSumaDados() {
        return sumaDados;
    }

    public void setSumaDados(int sumaDados) {
        this.sumaDados = sumaDados;
    }
    
    public int getColumnas() {
        return Columnas;
    }

    public void setColumnas(int Columnas) {
        this.Columnas = Columnas;
    }

    public Jugador getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugadores) {
        this.jugadores = jugadores;
    }

    public JButton[][] getMatrizBotones() {
        return matrizBotones;
    }

    public void setMatrizBotones(JButton[][] matrizBotones) {
        this.matrizBotones = matrizBotones;
    }
    //Metodo de la clase Thread que permite el movimiento de las fichas de los jugadores de la partida
    @Override
    public synchronized void run(){
        Tablero tableroBotones = new Tablero();
        JOptionPane.showMessageDialog(null, "Turno de " + jugadores.getUsuario() +" con la Ficha " + jugadores.getFicha());
        //Movimientos del tablero Automatico
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = Columnas-1; j >= (Columnas-1)-sumaDados; j--) {
                try {
                    if(Filas == 10 && Columnas == 10){
                        casillasDefinidas();
                        casillasInferiorAutomaticas();
                        matrizBotones[i][j].setText(jugadores.getFicha());
                        //Recorrido columna izquierda
                        if(j <= 0 ){
                            sumaAux = sumaDados-(Columnas-1);
                            for (int k = Filas-2; k >= (Filas-1)-sumaAux ; k--) {
                                for (int l = 0; l < 1; l++) {
                                    casillasDefinidas();
                                    casillasIzquierdaAutomaticas();
                                    matrizBotones[k][l].setText(jugadores.getFicha());
                                    Thread.sleep(500);
                                    //Recorrido fila superior
                                    if(k <= 0){
                                        sumaAux = sumaAux-(Filas-1);
                                        for (int m = 0; m < 1; m++) {
                                            for (int n = 1; n <= sumaAux; n++) {
                                                casillasDefinidas();
                                                casillasSuperiorAutomaticas();
                                                matrizBotones[m][n].setText(jugadores.getFicha());
                                                Thread.sleep(500);
                                                if(n >= 9){
                                                    sumaAux = sumaAux - (Columnas-1);
                                                    for (int o = 1; o <= sumaAux; o++) {
                                                        for (int p = Columnas-1; p < Columnas; p++) {
                                                            casillasDefinidas();
                                                            casillasDerechaAutomaticas();
                                                            matrizBotones[o][p].setText(jugadores.getFicha());
                                                            Thread.sleep(500);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }else{
                            
                        }
                    }else{//Movimientos del tablero que nosotros creamos o que obtenemos de nuestros archivos
                        casillasDefinidas();
                        mostrarSoE();       //Movimiento en la Fila inferior
                        mostrarPropiedadLugarInferior();
                        matrizBotones[i][j].setText(jugadores.getFicha());
                        if(j <= 0 ){//Movimiento en la Columna Izquierda del borde del tablero
                            sumaAux = sumaDados-(Columnas-1);
                            for (int k = Filas-2; k >= (Filas-1)-sumaAux ; k--) {
                                for (int l = 0; l < 1; l++) {
                                    casillasDefinidas();
                                    mostrarSoE();
                                    mostrarPropiedadLugarIzquierda();
                                    matrizBotones[k][l].setText(jugadores.getFicha());
                                    Thread.sleep(500);
                                    //Recorrido fila superior
                                    if(k <= 0){//Movimiento de la Fila Izquierda del borde del tablero
                                        sumaAux = sumaAux-(Filas-1);
                                        for (int m = 0; m < 1; m++) {
                                            for (int n = 1; n <= sumaAux; n++) {
                                                casillasDefinidas();
                                                mostrarSoE();
                                                mostrarPropiedadLugarSuperior();
                                                matrizBotones[m][n].setText(jugadores.getFicha());
                                                Thread.sleep(500);
                                                if(n >= 9){//Movimiento de la Columna Derecha del borde del tablero
                                                    sumaAux = sumaAux - (Columnas-1);
                                                    for (int o = 1; o <= sumaAux; o++) {
                                                        for (int p = Columnas-1; p < Columnas; p++) {
                                                            casillasDefinidas();
                                                            mostrarSoE();
                                                            mostrarPropiedadLugarDerecha();
                                                            matrizBotones[o][p].setText(jugadores.getFicha());
                                                            Thread.sleep(500);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                            
                    }              
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "FIN DE TU RECORRIDO ");
        
    }
    //Casillas que se muestran despues de que la ficha pasa por la casilla con los datos respectivos de la casilla
    public void casillasDefinidas(){
        numCasillaTrampa = Columnas/2;
        numCasillaTarjeta = Filas/2;
        matrizBotones[Filas-1][Columnas-1].setBackground(Color.gray);
        matrizBotones[Filas-1][Columnas-1].setText(casillaInicio.getTipo());
        matrizBotones[Filas-1][0].setBackground(Color.gray);
        matrizBotones[Filas-1][0].setText(casillaNeutraCarcel.getTipo());
        matrizBotones[0][0].setBackground(Color.gray);
        matrizBotones[0][0].setText(casillaNeutraDescanso.getTipo());
        matrizBotones[0][0].setFont(new Font("",Font.ITALIC,10));
        matrizBotones[0][Columnas-1].setBackground(Color.gray);
        matrizBotones[0][Columnas-1].setText("IR CARCEL");
        matrizBotones[0][Columnas-1].setFont(new Font("",Font.ITALIC,10));
        matrizBotones[0][numCasillaTrampa].setBackground(Color.gray);
        matrizBotones[0][numCasillaTrampa].setText(casillaTrampa.getTipo());
        matrizBotones[Filas-1][numCasillaTrampa].setBackground(Color.gray);
        matrizBotones[Filas-1][numCasillaTrampa].setText(casillaTrampa.getTipo());
        matrizBotones[numCasillaTarjeta][0].setBackground(Color.gray);
        matrizBotones[numCasillaTarjeta][0].setText(casillaTomaTarjeta.getTipo());
        matrizBotones[numCasillaTarjeta][Columnas-1].setBackground(Color.gray);
        matrizBotones[numCasillaTarjeta][Columnas-1].setText(casillaTomaTarjeta.getTipo());
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void casillasInferiorAutomaticas(){
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = numCasillaTarjeta+2; j < Columnas-1; j++) {
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
        for (int i = Filas-1; i < Filas; i++) {
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
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void casillasIzquierdaAutomaticas(){
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
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
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
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
            for (int j = numCasillaTrampa+1; j < Columnas-1; j++) {
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
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void casillasDerechaAutomaticas(){
        for (int i = 1; i < numCasillaTarjeta; i++) {
            for (int j = Columnas-1; j < Columnas; j++) {
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
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
            for (int j = Columnas-1; j < Columnas; j++) {
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
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarFilaInferior7x7(){
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = Columnas-2; j >= numCasillaTrampa+1; j--) {
                if(i == Filas-1 && j == Columnas-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[0].getNombrePropiedad());
                }else if(i == Filas-1 && j == Columnas-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[1].getNombrePropiedad());
                }
            }
        }
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = numCasillaTrampa-2; j >= 1; j--) {
                if(i == Filas-1 && j == numCasillaTrampa-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[2].getNombrePropiedad());
                }else if(i == Filas-1 && j == numCasillaTrampa-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[3].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarIzquierda7x7(){
        for (int i = Filas-2; i >= numCasillaTarjeta+1; i--) {
            for (int j = 0; j < 1; j++) {
                if(i == Filas-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[4].getNombrePropiedad());
                }else if(i == Filas-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[5].getNombrePropiedad());
                }
            }
        }
        //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
        for (int i = numCasillaTarjeta-2; i >= 1; i--) {
            for (int j = 0; j < 1; j++) {               
                if(i == numCasillaTarjeta-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[6].getNombrePropiedad());
                }else if(i == numCasillaTarjeta-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[7].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarSuperior7x7(){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                if(i == 0 && j == 1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[8].getNombrePropiedad());
                }else if(i == 0 && j == 2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[9].getNombrePropiedad());
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < Columnas-1; j++) {
                if(i == 0 && j == numCasillaTrampa+1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[10].getNombrePropiedad());
                }else if(i == 0 && j == numCasillaTrampa+2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[11].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarDerecha7x7(){
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == 1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[12].getNombrePropiedad());
                }else if(i == 2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[13].getNombrePropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == numCasillaTarjeta+1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[14].getNombrePropiedad());
                }else if(i == numCasillaTarjeta+2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[15].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarFilaInferior8x8(){
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = Columnas-2; j >= numCasillaTrampa+1; j--) {
                if(i == Filas-1 && j == Columnas-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[0].getNombrePropiedad());
                }else if(i == Filas-1 && j == Columnas-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[1].getNombrePropiedad());
                }
            }
        }
        for (int i = Filas-1; i < Filas; i++) {
            for (int j = numCasillaTrampa-2; j >= 1; j--) {
                if(i == Filas-1 && j == numCasillaTrampa-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[2].getNombrePropiedad());
                }else if(i == Filas-1 && j == numCasillaTrampa-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[3].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarIzquierda8x8(){
        for (int i = Filas-2; i >= numCasillaTarjeta+1; i--) {
            for (int j = 0; j < 1; j++) {
                if(i == Filas-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[4].getNombrePropiedad());
                }else if(i == Filas-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[5].getNombrePropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta-2; i >= 1; i--) {
            for (int j = 0; j < 1; j++) {                
                if(i == numCasillaTarjeta-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[6].getNombrePropiedad());
                }else if(i == numCasillaTarjeta-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[7].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarSuperior8x8(){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                if(i == 0 && j == 1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[8].getNombrePropiedad());
                }else if(i == 0 && j == 2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[9].getNombrePropiedad());
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < Columnas-1; j++) {
                if(i == 0 && j == numCasillaTrampa+1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[10].getNombrePropiedad());
                }else if(i == 0 && j == numCasillaTrampa+2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[11].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarDerecha8x8(){
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == 1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[12].getNombrePropiedad());
                }else if(i == 2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[13].getNombrePropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == numCasillaTarjeta+1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[14].getNombrePropiedad());
                }else if(i == numCasillaTarjeta+2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[15].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarFilaInferior9x9(){
        for (int i =Filas-1; i < Filas; i++) {
            for (int j = Columnas-2; j >= numCasillaTrampa+1; j--) {
                if(i == Filas-1 && j == Columnas-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[0].getNombrePropiedad());
                }else if(i == Filas-1 && j == Columnas-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[1].getNombrePropiedad());
                }else if(i == Filas-1 && j == Columnas-4){
                     matrizBotones[i][j].setText(casillaLugarIngresado[2].getNombrePropiedad());
                }
            }
        }
        for (int i = Filas-1; i <= Filas-1; i++) {
            for (int j = numCasillaTrampa-2; j >= 1; j--) {
                if(i == Filas-1 && j == numCasillaTrampa-2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[3].getNombrePropiedad());
                }else if(i == Filas-1 && j == numCasillaTrampa-3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[4].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarIzquierda9x9(){
        for (int i = Filas -2; i >= numCasillaTarjeta+1; i--) {
            for (int j = 0; j < 1; j++) {
                if(i == Filas-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[5].getNombrePropiedad());
                }else if(i == Filas-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[6].getNombrePropiedad());
                }else if(i == Filas-4 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[7].getNombrePropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta-2; i >= 1; i--) {
            for (int j = 0; j < 1; j++) {                //casillaLugarInferior2 = new Lugar[(numCasillaTrampa-1)-1];
                if(i == numCasillaTarjeta-2 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[8].getNombrePropiedad());
                }else if(i == numCasillaTarjeta-3 && j == 0){
                    matrizBotones[i][j].setText(casillaLugarIngresado[9].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarSuperior9x9(){
        for (int i = 0; i < 1; i++) {
            for (int j = 1; j < numCasillaTrampa-1; j++) {
                if(i == 0 && j == 1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[10].getNombrePropiedad());
                }else if(i == 0 && j == 2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[11].getNombrePropiedad());
                }
            }
        }
        for (int i = 0; i < 1; i++) {
            for (int j = numCasillaTrampa+1; j < Columnas-1; j++) {
                if(i == 0 && j == numCasillaTrampa+1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[12].getNombrePropiedad());
                }else if(i == 0 && j == numCasillaTrampa+2){
                    matrizBotones[i][j].setText(casillaLugarIngresado[13].getNombrePropiedad());
                }else if(i == 0 && j == numCasillaTrampa+3){
                    matrizBotones[i][j].setText(casillaLugarIngresado[14].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarDerecha9x9(){
        for (int i = 1; i < numCasillaTarjeta-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == 1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[15].getNombrePropiedad());
                }else if(i == 2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[16].getNombrePropiedad());
                }
            }
        }
        for (int i = numCasillaTarjeta+1; i < Filas-1; i++) {
            for (int j = Columnas-1; j <= Columnas-1; j++) {
                if(i == numCasillaTarjeta+1 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[17].getNombrePropiedad());
                }else if(i == numCasillaTarjeta+2 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[18].getNombrePropiedad());
                }else if(i == numCasillaTarjeta+3 && j == Columnas-1){
                    matrizBotones[i][j].setText(casillaLugarIngresado[19].getNombrePropiedad());
                }
            }
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarSoE(){
        matrizBotones[Filas-1][numCasillaTrampa-1].setBackground(Color.CYAN);
        matrizBotones[Filas-1][numCasillaTrampa-1].setText(casillaEstacionCreada[0].getNombrePropiedad());
        matrizBotones[Filas-1][numCasillaTrampa-1].setToolTipText(casillaEstacionCreada[0].getNombrePropiedad() + " Precio: " + casillaEstacionCreada[0].getPrecioCompra());
        matrizBotones[numCasillaTarjeta-1][0].setText(casillaServicioCreada[0].getNombrePropiedad());
        matrizBotones[numCasillaTarjeta-1][0].setBackground(Color.CYAN);
        matrizBotones[numCasillaTarjeta-1][0].setToolTipText(casillaServicioCreada[0].getNombrePropiedad() + " Precio: " + casillaServicioCreada[0].getPrecioCompra());
        matrizBotones[0][numCasillaTrampa-1].setText(casillaEstacionCreada[1].getNombrePropiedad());
        matrizBotones[0][numCasillaTrampa-1].setBackground(Color.CYAN);
        matrizBotones[0][numCasillaTrampa-1].setToolTipText(casillaEstacionCreada[1].getNombrePropiedad() + " Precio: " + casillaEstacionCreada[1].getPrecioCompra());
        matrizBotones[numCasillaTarjeta-1][Columnas-1].setText(casillaServicioCreada[1].getNombrePropiedad());
        matrizBotones[numCasillaTarjeta-1][Columnas-1].setBackground(Color.CYAN);
        matrizBotones[numCasillaTarjeta-1][Columnas-1].setToolTipText(casillaServicioCreada[1].getNombrePropiedad() + " Precio: " + casillaServicioCreada[1].getPrecioCompra());
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarInferior(){
        if(cantLugaresPorFoC == 4){
            mostrarPropiedadLugarFilaInferior8x8();
        }else if(cantLugaresPorFoC == 5){
            mostrarPropiedadLugarFilaInferior9x9();
        }else if(cantLugaresPorFoC == 3){
            mostrarPropiedadLugarFilaInferior7x7();
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarIzquierda(){
        if(cantLugaresPorFoC == 4){
            mostrarPropiedadLugarIzquierda8x8();
        }else if(cantLugaresPorFoC == 5){
            mostrarPropiedadLugarIzquierda9x9();
        }else if(cantLugaresPorFoC == 3){
            mostrarPropiedadLugarIzquierda7x7();
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarSuperior(){
        if(cantLugaresPorFoC == 4){
            mostrarPropiedadLugarSuperior8x8();
        }else if(cantLugaresPorFoC == 5){
            mostrarPropiedadLugarSuperior9x9();
        }else if(cantLugaresPorFoC == 3){
            mostrarPropiedadLugarSuperior7x7();
        }
    }
    //Nos permite recuperar los datos de la casilla automatica despues del paso de la ficha del jugador
    public void mostrarPropiedadLugarDerecha(){
        if(cantLugaresPorFoC == 4){
            mostrarPropiedadLugarDerecha8x8();
        }else if(cantLugaresPorFoC == 5){
            mostrarPropiedadLugarDerecha9x9();
        }else if(cantLugaresPorFoC == 3){
            mostrarPropiedadLugarDerecha7x7();
        }
    }
}
