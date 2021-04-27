package demo.d10;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.*;
/**
 * Esimerkki linkitetystä listasta.
 * Kun täydennät, ota @SuppressWarnings("unused") rivit pois
 * @author Vesa Lappalainen
 * @version 1.0, 15.03.2003
 */
@SuppressWarnings("unused")
public class Koulu {

  /**
   * Luokan yksi oppilas
   */
  public static class Oppilas {
    private final String nimi;
    private final double keskiarvo;
    private Oppilas seuraava;

    /**
     * Alustetaan oppilaan tiedot
     * @param nimi      oppilaan nimi
     * @param keskiarvo oppilaan keskiarvo
     */
    public Oppilas(String nimi, double keskiarvo) {
      this.nimi = nimi; this.keskiarvo = keskiarvo;
    }


    /**
     * Palautetaan oppilaan tiedot merkkijonona
     * @return oppilaan tiedot merkkijonona
     */
    @Override
    public String toString() {
      return Mjonot.fmt(nimi,-22) + " keskiarvo: " + Mjonot.fmt(keskiarvo,5,2);
    }
    
    /**
     * Palauttaa viitteen seuraavaan oppilaaseen
     * @return viite seuraavaan oppilaaseen
     */
    public Oppilas annaSeuraava() {
        return this.seuraava;
    }
  }

  private final String luokka;
  private int oppilaita;
  private Oppilas ensimmainen;
  private Oppilas viimeinen;


  /**
   * Alustetaan luokka
   * @param luokka luokannimi
   */
  public Koulu(String luokka) { this.luokka = luokka; }


  /**
   * Lisätään uusi oppilas
   * @param oppilas lisättävä oppilas
   * @example
   * <pre name="test">
   * #import java.io.ByteArrayOutputStream;
   * #CLASSIMPORT
   *  ByteArrayOutputStream bs  = new ByteArrayOutputStream();
   *  String alku =  "%n%nLuokka: 1b oppilaita: %d%n" +
   *                 "==========================================%n";
   *  String loppu = "==========================================%n";
   *  String t = "";
   *
   *  Koulu luokka = new Koulu("1b");
   *
   *  luokka.lisaa(new Koulu.Oppilas($nimi,$ka));
   *  luokka.tulosta(bs);
   *  bs.toString() === String.format(alku+($oppilaat)+loppu,$maara); bs.reset();
   *
   *    $nimi       | $ka | $maara | $oppilaat
   *  -------------------------------------------------------------------------------
   *    ---         | --- |   0    | t=""
   *  "Ankka Aku"   | 5.0 |   1    | t+="Ankka Aku              keskiarvo:  5.00%n"
   *  "Ankka Tupu"  | 7.0 |   2    | t+="Ankka Tupu             keskiarvo:  7.00%n"
   *  "Hiiri Mikki" | 9.0 |   3    | t+="Hiiri Mikki            keskiarvo:  9.00%n"
   *
   *
   *  luokka.poistaKaikki();
   *
   *  luokka.lisaa(new Koulu.Oppilas($nimi,$ka));
   *  luokka.tulosta(bs);
   *  bs.toString() === String.format(alku+($oppilaat)+loppu,$maara);  bs.reset();

   *    $nimi       | $ka | $maara | $oppilaat
   *  -------------------------------------------------------------------------------
   *    ---         | --- |   0    | t=""
   *  "Hiiri Mikki" | 9.0 |   1    | t+="Hiiri Mikki            keskiarvo:  9.00%n"
   *
   * Koulu kakkosluokka = new Koulu("2a");
   * kakkosluokka.lisaa(new Koulu.Oppilas("Seppo Siili",7.5));
   * 
   * kakkosluokka.annaEka().toString() ===                      "Seppo Siili            keskiarvo:  7.50";
   * kakkosluokka.oppilasMaara() === 1;
   * kakkosluokka.annaEka().toString() ===                      "Seppo Siili            keskiarvo:  7.50";
   * kakkosluokka.annaVika().toString() ===                     "Seppo Siili            keskiarvo:  7.50";
   * kakkosluokka.lisaa(new Koulu.Oppilas("Keijo Kala",9.5));
   * kakkosluokka.annaEka().annaSeuraava().toString() ===       "Keijo Kala             keskiarvo:  9.50";
   * kakkosluokka.oppilasMaara() === 2;
   * kakkosluokka.annaEka().toString() ===                      "Seppo Siili            keskiarvo:  7.50";
   * kakkosluokka.annaVika().toString() ===                     "Keijo Kala             keskiarvo:  9.50";
   * kakkosluokka.lisaa(new Koulu.Oppilas("Sulo Siiseli",4.5));
   * kakkosluokka.annaEka().annaSeuraava().annaSeuraava().toString() ===       "Sulo Siiseli           keskiarvo:  4.50";
   * kakkosluokka.oppilasMaara() === 3;
   * kakkosluokka.annaEka().toString() ===                                     "Seppo Siili            keskiarvo:  7.50";
   * kakkosluokka.annaVika().toString() ===                                    "Sulo Siiseli           keskiarvo:  4.50";                                     
   * </pre>
   */
    // BYCODEBEGIN
    public void lisaa(Oppilas oppilas) {
        if (this.ensimmainen == null ) 
            this.ensimmainen = oppilas;       
        else
            viimeinen.seuraava = oppilas;
        this.viimeinen = oppilas;
        this.oppilaita++;
    }

