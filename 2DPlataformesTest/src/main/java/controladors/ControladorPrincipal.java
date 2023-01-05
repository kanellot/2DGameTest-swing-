
package controladors;

import static configuracio.Configuracio.TICK;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author kanel
 */
public class ControladorPrincipal implements ActionListener {

    ControladorGrafics controladorGrafics;
    ControladorEntrades controladorEntrades;
    ControladorModel controladorModel;
    Timer timer;
    int tick = (int)TICK;
    int contadorFrames;
    
    public ControladorPrincipal(){
        
        controladorEntrades = new ControladorEntrades();
        controladorModel = new ControladorModel();
        controladorGrafics = new ControladorGrafics();
        
        
        timer = new Timer(tick, this);
        timer.start();
        contadorFrames = 0;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ciclePrincipal();
    }
    
    private void ciclePrincipal(){
        
        //Actualitza Model
        controladorModel.modelJoc.ActualizaModelJoc();

        if(contadorFrames==4){
            //Dibuixar Pantalla
            controladorGrafics.panellJoc.repaint();
            contadorFrames = 0;
        }else contadorFrames ++;
        
    }
}
