package demo.d4.test;

import java.util.Arrays;

/**
 * @author Henri
 * @version Feb 1, 2021
 *
 */
public class TaulukonMuuttaminen2 {

    /**
     * @param args ei käytössä
     */
    public static void main(String args[])
    {
        int[] t = { 23, 45, 12, 9, 3, 7 };
        System.out.println("Aluksi : " + Arrays.toString(t));
        KasitteleTaulukko(t);
        System.out.println("Lopuksi: " + Arrays.toString(t));
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
    *     5, 4, 6, 2, 9, 1    | 9, 0, 8, 0, 10, 0
    *     12, 3, 5, -5, 7, 10 | 15, 0, 0, 0, 17, 0
     * </pre>
     */
    public static void KasitteleTaulukko(int[] t)
    {
        int taulukonPituus = t.length;
        for (int i = 0; i< taulukonPituus; i+=2) {
            t[i] += t[i+1];
            t[i+1]=0;
        }
    }

}
