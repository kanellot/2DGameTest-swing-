
package entradaControls;

/**
 *
 * @author kanel
 */
public class Entrades {
    
    private static Boolean[] paraulaEntrada = new Boolean[]{false,false,false}; //0-Esquerra, 1-Dreta, 2-salt
    
    public static Boolean[] getParaulaEntrada(){
        return paraulaEntrada;
    }
    
    static void setDreta(){
        paraulaEntrada[1] = true;
    }
    
    static void setEsquerra(){
        paraulaEntrada[0] = true;
    }
    
    static void unsetDreta(){
        paraulaEntrada[1] = false;
    }
    
    static void unsetEsquerra(){
        paraulaEntrada[0] = false;
    }
    
    static void setAmunt(){
        paraulaEntrada[2] = true;
    }
    
    static void unsetAmunt(){
        paraulaEntrada[2] = false;
    }
    
    
}
