package malli;

import fi.jyu.mit.ohj2.*;

/**
 * Alustava luokka päivämäärää varten
 * @author Vesa Lappalainen
 * @version 1.0, 07.02.2003
 * @version 1.1, 14.02.2003
 * @version 1.2, 17.02.2003
 * @version 1.3, 11.02.2008
 */
public class Pvm implements Comparable<Object> {
    /*
     * #CLASSIMPORT
     * @example
     * <pre name="testJAVA">
     *  private static final String s22_2     = "22.2.2012",
     *                              s23_2     = "23.2.2012";
     *  private final Pvm    tammi2012 = new Pvm(1,1),
     *                       helmi2012 = new Pvm(1),
     *                       tanaan    = new Pvm(),
     *                       maalis97  = new Pvm(1,3,97),
     *                       p22_2     = new Pvm(s22_2),
     *                       p23_2     = new Pvm(s23_2);
     * </pre>
     */

    /** Päivän arvo */
    private int pv;
    /** Kuukauden arvo */
    private int kk;
    /** Vuoden arvo */
    private int vv;


    /**
     *  Muuttaa päivämäärän nykypäivälle.
     *  Todo: pitää vaihtaa hakemaan päivämäärä oikeasti. 
     *  Mutta perinnässäkään ei nyt saa käyttää enempää attribuutteja kuin tässä on
     */
    public void paivays() { 
        pv = 20; 
        kk = 2;  
        vv = 2012;  
    } 


