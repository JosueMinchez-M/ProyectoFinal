package proyectofinal.casillas;

import java.io.Serializable;

/**
 *
 * @author joshua
 */
public class Casilla implements Serializable{
    
    private String Tipo;
    
    public Casilla(String Tipo){
        this.Tipo = Tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