    /**
     * Poistaa kaikki oppilaat luokasta
     * @example
     * <pre name="test">
     *  Koulu kolmosluokka = new Koulu("3a");
     *  kolmosluokka.lisaa(new Koulu.Oppilas("Seppo Siili",7.5));
     *  kolmosluokka.lisaa(new Koulu.Oppilas("Keijo Kala",9.5));
     *  kolmosluokka.lisaa(new Koulu.Oppilas("Sulo Siiseli",4.5));
     *  kolmosluokka.oppilasMaara() === 3;
     *  kolmosluokka.poistaKaikki();
     *  kolmosluokka.oppilasMaara() === 0;
     *  kolmosluokka.annaEka() === null;
     *  kolmosluokka.annaVika() === null;
     *  
     * </pre>
     */
    public void poistaKaikki() {
        this.ensimmainen = null;
        this.viimeinen = null;
        this.oppilaita = 0;
    }
    
    
    /**
     * Palauttaa ensimmäisenä olevan oppilaan
     * @return listan ensimmäinen oppilas
     */
    public Oppilas annaEka() {
        return this.ensimmainen;
    }
    
    
    /**
     * Saantimetodi viimeisenä olevalle oppilaalle
     * @return linkitetyn listan viimeisenä oleva oppilas
     */
    public Oppilas annaVika() {
        return this.viimeinen;
    }
    
    
    /**
     * Antaa oppilaiden määrän luokassa
     * @return oppilaiden määrä
     */
    public int oppilasMaara() {
        return this.oppilaita;
    }
    
    // BYCODEEND

  /**
   * Tulostetaan luokan tiedot tietovirtaan.
   * @param os tietovirta, johon tulostetaan
   */
  public void tulosta(OutputStream os)  {
    PrintStream out = new PrintStream(os);
    out.println();
    out.println();
    out.println("Luokka: " + luokka + " oppilaita: " + oppilaita);
    out.println("==========================================");
    Oppilas kohdalla = this.ensimmainen;
    while (kohdalla != null) {
        out.println(kohdalla);
        kohdalla = kohdalla.seuraava;
    }
    out.println("==========================================");
  }

  /**
   * Testataan luokkaa
   * @param args ei käytössä
   */
  public static void main(String[] args)  {
    Koulu luokka = new Koulu("1b");

    luokka.lisaa(new Oppilas("Ankka Aku",5.0));
    luokka.lisaa(new Oppilas("Ankka Tupu",7.0));
    luokka.lisaa(new Oppilas("Hiiri Mikki",9.0));

    luokka.tulosta(System.out);
    luokka.poistaKaikki();
    luokka.tulosta(System.out);
  }
}

