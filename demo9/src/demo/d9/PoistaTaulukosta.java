package demo.d9;

/**
 * @author Henri
 * @version Mar 12, 2021
 *
 */
public class PoistaTaulukosta {

    /**
     * poistaa taulukosta luvun n-esiintymät
     * @param t taulukko josta poistetaan
     * @param lkm taulukon alkioiden lukumäärä
     * @param poistettava luku joka poistetaan
     * @return taulukon alkioiden lukumäärä
     * @example
     * <pre name="test">
     *  int t[] = { 4, 7, 6, 3, 6, 2 };
     *  int lkm = 6;
     *  merkkijonoksi(t, lkm) ==="4 7 6 3 6 2";
     *  lkm = poista(t, lkm, 6);
     *  lkm === 4
     *  merkkijonoksi(t, lkm) ==="4 7 3 2";
     *  
     *  int t2[] = { 6, 4, 7, 6, 3, 6, 2 };
     *  int lkm2 = 7;
     *  merkkijonoksi(t2, lkm2) ==="6 4 7 6 3 6 2";
     *  lkm2 = poista(t2, lkm2, 6);
     *  lkm2 === 4
     *  merkkijonoksi(t2, lkm2) ==="4 7 3 2";
     *  
     *  int t3[] = { 6, 4, 7, 6, 3, 6, 2, 6 };
     *  int lkm3 = 8;
     *  merkkijonoksi(t3, lkm3) ==="6 4 7 6 3 6 2 6";
     *  lkm3 = poista(t3, lkm3, 6);
     *  lkm3 === 4
     *  merkkijonoksi(t3, lkm3) ==="4 7 3 2";
     *  
     *  int t4[]={4,7,9,3,9,2};
     *  int lkm4 = 6;
     *  lkm4 = poista(t4, lkm4, 9) === 4;
     *  merkkijonoksi(t4, lkm4) ==="4 7 3 2";
     *  lkm4 = poista(t4, lkm4, 2) === 3; 
     *  merkkijonoksi(t4, lkm4) ==="4 7 3";
     *  lkm4 = poista(t4, lkm4,4)  === 2;
     *  merkkijonoksi(t4, lkm4) ==="7 3";
     * </pre>
     */
    public static int poista(int[] t, int lkm, int poistettava) {
        int pituus = lkm;
        int uusiPituus = 0;
        int i = 0;
        int j = 1;
        while (j < pituus ) {
            int tmp;
            int tutkittava = t[i];
            int seuraavaHyvaNro = t[j];
            if (tutkittava == poistettava) {
                if (seuraavaHyvaNro == poistettava) j++;
                else {
                    tmp = tutkittava;
                    t[i] = seuraavaHyvaNro;
                    t[j] = tmp;
                    uusiPituus++;
                    i++;
                    j++;
                } 
            }
            else {i++; j++; uusiPituus++;}
        }
        return uusiPituus;
    }

    
    /**
     * palauttaa taulukon merkkijonona
     * @param t taulukko joka muutetaan merkkijonoksi
     * @param lkm montako taulukon alkiota muutetaan merkkijonoksi
     * @return taulukko merkkijonona
     */
    public static String merkkijonoksi(int[] t, int lkm) {
        int tlkm = lkm;
        StringBuilder tuloste = new StringBuilder("");
        if (tlkm > t.length) tlkm = t.length;
        for (int i = 0; i < tlkm; i++) {
            tuloste.append(Integer.toString(t[i]) + " ");
        }
        int viimeinenValiLyonti = tuloste.lastIndexOf(" ");
        tuloste.delete(viimeinenValiLyonti, viimeinenValiLyonti + 1);  // Poistaa viimeisen välilyönnin
        return tuloste.toString();
    }
    
    /**
     * Tulostetaan taulukosta lkm kappaletta lukuja ja palautetaan tuloste
     * @param t   käsiteltävä taulukko
     * @param lkm käsitelteltävien alkioiden lkm
     */
    public static void tulosta(int t[], int lkm) {
        int tlkm = lkm;
        if (tlkm > t.length) tlkm = t.length;
        for (int i = 0; i < tlkm; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    /**
     * Pääohjelma poiston testaamista varten
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int t[] = { 6, 4, 7, 6, 3, 6, 2, 6 };
        int lkm = 7;
        tulosta(t, lkm);
        
        
        lkm = poista(t, lkm, 6); /* => t = {4,7,3,2}, lkm = 4 */
        tulosta(t, lkm);
        System.out.println(lkm);
    }

   
}