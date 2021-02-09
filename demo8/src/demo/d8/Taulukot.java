package demo.d8;

/**
 * @author Henri
 * @version Feb 5, 2021
 *
 */
public class Taulukot {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        double suurin = matriisinSuurin(mat);
        System.out.println(suurin);
    }

    /**
     * @param matriisi matriisi josta suurinta etsitään
     * @return suurin arvo, palautetaan double_min_value jos on syötetty tyhjä matriisi.
     * @example
     * <pre name="test">
     *  double mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
     *  matriisinSuurin(mat) ~~~ 8;
     *  double mat2[][] = { { 1, 2, 3, 4 }, {10, 6, 7, 8 }};
     *  matriisinSuurin(mat2) ~~~ 10;
     *  double mat3[][] = { { 1, 2, 3, 11 }, {10, 6, 7, 8 }};
     *  matriisinSuurin(mat3) ~~~ 11;
     *  double mat4[][] = { { 12, 2, 3, 11 }, {10, 6, 7, 8 }};
     *  matriisinSuurin(mat4) ~~~ 12;
     *  double mat5[][] = { {}, {}};
     *  matriisinSuurin(mat5) ~~~ Double.MIN_VALUE;
     * </pre>
     */
    public static double matriisinSuurin(double[][] matriisi) {
        double suurin = Double.MIN_VALUE;
        for (double[] rivi : matriisi)
            for (double luku : rivi)
                if (luku > suurin) suurin = luku;
        return suurin;
    }

    }


