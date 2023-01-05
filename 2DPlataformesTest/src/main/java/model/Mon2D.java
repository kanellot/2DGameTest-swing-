
package model;

import static configuracio.Configuracio.PANELLJOC_WIDTH;
import static configuracio.Configuracio.PANELLJOC_HEIGHT;
import java.awt.Color;
/**
 *
 * @author kanel
 */
public class Mon2D {
    
    int codiId;
    Sector[][] sectorArray;
    Personatge jugador;
    int tx = 0;
    int ty = 0;
    int panellWidth = PANELLJOC_WIDTH;
    int panellHeight = PANELLJOC_HEIGHT;
    int sectorWidth = Sector.WIDTH;
    int sectorHeight = Sector.HEIGHT;
    
    public Mon2D(){
        
        codiId = 0;
        sectorArray = new Sector[panellWidth/Sector.WIDTH][panellHeight/Sector.HEIGHT];
        jugador = new Personatge(500,300,0,0);
        creaSectors();
        sectorsTest();
        setArbust(27, 14);
        setArbust(42, 14);
        setArbre(32,6);

        setArbust(73, 14);
        setArbust(88, 14);
        setArbre(78,6);




        setCastell(96, 8);
    }

    public void creaSectors() {
		
	int codi=0;
	for(int y=0; y<panellHeight;y=y+Sector.HEIGHT) {
            for( int x=0;x<panellWidth;x=x+Sector.WIDTH) {
		sectorArray[tx][ty] = new Sector(codi, x, y);
        
		tx++;
		codi++;
            }
	ty++;
	tx=0;
	}
    }
    
    public void sectorsTest(){

        sectorArray[0][0].setSolid();
        sectorArray[0][1].setSolid();
        sectorArray[0][2].setSolid();
        sectorArray[0][3].setSolid();
        sectorArray[0][4].setSolid();
        sectorArray[0][5].setSolid();
        sectorArray[0][6].setSolid();
        sectorArray[0][7].setSolid();
        sectorArray[0][8].setSolid();
        sectorArray[0][9].setSolid();
        sectorArray[0][10].setSolid();
        sectorArray[0][11].setSolid();
        sectorArray[0][12].setSolid();
        sectorArray[0][13].setSolid();
        sectorArray[0][14].setSolid();
        sectorArray[0][15].setSolid();
        sectorArray[0][16].setSolid();
        sectorArray[0][17].setSolid();
        sectorArray[0][18].setSolid();

        sectorArray[51][14].setSolid();
        sectorArray[51][15].setSolid();
        sectorArray[51][16].setSolid();
        sectorArray[51][17].setSolid();
        sectorArray[51][18].setSolid();
        sectorArray[52][14].setSolid();
        sectorArray[52][15].setSolid();
        sectorArray[52][16].setSolid();
        sectorArray[52][17].setSolid();
        sectorArray[52][18].setSolid();

        sectorArray[56][12].setSolid();
        sectorArray[57][12].setSolid();
        sectorArray[58][12].setSolid();
        sectorArray[59][12].setSolid();
        sectorArray[60][12].setSolid();
        sectorArray[61][12].setSolid();
        sectorArray[62][12].setSolid();
        sectorArray[63][12].setSolid();
        sectorArray[64][12].setSolid();

        sectorArray[68][15].setSolid();
        sectorArray[68][16].setSolid();
        sectorArray[68][17].setSolid();
        sectorArray[68][18].setSolid();
        sectorArray[69][15].setSolid();
        sectorArray[69][16].setSolid();
        sectorArray[69][17].setSolid();
        sectorArray[69][18].setSolid();


        
        sectorArray[8][16].setSolid();
        sectorArray[9][16].setSolid();
        sectorArray[10][16].setSolid();
        
	    sectorArray[12][16].setSolid();
        
	    sectorArray[14][16].setSolid();
        sectorArray[15][16].setSolid();
        sectorArray[16][16].setSolid();
	    sectorArray[16][15].setSolid();
        
        sectorArray[21][17].setSolid();
        sectorArray[22][17].setSolid();
        sectorArray[23][17].setSolid();
		
        for(int i=0;i<panellWidth/Sector.WIDTH;i++) {
                    sectorArray[i][19].setSolid();
                    sectorArray[i][20].setSolid();
                    sectorArray[i][21].setSolid();
                    sectorArray[i][22].setSolid();
                    sectorArray[i][23].setSolid();
                    sectorArray[i][24].setSolid();
        }
    }

