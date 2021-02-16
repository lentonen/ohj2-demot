package demo.d6.Astia;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Suuntaaja;
import fi.jyu.mit.ohj2.Syotto;

/**
 *  John McLane (Bruce Willis) joutui elokuvassa Die Hard 3 ongelman eteen,
 *  jossa piti kahdella vesikanisterilla mitata jonkin muun suuruinen
 *  vesimäärä "tarkasti" ja näin estää pommin räjähtäminen.
 *  Koska aika meni varsin tiukalle, on vastaavien tilanteiden harjoittelemiseksi
 *  nyt tehty uusi menestysohjelma "Astia".
 *<br>
 *  Pelillä demonstroidaan/harjoitellaan miten voidaan kahdella astialla,
 *  5 l ja 8 l,  muodostaa kaikki mahdolliset tilavuudet 1-13 l.
 *  Pelissä on kaksi varsinaista astiaa: a5 ja a8, sekä kolmas apuastia
 *  ampari.  Nestettä voidaan kerrallaan kaataa yhdestä astiasta toiseen
 *  joko siten, että astian koko sisältö tyhjennetään jos se mahtuu
 *  tai astista kaadetaan sen verran että toinen astia tulee täyteen.
 *<br>
 *  Tee ohjelma jota voitasiin käyttää seuraavasti:
 *<br>
 *<pre>
 *  Käytössäsi on 8 ja 5 litran astia ja Ämpäri (100 l)
 *
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >ä 8[ret]
 *  8 litran astiassa on 8 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 5 litraa
 *  Mistä kaadetaan ja mihin >5 ä[ret]
 *  8 litran astiassa on 3 litraa
 *  5 litran astiassa on 0 litraa
 *  Mistä kaadetaan ja mihin >8 5[ret]
 *  8 litran astiassa on 0 litraa
 *  5 litran astiassa on 3 litraa
 *  Mistä kaadetaan ja mihin >[ret]
 *</pre>
 * @author  Vesa Lappalainen
 * @version 1.0, 09.02.2003
 */
public class AstiaPeli {
    private Astia astiat[];         // Taulukko astioille
    private int astioidenLkm = 3;   // montako astiaa peliin halutaan
    int monesko = 0;                //montako astiaa on lisätty
    String ämpäri = "ä";
    int ämpäriV = 100;
    
    
    /**
     * Astiapelin muodostaja. Luo Astia-taulukon, johon tallennetaan viitteet astioihin. Taulukon ensimmäiseksi
     * tallennetaan viite ämpäriin. Ämpärille viedään parametreina attribuutteina annetut arvot.
     */
    public AstiaPeli() {
        astiat = new Astia[astioidenLkm];
        Astia ampari = new Astia(ämpäri, ämpäriV);
        ampari.tayta();
        astiat[monesko] = ampari;
        monesko++;
    }
    
    /**
     * Lisää peliin astian. Astia tallennetaan taulukkoon. Jos taulukko täynnä, ei tehdä mitään.
     * @param nimi astian nimi
     * @param tilavuus astian tilavuus litroina
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.lisaa_astia("5",5);
     * peli.anna(1).getNimi() ==="5";
     * peli.lisaa_astia("8",8);
     * peli.anna(2).getNimi() ==="8";
     * </pre>
     */
    public void lisaa_astia(String nimi, int tilavuus) {
        if (monesko > astioidenLkm-1) return;   // yksi astia on ämpäri, joten peliin voidaan lisätä astioidenLkm-1 astiaa.
        Astia astia = new Astia(nimi, tilavuus);
        astiat[monesko] = astia;
        monesko++;
    }
    
    
    /**
     * palauttaa viitteen paikassa i olevaan astiaan
     * @param i paikka josta astia halutaan
     * @return viitteen olioon paikassa i
     * @example
     * <pre name="test">
     * AstiaPeli peli = new AstiaPeli();
     * peli.lisaa_astia("5",5);
     * peli.lisaa_astia("9",9);
     * peli.anna(0).getNimi() ==="ä";
     * peli.anna(1).getNimi() ==="5";
     * peli.anna(2).getNimi() ==="9";
     * </pre>
     */
    public Astia anna(int i) {
        return astiat[i];
    }
    
    
    /**
     * etsii taulukosta astiaa
     * @param nimi nimi jolla astiaa etsitään
     * @return astia
     * @example
     * <pre name="test">
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.lisaa_astia("5",5);
     *  peli.lisaa_astia("8",8);
     *  
     *  peli.etsi("ä").getNimi() ==="ä";
     *  peli.etsi("5").getNimi() ==="5";
     *  peli.etsi("8").getNimi() ==="8";
     *  peli.etsi("6").getNimi() === "null"; #THROWS NullPointerException
     * </pre>
     */
    public Astia etsi(String nimi) {
            for (int i = 0; i < astioidenLkm; i++) {
                if (anna(i).getNimi().equalsIgnoreCase(nimi)) return anna(i);
            }  
            return null;
    }
    

