package proyectofinal.casillas.propiedad;

import java.awt.Color;
import java.io.Serializable;
import proyectofinal.casillas.Propiedad;

/**
 *
 * @author joshua
 */
public class Lugar extends Propiedad implements Serializable{
    private static final long serialVersionUID = 1L;
    private int cantidadHoteles; //int cantidadCasas, int cantidadHoteles, int costoEstancia, int precioCasa, int precioHotel
    private int cantidadCasas;
    private int costoEstancia;
    //Costo de Estancia aumentado por cada Casa.
    private int precioCasa;
    //Costo de Estancia aumentado por cada Hotel.
    private int precioHotel;
    //Grupo de Propiedades al que pertenece.
    private Color grupoColor;
    
    public Lugar(String Tipo, String nombrePropiedad, String dueñoPropiedad, int precioCompra, int precioHipoteca, 
            boolean estadoHipoteca, Color grupoColor, int cantidadHoteles, int cantidadCasas, int costoEstancia,
            int precioCasa, int precioHotel){
        super(Tipo, nombrePropiedad, dueñoPropiedad, precioCompra,precioHipoteca, estadoHipoteca);
        this.grupoColor = grupoColor;
        this.cantidadHoteles = cantidadHoteles;
        this.cantidadCasas = cantidadCasas;
        this.costoEstancia = costoEstancia;
        this.precioCasa = precioCasa;
        this.precioHotel = precioHotel;
    }

    public int getCantidadHoteles() {
        return cantidadHoteles;
    }

    public int getCantidadCasas() {
        return cantidadCasas;
    }

    public int getCostoEstancia() {
        return costoEstancia;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public int getPrecioHotel() {
        return precioHotel;
    }
    public Color getGrupoColor() {
        return grupoColor;
    }
    public String toString(){
        return super.toString() + "\nColor = " + getGrupoColor();
    }
}
