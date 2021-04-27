package demo.d11;

import demo.d11.FunktionMinimi.*;
import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;

/**
 * Ohjelmalla piirretään sinin kuvaaja annetuilla tiedoilla.
 * @author Vesa Lappalainen
 * @version 1.0, 21.02.2003
 */
public class Sin {

  /**
 * @param args ei käytössä
 */
public static void main(String[] args)  {
    double x1=-5,x2=5,dx=0.5,y1,y2; String s;
    FunktioRR f = new SinFun();

    System.out.println("Piirrän funktion sin(x)");
    s = Syotto.kysy("Anna väli ja tiheys jolla piirretään",
                    Mjonot.fmt(x1,4,2) + " " + Mjonot.fmt(x2,4,2) + " "
                    +  Mjonot.fmt(dx,4,2));
    StringBuffer sb = new StringBuffer(s);
    x1 = Mjonot.erota(sb,' ',x1);
    x2 = Mjonot.erota(sb,' ',x2);
    dx = Mjonot.erota(sb,' ',dx);

    y1 = FunktionMinimi.funMin(f,x1,x2,(x2-x1)/dx);
    y2 = FunktionMinimi.funMax(f,x1,x2,(x2-x1)/dx);

    piirra(f,x1,x2,y1,y2,dx);

   }

    /**
     * Tulostaa funktion näyttöön halutulla tarkkuudella annetulle välille x1-x2
     * @param f tulostettava funktio
     * @param x1 alkupiste 
     * @param x2 loppupiste 
     * @param y1 minimiarvo
     * @param y2 maksimiarvo
     * @param dx piirtotiheys
     * @example
     * <pre name="test">
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import demo.d11.FunktionMinimi.*;
     * #import demo.d11.FunktionMinimi;
     * #import demo.d11.FunktionMinimi.FunktioRR;
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * double x1=-5,x2=5,dx=0.5,y1,y2;
     * FunktioRR f = new SinFun();
     *  y1 = FunktionMinimi.funMin(f,x1,x2,(x2-x1)/dx);
     *  y2 = FunktionMinimi.funMax(f,x1,x2,(x2-x1)/dx);
     *  
     *  piirra(f,x1,x2,y1,y2,dx);
     *  String tulos =
     * "                                       *\n" +
     * "                                       *\n" +
     * "                                   *\n"     +
     * "                           *\n" +
     * "                 *\n" +
     * "        *\n" +
     * "  *\n" +
     * "*\n" +
     * "   *\n" +
     * "          *\n" +
     * "                    *\n" +
     * "                              *\n" +
     * "                                     *\n" +
     * "                                       *\n" +
     * "                                      *\n" +
     * "                                *\n" +
     * "                       *\n" +
     * "             *\n" +
     * "     *\n" +
     * "*\n" +
     * " *\n";
     * 
     * so.ero(tulos) === null; 
     * so.palauta();
     * </pre>
     */
    public static void piirra(FunktioRR f, double x1, double x2, double y1,
        double y2, double dx) {         
        int piirtoleveys = 40;                          // Tulostusalueen leveys                       
        double pisteet = (int)(x2-x1)/dx +1;            // piirrettävien pisteiden määrä      
        int pisteidenMaara = (int)pisteet;             
        double yValinPituus = (y2-y1)/piirtoleveys;     // Kuinka suuri "hyppäys" yksi välilyönti on funktion arvossa   
        
        for (int i = 0; i < pisteidenMaara; i++) {
            double arvo = f.f(x1+i*dx);  //Funktion arvo tarkastellussa pisteessä
            int valiLyontienMaara = 0;
            double minEtaisyys = Double.MAX_VALUE;
            for (int j = 0; j < piirtoleveys; j++) {    // Lasketaan kuinka monta välilyöntiä tehdään ennen tähteä.
                double etaisyys = Math.abs(arvo - (y1+j*yValinPituus));  // IDEA: ennätystehtailu
                if (etaisyys < minEtaisyys) {                            // verrataan etäisyyttä kaikkiin mahdollisiin arvioihin jotka muodostuvat kun minimiarvoon lisätään hyppäyksiä
                    minEtaisyys = etaisyys;                              // jos etäisyys pienempi kuin edellinen, niin kirjataan ennätys muistiin.
                    valiLyontienMaara = j;                               // Lisäksi kirjataan muistiin indeksi, joka kuvaa välilyöntien määrää
                }
            }
            for (int k = 0; k < valiLyontienMaara; k++) 
                System.out.print(' ');
            System.out.println("*");
                
        }
    }
}