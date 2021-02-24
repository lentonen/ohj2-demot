package demo.d4;

import java.util.Calendar;

/**
 * Apulaskuja iän määrittämiseen.
 * @author Henri
 * @version Feb 1, 2021
 *
 */
public class Ika {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // 

    }
    
    /**
     * laskee paljonko henkilö täyttää kuluvana vuonna
     * @param syntVuosi syntymävuosi
     * @return paljono henkilö täyttää kuluvana vuonna
     */
    public static int paljonkoTayttaa(int syntVuosi) {
        int kuluvaVuosi = Calendar.getInstance().get(Calendar.YEAR);
        return kuluvaVuosi-syntVuosi;
    }
   

}
