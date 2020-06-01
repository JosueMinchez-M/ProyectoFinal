package proyectofinal.tablerojuego;

import java.io.Serializable;

/**
 *
 * @author joshua
 */
public class tamañoLugares implements Serializable{
    //MANEJA EL TAMAÑO DE LOS LUGARES QUE SE ENCUENTRAN EN EL TABLERO
    private int sumaLugaresTablero;
    private int cantidadLugaresPorFoC;
    
    public tamañoLugares(int sumaLugaresTablero, int cantidadLugaresFoC){
        this.sumaLugaresTablero = sumaLugaresTablero;
        this.cantidadLugaresPorFoC = cantidadLugaresFoC;
    }

    public int getSumaLugaresTablero() {
        return sumaLugaresTablero;
    }

    public void setSumaLugaresTablero(int sumaLugaresTablero) {
        this.sumaLugaresTablero = sumaLugaresTablero;
    }

    public int getCantidadLugaresPorFoC() {
        return cantidadLugaresPorFoC;
    }

    public void setCantidadLugaresPorFoC(int cantidadLugaresPorFoC) {
        this.cantidadLugaresPorFoC = cantidadLugaresPorFoC;
    }
    
    
    public String toString(){
        return "\nSuma Lugares = " + getSumaLugaresTablero();
    }
}
