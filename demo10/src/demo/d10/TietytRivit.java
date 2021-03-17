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
import fi.jyu.mit.ohj2.Syotto;

/**
 * @author Henri
 * @version Mar 16, 2021
 *
 */
public class TietytRivit {

    
    /**
     * Kopioidaan toisesta tiedostosta kaikki rivit, 
     * joiden alussa lukua 30 suurempi luku, toiseen tiedostoon.
     * @param args mikä tiedosto luetaan
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * 
     * Suuntaaja.StringInput si = new Suuntaaja.StringInput("testitulos.txt");
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput(); 
     * 
     *  VertaaTiedosto.kirjoitaTiedosto("lue.txt",
     *      "* hei\n" +
     *      "** moi\n" +
     *      "*** terve\n" +
     *      "\n" +
     *      "asd\n" +
     *      "**");
     *  String tulos =
     *      "** moi\n" +
     *      "*** terve\n" +
     *      "**";
     *  VertaaTiedosto.tuhoaTiedosto("testitulos.txt"); 
     *  main(new String[]{"lue.txt"});
     *  VertaaTiedosto.vertaaFileString("testitulos.txt",tulos) === null;
     *  si.palauta(); so.palauta();
     *  VertaaTiedosto.tuhoaTiedosto("testitulos.txt");
     *  VertaaTiedosto.tuhoaTiedosto("lue.txt");
     * </pre>
     */
    public static void main(String[] args) {
        String luettava = "koe.txt";  //args[0];
        String tallennettava = Syotto.kysy("Mihin tallennetaan");
        File luettavaTied = new File(luettava);
        File tallennettavaTied = new File(tallennettava);
        
        try (Scanner fi = new Scanner(new FileInputStream(luettavaTied)); PrintStream fo = new PrintStream(new FileOutputStream(tallennettavaTied, false))){
            while (fi.hasNext()) {
                String s = fi.nextLine();
                if (s.matches("\\*\\*.*"))
                    fo.println(s);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ei osata käsitellä tiedostoa " +luettavaTied.getAbsolutePath() );
        }
    }
}
