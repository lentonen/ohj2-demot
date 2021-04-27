package demo.d11;

import demo.d11.FunktionMinimi.FunktioRR;
import demo.d11.FunktionMinimi.*;
import fi.jyu.mit.graphics.EasyWindow;
import fi.jyu.mit.ohj2.Mjonot;
import fi.jyu.mit.ohj2.Syotto;

/**
 * Ohjelmalla funktioita näyttöön, jossa koordinaatisto.
 */
public class PiirtoKunnolla {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        double x1=-5,x2=5,dx=0.01,y1,y2; String s;
        FunktioRR f = new SinFun();             // Tähän voidaan vaihtaa funktio

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
     * Piirtää funktion näytölle annetulla tarkkuudella annetulle välille x1-x2
     * @param f piirrettävä funktio
     * @param x1 alkupiste
     * @param x2 loppupiste
     * @param y1 minimiarvo
     * @param y2 maksimiarvo
     * @param dx piirtotarkkuus
     */
    public static void piirra(FunktioRR f, double x1, double x2, double y1, double y2, double dx) {
        EasyWindow ikkuna = new EasyWindow(1200, 900);
        ikkuna.scale(x1-1,y1-1,x2+1,y2+1);
        double alkuPiste = x1;
        while (alkuPiste < x2) {
            double loppuPiste = alkuPiste + dx;
            ikkuna.addLine(alkuPiste, f.f(alkuPiste), loppuPiste, f.f(loppuPiste));
            alkuPiste += dx; 
        }
        if (x2-x1 > 1)
            ikkuna.addAxis(Math.round(Math.max(x2,x1)*2), Math.round(Math.max(Math.abs(y2),Math.abs(y1))*2) ,0);  // Kikkailut skaalaavat akseleita hieman tarkasteluvälin mukaan. Ei toimi vielä näillä optimaalisesti kaikissa tilanteissa.
        else
            ikkuna.addAxis((x2-x1),(y2-y1)*2.5, 0);  // Tämä mahdollistaa akselin piirtämisen todella pienellä tarkasteluvälillä. 
                                                     // Ei skaalaa akseleita kuitenkaan välttämättä kovinkaan järkevästi vielä. 
                                                     // Akselit eivät myöskään seuraa, jos tarkasteluväli on vaikkapa x-akselilla välillä 5-10.
                                                     // Nyt akselit piirretty origon kautta.
    }
}
