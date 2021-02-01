package demo.d4.fx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import demo.d4.Ika;

/**
 * @author Henri
 * @version 1.2.2021
 *
 */
public class IkaGUIController {
    @FXML
    private TextField textVuosiluku;

    @FXML
    private TextField textPaljonkoTayttaa;

    @FXML
    void kerroIka() {
        laskeIka();
    }

   
    
    //===================================================================
    
    
    private void laskeIka() {
        try {
            int syntymaVuosi = Integer.parseInt(textVuosiluku.getText());
            int paljonkoTayttaa = Ika.paljonkoTayttaa(syntymaVuosi);
            if (paljonkoTayttaa < 0) textPaljonkoTayttaa.setText("-");
            else textPaljonkoTayttaa.setText(Integer.toString(paljonkoTayttaa));
        } catch (Exception e) {
            textPaljonkoTayttaa.setText("-"); 
        }
       
    }
}