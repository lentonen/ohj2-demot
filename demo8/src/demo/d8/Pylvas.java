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
 * Astian graafinen versio.  Toteutettu tyhmästi
 * kopioimalla astian koodia.
 * 
 * @author  Vesa Lappalainen
 * @version 1.0, 09.02.2003
 * @version 1.1, 19.02.2009
 */
public class Pylvas extends DrawableCollection {
    private double maara;
    private double leveys;
    private double korkeus;

    private static final double suhde  = 0.5;
    private final Polygon ulko;
    private FillPolygon sisa;
    private final RPoint pinta1,pinta2;


    /**
     * Alustaa uuden pylvään tietyn kokoiseksi ja luonnollisesti tyhjäksi.
     * Luodaan pylvään graafinen esitys kahdesta suorakulmiosta.
     * Ulkosuorakulmiosta ja sisäsuorakulmiosta, joka esittää pylväässä
     * olevaa nestemäärää.
     * @param leveys pylvään leveys
     * @param korkeus  pylvään korkeus
     * @param maara nesteen määrä

     */
    public Pylvas(double leveys, double korkeus, double maara) {
        pinta1 = new RPoint(0,0);
        pinta2 = new RPoint(leveys,0);
        ulko = new Polygon(new RPoint[]{
                new RPoint(0,0),
                new RPoint(leveys,0),
                new RPoint(leveys,suhde*korkeus),
                new RPoint(0,suhde*korkeus)
        });
        sisa = new FillPolygon(new RPoint[]{
                new RPoint(0,0),
                new RPoint(leveys,0),
                pinta2,
                pinta1
        });

        sisa.setColor(Color.BLUE);
        add(ulko);
        add(sisa);
        this.leveys = leveys;
        this.korkeus = korkeus; 
        this.maara = maara;
    }


    /**
     * Asettaa pylvään nestemäärän ja tekee vastaavan graafisen muutoksen.
     * @param maara asetettava nestemäärä
     */
    private void setVali(double maara) {
        this.maara = maara;
        pinta1.set(Axis.Y, suhde*maara);
        pinta2.set(Axis.Y, suhde*maara);
        redraw();
    }
    
    
    /**
     * Muuttaa pylvään korkeutta.
     * @param maara Haluttu korkeus
     */
    private void setKorkeus(double korkeus) {
        double skaalaus = korkeus / this.korkeus;
        this.ulko.scale(1, skaalaus, 1);
        //redraw();
    }
    
    
    /**
     * Muuttaa pylvään väriä
     * @param color väri joka asetetaan
     */
    private void setValiColor(Color color) {
        this.sisa.setColor(color);
        
    }


    /**
     * Testaan pylväitä
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Pylvas p5 = new Pylvas(1,5,0); 
        Pylvas p8 = new Pylvas(1,8,2);
    
        // muodostajalle pylvään leveys, korkeus ja väritetyn osan määrä
        // väritetyn osan korkeudesta käytetään nimeä väli

        Window window = new Window();
        window.scale(0,0,5,8);
        p8.move(2,0,0);
        p8.setValiColor(Color.RED);

        window.add(p8);
        window.add(p5);
        window.showWindow();

        Syotto.kysy("Lisää 5 pylvään väliä");         p5.setVali(4);
        Syotto.kysy("Pienennä 8 pylvään korkeutta");  p8.setKorkeus(6);
        Syotto.kysy("Lisää 8 pylvään väliä");         p8.setVali(4);

    }



    

}


// BYCODEBEGIN

// BYCODEEND
