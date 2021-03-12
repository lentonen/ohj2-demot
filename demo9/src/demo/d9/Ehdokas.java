/**
 * 
 */
package demo.d9;

/**
 * @author Henri
 * @version Mar 12, 2021
 *
 */
public class Ehdokas {
    private double rahat;  // ehdokkaan rahat
    private int aanet;     // ehdokkaan äänet
    
    
    /**
     * Luodaan ehdokas
     * @param rahat ehdokkaan rahat
     * @param aanet ehdokkaan äänet
     */
    public Ehdokas(double rahat, int aanet) {
        this.rahat = rahat;
        this.aanet = aanet;
    }
    
    
    /**
     * Muuttaa ehdokkaan merkkijonoksi
     * @example
     * <pre name="test">
     * Ehdokas ehd = new Ehdokas(1500.0, 15);
     * ehd.toString() ==="Rahaa 1500.00, ääniä 15";
     * Ehdokas ehd3 = new Ehdokas(0, 0);
     * ehd3.toString() ==="Rahaa 0.00, ääniä 0";
     * </pre>
     */
    @Override
    public String toString() {
        return "Rahaa " + String.format("%.2f", rahat) +", ääniä " +aanet;
    }
    
    
    /**
     * Ehdokas ostaa ääniä. Osto tehdään vain jos rahat riittävät koko määrän ostamiseen.
     * @param maara haluttu äänimäärä
     * @param kappaleHinta yhden äänen hinta
     * @return true jos osto onnistui (rahat riittävät), false jos osto ei onnistu (rahat eivät riitä)
     * @example
     * <pre name="test">
     *  Ehdokas ehd1 = new Ehdokas(1000, 300);
     *  ehd1.toString() ==="Rahaa 1000.00, ääniä 300";
     *  boolean onnistui = ehd1.osta(10, 10);
     *  onnistui === true;
     *  ehd1.toString() ==="Rahaa 900.00, ääniä 310";
     *  onnistui = ehd1.osta(90, 10);
     *  ehd1.toString() ==="Rahaa 0.00, ääniä 400";
     *  onnistui === true;
     *  onnistui = ehd1.osta(1, 1);
     *  ehd1.toString() ==="Rahaa 0.00, ääniä 400";
     *  onnistui === false;
     * </pre>
     */
    public boolean osta(int maara, double kappaleHinta) {
        double kokonaisHinta = maara*kappaleHinta; 
        if (this.rahat >= kokonaisHinta) {
            this.aanet += maara;
            this.rahat -= maara*kappaleHinta;
            return true;
        }
        return false;
    }
    
    
    /**
     * verrataan ehdokkaita äänimäärien perusteella. Suurempi äänimäärä voittaa.
     * @param ehdokas ehdokas johon verrataan
     * @return negatiivinen luku jos hävitään, 0 jos tasapeli, positiivinen luku jos voitetaan
     * @example
     * <pre name="test">
     *   Ehdokas ehd1 = new Ehdokas(1000, 300);
     *   Ehdokas ehd2 = new Ehdokas(1000, 300);
     *   ehd1.compareTo(ehd2) === 0;
     *   ehd1.osta(1, 100.0); 
     *   ehd1.compareTo(ehd2) === 1;
     *   ehd2.osta(2, 100.0); 
     *   ehd1.compareTo(ehd2) === -1;
     * </pre>
     */
    public int compareTo(Ehdokas ehdokas) {
        if (this.aanet > ehdokas.aanet) return 1;
        if (ehdokas.aanet > this.aanet) return -1;
        return 0;
    }

    /**
     * Pääohjelma ehdokkaan testaamista varten
     * @param args ei käytössä
     */
    public static void main(String[] args)  {
        Ehdokas ehd1 = new Ehdokas(100000.0, 0);
        Ehdokas ehd2 = new Ehdokas(20000.0, 300);
        System.out.println(ehd1); // Tulostaa: Rahaa 100000.00, ääniä 0
        System.out.println(ehd2); // Tulostaa: Rahaa 20000.00, ääniä 300
        ehd1.osta(200, 100.0); // Ostaa 200 ääntä, 100 mk/kpl
        System.out.println(ehd1); // Tulostaa: Rahaa 80000.00, ääniä 200
        boolean onnistui = ehd2.osta(300, 100);
        if (!onnistui) System.out.println("Rahat ei riitä :-)");
        System.out.println(ehd2); // Tulostaa: Rahaa 20000.00, ääniä 300
        if (ehd1.compareTo(ehd2) > 0) System.out.println("Ehdokas 1 voitti!");
        if (ehd1.compareTo(ehd2) < 0) System.out.println("Ehdokas 2 voitti!");
        if (ehd1.compareTo(ehd2) == 0) System.out.println("Tasapeli!");
        // Vertailu tehdään äänimäärien perusteella.
        // Esimerkissä tulostuu : Ehdokas 2 voitti!
    }
}
