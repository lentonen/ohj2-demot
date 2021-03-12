/**
 * 
 */
package demo.d9;


/**
 * Int luokka, jolla voidaan luoda muutettavia kokonaisluvun tallentavia olioita.
 */
public class Int {
    int arvo;

    
    /**
     * parametriton muodostaja
     */
    public Int() {
        // arvo alustetaan oletuksena nollaksi.
    }
    
    
    /**
     * luodaan Int-olio jolle annetaan tallennettava kokonaisluku.
     * @param a arvo, jolla olio alustetaan.
     */
    public Int(int a) {
        arvo = a;
    }
    
    
    /**
     * set-metodi Int-olion arvolle
     * @param a asetettava arvo
     * @example
     * <pre name="test">
     * Int luku = new Int(5);
     * luku.intValue() === 5;
     * luku.set(6);
     * luku.intValue() === 6;
     * </pre>
     */
    public void set(int a) {
        arvo = a;
    }
    
    
    /**
     * palauttaa Int-olion arvon kokonaislukuna
     * @return Int-olion arvo kokonaislukuna
     * @example
     * <pre name="test">
     * Int luku = new Int(5);
     * luku.intValue() === 5;
     * Int luku2 = new Int(-5);
     * luku2.intValue() === -5;
     * Int luku3 = new Int();
     * luku3.intValue() === 0;
     * </pre> 
     */
    public int intValue() {
        return arvo;
    }
    
    
    /**
     * Muutetaan Int-olio merkkijonoksi
     * @example
     * <pre name="test">
     * Int luku = new Int(5);
     * luku.toString() === "5";
     * Int luku3 = new Int();
     * luku3.toString() === "0";
     * </pre>
     */
    @Override
    public String toString() {
        return Integer.toString(arvo);
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        //
    
    }
}
