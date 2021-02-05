package demo.d4;

import java.util.Arrays;

/**
 * @author Henri
 * @version Feb 1, 2021
 *
 */
public class TaulukonMuuttaminen {
    /**
     * @param args ei käytössä
     */
    public static void main(String args[])
    {
        int[] t = { 23, 45, 12, 9, 3, 7 };
        System.out.println("Aluksi : " + Arrays.toString(t));
        KasitteleTaulukko(t);
        System.out.println("Lopuksi: " + Arrays.toString(t));
        
        int a=4;
        int b=2;
        int c=0;
        if ( c++ != 0 ) 
            if ( a-- != 0);
            else b-=3;
        else c+=8;
        c = a*b;
    }
    
    
    /**
     * Aliohjelmalla käsitellään taulukko sovitulla tavalla
     * @param t taulukko joka käsitellään
     * @example
     * #import java.util.Arrays;
     * <pre name="test">
     *  int[] t; 
     *  t = new int[]{$t1}; KasitteleTaulukko(t); Arrays.toString(t) === "[$t2]";
     *
     *  $t1                |   $t2
     * ------------------------------------------------
    *    55, 44, 33, 2, 5, 9 | 60, 49, 38, 7, 10, 14
    *    23, 45, -12, 9, 0, -5 | 28, 50, -7, 14, 5, 0
     * </pre>
     */
    public static void KasitteleTaulukko(int[] t){
        int lisattava = 5;
        int taulukonPituus = t.length;
        for (int i = 0; i < taulukonPituus; i++){
            t[i] += lisattava;
        }
    }
}
