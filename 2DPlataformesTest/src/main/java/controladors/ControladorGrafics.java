
package controladors;

import entradaControls.EntradaTeclat;
import entradaControls.Entrades;
import grafics.Finestra;
import grafics.PanellJoc;

/**
 *
 * @author kanel
 */
public class ControladorGrafics {
    Finestra finestra;
    PanellJoc panellJoc;
    Entrades entrades;
     
    
    ControladorGrafics(){
        
        finestra = new Finestra();
        panellJoc = new PanellJoc();
        finestra.addKeyListener(new EntradaTeclat());
        finestra.add(panellJoc);
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
    }
}