    /**
     * Alustetaan päivämäärä. 0-arvot eivät muuta vastaavaa attribuuttia  
     * @param ipv päivän alustus
     * @param ikk kuukauden alustus
     * @param ivv vuoden alustus
     * @return true jos alustus onnistuu
     * @example
     * <pre name="test">
     *   Pvm pvm = new Pvm(20,2,2012);
     *   pvm.alusta(1,3,0)     === true;  pvm.toString() === "1.3.2012";
     *   pvm.alusta(2,13,2012) === false; pvm.toString() === "1.3.2012";
     *   pvm.alusta(28,2,2012) === true;  pvm.toString() === "28.2.2012";
     *   pvm.alusta(29,2,2011) === false; pvm.toString() === "28.2.2012";
     *   pvm.alusta(29,2,2012) === true;  pvm.toString() === "29.2.2012";
     *   pvm.alusta(31,3,2012) === true;  pvm.toString() === "31.3.2012";
     *   pvm.alusta(31,4,2012) === false; pvm.toString() === "31.3.2012";
     *   pvm.alusta( 0,2,2012) === false; pvm.toString() === "31.3.2012";
     * </pre>
     */
    public boolean alusta(int ipv, int ikk, int ivv) {
        int p = this.pv;
        int k = this.kk;
        int v = this.vv;
        if ( ivv > 0 ) v = ivv;
        if ( v < 50 ) v += 2000;
        if ( v < 100 ) v += 1900;
        if ( ikk > 0 ) k = ikk;
        if ( ipv > 0 ) p = ipv;

        if ( k > 12 ) return false;
        int kv = demo.d2.LisaaPvm.karkausvuosi(v);
        int pv_lkm = demo.d2.LisaaPvm.KPITUUDET[kv][k - 1];
        if ( p > pv_lkm ) return false;

        this.pv = p;
        this.kk = k;
        this.vv = v;
        return true;
    }


    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
    }


    /** 
     * Alustetaan kuukausi ja vuosi oletusarvoon.  
     * @param pv päivän alustusarvo, jos huono, käytetään nykypäivää
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
    }


    /**
     * Alustetaan vuosi oletusarvoon. Jos pv tai kk on huonoja,
     * käytetään nykypäiväystä.
     * @param pv päivän alustusarvo 
     * @param kk kuukauden oletusarvo
     */
    public Pvm(int pv, int kk) {
        this(pv, kk, 0);
    }


    /**
     * Alustetaan päivämäärä.  
     * Jos pv tai kk on huonoja, käytetään nykypäiväystä.
     * @param pv päivän alustusarvo
     * @param kk kuukauden oletusarvo
     * @param vv vuoden alustusarvo
     */
    public Pvm(int pv, int kk, int vv) {
        paivays();
        alusta(pv, kk, vv);
    } 


    /**
     * Alustetaan päivämäärä merkkijonosta.  Jos jonon sisältö väärän
     * muotoinen päiväys, käytetään nykypäivää.
     * @param s muotoa 12.3.2008 oleva merkkijono
     * @example
     * <pre name="test">
     *   Pvm pvm1 = new Pvm("12.3.2008"); pvm1.toString() === "12.3.2008";
     *   Pvm pvm2 = new Pvm("12.13.2008"); pvm2.toString() === tanaan.toString();
     *   Pvm pvm3 = new Pvm("32.1.2008");  pvm3.toString() === tanaan.toString();
     * </pre>
     */
    public Pvm(String s) {
        paivays();
        pvmParse(s);
    } 


    /**
     * Päivämäärä merkkijonona
     * @return päivämäärä muodossa 17.2.2007
     * @example
     * <pre name="test">
     *   tammi2012.toString() === "1.1.2012"
     *   helmi2012.toString() === "1.2.2012"
     *   tanaan.toString()    === "20.2.2012"
     *   maalis97.toString()  === "1.3.1997"
     *   p23_2.toString()     === s23_2
     * </pre>
     */
    @Override
    public String toString() {
        return pv + "." + kk + "." + vv;
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param sb tutkittava merkkijono
     */
    protected final void pvmParse(StringBuilder sb) {
        int p = Mjonot.erota(sb, '.', 0);
        int k = Mjonot.erota(sb, '.', 0);
        int v = Mjonot.erota(sb, ' ', 0);
        alusta(p, k, v);
        // tai alusta(Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0),Mjonot.erota(sb,'.',0));
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param s tutkittava merkkijono
     */
    protected final void pvmParse(String s) {
        pvmParse(new StringBuilder(s));
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * @param s tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * pvm.parse("12"); pvm.toString() === "12.3.2003";
     * pvm.parse("..2001"); pvm.toString() === "12.3.2001";
     * pvm.parse("..2009 14:30"); pvm.toString() === "12.3.2009"; 
     * </pre>
     */
    public void parse(String s) {
        pvmParse(s);
    }


    /**
     * Ottaa päivämäärän tiedot merkkijonosta joka on muotoa 17.2.2007
     * Jos joku osa puuttuu, sille käytetään tämän päivän arvoa oletuksena.
     * Merkkijonosta otetaan pois vain se osa, jota tarvitaan.
     * @param sb tutkittava merkkijono
     * 
     * @example
     * <pre name="test">
     * Pvm pvm = new Pvm(11,3,2003);
     * StringBuilder jono = new StringBuilder("12");
     * pvm.parse(jono); pvm.toString() === "12.3.2003"; jono.toString() === "";
     * jono = new StringBuilder("..2001");
     * pvm.parse(jono); pvm.toString() === "12.3.2001"; jono.toString() === "";
     * jono = new StringBuilder("..2009 14:30");
     * pvm.parse(jono); pvm.toString() === "12.3.2009"; jono.toString() === "14:30";
     * </pre>
     */
    public void parse(StringBuilder sb) {
        pvmParse(sb);
    }


    // Lisätty saantimetodit:

    /**
     * @return päivän arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("22.2.2010");
     *   pv.getPv() === 22;
     * </pre>
     */
    public int getPv() {
        return pv;
    }


    /**
     * @return kuukauden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("22.2.2010");
     *   pv.getKk() === 2;
     * </pre>
     */
    public int getKk() {
        return kk;
    }


    /**
     * @return vuoden arvo
     * @example
     * <pre name="test">
     *   Pvm pv = new Pvm("22.2.2010");
     *   pv.getVv() === 2010;
     * </pre>
     */
    public int getVv() {
        return vv;
    }


    /**
     * Verrataan päivämäärää olioon obj.  Jos o ei ole päivämäärä tai merkkijono
     * heiteään poikkeus.
     * @param obj olio johon verrataan, jonka toivotaan olevan Pv,2 tyyppiä.
     * @return -1 jos <  0 jos == ja 1 jos > kuin verrattava obj.
     * @throws ClassCastException jos luokka väärää tyyppiä
     * @example
     * <pre name="test">
     *   Pvm pvm = new Pvm(12,3,2012);
     *   pvm.compareTo(new Double(2)) === 0; #THROWS ClassCastException
     *   pvm.compareTo("12.3.2012") === 0; 
     *   pvm.compareTo(new StringBuilder("12.3.2012")) === 0;
     *   pvm.compareTo(new StringBuffer("12.3.2012")) === 0;
     *   pvm.compareTo(tanaan) === 1; 
     * </pre>
     */
    @Override
    public int compareTo(Object obj) {
        Pvm pvm = null;
        if ( obj instanceof String )
            pvm = new Pvm((String)obj);
        else if ( obj instanceof StringBuilder )
            pvm = new Pvm(((StringBuilder)obj).toString());
        else if ( obj instanceof StringBuffer )
            pvm = new Pvm(((StringBuffer)obj).toString());
        else if ( !(obj instanceof Pvm) ) throw new ClassCastException();
        if ( pvm == null ) pvm = (Pvm)obj;
        return compareTo(pvm);
    }


    /**
     * Verrataan miten kaksi päivämäärää suhtautuu toisiinsa.
     * @param pvm2 toinen verrattava
     * @return -1 jos  < pvm2, 0 jos yhtäsuuret ja 1 jos  > pvm2
     * 
     * @example
     * <pre name="test">
     *  maalis97.compareTo(tammi2012) === -1;  // ero vuodessa
     *  tammi2012.compareTo(maalis97) ===  1;
     *  tammi2012.compareTo(tanaan)   === -1;    // ero kuukaudessa
     *  tanaan.compareTo(tammi2012)   ===  1;
     *  helmi2012.compareTo(tanaan)   === -1;    // ero päivässä
     *  tanaan.compareTo(helmi2012)   ===  1;
     *  tanaan.compareTo(tanaan)      ===  0;
     * </pre>
     */
    public int compareTo(Pvm pvm2) {
        if ( getVv() < pvm2.getVv() ) return -1;
        if ( getVv() > pvm2.getVv() ) return 1;
        if ( getKk() < pvm2.getKk() ) return -1;
        if ( getKk() > pvm2.getKk() ) return 1;
        if ( getPv() < pvm2.getPv() ) return -1;
        if ( getPv() > pvm2.getPv() ) return 1;
        return 0;
        //  return compareTo(this,pvm2);       // Olisi helpoin jos on staattinen metodi
        //  return hashCode()-pvm2.hashCode(); // ei palauta -1,0,1 mutta <0, 0, >0
    }


    /**
     * Verrataan miten kaksi päivämäärää suhtautuu toisiinsa.
     * @param pvm1 ensimmäinen verratava
     * @param pvm2 toinen verrattava
     * @return -1 jos pvm1 < pvm2, 0 jos yhtäsuuret ja 1 jos pvm1 > pvm2
     * 
     * @example
     * <pre name="test">
     * #STATICIMPORT
     *  compareTo(maalis97,tammi2012) === -1;  // ero vuodessa
     *  compareTo(tammi2012,maalis97) === 1;
     *  compareTo(tammi2012,tanaan)   === -1;    // ero kuukaudessa
     *  compareTo(tanaan,tammi2012)   === 1;
     *  compareTo(helmi2012,tanaan)   === -1;    // ero päivässä
     *  compareTo(tanaan,helmi2012)   === 1;
     *  compareTo(tanaan,tanaan)      === 0;
     * </pre>
     * @example
     * <pre name="test">
     * #STATICIMPORT
     *  Pvm pv1 = new Pvm(15,6,2013);
     *  Pvm pv2 = new Pvm(14,5,2014);
     *  Pvm pv3 = new Pvm(15,7,2014);
     *  Pvm pv4 = new Pvm(16,7,2014);
     *  Pvm pv5 = new Pvm(16,7,2014);
     *  Pvm pv6 = new Pvm(16,7,2012);
     *  compareTo(pv1,pv2) === -1;  // ero vuodessa
     *  compareTo(pv2,pv1) ===  1;
     *  compareTo(pv2,pv3) === -1;  // ero kuukaudessa
     *  compareTo(pv3,pv2) ===  1;
     *  compareTo(pv3,pv4) === -1;  // ero päivässä
     *  compareTo(pv4,pv3) ===  1;
     *  compareTo(pv4,pv5) ===  0;  // kaikki samoja
     *  compareTo(pv6,pv2) === -1;  // ero kuukaudessa, mutta vuodessa toisinpäin
     *  compareTo(pv2,pv6) ===  1;
     * </pre>
     */
    public static int compareTo(Pvm pvm1, Pvm pvm2) {
        if ( pvm1.getVv() < pvm2.getVv() ) return -1;
        if ( pvm1.getVv() > pvm2.getVv() ) return 1;
        if ( pvm1.getKk() < pvm2.getKk() ) return -1;
        if ( pvm1.getKk() > pvm2.getKk() ) return 1;
        if ( pvm1.getPv() < pvm2.getPv() ) return -1;
        if ( pvm1.getPv() > pvm2.getPv() ) return 1;
        return 0;
        //  return pvm1.compareTo(pvm2);  // Helpoin olisi
    }


    /**
     * Vertaa onko päivämäärä sama kuin toinen objekti.
     * Osaa verrata String ja StringBuilder-luokkiinkin
     * @param obj verrattava objekti
     * @return true jos sisällöltään samat, muuten false
     * @example
     * <pre name="test">
     * maalis97.equals(tammi2012)          === false;
     * tammi2012.equals(maalis97)          === false;
     * tanaan.equals(tanaan)               === true;
     * p23_2.equals(new Pvm("23.2.2012"))  === true;
     * p23_2.equals(p22_2)                 === false;
     * p23_2.equals(s23_2)                 === true;
     * p23_2.equals(s22_2)                 === false;
     * s23_2.equals(p23_2)                 === false; // String ei osaa verrata pvm:ään
     * s23_2.equals(p22_2)                 === false; // String ei osaa verrata pvm:ään
     * s23_2.equals(p23_2.toString())      === true;  // mutta osaa merkkijonoon
     * tanaan.equals(new Double(2))        === false; // pvm ei osaa verrata muihin tyyppeihin
     * p23_2.equals(new StringBuilder("23.2.2012")) === true;
     * p23_2.equals(new StringBuffer("23.2.2012")) === true;
     * p23_2.equals(new StringBuilder("22.2.2012")) === false;
     * p23_2.equals(new StringBuffer("22.2.2012")) === false;
     * </pre>
     */
    @Override
    public boolean equals(Object obj) {
        if ( (obj instanceof String) ||
             (obj instanceof StringBuilder) ||
             (obj instanceof StringBuffer) ||
             (obj instanceof Pvm) ) return compareTo(obj) == 0;
        return false;
    }


    /**
     * @return päivämäärälle järjestysnumero
     * @example
     * <pre name="test">
     *   Pvm pv1 = new Pvm(1,1,2012);
     *   Pvm pv2 = new Pvm(2,1,2012);
     *   pv1.hashCode() === 2012*10000 + 100 + 1; 
     *   pv1.hashCode() === 20120101; 
     *   pv2.hashCode() === pv1.hashCode() + 1;
     *   Pvm pv3 = new Pvm(31,12,2011);
     *   pv3.hashCode() === 20111231; 
     * </pre>
     */
    @Override
    public int hashCode() {
        return 100*100*getVv() + 100*getKk() +  getPv();
    }


    /**
     * Testataan päivämäärä-luokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");
        System.out.println(pvm);
        pvm.parse("15.3");
        System.out.println(pvm);
        pvm.parse("14");
        System.out.println(pvm.getPv());

        Pvm pv1 = new Pvm(1, 2), pv2 = new Pvm(3, 3);
        if ( compareTo(pv1, pv2) < 0 ) System.out.println(pv1 + " < " + pv2);
        if ( pv1.compareTo(pv2) != 0 ) System.out.println(pv1 + " != " + pv2);
    }
}