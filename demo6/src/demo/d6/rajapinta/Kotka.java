package demo.d6.rajapinta;


/**
 * Koira joka laajentaa eläimen ominaisuudet
 * @author vesal
 * @version 25.1.2011
 * @example
 * <pre name="test">
 *   Kotka kalle = new Kotka("Kalle",13000);
 *   miuku.toString() === "Kalle 13000.0";
 * </pre>
 */
public class Kotka implements ElainRajapinta {
    private String nimi;
    private double paino;

    /**
     * Alustetaan koiran tiedot
     * @param nimi koiran nimi
     * @param paino koiran paino
     */
    public Kotka(String nimi, double paino) {
        this.nimi = nimi;
        this.paino = paino;
    }
    
    
    /**
     * Muuttaa koiran merkkijonoksi
     */
    @Override
    public String toString() {
        return nimi + " " +paino;
    }

    /**
     * Ääntelee kuin kotka
     */
    @Override
    public void aantele() {
        System.out.println("krääk krääk");
    }
}
