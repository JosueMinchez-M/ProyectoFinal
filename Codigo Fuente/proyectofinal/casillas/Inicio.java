package proyectofinal.casillas;

/**
 *
 * @author joshua
 */
public class Inicio extends Casilla{
    
    private int cantidadDineroVuelta;

    public Inicio(String Tipo, int cantidadDineroVuelta) {
        super(Tipo);
        this.cantidadDineroVuelta = cantidadDineroVuelta;
    }

    public int getCantidadDineroVuelta() {
        return cantidadDineroVuelta;
    }

    public void setCantidadDineroVuelta(int cantidadDineroVuelta) {
        this.cantidadDineroVuelta = cantidadDineroVuelta;
    }
    
}