    /**
     * Käynnistää astiapelin
     */
    public void pelaa() {
     // Tämän avulla poistetaan desimaalit tulosteesta
        NumberFormat formatter = new DecimalFormat("#0");     
        while (true) {
                
            // Tulostaa tämänhetkisen tilanteen. HUOM! oletuksena että ämpärien nimet ilmaisevat tilavuutta. esim 5l ämpäri nimetään "5".
            for (int i = astioidenLkm-1; i > 0; i--) {
                System.out.println(anna(i).getNimi() +" litran astiassa on " + formatter.format(anna(i).getMaara()) +
                                    " litraa"); 
            }
        
            // Kysytään käyttäjän syöte
            String s = Syotto.kysy("Mistä kaadetaan ja mihin");
            if (s == "") break;                                 // Jos tyhjä niin lopetetaan
            StringBuilder mistaMihin = new StringBuilder(s);
            String mista = Mjonot.erota(mistaMihin, ' ', "");   // Erotetaan mistä kaadetaan
            String mihin = mistaMihin.toString();               // Erotetaan mihin kaadetaan
            Astia mistaIndeksi = this.etsi(mista);              // etsii astian, mistä kaadetaan
            Astia mihinIndeksi = this.etsi(mihin);              // etsii astian, mihin kaadetaan
     
            if (mistaIndeksi == null || mihinIndeksi == null) 
                System.out.println("Syötit astian, jota ei ole olemassa");      // Jos ei löydetä syötetty ämpäriä
            else
                mistaIndeksi.kaada(mihinIndeksi);                               // Tehdään kaato astioiden välillä
        }
    }
    
    /**
     * Tulostaa ohjeen
     * @example
     * <pre name="test">
     *  Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     *  AstiaPeli peli = new AstiaPeli();
     *  peli.lisaa_astia("5",5);
     *  peli.lisaa_astia("8",8);
     *  peli.tulosta_ohje();
     *  so.ero("Käytössäsi on 5.0 sekä 8.0 litran astiat ja Ämpari (100.0 l)\n") === null;
     *  so.palauta();
     * </pre>
     */
    public void tulosta_ohje() {
        if ( astiat.length <= 0 ) return;
        String ja = "";
        System.out.print("Käytössäsi on ");
        for (int i = 1; i < astioidenLkm; i++) {
            System.out.print(ja + anna(i).getTilavuus());
            ja = " sekä ";
        }
        System.out.println(" litran astiat ja Ämpari (" +
                anna(0).getTilavuus() + " l)");
}
       
  

    /**
     * Testaan astioita
     * @param args ei käytössä
     */
    public static void main(String[] args) {


            AstiaPeli peli = new AstiaPeli();
            peli.lisaa_astia("5",5);
            peli.lisaa_astia("8",8);
            peli.tulosta_ohje();
            peli.pelaa();

        }
}

