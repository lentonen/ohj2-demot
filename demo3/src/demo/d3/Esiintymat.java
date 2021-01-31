package demo.d3;


 /**
 * @author Henri
 * @version Jan 29, 2021
 *
 */
public class Esiintymat
 {

    // BYCODEBEGIN
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args)
    {
        String tulos = poistaEsiintymat("Catcat", "at");
        System.out.println(tulos);
    }

    /**
     * @param jono jono josta poistetaan
     * @param poistettava jono jota poistetaan
     * @return jono josa ei esiinny poistettavaa jonoa
     * @example
     * <pre name="test">
     * poistaEsiintymat("Catcat", "at") === "Cc";
     * poistaEsiintymat("Paatti", "at") === "Pi";
     * poistaEsiintymat("Puatit", "at") === "Puit";
     * poistaEsiintymat("atiu", "at") === "iu";
     * poistaEsiintymat("atatiu", "at") === "iu";
     * poistaEsiintymat("kissaisis", "is") === "ksa";
     * </pre>
     */
    public static String poistaEsiintymat(String jono, String poistettava)
    {
        StringBuilder apujono = new StringBuilder(jono);
        String jonoString = apujono.toString();
        int poistettavanPituus = poistettava.length();
        
        while (jonoString.contains(poistettava)) {
            int alkuIndeksi = jonoString.indexOf(poistettava);
            apujono.delete(alkuIndeksi,alkuIndeksi + poistettavanPituus);
            jonoString = apujono.toString();
        }
        return jonoString;
    }

    // BYCODEEND
}


