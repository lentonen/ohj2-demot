/**
 * 
 */
package demo.d8;


/**
 * lasketaan 2-ulotteisen matriisin summa hyödyntäen aiemmin luotua summa-funktiota.
 * @author Henri
 * @version Feb 24, 2021
 *
 */
public class Matriisi {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double[][] t = new double[][] {{1,2,3,4,5},{6,7,8,9,10}};
        double summa = summa(t); 
        System.out.println(""+summa);
    
    }
    
    
    /**
     * Lskee 2-ulotteisen reaalilukumatriisin summan. Tein tehtävän etukäteen, joten koodiin on 
     * copy-pastettu summa-funktio demoista 7. Tässä funktiossa näkyy kommenttina koodirivi, joka
     * kirjoitettaisiin, jos käytössä olisi ollut demo7.
     * @param t matriisi jonka summa lasketaan
     * @return summa
     * @example
     * <pre name="test">
     *  double[][] t = new double[][] {{1,2,3},{4,5,6}};
     *  summa(t) ~~~ 21;
     *  double[][] t1 = new double[][] {{1,2,3},{4,5,6},{1,2,3}};
     *  summa(t1) ~~~ 27;
     *  double[][] t2 = new double[][] {{},{}};
     *  summa(t2) ~~~ 0;
     *  double[][] t3 = new double[][] {{-1,-2,-3},{1,2,3}};
     *  summa(t3) ~~~ 0;
     *  double[][] t4 = new double[][] {{-1},{3}};
     *  summa(t4) ~~~ 2;
     * </pre>
     */
    public static double summa(double[][] t) {
        double summa = 0;
        for (int i = 0; i < t.length; i++)
            summa += summa(t[i]);       // summa += demo.d7.Taulukot.summa(t[i]); 
        return summa;
        
        
                
    }
    
    
    /**
     * Palauttaa reaalilukutaulukon summan
     * @param t taulukko jonka alkioiden summa palautetaan
     * @return taulukon alkioiden summa
     * @example
     * <pre name="test">
     * double[] taulukko = new double[] {1.2, 2, 3, 4, 5};
     * summa(taulukko) ~~~ 15.2;
     * double[] taulukko2 = new double[] {-1.2, -2, -3, -4, -5};
     * summa(taulukko2) ~~~ -15.2;
     * double[] taulukko3 = new double[] {};
     * summa(taulukko3) ~~~ 0;
     * 
     * </pre>
     */
    public static double summa(double[] t) {
        int pituus = t.length;
        double summa = 0;
        for (int i = 0; i < pituus; i++)
            summa += t[i];
        return summa;
    }

}
