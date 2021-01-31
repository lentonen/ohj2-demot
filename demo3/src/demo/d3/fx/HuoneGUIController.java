package demo.d3.fx;

import fi.jyu.mit.ohj2.Mjonot;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author Henri
 * @version 27.1.2021
 *
 */
public class HuoneGUIController {
    @FXML private TextField textLeveys;

    @FXML private TextField textPituus;

    @FXML private TextField textKorkeus;

    @FXML private TextField textPintaAla;

    @FXML private TextField textTilavuus;

    @FXML void keyReleased() {
        laskePintaAlaJaTilavuus();
    }





    //==================================================
    
    /** Kerroin cm muuttamiseksi m */
    public static final double CM_M = 100;
    
    /**
     * Haetaan tekstikentästä luku
     * @param text kenttä josta haetaan
     * @param oletus luvun arvo jos kentästä ei saa järkevää lukua
     * @return kentästä haettu luku
     * @example
     * <pre name="test">
     * #TOLERANCE=0.01
     * #import javafx.embed.swing.JFXPanel;
     * #import javafx.scene.control.*;
     * (new JFXPanel()).toString(); 
     * haeLuku(new TextField("234.233"), 44) ~~~ 234.23;
     * haeLuku(new TextField("foobar1"), 44) ~~~ 44.00;
     * haeLuku(new TextField("1foobar"), 44) ~~~ 1.00;
     * </pre>
     */
    public static double haeLuku(TextField text,double oletus) {
        double luku = Mjonot.erotaDouble(text.getText(), oletus);
        return luku;
    }
    
    
    /**
     * Laittaa tekstikenttään tuloksen
     * @param text kenttä johon luku laitetaan
     * @param luku joka laitetaan kenttään
     */
    public static void laitaTulos(TextField text, double luku) {
        String tulos = String.format("%5.2f",luku);
        tulos = tulos.replace(',', '.');
        text.setText(tulos);
    }
    
    
    private void laskePintaAlaJaTilavuus() {
        double leveys_m = haeLuku(textLeveys, 0) / CM_M;
        double pituus_m = haeLuku(textPituus, 0) / CM_M;
        double korkeus_m  = haeLuku(textKorkeus, 0) / CM_M;
        double pa_m = leveys_m * pituus_m;
        double tilavuus_m = leveys_m * pituus_m *korkeus_m;
        laitaTulos(textPintaAla, pa_m);        
        laitaTulos(textTilavuus, tilavuus_m);
        
    }
}