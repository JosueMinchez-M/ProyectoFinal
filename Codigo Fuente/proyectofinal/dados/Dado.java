package proyectofinal.dados;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author joshua
 */
public class Dado {
    JButton[][] matrizBotones;
    private int cantidadDados;
    private int dado1;
    private int dado2;
    private int dado3;
    
    
    public Dado(int cantidadDados){
        this.cantidadDados = cantidadDados;
    }
//    public Dado(int cantidadDados){
//        this.cantidadDados = cantidadDados;
//    }
    public Dado(int cantidadDados, int dado1, int dado2, int dado3){
        this.cantidadDados = cantidadDados;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado3 = dado3;
    }

    public int getCantidadDados() {
        return cantidadDados;
    }

    public void setCantidadDados(int cantidadDados) {
        this.cantidadDados = cantidadDados;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public int getDado3() {
        return dado3;
    }

    public void setDado3(int dado3) {
        this.dado3 = dado3;
    }
    public void lanzarDados(JLabel lblDado1,JLabel lblDado2,JLabel lblDado3){
        if(getCantidadDados() == 1){
            mostrarImagenDado1(lblDado1);
        }else if(getCantidadDados() == 2){
            mostrarImagenDado1(lblDado1);
            mostrarImagenDado2(lblDado2);
        }else if(getCantidadDados() == 3){
            mostrarImagenDado1(lblDado1);
            mostrarImagenDado2(lblDado2);
            mostrarImagenDado3(lblDado3);
        }
    }
    public void imagenDadosSeleccionados(JLabel lblDado1,JLabel lblDado2,JLabel lblDado3){
        if(getCantidadDados() == 1){
            imagenInicialDado1(lblDado1);
        }else if(getCantidadDados() == 2){
            imagenInicialDado1(lblDado1);
            imagenInicialDado2(lblDado2);
        }else if(getCantidadDados() == 3){
            imagenInicialDado1(lblDado1);
            imagenInicialDado2(lblDado2);
            imagenInicialDado3(lblDado3);
        }
    }
    public void imagenInicialDado1(JLabel lblDado1){
        ImageIcon dadoUno = new ImageIcon("Dados/vueltasDado.gif");
        ImageIcon dadoUnoEscalado = new ImageIcon(dadoUno.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
        lblDado1.setIcon(dadoUnoEscalado);     
    }
    public void imagenInicialDado2(JLabel lblDado2){
        ImageIcon dadoDos = new ImageIcon("Dados/vueltasDado.gif");
        ImageIcon dadoDosEscalado = new ImageIcon(dadoDos.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
        lblDado2.setIcon(dadoDosEscalado);
    }
    public void imagenInicialDado3(JLabel lblDado3){
        ImageIcon dadoTres = new ImageIcon("Dados/vueltasDado.gif");
        ImageIcon dadoTresEscalado = new ImageIcon(dadoTres.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
        lblDado3.setIcon(dadoTresEscalado);
    }
    public void mostrarImagenDado1(JLabel lblDado1){
        if(getDado1() == 1){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado1.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }else if(getDado1() == 2){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado2.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }else if(getDado1() == 3){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado3.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }else if(getDado1() == 4){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado4.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }else if(getDado1() == 5){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado5.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }else if(getDado1() == 6){
            ImageIcon ImagenDado1 = new ImageIcon("Dados/dado6.png");
            ImageIcon ImagenDado1Escalada = new ImageIcon(ImagenDado1.getImage().getScaledInstance(lblDado1.getWidth(), lblDado1.getHeight(), Image.SCALE_DEFAULT));
            lblDado1.setIcon(ImagenDado1Escalada);
        }
        
    }
    public void mostrarImagenDado2(JLabel lblDado2){
        if(getDado2() == 1){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado1.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }else if(getDado2() == 2){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado2.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }else if(getDado2() == 3){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado3.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }else if(getDado2() == 4){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado4.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }else if(getDado2() == 5){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado5.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }else if(getDado2() == 6){
            ImageIcon ImagenDado2 = new ImageIcon("Dados/dado6.png");
            ImageIcon ImagenDado2Escalada = new ImageIcon(ImagenDado2.getImage().getScaledInstance(lblDado2.getWidth(), lblDado2.getHeight(), Image.SCALE_DEFAULT));
            lblDado2.setIcon(ImagenDado2Escalada);
        }
    }
    public void mostrarImagenDado3(JLabel lblDado3){
        if(getDado3() == 1){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado1.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }else if(getDado3() == 2){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado2.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }else if(getDado3() == 3){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado3.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }else if(getDado3() == 4){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado4.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }else if(getDado3() == 5){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado5.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }else if(getDado3() == 6){
            ImageIcon ImagenDado3 = new ImageIcon("Dados/dado6.png");
            ImageIcon ImagenDado3Escalada = new ImageIcon(ImagenDado3.getImage().getScaledInstance(lblDado3.getWidth(), lblDado3.getHeight(), Image.SCALE_DEFAULT));
            lblDado3.setIcon(ImagenDado3Escalada);
        }
    }
}
