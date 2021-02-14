/**
 * 
 */
package demo.d6;

/**
 * @author Henri
 * @version Feb 14, 2021
 *
 */
public class TaulukonKasittely {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        /*ta,he,ma,hu,to,ke,he,el,sy,lo,ma,jo*/
        int kPituudet[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        
        int i = pienimmanPaikka(kPituudet);
        int n = pienin(kPituudet);
        
        System.out.println("paikka " +i +" ja arvo " +n);
    }
    
    
    /**
     * palauttaa taulukon pienimman luvun paikan. Jos pienimpiä lukuja on monta, palautetaan pienin indeksi.
     * @param t taulukko josta pienimmän paikkaa etsitään
     * @return pienimmän luvun indeksi. Palauttaa -1, jos viety taulukko oli tyhjä.
     * @example
     * <pre name="test">
     * 
     * int t[] = {3,2,1,2,3};
     * pienimmanPaikka(t) === 2;
     * 
     * int t2[] = {1,2,3,2,3};
     * pienimmanPaikka(t2) === 0;
     * 
     * int t3[] = {3,2,3,2,1};
     * pienimmanPaikka(t3) === 4;
     * 
     * int t5[] = {3,1,3,2,1};
     * pienimmanPaikka(t5) === 1;
     * </pre>
     */
    public static int pienimmanPaikka(int t[]) {
        int pituus = t.length;
        if (pituus < 0) return -1;
        int pienin = t[0];
        int pienimmanIndeksi = 0;
        for (int i = 1; i< pituus; i++)
            if (t[i] < pienin) {
                pienimmanIndeksi = i;
                pienin = t[i];
            }
        return pienimmanIndeksi;
    }
    
    
    /**
     * palauttaa kokonaislukutaulukon pienimmän alkion
     * @param t taulukko jonka pienin alkio palautetaan
     * @return pienin alkio
     * @example
     * <pre name="test">
     * int t[] = {3,2,1,2,3};
     * pienin(t) === 1;
     * 
     * int t2[] = {-1,2,3,2,3};
     * pienin(t2) === -1;
     * 
     * int t3[] = {3,2,3,2,-100};
     * pienin(t3) === -100;
     * 
     * int t5[] = {3,1,3,2,1};
     * pienin(t5) === 1;
     * </pre>
     */
    public static int pienin(int t[]) {
        return t[pienimmanPaikka(t)];
    }

}
