package demo.d12;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Ohjelma nimien kyselylle.
 */
public class NimenKysely {
    private static Nimet nimet = new Nimet();
    
    
    /**
     * Käynnistää nimien kyselyn. Kysely lopetetaan, kun syötetään tyhjä rivi. Lopussa tulostetaan nimet sukunimen mukaan aakkosjärjestyksessä.
     */
    private static void käynnistäKysely() {
        String s;
        while (true) {
            s = Syotto.kysy("Anna nimi");
            if ("".equals(s)) {
                nimet.tulosta();
                break;
            }
            nimet.add(s);
        } 
    }
    
    
    /**
     * Nimet-luokka, jossa lista kaikista nimistä. Osaa lisätä nimiä tietorakenteeseen ja järjestää ne.
     */
    public static class Nimet {
        private ArrayList<Nimi> lista = new ArrayList<Nimi>();
    
        /**
         * Lisätään nimi tietorakenteeseen. Ei anneta lisätä, jos ei ole välimerkillä erotettua sukunimeä ja etunimeä.
         * Tällä hetkellä hyväksyy vielä sen, jos nimiä syötetään enemmän kuin kaksi.
         * @param jono lisättävä nimi
         * @example
         * <pre name="test">
         * #import demo.d12.NimenKysely.Nimet;
         * #import fi.jyu.mit.ohj2.Suuntaaja;
         * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
         * Nimet nimet = new Nimet();
         * nimet.size() === 0;
         * nimet.add("aku ankka");
         * nimet.size() === 1;
         * nimet.add("iines ankka");
         * nimet.size() === 2;
         * nimet.add("iines ");
         * nimet.size() === 2;
         * nimet.add("iines");
         * nimet.size() === 2;
         * so.palauta();
         * </pre>
         */
        public void add(String jono) {
            Nimi uusi = new Nimi();
            String virhe = uusi.parse(jono);
            if (virhe == null)
                lista.add(uusi);
            else System.out.println(virhe);
        }
        
        
        /**
         * saantimetodi tallennettujen nimien määrälle.
         * @return tietorakenteeseen tallennettujen nimien lukumäärä
         */
        public int size() {
            return lista.size();
        }
        
        
        /**
         * Tulostaa tietorakenteeseen lisätyt nimet sukunimen mukaan aakkosjärjestykseen.
         * @example
         * <pre name="test">
         * #import fi.jyu.mit.ohj2.Suuntaaja;
         * 
         * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
         * 
         *  String tulos =
         *      "Lisätyt nimet olivat:\n" +
         *      "Aku Ankka\n"+
         *      "Iines Ankka\n"+
         *      "Pelle Peloton\n"+
         *      "Sepe Susi\n"+
         *      "Pupu Tupuna\n"+
         *      "Väiski Vemmelsääri\n";
         * 
         * Nimet nimet = new Nimet();
         * nimet.add("Sepe Susi");
         * nimet.add("Iines Ankka");
         * nimet.add("Aku Ankka");
         * nimet.add("Pelle Peloton");
         * nimet.add("Väiski Vemmelsääri");
         * nimet.add("Pupu Tupuna");
         * 
         * nimet.tulosta();
         * so.ero(tulos) === null;
         * so.palauta();
         * </pre>
         */
        public void tulosta() {
            jarjesta();
            System.out.println("Lisätyt nimet olivat:");
            for (Nimi nimi : lista)
                System.out.println(nimi);
        }

        
        /**
         * Järjestää listan nimet aakkosjärjestykseen ensin sukunimen mukaan ja sitten etunimen mukaan.
         * Testattu tulosta-metodissa.
         */
        public void jarjesta() {
            Collections.sort(lista);
        }
    }
    
    
    /**
     * Nimi-luokka. Nimi sisältää etunimen ja sukunimen.
     */
    public static class Nimi implements Comparable<Nimi> {
        private String etunimi;
        private String sukunimi;
        
        /**
         * Muodostetaan nimi, joka sisältää etunimen ja sukunimen
         * @param etunimi henkilön etunimi
         * @param sukunimi henkilön sukunimi
         */
        public Nimi(String etunimi, String sukunimi) {
            this.etunimi = etunimi;
            this.sukunimi = sukunimi;
        }
        
        
        /**
         * Oletusmuodostaja.
         */
        public Nimi() {
            //
        }
        
        
        /**
         * Muodostaa nimen annetun merkkijonon perusteella. Olion nimi ei muutu, jos syötetty nimi ei sisällä sekä sukunimeä että etunimeä.
         * @param jono jono josta nimi parsitaan
         * @return null jos sekä etunimi että sukunimi saadaan parsittua. Virheteksti, jos jompikumpi nimistä epäonnistuu.
         * @example
         * <pre name="test">
         * #import demo.d12.NimenKysely.Nimi;
         * Nimi uusi = new Nimi();
         * String virhe = uusi.parse("aku ankka");
         * uusi.toString() === "aku ankka";
         * virhe === null;
         * virhe = uusi.parse("aku");
         * uusi.toString() === "aku ankka";
         * virhe === "Syötä nimi muodossa \"Etunimi Sukunimi\"";
         * virhe = uusi.parse("aku ");
         * uusi.toString() === "aku ankka";
         * virhe === "Syötä nimi muodossa \"Etunimi Sukunimi\"";
         * virhe = uusi.parse("Sepe Susi");
         * uusi.toString() === "Sepe Susi";
         * virhe === null;
         * </pre>
         */
        public String parse(String jono) {
            StringBuilder sb = new StringBuilder(jono);
            String etunimiEhdokas = Mjonot.erota(sb);
            String sukunimiEhdokas = sb.toString();
            if (sukunimiEhdokas.equals("") || etunimiEhdokas.equals("")) return "Syötä nimi muodossa \"Etunimi Sukunimi\"";
            etunimi = etunimiEhdokas;
            sukunimi = sukunimiEhdokas;
            return null;
        }

        
        /**
         * Verrataan nimiä toisiinsa ensin sukunimen ja sitten etunimen suhteen.
         * Käyttää String-luokan compareTo-metodia ensin sukunimeen ja sitten etunimeen. Jos samoja
         * niin palautetaan 0.
         */
        @Override
        public int compareTo(Nimi nimi) {
            int tulos = this.sukunimi.compareTo(nimi.sukunimi);
            if (tulos != 0) return tulos;
            tulos = this.etunimi.compareTo(nimi.etunimi);
            if (tulos != 0) return tulos;
            return 0;
        }
        
        
        /**
         * Muuttaa nimen merkkijonoksi
         * @example
         * <pre name="test">
         * Nimi tupu = new Nimi("Tupu", "Ankka");
         * tupu.toString() === "Tupu Ankka";
         * Nimi hupu = new Nimi("Hupu", "Ankka");
         * hupu.toString() === "Hupu Ankka";
         * </pre>
         */
        @Override
        public String toString() {
            return etunimi + " " +sukunimi;
        }
    }

    
    /**
     * Pääohjelma, josta kysely käynnistetään.
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        käynnistäKysely();
    }
}
