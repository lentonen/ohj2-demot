/**
 * 
 */
package demo.d7;

/**
 * @author Henri
 * @version Feb 22, 2021
 *
 */
public class Taulukot {
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double[] t2 = new double[] {18, 17.5, 18.5, 18.5, 19};

        System.out.print("Matin tuomaripisteet olivat: ");
        for (int i = 0; i < t2.length; i++)
            System.out.print("  " +t2[i] );
        System.out.println();

        double huonoin = huonoin(t2);
        System.out.println("Matin huonoin tuomaripiste oli " +huonoin);
        
        double paras = paras(t2);
        System.out.println("Matin paras tuomaripiste oli " +paras);
        
        double pisteet = summaHuonoinJaParasPois(t2);
        System.out.println("Matin yhteispisteiksi, kun paras ja huonoin tuomaripiste jäävät pois, saadaan " +pisteet);
    }


    /**
     * palauttaa reaalilukutaulukon suurimman alkion
     * @param t taulukko josta suurin palautetaan
     * @return suurin alkio
     * @example
     * <pre name="test">
     * double[] t1 = new double[] {1, 2, 3, 4, 5};
     * paras(t1) ~~~ 5;
     * double[] t2 = new double[] {5, 2, 3, 4, 1};
     * paras(t2) ~~~ 5;
     * double[] t3 = new double[] {5, 2, 10, 4, 1};
     * paras(t3) ~~~ 10;
     * double[] t4 = new double[] {-5, -2, -10, -4, -1};
     * paras(t4) ~~~ -1;
     * double[] t5 = new double[] {};
     * paras(t5) ~~~ Integer.MIN_VALUE;
     * </pre>
     */
    public static double paras(double[] t) {
        int pituus = t.length;
        double suurin = Integer.MIN_VALUE;
        for (int i = 0; i < pituus; i++)
            if (t[i] > suurin) suurin = t[i];
        return suurin;
            
    }


    /**
     * palauttaa reaalilukutaulukon pienimmän alkion
     * @param t taulukko josta pienin palautetaan
     * @return pienin alkio
     * @example
     * <pre name="test">
     * double[] t6 = new double[] {1.2, 2, 3, 4, 5};
     * huonoin(t6) ~~~ 1.2;
     * double[] t7 = new double[] {5, 2, 3, 4, 1.4};
     * huonoin(t7) ~~~ 1.4;
     * double[] t8 = new double[] {5, 2, 0.7, 4, 1};
     * huonoin(t8) ~~~ 0.7;
     * double[] t9 = new double[] {-5, -2, -10.2, -4, -1};
     * huonoin(t9) ~~~ -10.2;
     * double[] t10 = new double[] {};
     * huonoin(t10) ~~~ Integer.MAX_VALUE;
     * </pre>
     */
    public static double huonoin(double[] t) {
        int pituus = t.length;
        double pienin = Integer.MAX_VALUE;
        for (int i = 0; i < pituus; i++)
            if (t[i] < pienin) pienin = t[i];
        return pienin;
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


    /**
     * Palauttaa reaalilukutaulukon summan, kun paras ja huonoin on jätetty pois
     * @param t taulukko josta summa lasketaan
     * @return summa, josta poistettu taulukon suurin ja pienin alkio
     * @example
     * <pre name="test">
     * double[] taulukko = new double[] {1.2, 2, 3, 4, 5};
     * summaHuonoinJaParasPois(taulukko) ~~~ 9;
     * double[] taulukko2 = new double[] {-1.2, 2, -3, 4, -5};
     * summaHuonoinJaParasPois(taulukko2) ~~~ -2.2;
     * double[] taulukko3 = new double[] {};
     * summaHuonoinJaParasPois(taulukko3) ~~~ 0;
     * </pre>
     */
    public static double summaHuonoinJaParasPois(double[] t) {
        if (t.length == 0) return 0;
        return summa(t)-paras(t)-huonoin(t);
    }
 }
