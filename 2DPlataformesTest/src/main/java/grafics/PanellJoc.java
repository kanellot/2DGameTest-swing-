
package grafics;

import static configuracio.Configuracio.PANELLJOC_HEIGHT;
import static configuracio.Configuracio.PANELLJOC_WIDTH;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author kanel
 */
public class PanellJoc extends JPanel{
    
    private int width = PANELLJOC_WIDTH;
    private int height = PANELLJOC_HEIGHT;
    Renderer renderer;
    
    public PanellJoc(){
        
        this.setPreferredSize(new Dimension(width,height));
        renderer = new Renderer();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        Graphics2D graficsPanellActual = (Graphics2D) g;
        
        renderer.rendererActualitzaModel();
        
        renderer.esborraPantalla(graficsPanellActual);

        renderer.scrollPantalla(graficsPanellActual);
        
        renderer.dibuixarMon(graficsPanellActual);
        
        renderer.dibuixaPertsonatge(graficsPanellActual);

        graficsPanellActual.dispose();
        
    }
}
