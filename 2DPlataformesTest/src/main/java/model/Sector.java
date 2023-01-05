
package model;

import java.awt.Rectangle;
import java.awt.Color;

/**
 *
 * @author kanel
 */
public class Sector extends Rectangle {
    
    static final int WIDTH = 40;
    static final int HEIGHT = 40;
    private Boolean solid;
	Color sectorColor = new Color(100,130,255);
	
	public Sector(int codi, int x, int y) {
		
		this.x = x;
		this.y = y;
		this.width = WIDTH;
		this.height = HEIGHT;
		this.solid = false;
		
	}

	public Color getColor(){
		return this.sectorColor;
	}

	public void setColor(Color color){
		this.sectorColor = color;
	}
	
	public Boolean getSolid() {
		return this.solid;
	}
	
	public void setSolid() {
			this.solid=true;
	}
	
	public void unSetSolid() {
			this.solid=false;
	}
        
}
