
package model;

import entradaControls.Entrades;
/**
 *
 * @author kanel
 */
public class ModelJoc {
    
    public static Mon2D mon2dModel = new Mon2D();
    
    ActualitzaAcceleracio actualizaAcceleracio;
    Colisio colisio;

    
    public ModelJoc(){
        
        actualizaAcceleracio = new ActualitzaAcceleracio();
        colisio = new Colisio();
        
    }
    
    public void ActualizaModelJoc(){
        
        actualizaAcceleracio.ActualitzaAcceleracioPersonatge(mon2dModel.getPersonatge(),Entrades.getParaulaEntrada());
        mon2dModel.jugador = actualizaAcceleracio.getPersonatgeCalculAcceleracio();
        colisio.comprobarColisions(mon2dModel.jugador, mon2dModel);
        mon2dModel.jugador = colisio.getJugadorColisio();
    }
    
    public static Mon2D getMon2dModel(){
        return mon2dModel;
    } 
}


