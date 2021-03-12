package demo.d9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import fi.jyu.mit.ohj2.Mjonot;



/**
 * @author Henri
 * @version Mar 12, 2021
 *
 */
public class Kopiointi {

    /**
     * Kopioidaan toisesta tiedostosta kaikki rivit, 
     * joiden alussa lukua 30 suurempi luku, toiseen tiedostoon.
     * @param args luettavan ja tulostiedoston tiedot
     * TESTAAMINEN:
     * 
     * 1. Tuhotaan aikaisemmin luodut tiedostot luettava.txt ja tallennettava.txt 
     * 2.Luodaan testissä kaksi tekstitiedostoa luettava.txt ja tallennettava.txt.
     * 3. Kirjoitetaan luettava.txt-tiedostoon haluttu sisältö
     *   33 hiljaa 1 hiipii
     *   hyvä 33 tulee
     *   25 jep
     *   36 1 3 5 55
     *   nyt 33 riittää
     * 4. Ajetaan testissä pääohjelma parametrilla String[]{"luettava.txt", "tallennettava.txt"}
     * 5. Luodaan String-tyyppinen viitemuuttuja "tulos", johon tallennetaan se, mitä tallennettavassa tiedostossa pitäisi olla kopioinnin jälkeen.
     * 6. Verrataan tallennettava.txt sisältöä muuttujaan "tulos". Jos se antaa null, kaikki ok.
     * 7. Tuhotaan lopuksi molemmat tiedostot.
     */
    public static void main(String[] args) {
        //if (args.length <= 1) return;  // lähdetään pois jos ei annetata luettavan ja kirjoitettavan nimeä.
        String luettava = "luettava/luettava.txt";                          //args[0]
        String tallennettava = "tallennettava/tallennettava.txt";           //args[1];
        File luettavaTied = new File(luettava);
        File tallennettavaTied = new File(tallennettava);
        
        try (Scanner fi = new Scanner(new FileInputStream(luettavaTied)); PrintStream fo = new PrintStream(new FileOutputStream(tallennettavaTied, false))){
            while (fi.hasNext()) {
                String s = fi.nextLine();
                StringBuilder sb = new StringBuilder(s);
                int ekaLuku = 0;
                ekaLuku = Mjonot.erota(sb, ' ', 0);
                if (ekaLuku > 30) {
                    fo.println(s);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ei osata käsitellä tiedostoa " +luettavaTied.getAbsolutePath() );
        }
    
    }
    
    
   

}
