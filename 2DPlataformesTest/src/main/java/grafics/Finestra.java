
package grafics;

import static configuracio.Configuracio.FINESTRA_WIDTH;
import static configuracio.Configuracio.FINESTRA_HEIGHT;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author kanel
 */
public class Finestra extends JFrame {
    
    public Finestra(){
        
        
        this.setPreferredSize(new Dimension(FINESTRA_WIDTH,FINESTRA_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     
    }
}
