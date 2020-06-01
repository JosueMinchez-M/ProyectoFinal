package proyectofinal.casillas;

/**
 *
 * @author joshua
 */
public class Tarjeta extends Casilla{
    
    private int cantidadPremio;
    private int cantPagoJugadores;
    private int cantidadCasillas;
    //TarejetaSalga de la carcel
    //Definir tipo carcel para tarjeta VAYA A LA CARCEL
    public Tarjeta(String Tipo, int cantidadPremio, int cantPagoJugadores, int cantidadCasillas) { //, int cantidadPremio, int cantPagoJugadores, int cantidadCasillas
        super(Tipo);
        this.cantidadPremio = cantidadPremio;
        this.cantPagoJugadores = cantPagoJugadores;
        this.cantidadCasillas = cantidadCasillas;
    }

    public int getCantidadPremio() {
        return cantidadPremio;
    }

    public void setCantidadPremio(int cantidadPremio) {
        this.cantidadPremio = cantidadPremio;
    }

    public int getCantPagoJugadores() {
        return cantPagoJugadores;
    }

    public void setCantPagoJugadores(int cantPagoJugadores) {
        this.cantPagoJugadores = cantPagoJugadores;
    }

    public int getCantidadCasillas() {
        return cantidadCasillas;
    }

    public void setCantidadCasillas(int cantidadCasillas) {
        this.cantidadCasillas = cantidadCasillas;
    }
    
}
