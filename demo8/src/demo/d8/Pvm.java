/**
 * 
 */
package demo.d8;
import java.time.LocalDateTime;


/**
 * @author Henri
 * @version Feb 24, 2021
 *
 */
public class Pvm extends malli.Pvm {
 // #import java.util.Calendar;
    
    /** Muodostaja kun tuodaan pv, kk ja vv
     * @param pv päivä
     * @param kk kuukausi
     * @param vv vuosi
     * @example
     * <pre name="test">
     * Pvm testi = new Pvm(1, 2, 1995);
     * testi.getPv() === 1;
     * testi.getKk() === 2;
     * testi.getVv() === 1995;
     * </pre>
     */
    public Pvm(int pv, int kk, int vv) {
        super(pv, kk, vv);
    }
    
    
    /**
     * Muodostaja kun tuodaan pv ja kk. Vuosi tämän hetkisen ovm mukaan
     * @param pv päivä
     * @param kk kuukausi
     * @example
     * <pre name="test">
     * Calendar nyt = Calendar.getInstance();
     * int vv = nyt.get(Calendar.YEAR);
     * Pvm pvm = new Pvm(2, 3);
     * 
     * pvm.getPv() === 2;
     * pvm.getKk() === 3;
     * pvm.getVv() === vv;
     * 
     * </pre>
     */
    public Pvm(int pv, int kk) {
        super(pv, kk, annaVv());
    }
    
    
    /**
     * Muodostaja kun tuodaan pv. Kk ja vuosi tämän hetkisen pvm mukaan. 
     * @param pv päivä
     * @example
     * <pre name="test">
     * Calendar nyt = Calendar.getInstance();
     * int kk = nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1;
     * int vv = nyt.get(Calendar.YEAR);
     * Pvm pvm = new Pvm(2);
     * 
     * pvm.getPv() === 2;
     * pvm.getKk() === kk;
     * pvm.getVv() === vv;
     * </pre>
     */
    public Pvm(int pv) {
        super(pv, annaKk(), annaVv());
    }
    
    
    /**
     *  Alustetaan kaikki attribuutit tämän hetkisen pvm mukaan 
     *  @example
     * <pre name="test">
     *   Calendar nyt = Calendar.getInstance();
     *   int pv = nyt.get(Calendar.DATE);
     *   int kk = nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1;
     *   int vv = nyt.get(Calendar.YEAR);
     *   
     *   Pvm pvm = new Pvm();
     *   pvm.getPv() === pv;
     *   pvm.getKk() === kk;
     *   pvm.getVv() === vv;
     * </pre>
     */
    public Pvm() {
        super(annaPv(), annaKk(), annaVv());
    }

    
    /**
     * Alustetaan päivämäärä merkkijonosta
     * @param s muotoa 12.3.2008 oleva merkkijono
     * @example
     * <pre name="test">
     *   Calendar nyt = Calendar.getInstance();
     *   int pv = nyt.get(Calendar.DATE);
     *   int kk = nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1;
     *   int vv = nyt.get(Calendar.YEAR);
     *   Pvm pvm;
     *
     *   pvm = new Pvm($alustus); pvm.toString() === $toString;
     *
     *   | $alustus  |   $toString
     * -----------------------------------------------
     *   | 1, 1      |  "1.1."+vv
     *   | 1         |  1+"."+kk+"."+vv
     *   |           |  pv+"."+kk+"."+vv
     *   | 1, 3, 97  |  "1.3.1997"
     *   | "1.5"     |  "1.5."+vv
     *   | "1..1990" |  "1."+kk+".1990"
     *   | "..1990"  |  pv+"."+kk+".1990"
     * </pre>
     *
     */
    public Pvm(String s) {
        super(annaPv(), annaKk(), annaVv());   
        this.pvmParse(s);
    }
    
    
    /**
     * palauttaa tämän hetkisen kalenrikuukauden päivän
     * @return kalenterikuukauden päivä
     */
    public static int annaPv() {
        LocalDateTime aika = LocalDateTime.now();
        return aika.getDayOfMonth();
    }
    
    
    /**
     * palauttaa tämän hetkisen kalenrikuukauden
     * @return kalenterikuukauden numero
     */
    public static int annaKk() {
        LocalDateTime aika = LocalDateTime.now();
        return aika.getMonthValue();
    }
    
    
    /**
     * palauttaa tämän hetkisen vuoden
     * @return meneillään oleva vuosi
     */
    public static int annaVv() {
        LocalDateTime aika = LocalDateTime.now();
        return aika.getYear();
    }


    
    
    /**
     * Asettaa tämän hetkisen pv, kk ja vv.
     * @example
     * <pre name="test">
     *   Calendar nyt = Calendar.getInstance();
     *   int pv = nyt.get(Calendar.DATE);
     *   int kk = nyt.get(Calendar.MONTH) - Calendar.JANUARY + 1;
     *   int vv = nyt.get(Calendar.YEAR);
     *   Pvm pvm = new Pvm();
     *   pvm.paivays();
     *   
     *   pvm.getPv() === pv;
     *   pvm.getKk() === kk;
     *   pvm.getVv() === vv;
     * </pre>
     */
    @Override
    public void paivays() {
        this.alusta(annaPv(), annaKk(), annaVv());
    }
    

    /**
     * Testataan Pvm-luokkaa
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pvm tammi2016 = new Pvm(1, 1), maalis97 = new Pvm(1, 3, 97), tanaan = new Pvm();

        System.out.println(tammi2016 + " " + maalis97 + " " + tanaan);

        Pvm pvm = new Pvm();

        pvm.parse("12.1.1995");
        System.out.println(pvm);
        pvm.parse("15.2");
        System.out.println(pvm);
        pvm.parse("14");
        System.out.println(pvm);
        pvm.paivays();
        System.out.println(pvm);
        Pvm pv1 = new Pvm(1, 2), pv2 = new Pvm(3, 3);
        if ( compareTo(pv1, pv2) < 0 ) System.out.println(pv1 + " < " + pv2);
        if ( pv1.compareTo(pv2) != 0 ) System.out.println(pv1 + " != " + pv2); 
    }

}
