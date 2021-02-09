/**
 * 
 */
package demo.d5;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Henri
 * @version Feb 9, 2021
 *
 */
public class LinjaAuto {
    
    private int paikkojenMaara;
    private int vapaatPaikat;
    
    
    /**
     * muodostaja jolle annetaan paikkojen määrä
     * @param paikkojenMaara kuinka paljon linja-autoon mahtuu ihmisiä
     */
    public LinjaAuto(int paikkojenMaara) {
        this.paikkojenMaara = paikkojenMaara;
        this.vapaatPaikat = paikkojenMaara;
    }
    
    
    /**
     * Tulostetaan linja-auton tiedot paramterina tuotuun tietovirtaan
     * @param os tietovirta johon tiedot tulostetaan
     * @example
     * <pre name="test">
     * #import java.io.*;
     * ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
     * LinjaAuto linkki = new LinjaAuto(35);
     * linkki.tulosta(byteoutput);
     * byteoutput.toString() =R= "Kapasiteetti: 35, matkustajia: 0, vapaita paikkoja: 35.\\s*"
     * </pre>
     */
    public void tulosta(OutputStream os) {
        PrintStream out = new PrintStream(os);
        int matkustajia = this.paikkojenMaara-this.vapaatPaikat;
        out.println("Kapasiteetti: "+this.paikkojenMaara + "," +" matkustajia: "+matkustajia + "," +" vapaita paikkoja: "+this.vapaatPaikat + ".");
    }
    
    
    /**
     * saantimetodi vapaille paikoille. Hyödynnetään testaamisessa.
     * @return vapaiden paikkojen määrä
     */
    public int getTilaa() {
        return this.vapaatPaikat;
    }
    
    
    /**
     * saantimetodi vapaille paikoille. Hyödynnetään testaamisessa.
     * @return vapaiden paikkojen määrä
     */
    public boolean tilaa() {
        return this.vapaatPaikat > 0;
    }
    
    
    /**
     * metodi jolla lisätään ihmisiä linja-autoon
     * @param maara montako lisätään
     * @return palauttaa lukumäärän ihmisistä, jotka eivät mahtuneet bussiin.
     * @example
     * <pre name="test">
     * LinjaAuto auto = new LinjaAuto(35);
     * auto.lisaa(5);
     * auto.getTilaa() === 30;
     * </pre>
     */
    public int lisaa(int maara) {
        //this.vapaatPaikat = Math.max(this.vapaatPaikat-maara, 0);
        
        if (maara > this.vapaatPaikat) {
            int yli = maara - this.vapaatPaikat; // henkilöt jotka jäävät yli
            this.vapaatPaikat = 0;
            return yli;
        }
        this.vapaatPaikat -= maara;
        return 0;
    }

    
    /**
     * metodi jolla vähennetään ihmisiä linja-autosta
     * @param maara montako vähennetään
     * @return montako ihmistä liikaa yritettiin poistaa bussista.
     * @example
     * <pre name="test">
     * LinjaAuto auto = new LinjaAuto(35);
     * auto.lisaa(5);
     * auto.vahenna(3);
     * auto.getTilaa() === 33;
     * </pre>
     */
    public int vahenna(int maara) {
        //this.vapaatPaikat = Math.min(this.vapaatPaikat+maara, this.paikkojenMaara);
        int matkustajat = this.paikkojenMaara - this.vapaatPaikat;
        if (maara > matkustajat) {
            this.vapaatPaikat = this.paikkojenMaara;
            return matkustajat - maara;
        }
        this.vapaatPaikat += maara;
        return 0;
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        LinjaAuto pikkubussi = new LinjaAuto(10);
        LinjaAuto isobussi = new LinjaAuto(45);
        pikkubussi.lisaa(4);    pikkubussi.tulosta(System.out); // 10,4,6
        isobussi.lisaa(30);     isobussi.tulosta(System.out);   // 45,30,15
        int yli = pikkubussi.lisaa(15);
        isobussi.lisaa(yli);
        pikkubussi.tulosta(System.out);                         // 10,10,0
        isobussi.tulosta(System.out);                           // 45,39,6
        if ( pikkubussi.getTilaa() > 0 )
            System.out.println("Pieneen bussiin mahtuu!");   // ei tulosta
        if ( isobussi.tilaa() )
            System.out.println("Isoon bussiin mahtuu!");     // tulostaa
        int vajaa = pikkubussi.vahenna(12);                  // vajaa = -2
        if ( vajaa < 0 )
            System.out.println("Pikkubussissa ei edes ole näin montaa!");
        pikkubussi.tulosta(System.out);                         // 10,0,10
        
    
    }

}
