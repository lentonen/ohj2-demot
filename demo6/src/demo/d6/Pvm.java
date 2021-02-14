package demo.d6;

//import demo.d3.Pvm;

/**
 * Tutkitaan olioiden luomista
 * @author Henri
 * @version Jan 27, 2021
 *
 */
public class Pvm {
    
    private int p = 0;
    private int k = 0;
    private int v = 0;
    
    
    /**
     * Muodostaja, jolle annetaan päivä, kuukausi ja vuosi. Jos syötetään laiton päivämäärä, niin ei anneta
     * tehdä. Tällöin päivämääräksi jää 0.0.0.
     * @param p monesko päivä
     * @param k monesko kuukausi
     * @param v vuosiluku
     * @example
     * <pre name="test">
     * Pvm pv1 = new Pvm (15, 3, 2015);
     * pv1.toString() === "15.3.2015";
     * 
     * Pvm pv2 = new Pvm (45, 3, 2015);
     * pv2.toString() === "0.0.0";
     * </pre>
     */
    public Pvm(int p, int k, int v) {
        alusta(p, k, v);
    }
    
    
    /**
     * Muodostaja, jolle annetaan päivä ja kuukausi. Vuosiluvuksi tulee 0.
     * @param p monesko päivä
     * @param k monesko kuukausi
     */
    public Pvm(int p, int k) {
        this.p = p;
        this.k = k;
    }
    
    
    /**
     * @return saantimetodi, joka palauttaa vuoden
     */
    public int getVuosi() {
        return v;
    }
    
    
    /**
     * @return saantimetodi, joka palauttaa kuukauden
     */
    public int getKuukausi() {
        return k;
    }
    
    
    /**
     * @return saantimetodi, joka palauttaa päivän
     */
    public int getPaiva() {
        return p;
    }
    
    
    @Override
    public String toString() {
        return this.p +"." +this.k +"." + this.v;
    }
    
    
    /**
    * Palautetaan tieto, onko tutkittava vuosi karkausvuosi vai ei
    * @param vv tutkittava vuosi
    * @return 1 jos on karkausvuosi ja 0 jos ei ole
    * @example
    * <pre name="test">
    *   karkausvuosi(1900) === 0
    *   karkausvuosi(1900) === 0
    *   karkausvuosi(1901) === 0
    *   karkausvuosi(1996) === 1
    *   karkausvuosi(2000) === 1
    *   karkausvuosi(2001) === 0
    *   karkausvuosi(2004) === 1
    * </pre>
    */
   public static int karkausvuosi(int vv) {
       if ( vv % 400 == 0 ) return 1;
       if ( vv % 100 == 0 ) return 0;
       if ( vv % 4 == 0 ) return 1;
       return 0;
   }
   
   
   /**
 * @param pp uusi päivämäärä
 * @param kk uusi kuukausi
 * @param vv uusi vuosi
 * @example
 * <pre name="test">
 * Pvm pvm = new Pvm(15, 3, 2015);
 * pvm.toString() === "15.3.2015";
 * 
 * pvm.alusta(16, 4, 2016);
 * pvm.toString() === "16.4.2016";
 * 
 * pvm.alusta(17, 5, 20150);
 * pvm.toString() === "17.5.20150";
 * 
 * pvm.alusta(0, 0, 2003);
 * pvm.toString() === "17.5.2003";
 * 
 * pvm.alusta(29, 2, 2020);
 * pvm.toString() === "29.2.2020";
 * 
 * pvm.alusta(0, 0, 2021);
 * pvm.toString() === "29.2.2020";
 * 
 * pvm.alusta(28, 0, 2021);
 * pvm.toString() === "28.2.2021";
 * 
 * pvm.alusta(31,3,2021);
 * pvm.toString() === "31.3.2021";
 * 
 * pvm.alusta(0,4,2021);
 * pvm.toString() === "31.3.2021";
 * 
 * </pre>
 */
public void alusta(int pp, int kk, int vv) {
    // Jos pp tai kk on laiton, niin lopetetaan.   
    if (pp > 31 || kk > 13 || kk < 0) return;  
    
    // Taulukko karkausvuoden huomioimista varten
    int[][] kkPituudet ={ 
            // 1  2   3   4   5   6   7   8   9   10  11  12    0-rivi normaalivuosi, 1-rivi karkausvuosi
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }};
    
    // pvm tai kuukausi ei muuteta, tarkistetaan, että uusi vv ei aiheuta laitonta tilannetta
    if (pp == 0 && kk == 0) {
        if (this.k > 12 || this.p > kkPituudet[karkausvuosi(vv)][this.k-1]) return;  
        this.v=vv;
        return;
    }
    
    // pvm ei muutu, tarkistetaan että uusi kk ja vv eivät aiheuta laitonta tilannetta
    if (pp == 0 && (kk > 12 || this.p > kkPituudet[karkausvuosi(vv)][kk-1])) return;

