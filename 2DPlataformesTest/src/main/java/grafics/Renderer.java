
package grafics;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
import static configuracio.Configuracio.LIMIT_SCROLL_DRETA;
import static configuracio.Configuracio.LIMIT_SCROLL_ESQUERRA;
import static configuracio.Configuracio.FINESTRA_WIDTH;
import static configuracio.Configuracio.FINESTRA_HEIGHT;
import static configuracio.Configuracio.PANELLJOC_WIDTH;
import static configuracio.Configuracio.PANELLJOC_HEIGHT;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import model.ModelJoc;
import model.Mon2D;
import model.Personatge;

/**
 *
 * @author kanel
 */
public class Renderer  {
    
    int panellWidth, panellHeight;
    int finestraWidth, finestraHeight;
    
    Mon2D mon2dRenderer;
    Personatge jugadorRenderer;
    ModelJoc modelJocRenderer;
    Graphics2D g2dRenderer;
    int limitScrollDreta = LIMIT_SCROLL_DRETA;
    int limitScrollEsquerra = LIMIT_SCROLL_ESQUERRA;
    int limitScrollDiferencia = LIMIT_SCROLL_DRETA - LIMIT_SCROLL_ESQUERRA;
    int scrollActual = 0;
    
    Renderer (){
        panellWidth = PANELLJOC_WIDTH;
        panellHeight = PANELLJOC_HEIGHT;
        finestraWidth = FINESTRA_WIDTH;
        finestraHeight = FINESTRA_HEIGHT;
    }
    
    void rendererActualitzaModel(){
        mon2dRenderer = model.ModelJoc.mon2dModel;
        jugadorRenderer = model.ModelJoc.mon2dModel.getPersonatge();
    }
    
    //Clear Screen
    void esborraPantalla(Graphics2D g2d){
        g2d.clearRect(0, 0, panellWidth, panellHeight);
    }
    //Scroll Pantalla
    void scrollPantalla(Graphics2D g2d){
        //scroll esquerra
        if(jugadorRenderer.x<limitScrollEsquerra){
            //Actualitza posicio del limit
            limitScrollEsquerra = jugadorRenderer.x;
            //Actualitzem posicio limit contrari
            limitScrollDreta = limitScrollEsquerra + limitScrollDiferencia;
            //Calcul del nou scroll
            scrollActual = limitScrollEsquerra - LIMIT_SCROLL_ESQUERRA;
        } 
        //scroll dreta
        if(jugadorRenderer.x>limitScrollDreta){
            limitScrollDreta = jugadorRenderer.x;
            limitScrollEsquerra = limitScrollDreta - limitScrollDiferencia;
            scrollActual = limitScrollDreta - LIMIT_SCROLL_DRETA;
        } 
        //Aplica scroll
        g2d.translate(-1*scrollActual, 0);
    }

    //Dibuixar mon
    void dibuixarMon(Graphics2D g2d){
        int tx=0, ty=0;
        
        for(int y=0; y<panellHeight;y=y+mon2dRenderer.getSectorHeight()) {
			for( int x=0;x<panellWidth;x=x+mon2dRenderer.getSectorWidth()) {
				if(mon2dRenderer.getTileArray()[tx][ty].getSolid()) {
                    g2d.setColor(BLACK);
					g2d.fillRect(mon2dRenderer.getTileArray()[tx][ty].x,mon2dRenderer.getTileArray()[tx][ty].y,mon2dRenderer.getTileArray()[tx][ty].width,mon2dRenderer.getTileArray()[tx][ty].height);
				}else {
                    g2d.setColor(mon2dRenderer.getTileArray()[tx][ty].getColor());
					g2d.fillRect(mon2dRenderer.getTileArray()[tx][ty].x,mon2dRenderer.getTileArray()[tx][ty].y,mon2dRenderer.getTileArray()[tx][ty].width,mon2dRenderer.getTileArray()[tx][ty].height);
				}
                g2d.setColor(BLACK);
                //g2d.setFont(new Font ("times new roman", Font.PLAIN, 9));
				//g2d.drawString(Integer.toString(ty)+" / "+Integer.toString(tx),mon2dRenderer.getTileArray()[tx][ty].x+5,mon2dRenderer.getTileArray()[tx][ty].y+11);
				tx++;
			}
			ty++;
			tx=0;
		}
    }
    //Dibuixa Personatge
    void dibuixaPertsonatge(Graphics2D g2d){
        //g2d.drawRect(jugadorRenderer.x+10,jugadorRenderer.y+10, jugadorRenderer.width-10,jugadorRenderer.height-10);
        g2d.setColor(new Color(200,1,1));
        g2d.fillRect(mon2dRenderer.getPersonatge().x, mon2dRenderer.getPersonatge().y, mon2dRenderer.getPersonatge().width, mon2dRenderer.getPersonatge().height);
        g2d.setFont(new Font ("times new roman", Font.PLAIN, 14));
        //g2d.drawString(Float.toString(mon2dRenderer.getPersonatge().getAcceleracio()),mon2dRenderer.getPersonatge().x, mon2dRenderer.getPersonatge().y-20);
        g2d.setColor(new Color(225,5,5));
        g2d.fillRect(jugadorRenderer.x + 20 + (int)(15*jugadorRenderer.getAcceleracio()),5+jugadorRenderer.y  - (int)(20*jugadorRenderer.getAcceleracioY()), jugadorRenderer.width-40,jugadorRenderer.height-5);
        g2d.setColor(BLACK);
        g2d.drawRect(jugadorRenderer.x + 20 + (int)(15*jugadorRenderer.getAcceleracio()),5+jugadorRenderer.y  - (int)(20*jugadorRenderer.getAcceleracioY()), jugadorRenderer.width-40,jugadorRenderer.height-5);
        g2d.setColor(RED);
        g2d.fillRect(jugadorRenderer.x + 30 + (int)(25*jugadorRenderer.getAcceleracio()),10+jugadorRenderer.y  - (int)(20*jugadorRenderer.getAcceleracioY()), jugadorRenderer.width-60,jugadorRenderer.height-10);
    }
}
