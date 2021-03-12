/**
 * 
 */
package demo.d9;

/**
 * @author Henri
 * @version Mar 10, 2021
 *
 */
public class Pnouseva {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        System.out.println(pisinNouseva("abajiuxc"));
        System.out.println(pisinNouseva("kissa"));
        System.out.println(pisinNouseva("abcdefg"));
        System.out.println(pisinNouseva("dcba"));
        System.out.println(pisinNouseva("ab"));
        System.out.println(pisinNouseva("a"));
        System.out.println(pisinNouseva(""));
    
    }

    /**
     * laskee pisimmän nousevan osajonon pituuden
     * @param jono merkkijono josta pisintä nousevaa osajonoa etsitään
     * @return pisimmän nousevan pituus
     * @example
     * <pre name="test">
     * pisinNouseva("abc") === 3;
     * pisinNouseva("cab") === 2;
     * pisinNouseva("cba") === 1;
     * pisinNouseva("cbaaaa") === 4;
     * pisinNouseva("abcababcd") === 4;
     * pisinNouseva("") === 0;
     * pisinNouseva("ijkabcdeab") === 5;
     * </pre>
     */
    public static int pisinNouseva(String jono) {
        if (jono.length() == 0) return 0;
        int tutkittava = 1;
        int pisinJono = 1;
        int i = 1;
        int pituus = jono.length();
        while (i < pituus) {
            if (jono.charAt(i) >= jono.charAt(i-1)) tutkittava++;
            else tutkittava = 1;
            if (tutkittava > pisinJono) pisinJono = tutkittava;
            i++;
        }
        return pisinJono;        
    }
}
