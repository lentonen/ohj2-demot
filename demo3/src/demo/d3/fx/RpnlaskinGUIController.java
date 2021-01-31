package demo.d3.fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author Henri
 * @version 29.1.2021
 *
 */
public class RpnlaskinGUIController {

    @FXML private TextArea textAreaNaytto;
    
    @FXML private Button buttonEnter;

    @FXML private Button buttonPlus;

    @FXML private Button buttonMiinus;

    @FXML private Button buttonKerto;

    @FXML private Button buttonJako;

    @FXML void laskeErotus() {
        vahennaLuvut();
    }


    @FXML void laskeJako() {
        jaaLuvut();
    }


    @FXML void laskeKerto() {
        kerroLuvut();
    }


    @FXML void laskeSumma() {
        summaaLuvut();
    }

    @FXML void monistaAlin() {
        monistaLuku();
    }
    
  //===================================================================
    
    
    /**
     * @param text textArea josta syote haetaan
     * @return syotteen muutettuna StringBuilderiksi
     */
    private StringBuilder haeSyote(TextArea text) {
        StringBuilder syote = new StringBuilder(text.getText());
        return syote;
    }
    
    
    /**
     * Laittaa tekstikenttään tuloksen
     * @param text kenttä johon luku laitetaan
     * @param luku joka laitetaan kenttään
     */
    public static void laitaTulos(TextArea text, double luku) {
        String tulos = String.format("%5.2f",luku);
        tulos = tulos.replace(',', '.');
        text.setText(tulos);
    }
    
    
    /**
     * @param syote josta alin haetaan
     * @return alimpana olevan luvun
     */
    public static String haeAlinLuku(StringBuilder syote) {
        if (syote.length() == 0) return "0";
        if (syote.indexOf("\n") == -1) return syote.toString();
        StringBuilder varaSyote = new StringBuilder(syote);
        Mjonot.erota(varaSyote, '\n', true);
        return varaSyote.toString();
    }
    
    
    /**
     * Poistaa viimeisellä rivillä olevan luvun
     * @param syote käsiteltävä syöte, jonka viimeinen rivi poistetaan
     */
    private void poistaAlinLuku(StringBuilder syote) {
        syote.delete(syote.lastIndexOf("\n")+1, syote.length());
    }
    
    
    /**
     * Poistaa textArean lopusta viimeisen luvun ja sitä edeltäneen rivinvaihdon. Käytetään kun halutaan
     * tehdä tilaa laskutoimituksen tulostukselle.
     * @param text 
     */
    private void poistaViimeinen(TextArea text) {
        StringBuilder syote = haeSyote(text);
        int poistonAlku = syote.lastIndexOf("\n");
        int poistonLoppu = syote.length(); 
        syote.delete(Math.max(poistonAlku,0), poistonLoppu);
        text.setText(syote.toString());
    }
    
    
    /**
     * Poistaa syötteen loppusta kaikki rivinvaihdot
     * @param syote syöte josta rivinvaihdot poistetaan
     */
    private void poistaRivinvaihdotLopusta(StringBuilder syote) {
        if (syote.length()== 0) return;
        while (syote.lastIndexOf("\n") == syote.length()-1 && syote.length()-1 != -1) {
            syote.delete(syote.length()-1,  syote.length());
            poistaViimeinen(textAreaNaytto);
        }        
    }
    
    
    /**
     * Tekee rpn-laskukoneen jakolaskun kahdelle alimmalle luvulle. Ylempi luku jaetaan alemmalla.
     */
    private void jaaLuvut() {
        StringBuilder syote = haeSyote(textAreaNaytto);
        poistaRivinvaihdotLopusta(syote);        
        double alinLuku = Double.parseDouble(haeAlinLuku(syote));
        poistaAlinLuku(syote);
        poistaRivinvaihdotLopusta(syote);
        double toiseksiAlinLuku = Double.parseDouble(haeAlinLuku(syote));
        double summa = toiseksiAlinLuku / alinLuku;
        poistaViimeinen(textAreaNaytto);
        if (textAreaNaytto.getLength() == 0) textAreaNaytto.appendText(Double.toString(summa));  
        else textAreaNaytto.appendText("\n"+summa);   
        
        
    }
    
    
    /**
     * Tekee kertolaskun rpn-laskimen kahdelle alimmalle luvulle.
     */
    private void kerroLuvut() {
        StringBuilder syote = haeSyote(textAreaNaytto);
        poistaRivinvaihdotLopusta(syote);        
        double alinLuku = Double.parseDouble(haeAlinLuku(syote));
        poistaAlinLuku(syote);
        poistaRivinvaihdotLopusta(syote);
        double toiseksiAlinLuku = Double.parseDouble(haeAlinLuku(syote));
        double summa = alinLuku * toiseksiAlinLuku;
        poistaViimeinen(textAreaNaytto);
        if (textAreaNaytto.getLength() == 0) textAreaNaytto.appendText(Double.toString(summa));  
        else textAreaNaytto.appendText("\n"+summa);   
        
    }
            
    
    /**
     * Tekee yhteenlaskun rpn-laskimen kahdelle alimmalle luvulle
     */
    private void summaaLuvut() {
        try{
            StringBuilder syote = haeSyote(textAreaNaytto);
            poistaRivinvaihdotLopusta(syote);        
            double alinLuku = Double.parseDouble(haeAlinLuku(syote));
            poistaAlinLuku(syote);
            poistaRivinvaihdotLopusta(syote);
            double toiseksiAlinLuku = Double.parseDouble(haeAlinLuku(syote));
            double summa = alinLuku + toiseksiAlinLuku;
            poistaViimeinen(textAreaNaytto); // Tekee tilaa uudelle luvulle
            if (textAreaNaytto.getLength() == 0) textAreaNaytto.appendText(Double.toString(summa));  
            else textAreaNaytto.appendText("\n"+summa);  
        } catch (Exception e) {
            textAreaNaytto.setText("0.0");
        }
        
    }


