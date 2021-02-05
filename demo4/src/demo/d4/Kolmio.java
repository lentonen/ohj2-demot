package demo.d4;

/**
 * @author Henri
 * @version Feb 2, 2021
 *
 */
public class Kolmio {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double kateetti1 = 3.0;
        double kateetti2 = 4.0;
        double hypotenuusa = hypotenuusa(kateetti1, kateetti2);
        double pintaAla = kolmionAla(kateetti1, kateetti2);
        
        System.out.println("kolmion kateetit olivat " +kateetti1 +" ja " +kateetti2 +".\n"
                +"kolmion pinta-ala on tällöin " +pintaAla +" ja hypotenuusan pituus on " +hypotenuusa +".");

    }
    
    /**
    * @param kateetti1 suorakulmaisen kolmion ensimmäisen kateetin pituus
     * @param kateetti2 suorakulmaisen kolmion toisen kateetin pituus
     * @return kolmion pinta-ala
     * @example
    * <pre name="test">
    * kolmionAla(3.0, 4.0) ~~~ 6;
    * kolmionAla(0.0, 4.0) ~~~ 0;
    * kolmionAla(3.0, 0.0) ~~~ 0;
    * kolmionAla(0.0, 0.0) ~~~ 0;
    * kolmionAla(3.5, 2.0) ~~~ 3.5;
    * </pre>
    */
    public static double kolmionAla(double kateetti1, double kateetti2){
        if (kateetti1 == 0 || kateetti2 == 0) return 0.0;
        return (kateetti1*kateetti2)/2;
    }


    /**
    * @param kateetti1 suorakulmaisen kolmion ensimmäisen kateetin pituus
     * @param kateetti2 suorakulmaisen kolmion toisen kateetin pituus
     * @return hypotenuusan pituus
     * @example
    * <pre name="test">
    * hypotenuusa(3.0, 4.0) ~~~ 5.0;
    * hypotenuusa(0.0, 4.0) ~~~ 0;
    * hypotenuusa(3.0, 0.0) ~~~ 0;
    * hypotenuusa(0.0, 0.0) ~~~ 0;
    * hypotenuusa(5.0, 5.0) ~~~ 7.071067;
    * </pre>
    */
    public static double hypotenuusa(double kateetti1, double kateetti2){
        if (kateetti1 == 0 || kateetti2 == 0) return 0.0;
        return Math.sqrt(kateetti1*kateetti1+kateetti2*kateetti2);
    }
}