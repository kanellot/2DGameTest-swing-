
package model;

/**
 *
 * @author kanel
 */
public class Colisio {
    
    //index array colisions
    private final int INFERIOR=0, DRETA=1, SUPERIOR=2, ESQUERRA=3;
    private final int PIXEL_OFFSET_COLISIO = 10;
    private final int RESOLUCIO_PIXEL_COLISIO = Sector.WIDTH/2;
    private Boolean[] colisio;
    Personatge jugadorColisio;
    Mon2D mon2dColisio;
    int tyActualitzada, txActualitzada;
    
    
    public Colisio(){}
    
    void comprobarColisions(Personatge jugador, Mon2D mon2d){
        
        jugadorColisio = jugador;
        mon2dColisio = mon2d;
        colisio = new Boolean[]{false,false,false,false};

        actualitzacioMoviment();

        comprobarColisioInferior();

        comprobarColisioSuperior();

        comprobarColisioDreta();

        comprobarColisioEsquerra();

        jugadorColisio.setParaulaColisions(colisio);
    }

    void actualitzacioMoviment(){

        actualitzaMovimentJugadorX();
        actualitzaMovimentJugadorY();
        txActualitzada = jugadorColisio.coordenadaToSectorX(jugadorColisio.x);
        tyActualitzada = jugadorColisio.coordenadaToSectorY(jugadorColisio.y);
    }

    void actualitzaMovimentJugadorX(){
        float acc = jugadorColisio.getAcceleracio();
        jugadorColisio.x = jugadorColisio.x + (int)(acc*3);// 10px maxim moviment quan acc=1
    }

    void actualitzaMovimentJugadorY(){
        float acc = jugadorColisio.getAcceleracioY();
        jugadorColisio.y = jugadorColisio.y - (int)(acc*5);// 10px maxim moviment quan acc=1
        //Gravetat nomes aplica sino hi ha impuls de salt (acceleracioY)
        if(jugadorColisio.getAcceleracioY()==0) jugadorColisio.y = jugadorColisio.y+4;
    }
    
    private void comprobarColisioInferior(){
        
        int y, x;
        int tx, ty;
        int limitPunts = jugadorColisio.getPersonatgeSectorWidth()*2;

        y = jugadorColisio.y + jugadorColisio.height;
        x = jugadorColisio.x + PIXEL_OFFSET_COLISIO;

        for(int i=0; i<limitPunts; i++){
            //Coordenades SectorArray
            ty = jugadorColisio.coordenadaToSectorY(y);
            tx = jugadorColisio.coordenadaToSectorX(x);
            //Comprobar colisio
            if(comprobarColisioSector(tx, ty)) colisio[INFERIOR] = true;
            x = x + RESOLUCIO_PIXEL_COLISIO;
        }
        //Correccio moviment
        if(colisio[INFERIOR]) jugadorColisio.y = mon2dColisio.getSectorLimitAmbsolutSuperiorY(tyActualitzada);
    }
    
    private void comprobarColisioSuperior(){
        
        int y, x;
        int tx, ty;
        int limitPunts = jugadorColisio.getPersonatgeSectorWidth()*2;

        y = jugadorColisio.y;
        x = jugadorColisio.x + PIXEL_OFFSET_COLISIO;

        for(int i=0; i<limitPunts; i++){
            //Coordenades SectorArray
            ty = jugadorColisio.coordenadaToSectorY(y);
            tx = jugadorColisio.coordenadaToSectorX(x);
            //Comprobar colisio
            if(comprobarColisioSector(tx, ty)){
                colisio[SUPERIOR] = true;
            } 
            x = x + RESOLUCIO_PIXEL_COLISIO;
        }
        //Correccio moviment
        if(colisio[SUPERIOR]) jugadorColisio.y = mon2dColisio.getSectorLimitAmbsolutInferiorY(tyActualitzada)-1;
    }

    private void comprobarColisioDreta(){

        int y, x;
        int tx, ty;
        int limitPunts = jugadorColisio.getPersonatgeSectorHeight()*2;

        x = jugadorColisio.x + jugadorColisio.width;
        y = jugadorColisio.y + PIXEL_OFFSET_COLISIO;

        for(int i=0; i<limitPunts; i++){
            //Coordenades SectorArray
            ty = jugadorColisio.coordenadaToSectorY(y);
            tx = jugadorColisio.coordenadaToSectorX(x);
            //Comprobar colisio
            if(comprobarColisioSector(tx, ty)) colisio[DRETA] = true;
            y = y + RESOLUCIO_PIXEL_COLISIO;
        }
        //Correccio moviment
        if(colisio[DRETA]) jugadorColisio.x = mon2dColisio.getSectorLimitAmbsolutEsquerraX(txActualitzada);
    }

    private void comprobarColisioEsquerra(){
        
        int y, x;
        int tx, ty;
        int limitPunts = jugadorColisio.getPersonatgeSectorHeight()*2;

        x = jugadorColisio.x;
        y = jugadorColisio.y + PIXEL_OFFSET_COLISIO;

        for(int i=0; i<limitPunts; i++){
            //Coordenades SectorArray
            ty = jugadorColisio.coordenadaToSectorY(y);
            tx = jugadorColisio.coordenadaToSectorX(x);
            //Comprobar colisio
            if(comprobarColisioSector(tx, ty)) colisio[ESQUERRA] = true;
            y = y + RESOLUCIO_PIXEL_COLISIO;
        }
        //Correccio moviment
        if(colisio[ESQUERRA]) jugadorColisio.x = mon2dColisio.getSectorLimitAmbsolutDretaX(txActualitzada)-1;
    }
    
    private Boolean comprobarColisioSector(int tx, int ty){
        if(mon2dColisio.getTileArray()[tx][ty].getSolid()) return true;
        return false;
    }

    public Personatge getJugadorColisio(){
        return jugadorColisio;
    }
}