    // kuukausi ei muutu, tarkistetaan että uusi vv ja pp eivät aiheuta laitonta tilannetta
    if (kk == 0 ) {
        if (this.k > 12 || pp > kkPituudet[karkausvuosi(vv)][this.k-1]) {           
            return;
        }
    }
    
    // tarkistetaan että uudet arvot eivät aiheuta laitonta tilannetta.
    else if (kk > 12 || pp > kkPituudet[karkausvuosi(vv)][kk-1]) return;
    
    // Tarkistusten jälkeen laitetaan uudet arvot paikalleen, jos ei ole syötetty 0. 
    if (pp != 0) this.p=pp;
    if (kk != 0) this.k=kk;
    if (vv != 0) this.v=vv;
    }
    

    /**
     * @param pv1 ensimmäinen päivämäärä
     * @param pv2 toinen päivämäärä
     * @return -1 jos pv1 on ennen, 0 jos samoja, 1 jos pv1 on jälkeen
     * @example
     * <pre name="test">
     * Pvm pv1 = new Pvm(15,3,2015);
     * Pvm pv2 = new Pvm(15,3,2015);
     * compareTo(pv1, pv2) === 0;
     * 
     * pv2.alusta(16,0,0);
     * compareTo(pv1, pv2) === -1;
     * 
     * pv1.alusta(17,0,0);
     * compareTo(pv1, pv2) === 1;
     * 
     * </pre>
     */
    public static int compareTo (Pvm pv1, Pvm pv2) {
        if (pv1.getVuosi() < pv2.getVuosi()) return -1;
        if (pv1.getKuukausi() < pv2.getKuukausi()) return -1;
        if (pv1.getPaiva() < pv2.getPaiva()) return -1;
        if (pv1.getPaiva() > pv2.getPaiva()) return 1;
        return 0;
        
    }
    
    
    /**
     * Vertaa oliota itseään parametrina tuotuun päivämäärään
     * @param pv2 päivämäärä johon itseä verrataan
     * @return -1 jos olio itse on ennen, 0 jos samoja, 1 jos olio itse on jälkeen
     * @example
     * <pre name="test">
     * Pvm pv1 = new Pvm(15,3,2015);
     * Pvm pv2 = new Pvm(15,3,2015);
     * pv1.compareTo(pv2) === 0;
     * 
     * pv2.alusta(16,0,0);
     * pv1.compareTo(pv2) === -1;
     * 
     * pv1.alusta(17,0,0);
     * pv1.compareTo(pv2) === 1;
     * </pre>
     */
    public int compareTo(Pvm pv2) {
        if (this.v < pv2.getVuosi()) return -1;
        if (this.k < pv2.getKuukausi()) return -1;
        if (this.p < pv2.getPaiva()) return -1;
        if (this.p > pv2.getPaiva()) return 1;
        return 0;
    }

    
    /**
     * Vertaa oliota itseään parametrina tuotuun päivämäärä-olioon
     * @param pv2 päivämäärä johon olio itseään vertaa
     * @return true jos samoja, false jos erit
     * @example
     * <pre name="test">
     * Pvm pv1 = new Pvm(15,3,2015);
     * Pvm pv2 = new Pvm(15,3,2015);
     * pv1.equals(pv2) === true;
     * 
     * pv2.alusta(16,0,0);
     * pv1.equals(pv2) === false;
     * 
     * pv1.alusta(17,0,0);
     * pv1.equals(pv2) === false;
     * </pre>
     */
    public boolean equals(Pvm pv2) {
        if (compareTo(pv2) == 0) return true;
        return false;
    }
    
    
    /**
     * Pääohjelma Pvm-olioiden testaukselle
     * @param args ei käytetä   
     */
    public static void main(String[] args) {

        /*Pvm pvm = new Pvm(21, 1, 2015);
        System.out.println(pvm);
        
        pvm.alusta(29, 2, 2015);
        System.out.println(pvm);
        
        pvm.alusta(0, 2, 2015);
        System.out.println(pvm);
        
        pvm.alusta(0,0,2013);
        System.out.println(pvm);
        
        pvm.alusta(0, 13, 2014);
        System.out.println(pvm);
        
        Pvm pvm2 = new Pvm(29, 2, 2009);
        System.out.println(pvm2);
        */
        Pvm pv1 = new Pvm(1,2),pv2 = new Pvm(3,3);
        if ( compareTo(pv1,pv2) < 0 ) System.out.println(pv1 + " < " + pv2);
        if ( pv1.compareTo(pv2) != 0 ) System.out.println(pv1 + " != " + pv2);
        pv1.alusta(3, 3, 0);
        if ( pv1.equals(pv2) ) System.out.println(pv1 + " == " + pv2);

    }
}
