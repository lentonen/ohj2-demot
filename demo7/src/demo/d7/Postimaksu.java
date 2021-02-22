/**
 * 
 */
package demo.d7;

/**
 * @author Henri
 * @version Feb 16, 2021
 *
 */
public class Postimaksu {                         //ÄLÄ LAITA HINTOJA 5snt TARKKUUDELLA ESIM.
    private final static int[][] maksut = new int[][]{{100, 140, 200, 400, 600, 1000 },  //hinnat sentteinä, tarkkuus 10snt tällä hetkellä
                                                      {50 , 100, 250, 500, 1000, 2000}}; // painot grammoina
                                                      
    // Jos halutaan hinnat 1snt tarkkuudelle, niin muuta alla tarkkuus-attribuutiksi 1
    private static int tarkkuus = 10;

                                            

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double rahat = 1.00;
       // int paino = suurinKirjeenPaino(rahat);
        
        //System.out.println("Suurin kirje, jonka voit lähettää on " +paino +" grammaa");
       
        int paino2 = suurinKirjeenPainoTaulukolla(rahat);
        System.out.println("Suurin kirje, jonka voit lähettää on " +paino2 +" grammaa");
        
        int paino3 = suurinKirjeenPainoTaulukolla2(rahat);
        System.out.println("Suurin kirje, jonka voit lähettää on " +paino3 +" grammaa");
        
        
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
     * suurinKirjeenPainoTaulukolla(0) === 0;
     * suurinKirjeenPainoTaulukolla(0.5) === 0;
     * suurinKirjeenPainoTaulukolla(1) === 50;
     * suurinKirjeenPainoTaulukolla(1.39) === 50;
     * suurinKirjeenPainoTaulukolla(1.40) === 100;
     * suurinKirjeenPainoTaulukolla(2.20) === 250;
     * suurinKirjeenPainoTaulukolla(4.00) === 500;
     * suurinKirjeenPainoTaulukolla(9.90) === 1000;
     * suurinKirjeenPainoTaulukolla(10.10) === 2000;
     * </pre>
     */
    public static int suurinKirjeenPainoTaulukolla(double rahat) {
        int tasojenLkm =  maksut[0].length;
        for (int i=0; i < tasojenLkm; i++) {
            if (rahat < maksut[0][i+1]/100) return maksut[1][i];
        }
        return maksut[1][tasojenLkm-1];
    }
    
    
    /**
     * Laskee kuinka painavan kirjeen (g) voi lähettää tietyllä rahasummalla (€)
     * @param rahat paljonko rahaa käytössä
     * @return kuinka painavan kirjeen saa lähetettyä rahasummalla
     * @example
     * <pre name="test">
     * suurinKirjeenPainoTaulukolla2(0) === 0;
     * suurinKirjeenPainoTaulukolla2(0.5) === 0;
     * suurinKirjeenPainoTaulukolla2(1) === 50;
     * suurinKirjeenPainoTaulukolla2(1.39) === 50;
     * suurinKirjeenPainoTaulukolla2(1.40) === 100;
     * suurinKirjeenPainoTaulukolla2(2.20) === 250;
     * suurinKirjeenPainoTaulukolla2(4.00) === 500;
     * suurinKirjeenPainoTaulukolla2(9.90) === 1000;
     * suurinKirjeenPainoTaulukolla2(10.10) === 2000;
     * </pre>
     */
    public static int suurinKirjeenPainoTaulukolla2(double rahat) {
        int maxHinta = maksut[0][maksut[0].length-1];
        if (rahat >= maxHinta /100) return maksut[1][maksut[0].length-1]; // TODO: muuta riippumaan alkutaulukosta
        int[] hintaTaulukko = new int[ maxHinta /tarkkuus];
        
        hintaTaulukko = muodostahintaTaulukko(hintaTaulukko);
        double rahat10Cent = rahat*100/tarkkuus;
        int rahatInt = (int)rahat10Cent;
        return hintaTaulukko[rahatInt];
    }

    
    /**
     * Muodostaa taulukon attribuuttina annetuista maksut-taulukosta
     * @param hintaTaulukko
     * @return hintataulukko halutulla tarkkuudella.
     */
    private static int[] muodostahintaTaulukko(int[] hintaTaulukko) {
       for (int i = 0; i < maksut[0][0]/tarkkuus; i++)
           hintaTaulukko[i] = 0;
       int k = 0;
       for (int i=1; i < maksut[0].length; i++) {
           for (int j =  maksut[0][k]/tarkkuus; j <  maksut[0][k+1]/tarkkuus; j++)
           hintaTaulukko[j] = maksut[1][k];
           k++;
       }
        return hintaTaulukko;
    }
}


/*  IDEA SILMUKAN TAKANA
for (int j = maksut[0][1]/10; j < maksut[0][2]/10; j++)
hintaTaulukko[i] = maksut[1][1];

for (int j = 20; j < 40; j++)
hintaTaulukko[i] = 250;
for (int j = 40; j < 60; j++)
hintaTaulukko[i] = 500;
for (int j = 60; j < 100; j++)
hintaTaulukko[i] = 1000;*/