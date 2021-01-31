package demo.d2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Henri
 * @version Jan 22, 2021
 *
 */
public class Lukumaara {
    /** Ohjelma tulostaa näyttöön tiedon siitä, montako "kissa" sanaa on käyttäjän syöttämässä lauseessa. Kissa sana
     * voidaan korvata millä tahansa sanalla.
     * @param args ei käytetä
     */
    public static void main(String[] args)
    {
        String sana = "kissa";
        String lause = kysyRivi();
        int sanojenMaara = laskeSanojenMaara(sana, lause);  
        System.out.println("Rivillä oli " +sanojenMaara  +" " +"\"" +sana +"\"" +" sanaa" );
    }

    /**
     * Laskee annettujen sanojen määrän lauseessa
     * @param sana sana jota lauseesta etsitään
     * @param lause lause josta sanaa etsitään
     * @return palauttaa sanojen lukumäärän lauseessa
     */
    private static int laskeSanojenMaara(String sana, String lause) {
        StringTokenizer pilkottuRivi = new StringTokenizer(lause);
        int lkm = 0;
        while (pilkottuRivi.hasMoreTokens()) {
            if (pilkottuRivi.nextToken().equals(sana))
                lkm++;
        }
        return lkm;    
    }

    
    /**
     * Kysyy käyttäjältä tekstirivin
     * @return palauttaa käyttäjän syöttämän tekstin string:inä. Poistaa syötteen loppuun laitetun pisteen.
     */
    private static String kysyRivi() { 
        System.out.print("Anna rivi >");
        Scanner lukija = new java.util.Scanner(System.in);
        return lukija.nextLine().replaceAll("\\." , "");   // Lause voi loppua myös pisteeseen. Voitaisiin huomioida myös muita merkkejä.
        
    }

}
