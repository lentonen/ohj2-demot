package demo.d9;

/**
 * Esimerkki dynaamisesta taulukosta
 * @author Vesa Lappalainen @version 1.0, 02.03.2002
 * @author Santtu Viitanen @version 1.1, 21.07.2011
 * @example
 * <pre name="test">
 *  #THROWS Taulukko.TaulukkoTaysiException
 *  Taulukko luvut = new Taulukko();
 *  luvut.lisaa(0); luvut.lisaa(2); luvut.lisaa(99);
 *  luvut.toString() === "0,2,99";
 *  luvut.set(1,4); luvut.toString() === "0,4,99";
 *  int luku = luvut.get(2);
 *  luku === 99;
 *  luvut.get(2) === 99;
 *  luvut.set(21, 4); #THROWS IndexOutOfBoundsException
 *  luvut.lisaa(0); luvut.lisaa(0); //taulukko täyteen
 *  luvut.lisaa(0);  #THROWS Taulukko.TaulukkoTaysiException
 * </pre>
 */
public class Taulukko implements Cloneable {
    /** Luokka täyden taulukon poikkeusta varten  */
    public static class TaulukkoTaysiException extends Error {
        private static final long serialVersionUID = 1L;


        TaulukkoTaysiException(String viesti) {
            super(viesti);
        }
    }

    private int alkiot[];
    private int lkm;


    /**
     * Alustetaan 5 kokoinen taulukko
     */
    public Taulukko() {
        alkiot = new int[5];
    }


    /**
     * Alutetaan valitun kokoinen taulukko
     * @param koko taulukon koko
     */
    public Taulukko(int koko) {
        alkiot = new int[koko];
    }


    /**
     * Lisätään taulukkoon yksi alkio
     * @param luku lisättävä alkio
     * @throws TaulukkoTaysiException jos taulukko täysi
     */
    public void lisaa(int luku) throws TaulukkoTaysiException {
        if (lkm >= alkiot.length) throw new TaulukkoTaysiException("Tila loppu");
        alkiot[lkm++] = luku;
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
     * Asetetaan taulukon i's alkio
     * @param i mihin paikkaan astetaan
     * @param luku mikä arvo laitetaan
     * @throws IndexOutOfBoundsException jos väärä indeksi
     */
    public void set(int i, int luku) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        alkiot[i] = luku;
    }


    /**
     * Palautetana paikasssa i oleva luku
     * @param i mistä paikasta luku otetaan
     * @return paikassa i olevan luvun arvo
     * @throws IndexOutOfBoundsException jos indeksi väärin
     */
    public int get(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (lkm <= i)) throw new IndexOutOfBoundsException("i = " + i);
        return alkiot[i];
    }




    
    /**
     * luo kloonin Taulukko-oliosta.
     * @example
     * <pre name="test">
     * Taulukko luvut = new Taulukko(5);
     * luvut.lisaa(1); luvut.lisaa(2);
     * Taulukko luvut2 = luvut.clone();
     * luvut2.toString() === "1,2";
     * luvut.lisaa(3);
     * luvut2.toString() === "1,2";
     * luvut.toString() === "1,2,3";
     * luvut2.lisaa(4);
     * luvut2.toString() === "1,2,4";
     * luvut.toString() === "1,2,3";
     * </pre>
     */
    @Override
    public Taulukko clone() {
        Taulukko uusi = new Taulukko(this.alkiot.length);
        uusi.lkm = this.lkm;
        for (int i = 0; i <lkm; i++)
            uusi.set(i, this.get(i));
        return uusi;
    }


    /**
     * poistaa taulukosta annetun luvun esiintymät
     * @param n kokonaisluku jonka esiintymät poistetaan
     * @example
     * <pre name="test">
     *  Taulukko luvut2 = new Taulukko(7);
     *  luvut2.lisaa(1); luvut2.lisaa(2); luvut2.lisaa(1);
     *  luvut2.toString() === "1,2,1";
     *  luvut2.poista(2);
     *  luvut2.toString() === "1,1";
     *  luvut2.poista(1);
     *  luvut2.toString() === "";
     *  luvut2.poista(1);
     *  luvut2.toString() === "";
     */
    public void poista(int n) {
        this.lkm = PoistaTaulukosta.poista(this.alkiot, this.lkm, n);
        
    }


    /**
     * Kokeillaan kloonausta
     * @param args ei käytössä
     * @throws TaulukkoTaysiException jos tila loppuu
     * @throws CloneNotSupportedException jos kloonia ei tueta
     */
     public static void main(String args[]) throws TaulukkoTaysiException,  CloneNotSupportedException {
        Taulukko luvut = new Taulukko(7);
        luvut.lisaa(0); luvut.lisaa(2);
        System.out.println(luvut); // Tulostaa " 0 2"
        Taulukko taul = luvut.clone();
        luvut.lisaa(77);
        luvut.set(1, 4);
        System.out.println(taul);  // tulostaa saman kuin edellä " 0 2"
        
        Taulukko luvut2 = new Taulukko(7);
        luvut2.lisaa(1); luvut2.lisaa(2); luvut2.lisaa(1);
        System.out.println(luvut2); // Tulostaa "1,2,1"
        luvut2.poista(1);
        System.out.println(luvut2);  // tulostaa "2"
    }


   

}


