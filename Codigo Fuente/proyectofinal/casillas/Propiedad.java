package proyectofinal.casillas;

import java.io.Serializable;

/**
 *
 * @author joshua
 */
public class Propiedad extends Casilla implements Serializable{
    
    private String nombrePropiedad;
    private String dueñoPropiedad;
    private int precioCompra;
    private int precioHipoteca;
    private boolean estadoHipoteca;
    /**
     *
     * @param Tipo
     */
    public Propiedad(String Tipo, String nombrePropiedad, String dueñoPropiedad, int precioCompra, 
            int precioHipoteca, boolean estadoHipoteca){
        super(Tipo);
        this.nombrePropiedad = nombrePropiedad;
        this.dueñoPropiedad = dueñoPropiedad;
        this.precioCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
        this.estadoHipoteca = estadoHipoteca;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public String getDueñoPropiedad() {
        return dueñoPropiedad;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getPrecioHipoteca() {
        return precioHipoteca;
    }

    public boolean isEstadoHipoteca() {
        return estadoHipoteca;
    }
   
    public String toString(){
        return "\nNombre Propiedad = " + getNombrePropiedad() + "\nDueño Propiedad = " + getDueñoPropiedad() + "\nPrecio Compra = " + getPrecioCompra()+
                "\nPrecio Hipoteca = " + getPrecioHipoteca() + "\nEstado Hipoteca = " + isEstadoHipoteca();
    }
 
}
