package demo.d8;

import java.awt.Color;
import fi.jyu.mit.graphics.Axis;
import fi.jyu.mit.graphics.DrawableCollection;
import fi.jyu.mit.graphics.FillPolygon;
import fi.jyu.mit.graphics.Polygon;
import fi.jyu.mit.graphics.RPoint;
import fi.jyu.mit.graphics.Window;
import fi.jyu.mit.ohj2.Syotto;

/**
 * Graafinen pylväs, josta alaosa voi olla väritetty.
 * Pylvään ominaisuuksiin kuuluu leveys, korkeus ja
 * vali.  vali on väritetyn osan korkeus.
 * 
 * @author  Vesa Lappalainen
 * @version 1.0, 28.02.2003
 */
public class PylvasMalli extends DrawableCollection {
    private final Polygon ulko;
    private final FillPolygon sisa;
    private final RPoint pVali1, pVali2;
    private final RPoint pYla1, pYla2;


    /**
     * Alustaa pylvään.
     * @param leveys   pylvään leveys
     * @param korkeus  pylvään korkeus
     * @param vali     pylvään väritetyn osan korkeus
     */
    public PylvasMalli(double leveys, double korkeus, double vali) {

        pVali1 = new RPoint(0, 0);
        pVali2 = new RPoint(leveys, 0);
        setVali(vali);

        pYla1 = new RPoint(0, 0);
        pYla2 = new RPoint(leveys, 0);
        setKorkeus(korkeus);

        ulko = new Polygon(new RPoint[] {
                new RPoint(0, 0),
                new RPoint(leveys, 0),
                pYla2,
                pYla1
        });
        sisa = new FillPolygon(new RPoint[] {
                new RPoint(0, 0),
                new RPoint(leveys, 0),
                pVali2,
                pVali1
        });

        sisa.setColor(Color.BLUE);
        add(sisa);
        add(ulko);
    }


    /**
     * Asettaa väritetyn osan korkeuden
     * @param vali väritetyn osan korkeus
     */
    public void setVali(double vali) {
        pVali1.set(Axis.Y, vali);
        pVali2.set(Axis.Y, vali);
        redraw();
    }


    /**
     * @return pylvään leveys
     */
    public double getLeveys() {
        return pYla1.getX();
    }


    /**
     * @return pylvään korkeus
     */
    public double getKorkeus() {
        return pYla1.getY();
    }


    /**
     * @return pylvään väritetyn osan korkeus
     */
    public double getVali() {
        return pVali1.getY();
    }


    /**
     * Asettaa pylvään korkeuden
     * @param korkeus pyvään korkeus
     */
    public void setKorkeus(double korkeus) {
        pYla1.set(Axis.Y, korkeus);
        pYla2.set(Axis.Y, korkeus);
        redraw();
    }


    /**
     * Asetetaan pylvään täytetyn osan väri
     * @param color täytetyn osan väri
     */
    public void setValiColor(Color color) {
        sisa.setColor(color);
    }


    /**
     * Testaan pylväitä
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        PylvasMalli p5 = new PylvasMalli(1, 5, 3);
        PylvasMalli p8 = new PylvasMalli(1, 8, 2);

        Window window = new Window();
        window.scale(0, 0, 5, 8);
        p8.move(2, 0, 0);
        p8.setValiColor(Color.RED);

        window.add(p8);
        window.add(p5);
        window.showWindow();

        Syotto.kysy("Lisää 5 pylvään väliä");
        p5.setVali(4);
        Syotto.kysy("Pienennä 8 pylvään korkeutta");
        p8.setKorkeus(6);

        Syotto.kysy("Lisää 8 pylvään väliä");
        p8.setVali(6);

    }

}