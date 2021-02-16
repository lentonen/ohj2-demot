/**
 * 
 */
package demo.d6;

import java.awt.Graphics;
import fi.jyu.mit.graphics.BasicShape;
import fi.jyu.mit.graphics.EasyWindow;
import fi.jyu.mit.graphics.Matrix;
import fi.jyu.mit.graphics.RPoint;
import fi.jyu.mit.graphics.SPoint;
import fi.jyu.mit.graphics.Vector;

/**
 * @author Henri
 * @version Feb 15, 2021
 *
 */
public class SaannollinenMonikulmio extends BasicShape {
    private RPoint center;
    private int kulmat;
    private double r;
    private int[] sXPoints;
    private int[] sYPoints;


   /**
    * Luo uuden säännöllisen monikulmion
    * @param x Monikulmion keskipisteen x-koordinaatti
    * @param y Monikulmion keskipisteen y-koordinaatti
    * @param r keskipisteen etäisyys kulmista
    * @param kulmat kulmien määrä
    */
    public SaannollinenMonikulmio(double x, double y, double r, int kulmat) {
        super();
        this.center = new RPoint(x, y);
        this.r = r;
        this.kulmat = kulmat;
        initialize();
    }


   /**
    * Luo uuden säännöllisen monikulmion
    * @param x monikulmion keskipisteen x-koordinaatti
    * @param y monikulmion keskipisteen y-koordinaatti
    * @param z monikulmion keskipisteen z-koordinaatti
    * @param r keskipisteen etäisyys kulmista
    * @param kulmat kulmien määrä
    */
    public SaannollinenMonikulmio(double x, double y, double z, double r, int kulmat) {
        super();
        this.center = new RPoint(x, y, z);
        this.r = r;
        this.kulmat = kulmat;
        initialize();
    }


   /**
    * Alustaa monikulmion asetukset
    */
    private void initialize() {
        this.sXPoints = new int[this.kulmat];
        this.sYPoints = new int[this.kulmat];
    }


    /**
    * Asetetaan monikulmiolle uusi säde
    * @param r uusi säteen arvo
    * @return tämä olio ketjuttamista varten
    */
    public SaannollinenMonikulmio setR(double r) {
        this.r = r;
        redraw();
        return this;
    }


    /**
     * Piirretään monikulmio
     * @see fi.jyu.mit.graphics.BasicShape#drawShape(java.awt.Graphics, fi.jyu.mit.graphics.Matrix)
     */
    @Override
    protected void drawShape(Graphics g, Matrix a) {
        Vector rp = new Vector(); 
        SPoint sp = new SPoint(0, 0);
        for (int i = 0; i < kulmat; i++) {
            a.transform(
                    this.r * Math.cos((2 * Math.PI / kulmat) * i)
                            + this.center.getX(),
                    this.r * Math.sin((2 * Math.PI / kulmat) * i)
                            + this.center.getY(),
                    this.center.getZ(), rp, sp);
            sXPoints[i] = sp.getX();
            sYPoints[i] = sp.getY();
        }
        g.drawPolygon(sXPoints, sYPoints, kulmat);
    }
      
      
    /**
    * @param args ei käytössä
    */
    public static void main(String[] args) {
        EasyWindow window = new EasyWindow();
        window.add(new SaannollinenMonikulmio( 50, 50,30,3));
        window.add(new SaannollinenMonikulmio(150, 50,30,4));
        window.add(new SaannollinenMonikulmio( 50,150,30,5));
        window.add(new SaannollinenMonikulmio(150,150,30,6));
        window.showWindow();
    }
 }