package Jugabilidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author joshua
 */
public class TiempoIlimitado {
    
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    int hor = 0;
    boolean estado = true;
    int minutos, segundos;
    Timer tiempo;
    boolean bandera = true;
    
    public TiempoIlimitado(){
        
    }
    public TiempoIlimitado(int minutos){
        this.minutos = minutos;
    }
    
    public void tiempoIlimitado(JLabel lblTimer1, JLabel lblTimer2){
        estado = true;
        Thread hilo = new Thread(){
            public void run(){
                for (;;) {
                    if(estado == true){
                        try {
                            sleep(1);
                            if(miliseg >= 1000){
                                miliseg = 0;
                                seg++;
                            }
                            if(seg >= 60){
                                miliseg = 0;
                                seg = 0;
                                min++;
                                
                            }
                            if(min >= 60){
                                miliseg = 0;
                                seg = 0;
                                min = 0;
                                hor++;
                            }
                            lblTimer1.setText(hor + " : " + min + " : " + seg + " : ");
                            lblTimer2.setText("" + miliseg);
                            miliseg++;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TiempoIlimitado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        break;
                    }
                }
            }
        };
        hilo.start();
    }
    
    public void tiempoLimitado(JLabel lblMin, JLabel lblSeg){
        tiempo = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(segundos == 0){
                    segundos = 60;
                    minutos--;
                }
                if(minutos < 0){
                    minutos = 0;
                    segundos = 0;
                    tiempo.stop();
                }else{
                    segundos--;
                    if(segundos < 60){
                        lblSeg.setText("" + segundos);
                        bandera = false;
                    }
                    if(minutos < 60){
                        lblMin.setText("" + minutos);
                        if(segundos < 60){
                            lblSeg.setText("" + segundos);
                        }
                    }
                }
            }
            
        });
        tiempo.start();
    }
}
