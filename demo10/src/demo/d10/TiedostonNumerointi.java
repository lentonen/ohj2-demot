/**
 * 
 */
package demo.d10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author Henri
 * @version Mar 16, 2021
 *
 */
public class TiedostonNumerointi {

    /**
     * Kopioidaan toisesta tiedostosta kaikki rivit, 
     * joiden alussa lukua 30 suurempi luku, toiseen tiedostoon.
     * @param args luettavan ja tulostiedoston tiedot
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
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
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt"); 
     *  main(new String[]{"lue.txt","tulos.txt"});
     *  VertaaTiedosto.vertaaFileString("tulos.txt",tulos) === null;
     *  VertaaTiedosto.tuhoaTiedosto("tulos.txt");
     *  VertaaTiedosto.tuhoaTiedosto("lue.txt");
     * </pre>
     */
    public static void main(String[] args) {
        //if (args.length <= 1) return;  // lähdetään pois jos ei annetata luettavan ja kirjoitettavan nimeä.
        String luettava = args[0];   //"koe.txt";                //args[0]
        String tallennettava = args[1]; //   //"koe2.txt";           //args[1];
        File luettavaTied = new File(luettava);
        File tallennettavaTied = new File(tallennettava);
        
        try (Scanner fi = new Scanner(new FileInputStream(luettavaTied)); PrintStream fo = new PrintStream(new FileOutputStream(tallennettavaTied, false))){
            int count = 1;
            while (fi.hasNext()) {
                String s = fi.nextLine();
                if (s.length() > 40)
                    s = s.substring(0, 40);
                fo.println("/* 0"+count +" */ " +s);
                System.out.println("/* 0"+count +" */ " +s);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ei osata käsitellä tiedostoa " +luettavaTied.getAbsolutePath() );
        }
    
    }
    
    
   

}