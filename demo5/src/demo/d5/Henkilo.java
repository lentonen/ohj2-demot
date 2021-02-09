package demo.d5;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author Henri
 * @version Feb 4, 2021
 *
 */
public class Henkilo {
    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;
    
    /**
     * Henkilo-olion muodostaja.
     * @param etunimi etunimi
     * @param sukunimi sukunimi
     * @param syntymavuosi syntymäaika
     */
    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi= syntymavuosi;
    }
    
    
    /**
     * Henkilo-olion muodostaja, jolle tuodaan yksi merkkijono.
     * @param merkkijono merkkijono, josta haetaan tieto olion muodostamista varten.
     */
    public Henkilo(String merkkijono) {
        parse(merkkijono);
    }
    
    
    /**
     * Henkilo-olion oletusmuodostaja. Jos parametreina ei anneta mitään, asetetaan etunimi ja sukunimi
     * tyhjiksi merkkijonoiksi. Syntymävuosi asetetaan 0.
     */
    public Henkilo() {
        this.etunimi = "";
        this.sukunimi = "";
        this.syntymavuosi=0;
    }
    
    
    
    
    /** 
     * Palautetaan henkilön nimi
     * @return palauttaa nimen muodossa "Etunimi Sukunimi"
     * @example
     * <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.getNimi() === "Aku Ankka";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.getNimi() === "Pele";
     * </pre>
     */
    public String getNimi() {
        return (etunimi + " " +sukunimi).trim();
    }
    
    
    /** Palauttaa henkilön syntymävuoden
     * @return henkilön syntymävuosi
     * @example
     * <pre name="test">
     * Henkilo aku = new Henkilo("Aku","Ankka",1934);
     * aku.getSyntymavuosi() === 1934;
     * </pre>
     */
    public int getSyntymavuosi() {
        return syntymavuosi;
    }
    
    /**
     * tiedot | erotetussa muodossa
     * @example
     *  <pre name="test">
     *   Henkilo aku = new Henkilo("Aku","Ankka",1934);
     *   aku.toString() === "Aku|Ankka|1934";
     *   Henkilo pele = new Henkilo("Pele","",1940);
     *   pele.toString() === "Pele||1940";
     * </pre>
     */
    @Override
    public String toString() {
        return etunimi +"|" +sukunimi +"|" +syntymavuosi;
    }
    
    
    /**
     * Tulostetaan henkilön tiedot paramterina tuotuun tietovirtaan
     * @param os tietovirta johon tiedot tulostetaan
     * @example
     * <pre name="test">
     * #import java.io.*;
     * ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
     * Henkilo hlo = new Henkilo("Aku","Ankka",1934);
     * hlo.tulosta(byteoutput);
     * byteoutput.toString() =R= "Aku Ankka 1934\\s*"
     * </pre>
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        out.println(etunimi + " " + sukunimi + " " + syntymavuosi);
    }
    
    
    /**
     * @param tolppajono syöte josta tietoja haetaan
     */
    public void parse(String tolppajono) {
        StringBuilder merkkijono = new StringBuilder(tolppajono);
        this.etunimi = Mjonot.erota(merkkijono, '|', "!");
        this.sukunimi = Mjonot.erota(merkkijono, '|', "!");
        this.syntymavuosi = Mjonot.erotaInt(merkkijono, syntymavuosi);
    }

    
    /**
     * Testataan henkilöluokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo hlo = new Henkilo();
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(hlo);
        hlo.parse("Sepe|Susi|1933");
        hlo.tulosta(System.out);
        aku.tulosta(System.out);
        Henkilo mikki = new Henkilo("Mikki|Hiiri");
        System.out.println(mikki);
    }
}