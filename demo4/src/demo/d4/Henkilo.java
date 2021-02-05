package demo.d4;

/**
 * @author Henri
 * @version Feb 4, 2021
 *
 */
public class Henkilo {
    private String enimi;
    private String snimi;
    private int syntVuosi;
    
    /**
     * Henkilo-olion konstruktori.
     * @param enimi etunimi
     * @param snimi sukunimi
     * @param syntVuosi syntymäaika
     */
    public Henkilo(String enimi, String snimi, int syntVuosi) {
        this.enimi = enimi;
        this.snimi = snimi;
        this.syntVuosi= syntVuosi;
    }
    
    
    /**
     * @return palauttaa nimen muodossa "Etunimi Sukunimi"
     */
    public String getNimi() {
        return enimi + " " +snimi;
    }
    
    
    /**
     * @return henkilön syntymävuosi
     */
    public String getSyntymavuosi() {
        return Integer.toString(syntVuosi);
    }
    
    
    @Override
    public String toString() {
        return enimi +"|" +snimi +"|" +syntVuosi;
    }

    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Henkilo aku = new Henkilo("Aku", "Ankka", 1934);
        System.out.println(aku.getNimi());  // tulostaa Aku Ankka
        System.out.println(aku.getSyntymavuosi());  // tulostaa 1934
        System.out.println(aku.toString()); // tulostaa Aku|Ankka|1934
    }
}