    public void setArbust(int tx, int ty){


        final Color verd = new Color(0,200,0);
        final Color marro = new Color(180,122,87);

                                                                                    sectorArray[tx+2][ty].setColor(verd);
                                            sectorArray[tx+1][ty+1].setColor(verd); sectorArray[tx+2][ty+1].setColor(verd); sectorArray[tx+3][ty+1].setColor(verd);
        sectorArray[tx][ty+2].setColor(verd); sectorArray[tx+1][ty+2].setColor(verd); sectorArray[tx+2][ty+2].setColor(verd); sectorArray[tx+3][ty+2].setColor(verd);  sectorArray[tx+4][ty+2].setColor(verd);
                                            sectorArray[tx+1][ty+3].setColor(verd); sectorArray[tx+2][ty+3].setColor(verd); sectorArray[tx+3][ty+3].setColor(verd);
                                                                                    sectorArray[tx+2][ty+4].setColor(marro);
        
    }
    
    public void setArbre(int tx, int ty){

        final Color verd = new Color(0,200,0);
        final Color marro = new Color(180,122,87);

        sectorArray[tx+5][ty].setColor(verd);

        sectorArray[tx+1][ty+1].setColor(verd);
        sectorArray[tx+2][ty+1].setColor(verd);
        sectorArray[tx+3][ty+1].setColor(verd);
        sectorArray[tx+4][ty+1].setColor(verd);
        sectorArray[tx+5][ty+1].setColor(verd);
        sectorArray[tx+6][ty+1].setColor(verd);
        sectorArray[tx+7][ty+1].setColor(verd);
        sectorArray[tx+8][ty+1].setColor(verd);

        sectorArray[tx][ty+2].setColor(verd);
        sectorArray[tx+1][ty+2].setColor(verd);
        sectorArray[tx+2][ty+2].setColor(verd);
        sectorArray[tx+3][ty+2].setColor(verd);
        sectorArray[tx+4][ty+2].setColor(verd);
        sectorArray[tx+5][ty+2].setColor(verd);
        sectorArray[tx+6][ty+2].setColor(verd);
        sectorArray[tx+7][ty+2].setColor(verd);
        sectorArray[tx+8][ty+2].setColor(verd);
        sectorArray[tx+9][ty+2].setColor(verd);
        sectorArray[tx+10][ty+2].setColor(verd);

        sectorArray[tx+1][ty+3].setColor(verd);
        sectorArray[tx+2][ty+3].setColor(marro);
        sectorArray[tx+3][ty+3].setColor(verd);
        sectorArray[tx+4][ty+3].setColor(verd);
        sectorArray[tx+5][ty+3].setColor(verd);
        sectorArray[tx+6][ty+3].setColor(verd);
        sectorArray[tx+7][ty+3].setColor(verd);
        sectorArray[tx+8][ty+3].setColor(verd);
        sectorArray[tx+9][ty+3].setColor(verd);
        sectorArray[tx+10][ty+3].setColor(verd);
        sectorArray[tx+11][ty+3].setColor(verd);

        sectorArray[tx+2][ty+4].setColor(marro);
        sectorArray[tx+3][ty+4].setColor(marro);
        sectorArray[tx+4][ty+4].setColor(verd);
        sectorArray[tx+5][ty+4].setColor(verd);
        sectorArray[tx+6][ty+4].setColor(verd);
        sectorArray[tx+7][ty+4].setColor(marro);
        sectorArray[tx+8][ty+4].setColor(verd);
        sectorArray[tx+9][ty+4].setColor(verd);
        sectorArray[tx+10][ty+4].setColor(verd);

        sectorArray[tx+3][ty+5].setColor(marro);
        sectorArray[tx+4][ty+5].setColor(marro);
        sectorArray[tx+5][ty+5].setColor(verd);
        sectorArray[tx+6][ty+5].setColor(marro);
        sectorArray[tx+7][ty+5].setColor(marro);
        sectorArray[tx+8][ty+5].setColor(verd);

        sectorArray[tx+4][ty+6].setColor(marro);
        sectorArray[tx+5][ty+6].setColor(marro);
        sectorArray[tx+6][ty+6].setColor(marro);

        sectorArray[tx+4][ty+7].setColor(marro);
        sectorArray[tx+5][ty+7].setColor(marro);

        sectorArray[tx+4][ty+8].setColor(marro);
        sectorArray[tx+5][ty+8].setColor(marro);

        sectorArray[tx+4][ty+9].setColor(marro);
        sectorArray[tx+5][ty+9].setColor(marro);

        sectorArray[tx+4][ty+10].setColor(marro);
        sectorArray[tx+5][ty+10].setColor(marro);

        sectorArray[tx+4][ty+11].setColor(marro);
        sectorArray[tx+5][ty+11].setColor(marro);

        sectorArray[tx+4][ty+12].setColor(marro);
        sectorArray[tx+5][ty+12].setColor(marro);

        sectorArray[tx+3][ty+13].setColor(marro);
        sectorArray[tx+4][ty+13].setColor(marro);
        sectorArray[tx+5][ty+13].setColor(marro);
        sectorArray[tx+6][ty+13].setColor(marro);

    }

