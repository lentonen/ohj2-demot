
package demo.d7;

public class Postimaksu2 {                         
    private final static double[][] maksut = new double[][]{{0, 1.00, 1.40, 2.00, 4.00, 6.00, 10.00 },  //hinnat euroina
                                                            {0, 50  ,  100,  250,  500,  1000, 2000}};   // painot grammoina
                                     

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double rahat = 1.00;
       // int paino = suurinKirjeenPaino(rahat);
        
        //System.out.println("Suurin kirje, jonka voit lähettää on " +paino +" grammaa");
       
        double paino2 = suurinKirjeenPainoTaulukolla(rahat);
        System.out.println("Suurin kirje, jonka voit lähettää on " +paino2 +" grammaa");  
    }

    /**
     * Laskee kuinka painavan kirjeen (g) voi lähettää tietyllä rahasummalla (€)
     * @param rahat paljonko rahaa käytössä
     * @return kuinka painavan kirjeen saa lähetettyä rahasummalla
     * @example
     * <pre name="test">
     * suurinKirjeenPaino(0) === 0;
     * suurinKirjeenPaino(0.5) === 0;
     * suurinKirjeenPaino(1) === 50;
     * suurinKirjeenPaino(1.39) === 50;
     * suurinKirjeenPaino(1.40) === 100;
     * suurinKirjeenPaino(2.20) === 250;
     * suurinKirjeenPaino(4.00) === 500;
     * suurinKirjeenPaino(9.90) === 1000;
     * suurinKirjeenPaino(10.10) === 2000;
     * </pre>
     */
    public static int suurinKirjeenPaino(double rahat) {
        
        
        if (rahat < 1.00) return 0;
        if (rahat < 1.40) return 50;
        if (rahat < 2.00) return 100;
        if (rahat < 4.00) return 250;
        if (rahat < 6.00) return 500;
        if (rahat < 10.00) return 1000;
        return 2000; 
    }
    
    
    /**
     * Laskee kuinka painavan kirjeen (g) voi lähettää tietyllä rahasummalla (€)
     * @param rahat rahat paljonko rahaa käytössä
     * @return kuinka painavan kirjeen saa lähetettyä rahasummalla
     * @example
     * <pre name="test">
     * suurinKirjeenPainoTaulukolla(0) ~~~ 0;
     * suurinKirjeenPainoTaulukolla(0.5) ~~~ 0;
     * suurinKirjeenPainoTaulukolla(1) ~~~ 50;
     * suurinKirjeenPainoTaulukolla(1.39) ~~~ 50;
     * suurinKirjeenPainoTaulukolla(1.40) ~~~ 100;
     * suurinKirjeenPainoTaulukolla(2.20) ~~~ 250;
     * suurinKirjeenPainoTaulukolla(4.00) ~~~ 500;
     * suurinKirjeenPainoTaulukolla(9.90) ~~~ 1000;
     * suurinKirjeenPainoTaulukolla(10.10) ~~~ 2000;
     * </pre>
     */
    public static double suurinKirjeenPainoTaulukolla(double rahat) {
        int tasojenLkm =  maksut[0].length;
        for (int i=0; i < tasojenLkm-1; i++) {
            if (rahat < maksut[0][i+1]) return maksut[1][i];
        }
        return maksut[1][tasojenLkm-1];
    }
}
    
    