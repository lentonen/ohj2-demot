package sample;

import java.awt.Color;
import fi.jyu.mit.graphics.*;

/**
 * Piirretään ukkoja jotka liikkuvat ja pyörivät.
 * @author vesal
 */
public class UkkoSample {

    /**
     * Ukko-luokka josta saadaa viite toiseen käteen
     * @author vesal
     */
    public static class Ukko extends DrawableCollection {
        private final Drawable oikeaKasi;
        private final Drawable vasenKasi;
        private final Drawable vasenJalka;
        private final Drawable oikeaJalka;


        /**
         * Alustetaan ukko haluttuun paikkaa
         * @param dx ukon pään keskipiste
         * @param dy ukon pään keskipiste
         */
        public Ukko(double dx, double dy) {
            super();
            move(dx, dy, 0.0);
            add(new Circle(0, 0, 20));
            add(new Line(0, 0, 0, 100)).move(0, 20, 0);
            oikeaKasi = add(new Line(0, 0, 0, 90)).move(0, 30, 0).rotate(Axis.Z, 30);
            vasenKasi = add(new Line(0, 0, 0, 90)).move(0, 30, 0).rotate(Axis.Z, -130);
            oikeaJalka = add(new Line(0, 0, 0, 100)).move(0, 120, 0).rotate(Axis.Z, 25);
            vasenJalka = add(new Line(0, 0, 0, 100)).move(0, 120, 0).rotate(Axis.Z, -25);
        }


        /**
         * Alustetaan ukko haluttuun paikkaan ja kokoon
         * @param dx ukon pään keskipiste
         * @param dy ukon pään keskipiste
         * @param s  ukon skaalauskerroin
         * @param deg ukon kiertokulma Z-akselin suhteen
         * @param color ukon väri
         */
        public Ukko(double dx, double dy, double s, double deg, Color color) {
            this(dx, dy);
            if (s != 1) scale(s, s, s);
            if (deg != 0) rotate(Axis.Z, deg);
            if (color != null) setColor(color);
        }


        /**
         * @return palautetaan viite ukon oikeaan käteen
         */
        public Drawable getoikeaKasi() {
            return oikeaKasi;
        }
        
        /**
         * @return palautetaan viite ukon vasempaan käteen
         */
        public Drawable getvasenKasi() {
            return vasenKasi;
        }


        /**
         * @return palautetaan viite ukon toiseen jalkaan
         */
        public Drawable getvasenJalka() {
            return vasenJalka;
        }
        
        
        /**
         * @return palautetaan viite ukon toiseen jalkaan
         */
        public Drawable getoikeaJalka() {
            return oikeaJalka;
        }

    }


    /**
     * @param args ei käytössä
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Window window = new Window();
        window.add(new Ukko(60, 60));
        Ukko pukko = new Ukko(160, 60, 0.5, 0, Color.RED);
        window.add(pukko);
        Drawable oukko = window.add(new Ukko(260, 60, 0.3, 0, Color.ORANGE));
        window.showWindow();
        Ukko ukko = new Ukko(260, 180, 0.3, 0, null);
        window.add(ukko);

        //new Rotator(ukko, Axis.Z, 3, 50);
        new Rotator(ukko.getoikeaKasi(), Axis.Z, 5, 25);
        new Rotator(ukko.getvasenKasi(), Axis.Z, -5, 25);
        new Rotator(ukko.getvasenJalka(), Axis.Z, -5, 25);
        new Rotator(ukko.getoikeaJalka(), Axis.Z, 5, 25);

        new Mover(oukko, 2, 3, 0, 300);
        new Rotator(oukko, Axis.Y, 10, 230);

        // window.scale(0.5,2, 1);

        // Esimerkki ukon siirtamisesta hiiren kohdalle.
        new MouseFollower(window.getPanel(), pukko, 0, 0, 0, true);

        // window.getPanel().setBackground(Color.CYAN);
        window.setTitle("Ukot heiluu");
    }

}