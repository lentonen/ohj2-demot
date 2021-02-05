package demo.d4;

/**
 * @author Henri
 * @version Feb 2, 2021
 *
 */
public class Demo {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int pisteet = 65;
        int maksimi = -1;
        int hyvitys = demohyvitys(pisteet, maksimi);
        System.out.println("Jos olet saanut " +pisteet +" demopistettä (max " +maksimi+"), niin demohyvityksesi on " +hyvitys +".");

    }
    
    
    /**
     * Palauttaa demohyvitykset:
     *     40%  50%  60%  70%  80%  90%
     * dh  1    2    3    4    5    6
     * 
     * @param pisteet tehtyjen demotehtävien pisteet
     * @param maksimi demotehtävien maksimipistemäärä
     * @return hyvityspisteet \n
     *         palauttaa 0, jos maksimipistemääräksi asetettu <=0
     * @example
     * <pre name="test">
     * demohyvitys(-10, 100) === 0;
     * demohyvitys(0, 100) === 0;
     * demohyvitys(100, 0) === 0;
     * demohyvitys(100, -10) === 0;
     * demohyvitys(40, 100) === 1;
     * demohyvitys(49, 100) === 1;
     * demohyvitys(50, 100) === 2;
     * demohyvitys(59, 100) === 2;
     * demohyvitys(60, 100) === 3;
     * demohyvitys(69, 100) === 3;
     * demohyvitys(70, 100) === 4;
     * demohyvitys(79, 100) === 4;
     * demohyvitys(80, 100) === 5;
     * demohyvitys(89, 100) === 5;
     * demohyvitys(90, 100) === 6;
     * demohyvitys(100, 100) === 6;
     * demohyvitys(105, 100) === 6;
     * 
     * </pre>
     */
     public static int demohyvitys(int pisteet, int maksimi){
        if (maksimi == 0) return 0;
        double tehtyjenProsentti = (pisteet*1.0)/(maksimi*1.0)*100;
        if (tehtyjenProsentti < 40) return 0;
        if (tehtyjenProsentti < 50) return 1;
        if (tehtyjenProsentti < 60) return 2;
        if (tehtyjenProsentti < 70) return 3;
        if (tehtyjenProsentti < 80) return 4;
        if (tehtyjenProsentti < 90) return 5;
        return 6;
     }

}
