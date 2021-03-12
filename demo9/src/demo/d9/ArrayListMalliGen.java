package demo.d9;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fi.jyu.mit.ohj2.Tiedosto;

/**
 * Esimerkki Javan ArrayListin käytöstä Java 1.5:n geneerisyyden
 * ja "autoboxin" avulla.
 * @author Vesa Lappalainen @version 1.0, 02.03.2002
 * @version 1.1, 01.03.2005
 * @author Santtu Viitanen @version 1.2, 22.07.2011
 */
public class ArrayListMalliGen {

    /**
     * @param os virta johon tulostetaan
     * @param luvut tulostettavat luvut
     */
    public static void tulosta(OutputStream os, Collection<Int> luvut) {
        @SuppressWarnings("resource")
        PrintStream out = Tiedosto.getPrintStream(os);
        for (Int luku : luvut) {
            out.print(luku + " ");
        }
        out.println();
    }

    /**
     * @param os virta johon tulostetaan
     * @param luvut tulostettavat luvut
     */
    public static void tulostaIter(OutputStream os, Collection<Int> luvut) {
        @SuppressWarnings("resource")
        PrintStream out = Tiedosto.getPrintStream(os);
        for (Iterator<Int> it = luvut.iterator(); it.hasNext(); ) {
            Int luku = it.next();
            out.print(luku + " ");
        }
        out.println();
    }

    /**
     * Esimekki listasta
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        ArrayList<Int> luvut = new ArrayList<Int>(7);
        try {
            luvut.add(new Int(0));
            luvut.add(new Int(2));
            luvut.add(new Int(99));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        Int luku = luvut.get(1);
        luku.set(4);
        luvut.get(2).set(9);
        
        
        System.out.println(luvut);
        luvut.set(1, new Int(4));
        System.out.println(luvut);
        Int luku2 = luvut.get(2);
        System.out.println("Paikassa 2 on " + luku2);
        tulosta(System.out, luvut);
        try {
            luvut.set(21, new Int(4));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
}