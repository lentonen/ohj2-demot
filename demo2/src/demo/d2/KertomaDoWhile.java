package demo.d2;

/**
 * @author Henri
 * @version Jan 20, 2021
 *
 */
public class KertomaDoWhile
{

    /**
     * @param args ljh
     */
    public static void main(String[] args)
    {
        System.out.printf("Luvun 5 kertoma on: %d\n", kertoma(5));
        System.out.printf("Luvun 10 kertoma on: %d\n", kertoma(10));
    }

    // BYCODEBEGIN
    /**
     * Aliohjelma, joka laskee luvun kertoman
     * @param n luku, jonka kertoma lasketaan
     * @return kertoma
     * @example
     * <pre name="test">
     *  kertoma(3) === 6;
     *  kertoma(5) === 120;
     *  kertoma(0) === 1;
     * </pre>
     */
    public static int kertoma(int n)
    {   
        if (n == 0 ) return 1;  
       
        int kertoma = 1;        
        int kerroin = n;           
        
        do {
           kertoma = kertoma * kerroin;  
           kerroin--;                    
        } while (kerroin != 1);
        
        return kertoma;
    }
    // BYCODEEND
}


