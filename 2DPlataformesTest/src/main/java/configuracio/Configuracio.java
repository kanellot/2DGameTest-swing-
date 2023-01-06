
package configuracio;
//configuracio test 2

/**
 *
 * @author kanel
 */
public class Configuracio {
    
    //Finestra
    public static final int FINESTRA_WIDTH = 1920;
    public static final int FINESTRA_HEIGHT = 1080;
    public static final int FINESTRA_REFRESC = 50; //50fps
    public static final float TICK = 1000f*((1f/FINESTRA_REFRESC)/4f);//Execucuo programa cada 5ms (4 vegades per frame)
    public static final int LIMIT_SCROLL_DRETA = 60*(FINESTRA_WIDTH/100);//posicio del jugador derta per fer scroll (50%width)
    public static final int LIMIT_SCROLL_ESQUERRA = 30*(FINESTRA_WIDTH/100);//posicio jugador esquerra per fer scroll (20%width)
    
    //PanellJoc
    public static final int PANELLJOC_WIDTH = 6000;
    public static final int PANELLJOC_HEIGHT = 1080;
}
