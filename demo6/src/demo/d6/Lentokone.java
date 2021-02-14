/**
 * 
 */
package demo.d6;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Henri
 * @version Feb 14, 2021
 *
 */
public class Lentokone extends Kulkuneuvo {
    private int miehisto;
    
    /**
     * Muodostaja lentokoneelle
     * @param nopeus lentokoneen nopeus
     * @param matkustajat matkustajien lukumäärä
     * @param miehisto miehistön lukumäärä
     */
    public Lentokone(int nopeus, int matkustajat, int miehisto) {
        super(nopeus, matkustajat);
        this.miehisto = miehisto;
    }
    
    
    /**
     * saantimetodi miehistön määrälle
     * @return palauttaa miehistön määrän
     */
    public int getMiehisto() {
        return miehisto;
    }
    
    
    /**
     * Kertoo arvion sille, montako matkustajaa on yhtä miehistön jäsentä kohden
     * @return matkustajien suhde miehistöön
     */
    public double getMatkustajaMiehistoSuhde() {
        return Math.round((1.0 * this.getMatkustajat()) / (1.0 * this.getMiehisto()));
    }
    
    
    /**
     * Muuttaa olion merkkijonoksi, jossa näkee tiedot nopeudesta, matkustajista ja miehistöstä.
     */
    @Override
    public String toString() {
        return super.toString() + ", miehistöä " +miehisto;
    }
    
    /**
     * pääohjelma lentokone-luokan testaamista varten
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        NumberFormat formatter = new DecimalFormat("#0");   
        Lentokone finnair = new Lentokone(850, 125, 2);
        System.out.println(finnair.toString());
        System.out.println("Jokaista miehistön jäsentä kohden on kyydissä noin " +formatter.format(finnair.getMatkustajaMiehistoSuhde()) +" matkustajaa");
    
    }

}
