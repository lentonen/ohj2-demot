/**
 * 
 */
package demo.d5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Henri
 * @version Feb 10, 2021
 *
 */
public class Tietokone {
    
    private int muistiKoko;             // muisti Gt
    private int kovalevyKoko;           // kovalevyn koko Gt
    private int prosessoriTaajuus;      // prosessorin kellotaajuus
    private int prosessoriYtimet;       // montako ydintä
    private String emolevy;             // emolevyn merkki
    private int virtalahde;             // minkä kokoinen virtalähde
    private boolean näytönohjain;       // onko erillinen näytönohjain vai ei
    
    /**
     * Oletusmuodostaja
     */
    public Tietokone() {
        this.emolevy = "";
    }
    
    
    /**
     * Muodostaja
     * @param muisti muistin määrä Gt
     * @param kovalevy  Kovalevyn koko Gt
     * @param taajuus Prosessorin kellotaajuus
     * @param ytimet Ydinten lukumäärä prosessorissa
     * @param emo emolevyn merkki ja malli
     * @param virta virtalähteen teho W
     * @param nayttis true, jos erillinen näyttis, false jos ei
     */
    public Tietokone(int muisti, int kovalevy, int taajuus, int ytimet, String emo, int virta, Boolean nayttis) {
        this.muistiKoko = muisti;             
        kovalevyKoko = kovalevy;           
        prosessoriTaajuus = taajuus;      
        prosessoriYtimet = ytimet;       
        emolevy = emo;             
        virtalahde = virta;             
        näytönohjain = nayttis;
    }
    
    
    /**
     * vaihdetaan muistit
     * @param maara paljonko uusi muisti on Gt
     */
    public void uusiMuisti(int maara) {
        this.muistiKoko = maara;
    }
    
  
    /**
     * laitetaan koneeseen uusi prosessori
     * @param ytimet kuinka monta ydintä
     * @param kellotaajuus udinten kellotaajuus
     */
    public void uusiProsessori(int ytimet, int kellotaajuus) {
        this.prosessoriYtimet = ytimet;
        this.prosessoriTaajuus = kellotaajuus;
    }
    
    
    /**
     * laitetaan koneeseen uusi virtalähde
     * @param teho uuden virtalähteen teho
     */
    public void uusiVirtalahde(int teho) {
        this.virtalahde = teho;
    }
    
    
    /**
     * Vaihdetaan emolevy
     * @param emo mikä emolevy laitetaan
     */
    public void vaihdaEmo(String emo) {
        this.emolevy = emo;
    }
    
    
    /**
     * asentaa koneeseen erillisen näytönohjaimen
     */
    public void asennaNayttis() {
        this.näytönohjain = true;
    }
    
    
    /**
     * asentaa irrottaa koneesta erillisen näytönohjaimen
     */
    public void irrotaNayttis() {
        this.näytönohjain = false;
    }
    
    /**
     * Tulostetaan tietokoneen tiedot paramterina tuotuun tietovirtaan
     * @param os tietovirta johon tiedot tulostetaan
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        String naytonohjain;
        if (this.näytönohjain == true) naytonohjain = "on";
        else naytonohjain = "ei";
        out.println("Muistia: "+this.muistiKoko +" Gt" + "\n" 
                    +"Kovalevyn koko: "+kovalevyKoko +" Gt" + "\n" 
                    +"Prosessorin kellotaajuus: "+this.prosessoriTaajuus + " MHz" + "\n"
                    +"Prosessorin ytimet: "+this.prosessoriYtimet + "\n"
                    +"Emolevy: "+this.emolevy + "\n"
                    +"Virtalähde: "+this.virtalahde +" W" + "\n"
                    +"Erillinen näytönohjain: "+naytonohjain +"\n");
    }

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
    Tietokone kone = new Tietokone();
    kone.tulosta(System.out);
    
    Tietokone kone2 = new Tietokone(16, 128, 3500, 8, "ASUS", 650, true);
    kone2.tulosta(System.out);
    kone2.irrotaNayttis();
    kone2.tulosta(System.out);
    kone2.vaihdaEmo("ASRock");;
    kone2.tulosta(System.out);
    kone2.uusiVirtalahde(1000);
    kone2.tulosta(System.out);
    kone2.uusiProsessori(16, 4200);
    kone2.tulosta(System.out);
    kone2.uusiMuisti(8);
    kone2.tulosta(System.out);
    
    }

}
