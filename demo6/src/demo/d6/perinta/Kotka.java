package demo.d6.perinta;

/**
 * @author Henri
 * @version Feb 15, 2021
 *
 */
public class Kotka extends Elain {
    
    /**
     * Alustetaan kotkan tiedot
     * @param nimi koiran nimi
     * @param paino koiran paino
     */
    public Kotka(String nimi, double paino) {
        super(nimi, paino);
    }
    
    
    /**
     * Ääntelee kuin kotka
     */
    @Override
    public void aantele() {
        System.out.println("krääk krääk");
    }

}
