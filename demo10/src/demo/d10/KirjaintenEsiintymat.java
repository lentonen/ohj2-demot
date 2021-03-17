package demo.d10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lasketaan paljonko mitäkin kirjainta esiintyy annetussa tekstitiedostossa.
 */
public class KirjaintenEsiintymat {

    /**
     * Pääohjelma
     * @param args mistä tiedostosta kirjaimia lasketaan
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #import fi.jyu.mit.ohj2.Suuntaaja;
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * 
     * Suuntaaja.StringOutput so = new Suuntaaja.StringOutput();
     * 
     * VertaaTiedosto.kirjoitaTiedosto("luettava.txt",
     *      "Testaaminen on kivaa.");
     * String tulos =
     *      " : 2\n" + 
     *      ".: 1\n" +
     *      "a: 4\n" +
     *      "e: 2\n" +
     *      "i: 2\n" +
     *      "k: 1\n" +
     *      "m: 1\n" +
     *      "n: 3\n" +
     *      "o: 1\n" +
     *      "s: 1\n" +
     *      "t: 2\n" +
     *      "v: 1\n" 
     *      ; 
     *  main(new String[]{"luettava.txt"});
     *  so.ero(tulos) === null;
     *  so.palauta();
     *  VertaaTiedosto.tuhoaTiedosto("luettava.txt");
     * </pre>
     */
    public static void main(String[] args) {
        String luettava =args[0]; // "esiintymat.txt";  //args[0];
        File luettavaTied = new File(luettava);
        int[] laskuri = new int[255];
        int merkkienMaara = laskuri.length;
        
        try (Scanner fi = new Scanner(new FileInputStream(luettavaTied))){
            while (fi.hasNext()) {
                String s = fi.nextLine().toLowerCase();
                int pituus = s.length();
                for (int i = 0; i < pituus; i++) {
                    int paikka = s.charAt(i);
                    laskuri[paikka]++;
                }             
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ei osata käsitellä tiedostoa " +luettavaTied.getAbsolutePath() );
        }
        for (int i = 0; i < merkkienMaara; i++) {  
            int lkm = laskuri[i];
            if (lkm != 0) {
                char c = (char)i;
                System.out.println(c+": " +lkm);
            }
        }
    }
}

