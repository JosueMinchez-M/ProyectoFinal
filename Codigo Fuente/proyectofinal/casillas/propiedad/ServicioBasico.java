package proyectofinal.casillas.propiedad;

import java.io.Serializable;
import proyectofinal.casillas.Propiedad;

/**
 *
 * @author joshua
 */
public class ServicioBasico extends Propiedad implements Serializable{
    
    private int costoServicio;

    public ServicioBasico(String Tipo, String nombrePropiedad, String dueñoPropiedad, int precioCompra, int precioHipoteca, boolean estadoHipoteca, int costoServicio) {
        super(Tipo, nombrePropiedad, dueñoPropiedad, precioCompra, precioHipoteca, estadoHipoteca);
        this.costoServicio = costoServicio;
    }

    public int getCostoServicio() {
        return costoServicio;
    }
    
}
