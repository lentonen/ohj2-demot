package demo.d3;

/**
 * Tutkitaan olioiden luomista
 * @author Henri
 * @version Jan 27, 2021
 *
 */
public class Pvm {
    
    private int p;
    private int k;
    private int v;
    
    
    /**
     * Alustetaan päivämäärä-olio
     * @param p monesko päivä
     * @param k monesko kuukausi
     * @param v vuosiluku
     */
    public Pvm(int p, int k, int v) {
        this.p = p;
        this.k = k;
        this.v = v;
    }
    
    
    @Override
    public String toString() {
        int[][] kkPituudet ={ 
            // 1  2   3   4   5   6   7   8   9   10  11  12    0-rivi normaalivuosi, 1-rivi karkausvuosi
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }};
        if (this.k > 12 || this.p > kkPituudet[karkausvuosi(this.v)][k-1]) return "pvm ei ole mahdollinen";
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
     * Luodaan päivämäärä-olioita.
     * @param args ei käytetä   
     */
    public static void main(String[] args) {
        Pvm p1 = new Pvm(32, 1,  2015);
        Pvm p2 = new Pvm(12, 12, 2012);
        Pvm p3 = new Pvm(19, 8,  1990);
        Pvm p4 = new Pvm(29, 2,  1990);
        Pvm p5 = new Pvm(29, 2,  2020);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}
