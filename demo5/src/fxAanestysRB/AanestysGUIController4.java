package fxAanestysRB;


import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Chooser;
import fi.jyu.mit.fxgui.Dialogs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 * Kontrolleri äänestykselle
 * @author vesal
 * @version 4.2.2017
 *
 */
public class AanestysGUIController4 implements Initializable  {
    private int[] tulokset = new int[4];
    
    @FXML private Label labelValittu;
    @FXML private Chooser<String> valinta;

    @FXML void handleAanesta() { aanesta(); }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        valinta.addSelectionListener((e) -> nayta());
        labelValittu.setText("");
    }
    
    
    private void nayta() {
        String s = valinta.getSelectedText();
        if ( s == null ) return;
        labelValittu.setText("Valittu: " + s);
    }


    private void aanesta() {
        String kohde = valinta.getSelectedText();
        int i = valinta.getSelectedIndex();
        tulokset[i]++;
        Dialogs.showMessageDialog("Olet siis: " + kohde +"\n"
                                    +"Tilanne:" +"\n"
                                    +"Tyttö:"  +tulokset[0] +"\n"
                                    +"Poika:"  +tulokset[1] +"\n"
                                    +"Nainen:" +tulokset[2] +"\n"
                                    +"Mies:"         +tulokset[3]
                                            );
    }

}
