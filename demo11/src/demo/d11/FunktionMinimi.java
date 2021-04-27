
package demo.d11;

/**
 * Funktion minimin etsintää
 */
public class FunktionMinimi {

    /**
     * Rajapinta kaikille funktiolle R->R
     */
    public interface FunktioRR {
        /**
         * @param x piste jossa lasketaan
         * @return funktion arvo pisteessä
         */
        public double f(double x);
    }
    
    
    /**
     * Toisen asteen polynomifunktio-olio
     */
    public static class P2 implements FunktioRR {
        private double a;
        private double b;
        private double c;

        
        /**
         * oletusmuodostaja, joka muodostaa x^2
         */
        public P2() {
            a = 1;
        }
        
        
        /**
         * Muodostaja jolle viedään toisen asteen polynomin parametrit
         * @param a x^2 kerroin
         * @param b x kerroin
         * @param c vakiotermi
         */
        public P2(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        
        @Override
        public double f(double x) {
            return a*x*x+b*x+c;
        }   
    }
    
    
    /**
     * Luokka sini-funktiolla
     */
    public static class SinFun implements FunktioRR {
        @Override
        public double f(double x) {
            return Math.sin(x);
        }
    }
    
    
    /**
     * Etsitään funktion arvo pienin arvo välillä x1-x2
     * @param f funktio-olio, jonka minimiä etsitään
     * @param x1 tarkasteluvälin alkupiste
     * @param x2 tarkasteluvälin loppupiste
     * @param tiheys montako tarkastelupistettä funktiolle asetetaan
     * @return likiarvo minimille.
     * @example
     * <pre name="test">
     * #STATICIMPORT
     *  funMin(new P2(0,1,0), -10, 10, 1000) ~~~ -10;        // Testataan että alkupisteessä oleva minimi löytyy
     *  funMin(new P2(1,0,0), -10, 10, 1000) ~~~ 0;          // Testataan että väliltä löytyvä minimi löytyy
     *  funMin(new P2(1,0,1), -10, 10, 1000) ~~~ 1;          // Testataan että minimi muuttuu kun vakiotermin verran
     *  funMin(new P2(-1,0,1), -10, 100, 1000) ~~~ -9999;    // Testataan, että päätepisteessä oleva minimi löytyy
     *  funMin(new SinFun(), -2, 2, 1000) ~~~ -1;            // Testataan jollakin toisentyyppisellä funktiolla
     * </pre>
     */
    public static double funMin(FunktioRR f,double x1, double x2, double tiheys) {
        double min = Double.MAX_VALUE;
        double dx = (x2-x1)/tiheys;
        for (double x = x1; x < x2; x+=dx)
            if (f.f(x) < min) min = f.f(x);
        return min;
    }
    
    
    /**
     * Etsitään funktion arvo suurin arvo välillä x1-x2
     * @param f funktio-olio, jonka maksimia etsitään
     * @param x1 tarkasteluvälin alkupiste
     * @param x2 tarkasteluvälin loppupiste
     * @param tiheys montako tarkastelupistettä funktiolle asetetaan
     * @return likiarvo maksimille.
     * @example
     * <pre name="test">
     * #STATICIMPORT
     *  funMax(new P2(0,-1,0), -10, 10, 1000) ~~~ 10;        // Testataan että alkupisteessä oleva maksimi löytyy
     *  funMax(new P2(-1,0,0), -10, 10, 1000) ~~~ 0;         // Testataan että väliltä löytyvä maksimi löytyy
     *  funMax(new P2(-1,0,1), -10, 10, 1000) ~~~ 1;         // Testataan että maksimi muuttuu vakiotermin verran
     *  funMax(new P2(1,0,1), -10, 100, 1000) ~~~ 10001;     // Testataan, että päätepisteessä oleva maksimi löytyy
     *  funMax(new SinFun(), -2, 2, 1000) ~~~ 1;             // Testataan jollakin toisentyyppisellä funktiolla
     * </pre>
     */
    public static double funMax(FunktioRR f,double x1, double x2, double tiheys) {
        double max = Integer.MIN_VALUE;
        double dx = (x2-x1)/tiheys;
        for (double x = x1; x < x2; x+=dx)
            if (f.f(x) > max) max = f.f(x);
        return max;
    }
    
    
    /**
     * Pääohjelma testaamista varten
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double minArvo = funMin(new FunktioRR() {
            @Override
            public double f(double x) {return x*x+1;}
        },-2,2,1000);
        System.out.println(String.format("%.2f", minArvo));
        
        minArvo = funMin(new P2(1,2,3), -10, 10, 1000);
        System.out.println(String.format("%.2f", minArvo));
    
    }
}
