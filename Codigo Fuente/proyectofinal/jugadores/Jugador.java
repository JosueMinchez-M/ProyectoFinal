package proyectofinal.jugadores;

/**
 *
 * @author joshua
 */
public class Jugador {
    
    private String Usuario;
    private int Dinero;
    private String ficha;

    public Jugador(String Usuario, int Dinero, String ficha){
        this.Usuario = Usuario;
        this.Dinero = Dinero;
        this.ficha = ficha;
    }
    public Jugador(int Dinero){
        this.Dinero = Dinero;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getDinero() {
        return Dinero;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return getUsuario() + getDinero() + getFicha();
    }
}
