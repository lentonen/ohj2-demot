package demo.d12;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import fi.jyu.mit.ohj2.Help;
import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;

/**
 * 
 */
public class Komentorivi {

    /**
     *  Rajapinta konsolissa toteutettaville komennoille.
     */
    public interface KomentoRajapinta {
        
        
        /**
         * Suorittaa komennon
         * @param parametrit
         * @return komennon tulos
         */
        String suorita(String parametrit);
    }


    /**
     * Luokka yhteenlaskulle.
     */
    public static class Ynnaa implements KomentoRajapinta {
       
        
        /**
         * Laskee yhteen parametreina tuodut kokonaisluvut. Jos parametrina tuodaan kirjaimia, niin niistä ei välitetä. Mikäli laskettavia
         * numeroita ei ole, palautetaan 0.
         * @example
         * <pre name="test">
         * #import demo.d12.Komentorivi.Ynnaa;
         * Ynnaa ynnaa = new Ynnaa();
         * ynnaa.suorita("1 2 3") === "6";
         * ynnaa.suorita("") === "0";
         * ynnaa.suorita("s") === "0";
         * ynnaa.suorita("-5 10 100") === "105";
         * ynnaa.suorita("-5 10 100 -1000") === "-895";
         * </pre>
         */
        @Override
        public String suorita(String parametrit) {
            StringBuilder sb = new StringBuilder(parametrit);
            int luku = 0;
            int summa = 0;
            while (luku != Integer.MAX_VALUE) {
                summa += luku;
                luku = Mjonot.erotaInt(sb, Integer.MAX_VALUE);
            }
            return Integer.toString(summa);
        }
    }
    

    /**
     * Apua-luokka komentorivin ohjeille.
     */
    public static class Apua implements KomentoRajapinta {
        private String tiedostonNimi;
        private Help help = null;
        private ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        
        /**
         * Luodaan Apua-olio, jolle viedään parametrina luettavan help-tiedoston nimi.
         * @param tiedostonNimi tiedosto johon ohjeet tallennettu
         */
        public Apua(String tiedostonNimi) {
            this.tiedostonNimi = tiedostonNimi;
        }
        

        /**
         * Näyttää ohjeet komentorivin käytölle.
         * @example
         * <pre name="test">
         * #THROWS IOException
         * #import fi.jyu.mit.ohj2.VertaaTiedosto;
         * #import java.io.IOException;
         * #import fi.jyu.mit.ohj2.Suuntaaja;
         * 
         * VertaaTiedosto.kirjoitaTiedosto("lue.txt",
         *  "[SISÄLLYS] - aina etsitään sisällystä tällä aihe- (topic) nimellä.\n" +
         *  " Ohjelma osaa tällä hetkellä\n\n" +
         *  "ynnää - kokonaisluvut\n" +
         *  "isoksi - jono\n" +
         *  "palindromiko - jono\n\n" +
         *  "[YNNÄÄ]\n" +
         *  "Ynnä\n" +
         *  "[ISOKSI]\n" +
         *  "isoksi\n" +
         *  "[PALINDROMIKO]\n" +
         *  "palindromi");
         *  
         *  Apua apua = new Apua("lue.txt");
         *  apua.suorita("ynnää") === "Ynnä\n" ;
         *  apua.suorita("Isoksi") === "isoksi\n" ;
         *  apua.suorita("PALINDROMIKO") === "palindromi\n" ;
         *  
         *  VertaaTiedosto.tuhoaTiedosto("lue.txt");
         * </pre>
         */
        @Override
        public String suorita(String parametrit) {
            bos.reset();
            try {
                help = new Help(tiedostonNimi);
            } catch (IOException e) {
                System.err.println("Ongelmia tiedoston lukemisessa");
            }
            if (parametrit.equals("")) { 
                help.browse();
                return "";
            }
            help.setOut(new PrintStream(bos));
            help.browse(parametrit);
            return bos.toString().replace("\r\n", "\n");  // Varmistetaan, että jono ei sisällä rivinvaihtoa \r\n 
        }   
    }
    
    
    /**
     * Palindromi-luokka. Palindromi-oliolta osaa kertoa onko sille parametrina viety sana palindromi.
     */
    public static class Palindromiko implements KomentoRajapinta {

        
        /**
         * Kertoo onko parametrina tuotu jono palindromi.
         * @example
         * <pre name="test">
         * Palindromiko pal = new Palindromiko();
         * pal.suorita("abba") === "Sana \"abba\" on palindromi";
         * pal.suorita("abbas") === "Sana \"abbas\" ei ole palindromi";
         * pal.suorita("Saippuakauppias") === "Sana \"Saippuakauppias\" on palindromi";
         * pal.suorita("") === "Sana \"\" on palindromi";
         * </pre>
         */
        @Override
        public String suorita(String parametrit) {
            if (palindromi(parametrit)) return "Sana \"" +parametrit +"\" on palindromi";
            return "Sana \"" +parametrit +"\" ei ole palindromi";
        }
        
        
        /**
         * Tutkii onko sana palindromi. Ei välitetä isoista ja pienistä kirjaimista
         * @param sana tutkittava sana
         * @return true jos on, false jos ei ole
         * @example
         * <pre name="test">
         * #import demo.d12.Komentorivi.Palindromiko;
         * String sana = "abba";
         * Palindromiko.palindromi(sana) === true;
         * sana = "apua";
         * Palindromiko.palindromi(sana) === false;
         * sana = "saippuakauppias";
         * Palindromiko.palindromi(sana) === true;
         * sana = "Saippuakauppias";
         * Palindromiko.palindromi(sana) === true;
         * </pre>
         */
        public static boolean palindromi(String sana) {
            int viimeinen = sana.length() -1;
            String sanaLower = sana.toLowerCase();
            int i = 0;
            while ( i  < viimeinen-i) {
                if (sanaLower.charAt(i) != sanaLower.charAt(viimeinen-i)) return false;
                i++;
            }
            return true;
       }
    }
    
    
    /**
     * Isoksi-luokka. Isoksi-olio osaa muuttaa sille viedyn jonon kirjaimet isoiksi.
     */
    public static class Isoksi implements KomentoRajapinta {

        
        /**
         * Muuttaa merkkijonon pienet kirjaimet isoiksi.
         * @example
         * <pre name="test">
         * Isoksi iso = new Isoksi();
         * iso.suorita("") === "";
         * iso.suorita("abc") === "ABC";
         * iso.suorita("abc 3216") === "ABC 3216";
         * iso.suorita("Kissa") === "KISSA";
         * iso.suorita("ERt-097") === "ERT-097";
         * </pre>
         */
        @Override
        public String suorita(String parametrit) {
            return parametrit.toUpperCase();
        }
    }

    
    /**
     * Komennon nimi ja vastaava "funktio".
     */
    public static class Komento {
        
