package proyectofinal.casillas;

/**
 *
 * @author joshua
 */
public class Trampa extends Casilla{
    
    private int cantCasillasRecorridas;
    private int cantidadMulta;
    private int perderTurno;
    
    public Trampa(String Tipo, int cantCasillasRecorridas, int cantidadMulta, int perderTurno){
        super(Tipo);
        this.cantCasillasRecorridas = cantCasillasRecorridas;
        this.cantidadMulta = cantidadMulta;
        this.perderTurno = perderTurno;
    }

    public int getCantCasillasRecorridas() {
        return cantCasillasRecorridas;
    }

    public void setCantCasillasRecorridas(int cantCasillasRecorridas) {
        this.cantCasillasRecorridas = cantCasillasRecorridas;
    }

    public int getCantidadMulta() {
        return cantidadMulta;
    }

    public void setCantidadMulta(int cantidadMulta) {
        this.cantidadMulta = cantidadMulta;
    }

    public int getPerderTurno() {
        return perderTurno;
    }

    public void setPerderTurno(int perderTurno) {
        this.perderTurno = perderTurno;
    }
    
}
