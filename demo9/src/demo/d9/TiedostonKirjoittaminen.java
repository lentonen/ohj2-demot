package demo.d9;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Kirjoitetaan tiedostoon rivejä.
 */
public class TiedostonKirjoittaminen {
    /**
     * @param args  Tuodaan parametreina seuraavaa,
     * 0 =  kuinka monta riviä kirjoitetaan
     * 1 =  mitä kirjoitetaan
     * 2 =  minkä nimiseen tiedostoon kirjoitetaan.
     * 
     * TESTAAMINEN:
     * 
     * 1. Jos olemassa, niin tuhotaan aikaisemmin luotu tiedosto toistoTest.txt
     * 2. Ajetaan testissä pääohjelma parametrilla String[]{"100", "En enää turhaan kirjoita!" toistoTest.txt}
     * 3. Luodaan String-tyyppinen viitemuuttuja "tulos", johon tallennetaan se, mitä tallennettavassa tiedostossa pitäisi olla ajon jälkeen.
     * 4. Verrataan toistoText.txt sisältöä muuttujaan "tulos". Jos se antaa null, kaikki ok.
     * 5. Tuhotaan lopuksi toistoText.txt
     */
    public static void main(String[] args) {
        double rivit = Double.parseDouble(args[0]);
        String viesti = args[1];
        String tied = args[2];
        File tiedosto = new File(tied);
 
        try (PrintStream fo = new PrintStream(new FileOutputStream(tiedosto, false))){
            for (int i = 0; i < rivit; i++)
                fo.println(viesti);
        } catch (FileNotFoundException e) {
            System.err.println("Ei voida kirjoittaa tiedostoon: " + tiedosto.getAbsolutePath());
        }
    }       
}