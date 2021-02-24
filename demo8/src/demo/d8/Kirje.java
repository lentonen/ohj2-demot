
package demo.d8;

import java.lang.reflect.Array;

/**
 * Kirjeluokka, jonka sisällä staattinen Hinta-luokka.
 * @author Henri
 * @version Feb 24, 2021
 *
 */
public class Kirje {        
    
    private final static double[][] maksut = new double[][]{{50  ,  1.00},   
                                                            {100 ,  1.40},
                                                            {250 ,  2.00},
                                                            {500 ,  4.00},
                                                            {1000,  6.00},
                                                            {2000, 10.00}};
        
    private final static Hinta[] maksutOlio = new Hinta[]{ new Hinta(1.00, 50), new Hinta(1.40,100), new Hinta(2.00,250), new Hinta(4.00,500), new Hinta(6.00,1000), new Hinta(10.00,2000)};
      
    /**
     * Testataan luokkien toimintaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
    }
    
    
    /**
     * Laskee kuinka paljon maksaa tietyn painoisen kirjeen lähettäminen
     * @param kirjePaino kirjeen paino
     * @return postimaksu
     * @example
     * <pre name="test">
     * postimaksuDoubleTaulukko(-100) ~~~ -1;
     * postimaksuDoubleTaulukko(0)    ~~~ 1.00;
     * postimaksuDoubleTaulukko(45)   ~~~ 1.00;
     * postimaksuDoubleTaulukko(50)   ~~~ 1.00;
     * postimaksuDoubleTaulukko(100)  ~~~ 1.40;
     * postimaksuDoubleTaulukko(249)  ~~~ 2.00;
     * postimaksuDoubleTaulukko(501)  ~~~ 6.00;
     * postimaksuDoubleTaulukko(999)  ~~~ 6.00;
     * postimaksuDoubleTaulukko(1000) ~~~ 6.00;
     * postimaksuDoubleTaulukko(1999) ~~~ 10.00;
     * postimaksuDoubleTaulukko(2000) ~~~ 10.00;
     * postimaksuDoubleTaulukko(2001) ~~~ -1.00;
     * </pre>
     */
    public static double postimaksuDoubleTaulukko(double kirjePaino) {
        if (kirjePaino < 0) return -1.0;
        int tasojenLkm =  maksut.length;
        for (int i=0; i < tasojenLkm; i++) 
            if (kirjePaino <= maksut[i][0]) return maksut[i][1];
        return -1.0;
    }
    
    
    /**
     * palauttaa kirjeen painoa vastaavan postimaksun
     * @param kirjePaino kirjeen paino
     * @return postimaksu, palautetaan -1 jos maksua ei ole määritetty.
     * @example
     * <pre name="test">
     * postimaksu(-100) ~~~ -1;
     * postimaksu(0)    ~~~ 1.00;
     * postimaksu(45)   ~~~ 1.00;
     * postimaksu(50)   ~~~ 1.00;
     * postimaksu(100)  ~~~ 1.40;
     * postimaksu(249)  ~~~ 2.00;
     * postimaksu(501)  ~~~ 6.00;
     * postimaksu(999)  ~~~ 6.00;
     * postimaksu(1000) ~~~ 6.00;
     * postimaksu(1999) ~~~ 10.00;
     * postimaksu(2000) ~~~ 10.00;
     * postimaksu(2001) ~~~ -1.0;
     * 
     * </pre>
     */
    public static double postimaksu(int kirjePaino) {
        if (kirjePaino < 0) return -1.0;
        int tasojenLkm = Array.getLength(maksutOlio);
        for (int i = 0; i < tasojenLkm; i++)
            if (kirjePaino <= maksutOlio[i].annaPaino()) return maksutOlio[i].annaHinta();
        return -1.0;
        
    }

    
    /**
     * Hinta-luokka
     */
    public static class Hinta {
        private double hinta = 0;
        private int paino = 0;
        
        
        /**
         * Muodostaja hinta-oliolle
         * @param hinta kirjeen hinta
         * @param paino kirjeen paino
         */
        public Hinta(double hinta, int paino) {
            this.hinta = hinta;
            this.paino = paino;
        }
        
        
        /**
         * Saantimetodi painolle
         * @return kirjeen paino
         */
        public int annaPaino() {
            return this.paino;
        }
        
        
        /**
         * Saantimetodi hinnalle
         * @return kirjeen hinta
         */
        public double annaHinta() {
            return this.hinta;
        }
        
        
        /**
         * Testataan luokkien toimintaa
         * @param args ei käytössä
         */
        public static void main(String[] args) {
            int paino = 500;
            double maksu1 = postimaksuDoubleTaulukko(paino);
            System.out.println("Testataan toimiiko 2-ulotteisella double-taulukolla:\n"
                    + "Kirjeen paino on " +paino + " grammaa" +"\n"
                    + "Hinta on tällöin: " +String.format("%.2f", maksu1) +" euroa\n");
        
            
            double maksu2 = postimaksu(paino);
            System.out.println("Testataan toimiiko oliotaulukolla:\n"
                    + "Kirjeen paino on " +paino + " grammaa" +"\n"
                    + "Hinta on tällöin: " +String.format("%.2f", maksu2) +" euroa");
        }
    }
}
    
    