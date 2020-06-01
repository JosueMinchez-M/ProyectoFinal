package proyectofinal.casillas.propiedad;

import java.io.Serializable;
import proyectofinal.casillas.Propiedad;

/**
 *
 * @author joshua
 */
public class Estacion extends Propiedad implements Serializable{
    
    private int costoUsoEstacion;
    
    public Estacion(String Tipo, String nombrePropiedad, String dueñoPropiedad, int precioCompra, int precioHipoteca, 
            boolean estadoHipoteca, int costoUsoEstacion) {
        super(Tipo, nombrePropiedad, dueñoPropiedad, precioCompra, precioHipoteca, estadoHipoteca);
        this.costoUsoEstacion = costoUsoEstacion;
    }

    public int getCostoUsoEstacion() {
        return costoUsoEstacion;
    }
    
}
