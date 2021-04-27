package demo.d11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;


/**
 *
 */
public class ValuutatTiedostosta {
    
    
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
        
        
        /**
         * Oletusmuodostaja
         */
        public Valuutta() {
            // Ei tarvitse mitään
        }
        
        
        /**
         * Muuttaa valuutan merkkijonoksi
         * @return valuutta merkkijonona
         * @example
         * <pre name="test">
         * Valuutta euro = new Valuutta("eur", 1.0);
         * euro.toString() === "eur 1.00"
         * </pre>
         */
        @Override
        public String toString() {
            return nimi + " " + String.format("%.2f", kurssi);
        }


        /**
         * parsii valuutan tiedot annetusta merkkijonosta
         * @param s merkkijono, josta valuutan tietoja haetaan
         * @example
         * <pre name="test">
         * Valuutta euro = new Valuutta();
         * euro.parse(" eur  |  1 ");
         * euro.toString() === "eur 1.00";
         * 
         * Valuutta dollari = new Valuutta();
         * dollari.parse(" usd  |  5.7 ");
         * dollari.toString() === "usd 5.70";
         * </pre>
         */
        public void parse(String s) {
            StringBuilder sb = new StringBuilder(s);
            nimi = (Mjonot.erota(sb, '|', nimi));
            kurssi = Mjonot.erota(sb, '|', kurssi);
        }
    }
    
    
    /**
     * Lukee valutat tiedostosta ja palauttaa ne valuutta-listana
     * @param tiedosto s
     * @return listan tiedostosta luetuista valuutoista
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #THROWS IndexOutOfBoundsException 
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     *  VertaaTiedosto.kirjoitaTiedosto("testivaluutat.txt",
     *      "eur|1\n"+
     *      "usd|0.85\n"+
     *      "gbp|1.17\n");
     *  var valuutat = lueValuutat("testivaluutat.txt");
     *  valuutat.get(0).toString() ==="eur 1.00";
     *  valuutat.get(1).toString() ==="usd 0.85";
     *  valuutat.get(2).toString() ==="gbp 1.17";
     *  valuutat.get(3).toString() ==="eur 1.17"; #THROWS IndexOutOfBoundsException
     *  VertaaTiedosto.tuhoaTiedosto("testivaluutat.txt");
     * </pre>
     */
    public static ArrayList<Valuutta> lueValuutat(String tiedosto ) {
        ArrayList<Valuutta> valuutatLuettu = new ArrayList<Valuutta>();
        File ftied = new File(tiedosto);
        try (Scanner fi = new Scanner(new FileInputStream(ftied))) {
            while (fi.hasNext()) {
                String s = "";
                s = fi.nextLine();
                Valuutta valuutta = new Valuutta();
                valuutta.parse(s); // voisi palauttaa onnistuuko parsiminen BOOL
                valuutatLuettu.add(valuutta);
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return valuutatLuettu;
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        var valuutat = lueValuutat("valuutat.txt");
        Valuutta vaihdettava = valuutat.get(0);
        String mihinVaihdetaan = Syotto.kysy("Mihin valuuttaan halutaan vaihtaa? Osataan vaihtaa usd, eur, gbp");
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



