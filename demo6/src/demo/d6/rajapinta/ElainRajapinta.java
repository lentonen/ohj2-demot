/**
 * 
 */
package demo.d6.rajapinta;

/**
 * @author Henri
 * @version Feb 15, 2021
 *
 */
public interface ElainRajapinta {
    
    /**
     * Metodi joka tulostaa eläimen ääntelyn
     */
    public void aantele();
    
    
    /**
     * eläin merkkijonoksi
     * @return palauttaa eläimen merkkijonona "Nimi " +"paino"
     */
    @Override
    public String toString();

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    }

}
