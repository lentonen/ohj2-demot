package Pohja.Tauno;

import java.util.Arrays;

/**
 * Pohja Tauno-testeille
 * @author vesal
 * @version 8.1.2015
 *
 */
@SuppressWarnings("all")
public class Kasittele
{
    public static void main(String args[])
    {
        int[] t = { 23, 45, 12, 9, 3, 7 };
        System.out.println("Aluksi : " + Arrays.toString(t));
        KasitteleTaulukko(t);
        System.out.println("Lopuksi: " + Arrays.toString(t) +"\n");
        
        int[] t2 = { 23, 45, 12, 9, 3, 7 };
        System.out.println("Aluksi : " + Arrays.toString(t2));
        KasitteleTaulukkoaErilailla(t2);
        System.out.println("Lopuksi: " + Arrays.toString(t2));
    }


    /**
     * Aliohjelmalla kääntää taulukon alkiot päinvastaiseen järjestykseen
     * @param t taulukko joka käsitellään
     * @example
     * #import java.util.Arrays;
     * <pre name="test">
     *  int[] t; 
     *  t = new int[]{$t1}; KasitteleTaulukko(t); Arrays.toString(t) === "[$t2]";
     *
     *  $t1                |   $t2
     * ------------------------------------------------
    *    55, 44, 33, 2, 5, 9 | 9, 5, 2, 33, 44, 55
    *    23, 45, 12, 9, 3, 7 | 7, 3, 9, 12, 45, 23
    *    12, 9, 3, 7         | 7, 3, 9, 12
    *    3, 7                | 7, 3
    *    1                   | 1
     * </pre>
     */
    public static void KasitteleTaulukko(int[] t)
    {
        if (t.length <= 1) return;
        int tmp;
        int viimeisenIndeksi = t.length-1;
        for (int i = 0; i < viimeisenIndeksi-i; i++){
            tmp = t[i];
            t[i] = t[viimeisenIndeksi-i];
            t[viimeisenIndeksi - i] = tmp;
        }

    }
    
    
    /**
     * Aliohjelmalla kääntää taulukon peräkkäisten alkioiden järjestyksen
     * @param t taulukko joka käsitellään
     * @example
     * #import java.util.Arrays;
     * <pre name="test">
     *  int[] t; 
     *  t = new int[]{$t1}; KasitteleTaulukkoaErilailla(t); Arrays.toString(t) === "[$t2]";
     *  
     *
     *  $t1                |   $t2
     * ------------------------------------------------
    *     55, 44, 33, 2, 5, 9 | 44, 55, 2, 33, 9, 5
    *     23, 45, 12, 9, 3, 7 | 45, 23, 9, 12, 7, 3
    *     12, 9, 3, 7         | 9, 12, 7, 3
    *     3, 7                | 7, 3
    *     1                   | 1
     * </pre>
     */
    public static void KasitteleTaulukkoaErilailla(int[] t)
    {
        if (t.length <= 1) return;
        int tmp;
        int taulukonPituus = t.length;
        int i = 0;

        while (i < taulukonPituus){
                tmp = t[i];
                t[i] = t[i+1];
                t[i+1] = tmp;
                i += 2;
        }
        
    }
    
}

