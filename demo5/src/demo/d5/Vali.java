/**
 * 
 */
package demo.d5;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author Henri
 * @version Feb 12, 2021
 *
 */
public class Vali {
    private double alaraja;
    private double ylaraja;
    
    
    /**
     * muodostaja jolle viedään ala- ja yläraja.
     * @param alaraja reaalilukuvälin alaraja
     * @param ylaraja reaalilukuvälin yläraja
     */
    public Vali(double alaraja, double ylaraja) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
    }
    
    
    /**
     * saantimetodi alarajalle
     * @return alarajan arvo
     */
    public double getAlaraja() {
        return alaraja;
    }
    
    
    /**
     * saantimetodi ylärajalle
     * @return ylärajan arvo
     */
    public double getYlaraja() {
        return ylaraja;
    }
    
    
    /**
     * Muuttaa välin ala- ja ylärajaa käyttämän syöttämän merkkijonon perusteella.
     * @param mj merkkijono josta ala- ja yläraja haetaan
     */
    public void parse(String mj) {
        StringBuilder jono = new StringBuilder(mj);
        double ala;
        double yla;
        if (mj.indexOf("-") == -1 && mj.length() != 0) {
            ala = Double.parseDouble(mj);
            yla = Double.parseDouble(mj);
        }
        else {
            ala = Mjonot.erota(jono, '-', alaraja);
            yla = Mjonot.erota(jono, '-', ylaraja);
        }
        this.alaraja = ala;
        this.ylaraja = yla;
    }
    
    
    /**
     * Muuttaa Vali-olion merkkijonoksi
     * @return olion merkkijonona
     */
    @Override
    public String toString() {
        return Double.toString(this.alaraja) + "-" +Double.toString(this.ylaraja);
    }
    
    
    /**
     * vertaa välejä toisiinsa (eli osuvatko päällekkäin). HUOM! Ei ole mielekäs tapa
     * verrata, koska välit voivat asettua siten, että toisen loppupiste on toisen alkupiste.
     * Tällöin välit ovat päällekkäin ainoastaan yhdessä pisteessä. Järkevämpi tapa
     * olisi tehdä compareTo, joka palauttaa arvon, joka kertoo kuinka paljon välit ovat päällekkäin.
     * @param vali väli johon verrataan
     * @return -1 kun ollaan verratusta vasemmalla, 1 kun ollaan verratusta oikealla, 0 kun ollaan päällekkäin jossakin kohdin
     * @example
     * <pre name="test">
     * Vali vali1 = new Vali(1,3);
     * Vali vali2 = new Vali(2,4);
     * vali1.compareTo(vali2) === 0;
     * vali2.parse("3.5-");
     * vali1.compareTo(vali2) === -1;
     * vali1.parse("5-10");
     * vali1.compareTo(vali2) === 1;
     * </pre>
     */
    public int compareTo(Vali vali) {
        if (vali.alaraja > ylaraja) return -1;
        if (vali.ylaraja < alaraja) return 1;
        return 0;
                
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Vali v1 = new Vali(1, 3), v2 = new Vali(2, 4);
        System.out.println(v1); // tulostaa (1.0-3.0)
        System.out.println(v2); // tulostaa (2.0-4.0)
        v1.parse("8-10");    // loppupiste puuttuu, käytetään valin olemassa olevaa
        v2.parse("6-8");
        System.out.println(v1); // tulostaa (2.0-3.0)
        System.out.println(v2); // tulostaa (2.5-7.0)
        

        int osuman_laatu = v1.compareTo(v2); // vastaa "vähennyslaskua"
                                             // ol = v1 - v2;
        if ( osuman_laatu == 0 ) // esimerkin välit osuvat
            System.out.println("Välit osuvat toisiinsa");
        else if ( osuman_laatu == 1 )
            System.out.println("v1 kokonaan v2:n oikealla puolella");
        else if ( osuman_laatu == -1 )
            System.out.println("v1 kokonaan v2:n vasemmalla puolella");
    }

}