    /**
     * Monistaa rpn-laskimen alimman luvun enter-näppäimellä uudelle riville.
     */
    private void monistaLuku() {
        try{
            StringBuilder syote = haeSyote(textAreaNaytto);  //TODO: regexp kuntoon, jotta enter ei lisää kirjaimia
            poistaRivinvaihdotLopusta(syote);
            if (syote.length() == 0 || syote.toString().matches(".*[a-z]")) {
                textAreaNaytto.setText("");
                textAreaNaytto.appendText("0.0" +"\n" +"0.0") ;
                return;
            }
            String alinLuku = haeAlinLuku(syote);
            if (alinLuku !="") textAreaNaytto.appendText("\n" + alinLuku);
            else  textAreaNaytto.appendText("\n" + textAreaNaytto.getText()); 
        } catch (Exception e) {
            textAreaNaytto.setText("0.0" + "\n" +"0.0");
        }
    }
    
    /**
     * Tekee vähennyslaskun rpn-laskimen kahdelle alimmalle luvulle
     */
    private void vahennaLuvut() {
        try {
            StringBuilder syote = haeSyote(textAreaNaytto);
            poistaRivinvaihdotLopusta(syote);        
            double alinLuku = Double.parseDouble(haeAlinLuku(syote));
            poistaAlinLuku(syote);
            poistaRivinvaihdotLopusta(syote);
            double toiseksiAlinLuku = Double.parseDouble(haeAlinLuku(syote));
            double summa = toiseksiAlinLuku- alinLuku;
            poistaViimeinen(textAreaNaytto);
            if (textAreaNaytto.getLength() == 0) textAreaNaytto.appendText(Double.toString(summa));  
            else textAreaNaytto.appendText("\n"+summa);
        } catch (Exception e) {
                textAreaNaytto.setText("0.0");
        
        }
    }
}