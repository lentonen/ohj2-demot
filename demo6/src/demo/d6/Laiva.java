/**
 * 
 */
package demo.d6;

/**
 * @author Henri
 * @version Feb 14, 2021
 *
 */
public class Laiva extends Kulkuneuvo {
    private boolean loytyyTaxFree;
    
    /**
     * Muodostaja laivalle
     * @param nopeus laivan nopeus
     * @param matkustajat laivan matkustajat
     * @param taxFree löytyykö tax free, true jos löytyy
     */
    public Laiva(int nopeus, int matkustajat, boolean taxFree) {
        super(nopeus, matkustajat);
        loytyyTaxFree = taxFree;
    }
    
    
    /**
     * kertoo onko taxfree myymälä
     * @return palauttaa true jos on, false jos ei ole.
     */
    public boolean getTaxFree() {
        return loytyyTaxFree;
    }

    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Laiva SiljaLine = new Laiva(10, 985, true);
        System.out.println(SiljaLine.toString());
        
        int n = SiljaLine.getMatkustajat();
        System.out.println(Integer.toString(n));
        
        if (SiljaLine.getTaxFree()) System.out.println("Jee tax free löytyy!");
            
    
    }

}
