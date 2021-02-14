/**
 * 
 */
package demo.d6;

/**
 * @author Henri
 * @version Feb 14, 2021
 *
 */
public class Kulkuneuvo {
    private int nopeus;
    private int matkustajat;
    
    
    /**
     * Muodostaja Kulkuneuvolle
     * @param nopeus kulkuneuvon nopeus
     * @param matkustajat kulkuneuvon matkustajat
     */
    public Kulkuneuvo(int nopeus, int matkustajat) {
        this.nopeus = nopeus;
        this.matkustajat = matkustajat;
    }

    
    /**
     * saantimetodi nopeudelle
     * @return kulkuneuvon nopeus
     */
    public int getNopeus() {
        return nopeus;
    }
    
    
    /**
     * saantimetodi matkustajille
     * @return kulkuneuvon nopeus
     */
     public int getMatkustajat() {
        return matkustajat;
     }
    
    
    /**
     * Muuttaa olion merkkijonoksi
     */
    @Override
    public String toString() {
        return "Nopeus " +nopeus +" km/h, matkustajat " +matkustajat; 
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kulkuneuvo kulkuneuvo = new Kulkuneuvo(100, 1000);
        System.out.println(kulkuneuvo.toString());
    
    }

}
