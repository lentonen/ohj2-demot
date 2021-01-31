package demo.d2;

/**
 * @author Henri
 * @version Jan 20, 2021
 *
 */
public class transitiivisuus {

    /**
     * @param args ei käytetä
     */
    public static void main(String[] args) {
        String a1 = new String("eka");
        String a2 = new String("toka");
        String a3 = new String("eka");
        
        a1.equals(a2);
        a2.equals(a3);
        a1.equals(a3);
        

    }

}
