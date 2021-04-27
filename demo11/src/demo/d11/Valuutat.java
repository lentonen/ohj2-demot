package demo.d11;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;

/**
 * Kirjoita tekstipohjainen rahanvaihto-ohjelma, 
 * jossa on vakiotaulukko (eli taulukko on esitelty ja 
 * alustettu koodissa, alkioina Valuutta-olioita, joissa 
 * siis merkkijono ja reaaliluku).
 *  val.   kur.
 * +-----+----------+
 * |mk   |  1.0     |
 * |$    |  5.7     |
 * |EUROA|  5.94573 |
 * |SKr  |  0.6     |
 * +-----+----------+ 
 * ja jonka toiminta näyttäisi seuraavalta:
 *
 * Määrä ja valuutta>10 Skr[RET]
 * 10.00 Skr on 6.00 mk.
 * Määrä ja valuutta>2 EUROA[RET]
 * 2 EUROA on 11.89 mk.
 * Määrä ja valuutta>loppu[RET]
 * Kiitos!
 *
 */
public class Valuutat {
    private static final Valuutta[] valuutat = new Valuutta[] {new Valuutta("mk", 1.0), new Valuutta("$", 5.7), new Valuutta("EUROA", 5.94573), new Valuutta("SKr", 0.6)};
    
    
    /**
     * Valuutta-olio
     */
    public static class Valuutta {
        private double kurssi;
        private String nimi;
        
        
        /**
         * Muodosta jolle viedään valuutan nimi ja kurssi
         * @param valuutanNimi valuutan nimi
         * @param valuutanKurssi kurssi
         */
        public Valuutta(String valuutanNimi, double valuutanKurssi) {
            kurssi = valuutanKurssi;
            nimi = valuutanNimi;
        }
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Valuutta vaihdettava = valuutat[0];
        String mihinVaihdetaan = Syotto.kysy("Mihin valuuttaan halutaan vaihtaa? Osataan vaihtaa mk, $, euroa, skr.");
        for (Valuutta v : valuutat) 
            if (mihinVaihdetaan.equalsIgnoreCase(v.nimi)) vaihdettava = v;
       
        while (true) {
            String s = Syotto.kysy("Määrä ja valuutta");
            if (s == "") break;                                 // Jos tyhjä niin lopetetaan
            StringBuilder sb = new StringBuilder(s);
            double maara = Mjonot.erotaDouble(sb, -1);
            String valNimi = sb.toString().trim();
            for (Valuutta val : valuutat) {
                if (valNimi.equalsIgnoreCase(val.nimi)) System.out.println(String.format("%.2f", maara)  + " " +val.nimi 
                        + " on " +String.format("%.2f", vaihdaValuutta(val, vaihdettava, maara)) 
                        + " " +vaihdettava.nimi +"."); 
            }
        }
        System.out.println("Kiitos!");
    }

    
    /**
     * vaihtaa annetun määrän valuuttaa toiseksi valuutaksi
     * @param mista valuutta josta vaihdetaan
     * @param mihin valuutta johon vaihdetaan
     * @param maara kuinka paljon vaihdetaan
     * @return paljonko uutta valuuttaa saadaan
     * @example
     * <pre name="test">
     * Valuutta euro    = new Valuutta("eur", 1.00);
     * Valuutta dollari = new Valuutta("usd", 0.85);
     * Valuutta punta   = new Valuutta("gbp", 1.17);
     * 
     * vaihdaValuutta(euro, euro, 1) ~~~ 1.0;
     * vaihdaValuutta(euro, dollari, 1) ~~~ 1.176470;
     * vaihdaValuutta(dollari, euro, 1) ~~~ 0.85;
     * vaihdaValuutta(dollari, punta, 1) ~~~ 0.7264957;
     * vaihdaValuutta(punta, dollari, 1) ~~~ 1.376470588;
     * </pre>
     */
    public static double vaihdaValuutta(Valuutta mista, Valuutta mihin, double maara) {
        return maara*(mista.kurssi/mihin.kurssi);
    }
}
