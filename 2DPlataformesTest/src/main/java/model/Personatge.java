
package model;

import java.awt.Rectangle;

/**
 *
 * @author kanel
 */
public class Personatge extends Rectangle {
    
    private final int WIDTH=80, HEIGHT=120;
    private float acceleracio;//acceleracioX
    private float acceleracioY;//acceleracioY
    private Boolean[] paraulaColisions;
    private final int INFERIOR=0, DRETA=1, SUPERIOR=2, ESQUERRA=3;//index paraula colisiont
    private int personatgeSectorWidth, personatgeSectorHeight;
    
    public Personatge(int x, int y, int width, int height){
        
        this.x = x;
        this.y = y;
        this.width = WIDTH;
        this.height = HEIGHT;
        personatgeSectorWidth = WIDTH/Sector.WIDTH;
        personatgeSectorHeight = HEIGHT/Sector.HEIGHT;
        
        acceleracio = 0f;
        paraulaColisions = new Boolean[]{false, false, false, false, false}; 
    }

    public float getAcceleracioY(){
        return this.acceleracioY;
    }

    public Boolean getColisioDreta(){
        return paraulaColisions[DRETA];
    }

    public Boolean getColisioSuperior(){
        return paraulaColisions[SUPERIOR];
    }

    public Boolean getColisioEsquerra(){
        return paraulaColisions[ESQUERRA];
    }

    public boolean getTocaTerra (){
        return paraulaColisions[INFERIOR];
    }

    public void setParaulaColisions (Boolean[] colisions){
         //Array resultat de les colisions
        //0-colisioInferior, 1-ColisioDreta, 2-ColisioEsquerra, 3-colisioSuperior
        paraulaColisions = colisions;
    }
    
    public float getAcceleracio(){
        return acceleracio;
    }
    
    public void setAcceleracio(float novaAcceleracio){
        acceleracio = novaAcceleracio;
    }

    public void setAcceleracioY(float novaAcceleracio){
        acceleracioY = novaAcceleracio;
    }
    
    public int getPersonatgeSectorWidth(){
        return this.personatgeSectorWidth;
    }
    
    public int getPersonatgeSectorHeight(){
        return this.personatgeSectorHeight;
    }
    
    public int coordenadaToSectorX(int x){
        return x/Sector.WIDTH;
    }
    
    public int coordenadaToSectorY(int y){
        return y/Sector.HEIGHT;
    }
}
