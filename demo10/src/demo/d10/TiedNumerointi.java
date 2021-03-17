package demo.d10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tiedoston numerointi ja tulostus
 */
public class TiedNumerointi {

    /**
     * tulostaa tiedoston sisällön siten, että kunkin rivin alkuun tulee rivinumero
     *  ja kustakin rivistä tulostetaan korkeintaan 40 merkkiä.
     * @param args luettavan tiedosto
     * <pre name="test">
     * #THROWS IOException
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * 
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     *  VertaaTiedosto.kirjoitaTiedosto("lue.txt",
     *      "123456789012345678901234567890123456789012345678901234567890\n"+
     *      "Kissa istuu puussa\n"+
     *      "ja ihmettelee\n"+
     *      "mualiman menoa\n");
     *  String tulos =
     *      "/" +"*"+ " 0" +"1" +" *"+"/"  +" 1234567890123456789012345678901234567890\n" +
     *      "/" +"*"+ " 0" +"2" +" *"+"/"  +" Kissa istuu puussa\n" +
     *      "/" +"*"+ " 0" +"3" +" *"+"/"  +" ja ihmettelee\n" +
     *      "/" +"*"+ " 0" +"4" +" *"+"/"  +" mualiman menoa\n";
     *  main(new String[]{"lue.txt"});
     *  so.ero(tulos) === null;
     *  so.palauta();
     *  VertaaTiedosto.tuhoaTiedosto("lue.txt");
     * </pre>
     */
    public static void main(String[] args) {
        //if (args.length <= 1) return;  // lähdetään pois jos ei annetata luettavan ja kirjoitettavan nimeä.
        String luettava = args[0];   //"koe.txt";                //args[0]
        File luettavaTied = new File(luettava);
        
        try (Scanner fi = new Scanner(new FileInputStream(luettavaTied));){
            int count = 1;
            while (fi.hasNext()) {
                String s = fi.nextLine();
                if (s.length() > 40)
                    s = s.substring(0, 40);
                System.out.println("/* 0"+count +" */ " +s);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ei osata käsitellä tiedostoa " +luettavaTied.getAbsolutePath() );
        }
    
    }

}