    public void setTorre(int tx, int ty){

        sectorArray[tx][ty].setSolid();
        sectorArray[tx+2][ty].setSolid();
        sectorArray[tx+4][ty].setSolid();

        sectorArray[tx][ty+1].setSolid();
        sectorArray[tx+1][ty+1].setSolid();
        sectorArray[tx+2][ty+1].setSolid();
        sectorArray[tx+3][ty+1].setSolid();
        sectorArray[tx+4][ty+1].setSolid();

        sectorArray[tx+1][ty+2].setSolid();
        sectorArray[tx+2][ty+2].setSolid();
        sectorArray[tx+3][ty+2].setSolid();

        sectorArray[tx+1][ty+3].setSolid();
        sectorArray[tx+2][ty+3].setSolid();
        sectorArray[tx+3][ty+3].setSolid();

    }

    public void setCastell(int tx, int ty){

        setTorre(tx, ty);

        setTorre(tx+12, ty);

        for(int i=0; i<15; i++){
            for(int j=0; j<7; j++){
                sectorArray[i+1+tx][j+4+ty].setSolid();
            }
        }

        sectorArray[tx+3][ty+6].unSetSolid();
        sectorArray[tx+4][ty+6].unSetSolid();
        sectorArray[tx+3][ty+7].unSetSolid();
        sectorArray[tx+4][ty+7].unSetSolid();

        sectorArray[tx+3+9][ty+6].unSetSolid();
        sectorArray[tx+4+9][ty+6].unSetSolid();
        sectorArray[tx+3+9][ty+7].unSetSolid();
        sectorArray[tx+4+9][ty+7].unSetSolid();

        sectorArray[tx+7][ty+8].unSetSolid();
        sectorArray[tx+8][ty+8].unSetSolid();
        sectorArray[tx+9][ty+8].unSetSolid();
        sectorArray[tx+7][ty+9].unSetSolid();
        sectorArray[tx+8][ty+9].unSetSolid();
        sectorArray[tx+9][ty+9].unSetSolid();
        sectorArray[tx+7][ty+10].unSetSolid();
        sectorArray[tx+8][ty+10].unSetSolid();
        sectorArray[tx+9][ty+10].unSetSolid();
        
    }
    
    
    public Personatge getPersonatge(){
        return jugador;
    }
    
    public Sector[][] getTileArray(){
		return this.sectorArray;
	}
    
    public int getSectorHeight(){
        return sectorHeight;
    }
   
    public int getSectorWidth(){
        return sectorWidth;
    }
    //retorna el valor de posicio absolut en px del limit del sector seleccionat
    public int getSectorLimitAmbsolutEsquerraX (int tx){
        return tx * Sector.WIDTH;
    }
    public int getSectorLimitAmbsolutDretaX (int tx){
        return (tx+1) * Sector.WIDTH;
    }
    public int getSectorLimitAmbsolutSuperiorY (int ty){
        return ty * Sector.HEIGHT;
    }
    public int getSectorLimitAmbsolutInferiorY (int ty){
        return (ty+1) * Sector.HEIGHT;
    }
}
