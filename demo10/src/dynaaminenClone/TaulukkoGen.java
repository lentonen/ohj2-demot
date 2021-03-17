package dynaaminenClone;
import demo.d9.*;
/**
 * Esimerkki dynaamisesta taulukosta Java 1.5:n geneerisyyttä
 * ja "autoboxingia" käyttäen.
 * @author Vesa Lappalainen @version 1.0, 02.03.2002
 * @version 1.1, 01.03.2005
 * @author Santtu Viitanen @version 1.2, 21.07.2011
 * @param <TYPE> Tyyppi jota talletetaan
 */
public class TaulukkoGen<TYPE extends Int> implements Cloneable  {
    /** Luokka täyden taulukon poikkeusta varten  */
    public static class TaulukkoTaysiException extends Error {
        private static final long serialVersionUID = 1L;


        TaulukkoTaysiException(String viesti) {
            super(viesti);
        }
    }

    private TYPE alkiot[];
    private int lkm;


    /**
     * Alustetaan 5 kokoinen taulukko
     */
    public TaulukkoGen() {
        this(5);
    }


    /**
     * Alutetaan valitun kokoinen taulukko
     * @param koko taulukon koko
     */
    @SuppressWarnings("unchecked")
    public TaulukkoGen(int koko) {
        // alkiot = (TYPE[]) new Object[koko];
        alkiot = (TYPE[])new Int[koko];  // Jos rajattu geneerisyys
        // alkiot = new TYPE[koko];
    }


    /**
     * Lisätään taulukkon uusi alkio
     * @param alkio lisättävän alkion viite
     * @throws TaulukkoTaysiException jos taulukko jo täysi
     */
    public void lisaa(TYPE alkio) throws TaulukkoTaysiException {
        if (lkm >= alkiot.length) throw new TaulukkoTaysiException("Tila loppu");
        alkiot[lkm++] = alkio;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        String erotin = "";
        for (int i = 0; i < lkm; i++) {
            s.append(erotin + alkiot[i]);
            erotin = ",";
        }
        return s.toString();
    }


    /**
     * Muutetaan paikan i arvo
     * @param i mihin paikkaa asetetaan
     * @param alkio uuden alkion viite
     * @throws IndexOutOfBoundsException jos indeksiväärin
     */
    public void set(int i, TYPE alkio) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        alkiot[i] = alkio;
    }


    /**
     * Paikassa i olevan alkion viite
     * @param i mistä paikasta
     * @return paikassa i oleva viite
     * @throws IndexOutOfBoundsException jos indeksi väärin
     */
    public TYPE get(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        return alkiot[i];
    }

    /**
     * <pre name="test">
     * #THROWS CloneNotSupportedException
     * #import demo.d9.Int;
     *  TaulukkoGen<Int> luvut = new TaulukkoGen<Int>(20);
     *  luvut.lisaa(new Int(0)); luvut.lisaa(new Int(2));
     *  luvut.lisaa(new Int(99));
     *  TaulukkoGen<Int> taul = luvut.clone();
     *  luvut.toString() === "0,2,99";
     *  taul.toString()  === "0,2,99";
     *  luvut.get(1).set(3);
     *  luvut.toString() === "0,3,99";
     *  taul.toString()  === "0,2,99";
     *  luvut.lisaa(new Int(2)); luvut.lisaa(new Int(5));
     *  luvut.lisaa(new Int(2)); luvut.lisaa(new Int(6));
     *  luvut.toString() === "0,3,99,2,5,2,6";
     *  taul.toString()  === "0,2,99";
     *  taul.get(3).intValue() === 2; #THROWS IndexOutOfBoundsException
     *  luvut.poista(new Int(2));
     *  luvut.toString() === "0,3,99,5,6";
     *  taul.toString()  === "0,2,99";
     * </pre>
     */
// BYCODEBEGIN
    @Override
    public TaulukkoGen<Int> clone() {
        TaulukkoGen<Int> uusiTaulukko = new TaulukkoGen<Int>(this.alkiot.length);
        for (int i=0; i < lkm; i++) {
            Int uusiAlkio = new Int(0);
            uusiAlkio.set(this.get(i).intValue()); 
            uusiTaulukko.lisaa(uusiAlkio);
        }
        return uusiTaulukko;
    }

    
    /**
     * Poistetaan taulukosta kaikki tietyn Int-luvun esiintymät.
     * @param poistettava poistettava luku
     * @example
     * <pre name="test">
     * TaulukkoGen<Int> luvut = new TaulukkoGen<Int>(20);
     * luvut.lisaa(new Int(0)); luvut.lisaa(new Int(2)); luvut.lisaa(new Int(1)); luvut.lisaa(new Int(2)); 
     * luvut.lisaa(new Int(3)); luvut.lisaa(new Int(4)); luvut.lisaa(new Int(1)); luvut.lisaa(new Int(2));
     * luvut.toString() === "0,2,1,2,3,4,1,2";
     * luvut.poista(new Int(0));
     * luvut.toString() === "2,1,2,3,4,1,2";
     * luvut.poista(new Int(4));
     * luvut.toString() === "2,1,2,3,1,2";
     * luvut.poista(new Int(2));
     * luvut.toString() === "1,3,1";
     * luvut.poista(new Int(2));
     * luvut.toString() === "1,3,1";
     * luvut.poista(new Int(1));
     * luvut.toString() === "3";
     * luvut.poista(new Int(3));
     * luvut.toString() === "";
     * </pre>
     */
    public void poista(Int poistettava) {
        int luku;
        int kirj;
        int pituus = this.lkm;
        for (luku = 0, kirj = 0; luku < pituus; luku++)
            if (this.alkiot[luku].intValue() != poistettava.intValue()) 
                alkiot[kirj++] = alkiot[luku];
            else this.lkm--;
    }

// BYCODEEND

    /**
     * Testataan taulukkoa
     * @param args ei käytössä
     * @throws TaulukkoTaysiException jos ei mahu
     * @throws CloneNotSupportedException poikkeus
     */
    public static void main(String[] args) throws  TaulukkoTaysiException, CloneNotSupportedException  {
        TaulukkoGen<Int> luvut = new TaulukkoGen<Int>(20);
        luvut.lisaa(new Int(0)); luvut.lisaa(new Int(2));
        luvut.lisaa(new Int(99));
        System.out.println(luvut);

        TaulukkoGen<Int> taul = luvut.clone();
        System.out.println(taul);
        luvut.get(1).set(3);
        System.out.println(taul);

        luvut.lisaa(new Int(2)); luvut.lisaa(new Int(5));
        luvut.lisaa(new Int(2)); luvut.lisaa(new Int(6));
        System.out.println(luvut);
        luvut.poista(new Int(2));
        System.out.println(luvut);
        System.out.println(taul);
    }
}


