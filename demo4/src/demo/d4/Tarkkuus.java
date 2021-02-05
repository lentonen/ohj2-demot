package demo.d4;

/**
 * @author Henri
 * @version Feb 2, 2021
 *
 */
public class Tarkkuus {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    
    /**
     * @param x verrattava luku
     * @param eps virheraja, eps aina >= 0
     * @return -1, jos x < -eps \n
     *          0, jos -eps <= x <= eps \n
     *          1, jos x > eps
     *  @example
     * <pre name="test">
     * etumerkki(0,0)  ~~~ 0;
     * etumerkki(1,0)  ~~~ 1;
     * etumerkki(-1,0) ~~~ -1;
     * etumerkki(0.2, 0.5) ~~~ 0;
     * etumerkki(-0.2, 0.5) ~~~ 0;
     * etumerkki(0.0, 0.5) ~~~ 0;
     * etumerkki(-0.5, 0.5) ~~~ 0;
     * etumerkki(0.5, 0.5) ~~~ 0;
     * etumerkki(0.51, 0.5) ~~~ 1;
     * etumerkki(-0.51, 0.5) ~~~ -1;
     * </pre>
     */
    public static int etumerkki(double x, double eps) {
        if (x < -eps) return -1;
        if (x >  eps) return 1;
        return 0;
    }

}
