package demo.d6;

import fi.jyu.mit.ohj2.Mjonot;

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
    
    
    /** Alustetaan kaikki attribuutit oletusarvoon */
    public Pvm() {
        this(0, 0, 0);
    }
    
    
    /** 
     * Alustetaan kuukausi ja vuosi oletusarvoon.  
     * @param pv päivän alustusarvo, jos huono, käytetään nykypäivää
     */
    public Pvm(int pv) {
        this(pv, 0, 0);
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
   * Tarkistaa onko syötetty pvm laiton
   * @param pp päivä
   * @param kk kuukausi
   * @param vv vuosi
   * @return true jos päivä on laiton, false jos ei
   */
   public static boolean onkoLaitonPvm(int pp, int kk, int vv) {
       // Taulukko karkausvuoden huomioimista varten
       int[][] kkPituudet ={ 
               // 1  2   3   4   5   6   7   8   9   10  11  12    0-rivi normaalivuosi, 1-rivi karkausvuosi
               { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
               { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }};
       
       if (kk > 12 || pp > kkPituudet[karkausvuosi(vv)][kk-1]) return true;
       return false;
   }
   
   
   /**
   * @param kk uusi kuukausi
   * @param pp uusi päivämäärä
   * @param vv uusi vuosi
   * @example
   * <pre name="test">
   * Pvm pvm = new Pvm(20,2,2012);
   *   pvm.alusta(1,3,0);     pvm.toString() === "1.3.2012";
   *   pvm.alusta(2,13,2012); pvm.toString() === "1.3.2012";
   *   pvm.alusta(28,2,2012); pvm.toString() === "28.2.2012";
   *   pvm.alusta(29,2,2011); pvm.toString() === "28.2.2012";
   *   pvm.alusta(29,2,2012); pvm.toString() === "29.2.2012";
   *   pvm.alusta(31,3,2012); pvm.toString() === "31.3.2012";
   *   pvm.alusta(31,4,2012); pvm.toString() === "31.3.2012";
   *   pvm.alusta( 0,2,2012); pvm.toString() === "31.3.2012";
   * 
   * </pre>
   */
   public void alusta(int pp, int kk, int vv) {
       // Jos pp tai kk on laiton, niin lopetetaan.   
       if (pp > 31 || kk > 13 || kk < 0) return;  
    
       //Tallennetaan alustamisessa ehdotettu pvm. apumuuttujiin
       int apuP = pp;
       int apuK = kk;
       int apuV = vv;
       if (pp == 0) apuP = this.p;
       if (kk == 0) apuK = this.k;  
       if (vv == 0) apuV = this.v;

    
       //Tarkistetaan onko laiton, jos on niin lopetetaan.
       if (onkoLaitonPvm(apuP, apuK, apuV)) return;
    
       // Alustetaan uusi pvm.
       this.p = apuP;
       this.k = apuK;
       this.v = apuV;
    }


    /**
     * @param pv1 ensimmäinen päivämäärä
     * @param pv2 toinen päivämäärä
     * @return -1 jos pv1 on ennen, 0 jos samoja, 1 jos pv1 on jälkeen
     * @example
     * <pre name="test">
     *  Pvm pv1 = new Pvm(15,6,2013);
     *  Pvm pv2 = new Pvm(14,5,2014);
     *  Pvm pv3 = new Pvm(15,7,2014);
     *  Pvm pv4 = new Pvm(16,7,2014);
     *  Pvm pv5 = new Pvm(16,7,2014);
     *  Pvm pv6 = new Pvm(16,7,2012);
     *  Pvm.compareTo(pv1,pv2) === -1;  // ero vuodessa
     *  Pvm.compareTo(pv2,pv1) ===  1;
     *  Pvm.compareTo(pv2,pv3) === -1;  // ero kuukaudessa
     *  Pvm.compareTo(pv3,pv2) ===  1;
     *  Pvm.compareTo(pv3,pv4) === -1;  // ero päivässä
     *  Pvm.compareTo(pv4,pv3) ===  1;
     *  Pvm.compareTo(pv4,pv5) ===  0;  // kaikki samoja
     *  Pvm.compareTo(pv6,pv2) === -1;  // ero kuukaudessa, mutta vuodessa toisinpäin
     *  Pvm.compareTo(pv2,pv6) ===  1;
     * 
     * </pre>
     */
    public static int compareTo (Pvm pv1, Pvm pv2) {
        if (pv1.getVuosi() < pv2.getVuosi()) return -1;
        if (pv1.getVuosi() > pv2.getVuosi()) return 1;
        
        
        if (pv1.getKuukausi() < pv2.getKuukausi()) return -1;
        if (pv1.getKuukausi() > pv2.getKuukausi()) return  1;
        
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
     *  Pvm pv1 = new Pvm(15,6,2013);
     *  Pvm pv2 = new Pvm(14,5,2014);
     *  Pvm pv3 = new Pvm(15,7,2014);
     *  Pvm pv4 = new Pvm(16,7,2014);
     *  Pvm pv5 = new Pvm(16,7,2014);
     *  Pvm pv6 = new Pvm(16,7,2012);
     *  pv1.compareTo(pv2) === -1;  // ero vuodessa
     *  pv2.compareTo(pv1) ===  1;
     *  pv2.compareTo(pv3) === -1;  // ero kuukaudessa
     *  pv3.compareTo(pv2) ===  1;
     *  pv3.compareTo(pv4) === -1;  // ero päivässä
     *  pv4.compareTo(pv3) ===  1;
     *  pv4.compareTo(pv5) ===  0;  // kaikki samoja
     *  pv6.compareTo(pv2) === -1;  // ero kuukaudessa, mutta vuodessa toisinpäin
     *  pv2.compareTo(pv6) ===  1;
     * </pre>
     */
    public int compareTo(Pvm pv2) {
        if (this.v < pv2.getVuosi()) return -1;
        if (this.v > pv2.getVuosi()) return 1;
        
        if (this.k < pv2.getKuukausi()) return -1;
        if (this.k > pv2.getKuukausi()) return 1;
        
        if (this.p < pv2.getPaiva()) return -1; 
        if (this.p > pv2.getPaiva()) return 1;
        
        return 0;
    }

    
    /**
     * Vertaa oliota itseään parametrina tuotuun päivämäärä-olioon
     * @param o päivämäärä johon olio itseään vertaa
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
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Pvm))
            return false;
        Pvm pv2 = (Pvm) o;
        if (compareTo(pv2) == 0) return true;
        return false;
    }
    
    
    @Override
    public int hashCode() {
        return super.hashCode();
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
        
        
        StringBuilder mj = new StringBuilder("1,6,2015");
        int pv = Mjonot.erota(mj, ',', 0);
        int kk = Mjonot.erota(mj, ',', 0);
        int vv = Mjonot.erota(mj, ',', 0);
        System.out.println(pv);
        System.out.println(kk);
        System.out.println(vv);

    }
}
