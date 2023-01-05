
package model;

import static configuracio.Configuracio.TICK;
/**
 *
 * @author kanel
 */

//Segons la paraula d'entrada (Controls Teclat) calcula la nova acceleració 
public class ActualitzaAcceleracio {
    //Parametres acceleracio X
    private final int ACCELERACIO_ATTACK = 500; //ms
    private final int ACCELERACIO_DECAY = 400; //ms
    private final int TEMPS_REFRESC = (int)TICK;//5ms
    private final float ACCELERACIO_RANG = 1;
    private final float ACCELERACIO_RANG_CONTRASENTIT = 2;
    private final int ESQUERRA=0, DRETA=1, AMUNT=2; //Index
    //Parametres acceleracio Y
    private final int SALT_DURACIO_TOTAL = 200;//Duracio del impuls inicial en ms
    private final int SALT_DURACIO_INICIAL = 80;//Duracio del impuls maxima
    private final int SALT_DURACIO_DECAY = 120;//ms Duracio decay acceleracioY fins a 0
    private final int SALT_RETARD_TOCA_TERRA = 120;//ms retard desde que es toca terra dins que es pot tornar a saltar
    private final float ACCELERACIOY_RANG = 1;
    private final float SALT_ACCELERACIO_INICIAL = 1f;

    private Personatge subjecteCalculAcceleracio;
    private Boolean[] paraulaEntrada;
    private float acceleracioActual;//acceleracio X
    private float novaAcceleracio;//acceleracio X
    private float acceleracioY;
    private int contadorSalt;
    private int contadorRetardSalt;
    private Boolean decaySaltBandera;
    private Boolean saltantBandera = false;
    
    public void ActualitzaAcceleracioPersonatge(Personatge personatge, Boolean[] paraulaEntrada){
        
        subjecteCalculAcceleracio = personatge;
        acceleracioActual = personatge.getAcceleracio();
        this.paraulaEntrada = entradaControls.Entrades.getParaulaEntrada();

        if(paraulaEntrada[DRETA]&&!(paraulaEntrada[ESQUERRA])) acceleraDreta();
        if(!(paraulaEntrada[DRETA])&&paraulaEntrada[ESQUERRA]) acceleraEsquerra();
        if(!(paraulaEntrada[DRETA])&&!(paraulaEntrada[ESQUERRA])) desaccelera();
        if(paraulaEntrada[AMUNT]&& subjecteCalculAcceleracio.getTocaTerra() && !(saltantBandera)) iniciSalt();
        if(saltantBandera) actualitzaSalt();
    }

    private void actualitzaSalt (){
        // finalitza impuls del salt per temps total
        if(contadorSalt>SALT_DURACIO_TOTAL/TEMPS_REFRESC) decaySaltBandera = true;
        // finalitza per temps parcial (sino s'allarga salt)       
        if((contadorSalt>SALT_DURACIO_INICIAL/TEMPS_REFRESC && !(this.paraulaEntrada[AMUNT]))) decaySaltBandera = true;
        //Aplica el decay al valor de acceleracioY
        if(decaySaltBandera) {
            acceleracioY = acceleracioY - (ACCELERACIOY_RANG/(SALT_DURACIO_DECAY/TEMPS_REFRESC));
        }
        //Finalitza el decay
        if(acceleracioY<0){
            acceleracioY = 0;
            decaySaltBandera = false;
        } 
        // Comença el retard que impedeix tornar a saltar just tocar a terra
        if(subjecteCalculAcceleracio.getTocaTerra() && saltantBandera){
            if(contadorRetardSalt==SALT_RETARD_TOCA_TERRA/TEMPS_REFRESC){
                saltantBandera = false;
            }else contadorRetardSalt++;
        }       
        subjecteCalculAcceleracio.setAcceleracioY(acceleracioY); 
        if(saltantBandera)contadorSalt++;
    }

    private void iniciSalt (){
        contadorSalt = 0;
        contadorRetardSalt = 0;
        decaySaltBandera = false;
        saltantBandera = true;
        acceleracioY = SALT_ACCELERACIO_INICIAL;
    }
     
    private void acceleraDreta(){ 
        //Accelera en sentit favorable
        if(acceleracioActual>=0) novaAcceleracio = acceleracioActual +(ACCELERACIO_RANG/(float)(ACCELERACIO_ATTACK/TEMPS_REFRESC));
        //Accelera contrasentit
        if(acceleracioActual<0) novaAcceleracio = acceleracioActual +(ACCELERACIO_RANG_CONTRASENTIT/(float)(ACCELERACIO_ATTACK/TEMPS_REFRESC));
        if(novaAcceleracio>ACCELERACIO_RANG) novaAcceleracio = ACCELERACIO_RANG;
        if(subjecteCalculAcceleracio.getColisioDreta()) novaAcceleracio = 0;
        subjecteCalculAcceleracio.setAcceleracio(novaAcceleracio);
    }
    
    private void acceleraEsquerra(){ 
       
        if(acceleracioActual<=0) novaAcceleracio = acceleracioActual +(-1*(ACCELERACIO_RANG/(ACCELERACIO_ATTACK/TEMPS_REFRESC)));
        if(acceleracioActual>0) novaAcceleracio = acceleracioActual +(-1*(ACCELERACIO_RANG_CONTRASENTIT/(ACCELERACIO_ATTACK/TEMPS_REFRESC)));
        if(novaAcceleracio<(-1*ACCELERACIO_RANG)) novaAcceleracio = (-1*ACCELERACIO_RANG);
        if(subjecteCalculAcceleracio.getColisioEsquerra()){
            novaAcceleracio = 0;
        } 
        subjecteCalculAcceleracio.setAcceleracio(novaAcceleracio);
    }
    
    private void desaccelera(){ 
        
        if(subjecteCalculAcceleracio.getAcceleracio()>0) desacceleraRestaDreta();
        if(subjecteCalculAcceleracio.getAcceleracio()<0) desacceleraRestaEsquerra();
        subjecteCalculAcceleracio.setAcceleracio(novaAcceleracio);
    }
    
    private void desacceleraRestaDreta(){
        novaAcceleracio = acceleracioActual - (ACCELERACIO_RANG/(ACCELERACIO_DECAY/TEMPS_REFRESC));
        if(novaAcceleracio<0) novaAcceleracio = 0;
    }
    
    private void desacceleraRestaEsquerra(){
        novaAcceleracio = acceleracioActual + (ACCELERACIO_RANG/(ACCELERACIO_DECAY/TEMPS_REFRESC));
        if(novaAcceleracio>0) novaAcceleracio = 0;
    }
    
    public Personatge getPersonatgeCalculAcceleracio(){
        return subjecteCalculAcceleracio;
    }
    
}
