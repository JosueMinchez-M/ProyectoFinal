package proyectofinal.tablerojuego;

import java.io.Serializable;

/**
 *
 * @author joshua
 */
//CAPTURA EL TAMAÑO DE LAS FILAS Y COLUMNAS PARA EL TABLERO
public class Tamaño implements Serializable{
    private int Filas;
    private int Columnas;
    
    public Tamaño(int Filas, int Columnas){
        this.Filas = Filas;
        this.Columnas = Columnas;
    }

    public int getFilas() {
        return Filas;
    }

    public void setFilas(int Filas) {
        this.Filas = Filas;
    }

    public int getColumnas() {
        return Columnas;
    }

    public void setColumnas(int Columnas) {
        this.Columnas = Columnas;
    }
    @Override
    public String toString(){
        return "\nFilas = " + getFilas() + "\nColumnas = " + getColumnas();
    }
    
}
