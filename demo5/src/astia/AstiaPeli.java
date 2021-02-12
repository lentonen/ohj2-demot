package astia;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import fi.jyu.mit.ohj2.Mjonot;
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

    /**
     * Testaan astioita
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // Tämän avulla poistetaan desimaalit tulosteesta
        NumberFormat formatter = new DecimalFormat("#0");
        
        // Luodaan vaadittavat astiat ja ämpäri, joka täytettään vedellä
        Astia astiat[] = { new Astia("ä", 100), new Astia("5", 5), new Astia("8", 8) };
        Astia ampari = astiat[0];
        ampari.tayta();
        
        // Tuloste alkutilanteesta
        System.out.println("Käytössäsi on 8 ja 5 litran astia ja Ämpäri (100 l)" + "\n");       
            while (true) {
                
                // Tulostaa tämänhetkisen tilanteen
                System.out.println("8 litran astiassa on " + formatter.format(astiat[2].getMaara()) +
                " litraa");
                System.out.println("5 litran astiassa on " + formatter.format(astiat[1].getMaara()) +
                " litraa");
        
                // Kysytään käyttäjän syöte
                String s = Syotto.kysy("Mistä kaadetaan ja mihin");
                if (s == "") break;                                 // Jos tyhjä niin lopetetaan
                StringBuilder mistaMihin = new StringBuilder(s);
                String mista = Mjonot.erota(mistaMihin, ' ', "");   // Erotetaan mistä kaadetaan
                String mihin = mistaMihin.toString();               // Erotetaan mihin kaadetaan
                int mistaIndeksi = -1;                              // Alustetaan indeksi, jota käytetään astialle, mistä kaadetaan
                int mihinIndeksi = -1;                              // Alustetaan indeksi, jota käytetään astialle, mihin kaadetaan 
        
                for (int i=0; i < astiat.length; i++) {
                    if (astiat[i].oletko(mihin))
                        mihinIndeksi = i;                           // Etsii indeksin astialle, mihin kaadetaan
                    if (astiat[i].oletko(mista))
                        mistaIndeksi = i;                           // Etsii indeksin astialle, mistä kaadetaan
                }
                if (mistaIndeksi == -1 || mihinIndeksi == -1) 
                    System.out.println("Syötit astian, jota ei ole olemassa");      // Jos ei löydetä syötetty ämpäriä
                else
                    astiat[mistaIndeksi].kaada(astiat[mihinIndeksi]);               // Tehdään kaato astioiden välillä
            }
        }

}

