
package entradaControls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author kanel
 */
public class EntradaTeclat implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_LEFT) Entrades.setEsquerra();
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT) Entrades.setDreta();
        if(ke.getKeyCode()==KeyEvent.VK_UP) Entrades.setAmunt();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_LEFT) Entrades.unsetEsquerra();
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT) Entrades.unsetDreta();
        if(ke.getKeyCode()==KeyEvent.VK_UP) Entrades.unsetAmunt();
    }
    
    
}
