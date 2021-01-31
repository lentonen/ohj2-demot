package demo.d3;

/**
 * @author Henri
 * @version Jan 27, 2021
 *
 */
public class Jokerimerkki
{

    // BYCODEBEGIN

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args)
    {
        if ( onkoSamatKysymysmerkilla("Kissa","K?ss?") )
            System.out.println("On samat");
        //TODO: kirjoita lisää testejä tähän
    }

    /**
     * @param jono s
     * @param maski s
     * @return s
     * @example
     * <pre name="test">
     * onkoSamatKysymysmerkilla("kissa", "kissa") === true;
     * onkoSamatKysymysmerkilla("kissa", "koira") === false;
     * onkoSamatKysymysmerkilla("kissa", "kiss") === false;
     * onkoSamatKysymysmerkilla("kis", "kissa") === false;
     * onkoSamatKysymysmerkilla("kissa", "kiss?") === true;
     * onkoSamatKysymysmerkilla("kissa", "?issa") === true;
     * onkoSamatKysymysmerkilla("kissa", "ki?sa") === true;
     * onkoSamatKysymysmerkilla("", "") === true;
     * onkoSamatKysymysmerkilla("oke", "???") === true;
     * </pre>
     */ 
    public static boolean onkoSamatKysymysmerkilla(String jono, String maski)
    {
        if (jono.length() != maski.length()) return false;
        
        int viimeisenIndeksi = jono.length()-1;
        for (int i = 0; i <= viimeisenIndeksi; i++)
            if (jono.charAt(i) != maski.charAt(i) && maski.charAt(i) != '?') return false;
        return true;
    }
    // BYCODEEND
}