        private String nimi;
        private KomentoRajapinta komento; 
        
        
        /**
         * Luodaan komento-olio jolla on nimi ja komento.
         * @param nimi nimi
         * @param kRajaP komento
         */
        public Komento(String nimi, KomentoRajapinta kRajaP) {
            this.nimi = nimi;
            this.komento = kRajaP;
        }
        
        
        /**
         * Saantimetodi komennon nimelle
         * @return komennon nimi
         */
        public String annaNimi() {
            return nimi;
        }
    }
    

    /**
     * Komennot-luokka, jossa tietorakenne komentojen tallentamista varten.
     */
    public static class Komennot {
        private static List<Komento> komennot = new ArrayList<Komento>();
        
        
        /**
         * Palauttaa tietorakenteeseen tallennettujen komentojen lukumäärän
         * @return komentojen lukumäärä.
         */
        public int size() {
            return komennot.size();
        }

        
        /**
         * Tulkitsee käyttäjän syötteen. Erottaa komennon ja välittää sen perusteella parametrit oikeaan paikkaan.
         * Komento välitetään ensimmäiselle oliolle, jonka nimi vastaa kirjoitettua komentoa. Jos nimeä ei kirjoiteta
         * täydellisesti, niin regexp valitsee komennon, joka ensimmäisenä täsmää regular expressioniin.
         * @param s Käyttäjän syöttämä merkkijono
         * @return komentoa vastaava tulos.
         * @example
         * <pre name="test">
         * #import demo.d12.Komentorivi.Komennot;
         * Komennot komennot = new Komennot();
         * komennot.add(new Komento("ynnää", new Ynnaa()));
         * String s = "ynnää 2 3 4";
         * komennot.tulkitse(s) === "9";
         * s = "ynnaa 2 3 4";
         * komennot.tulkitse(s) === "komentoa ei tunneta";
         * s = "ynnää 2 3 4 s";
         * komennot.tulkitse(s) === "9";
         * s = "ynnää";
         * komennot.tulkitse(s) === "0";
         * s = "ynnää 2";
         * komennot.tulkitse(s) === "2";
         * </pre>
         */
        public String tulkitse(String s) {
            StringBuilder sb = new StringBuilder(s);
            String komento = Mjonot.erota(sb).replace("?", "\\?");
            String parametrit = sb.toString();
            for (Komento tarkasteltava: komennot) {
                if (tarkasteltava.annaNimi().matches(komento +".*")) {
                    String tulos = tarkasteltava.komento.suorita(parametrit);
                    return tulos;
                }
            }
            return "komentoa ei tunneta";
        }
        
        
        /**
         * Lisää komennon tietorakenteeseen
         * @param komento lisättävä komento
         * @example
         * <pre name="test">
         * Komennot testi = new Komennot();
         * testi.size() === 0;
         * testi.add(new Komento("ynnää", new Ynnaa()));
         * testi.size() === 1;
         * testi.add(new Komento("+", new Ynnaa()));
         * testi.size() === 2;
         * </pre>
         */
        public void add(Komento komento) {
            komennot.add(komento);
        }
    }
    
    
    /**
     * Testipääohjelma
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Komennot komennot = new Komennot();
        Apua apua = new Apua("komento.txt");
        komennot.add(new Komento("?", apua));
        komennot.add(new Komento("apua", apua));
        komennot.add(new Komento("+", new Ynnaa()));
        komennot.add(new Komento("ynnää", new Ynnaa()));
        komennot.add(new Komento("isoksi", new Isoksi()));
        komennot.add(new Komento("palindromiko", new Palindromiko()));

        String s;

        while (true) {
            s = Syotto.kysy("Anna komento");
            if ("".equals(s))
                break;
            String tulos = komennot.tulkitse(s);
            System.out.println(tulos);
        }
    }
}


