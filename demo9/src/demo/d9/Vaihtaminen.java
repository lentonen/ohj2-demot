package demo.d9;

import java.util.Arrays;

/**
 * Alla on määritelty muutamia taulukonkäsittelyaliohjelmia edellisten demojen mallivastauksista. 
 * Muuta silmukoista for each -silmukoiksi ne, jotka on mahdollista muuttaa lisäämättä silmukkaan if-lauseita. 
 * Aja testit ja totea, että toimii. Kirjoita muiden aliohjelmien kommentteihin, että miksi 
 * näiden funktioiden silmukoita ei voitu toteuttaa for each-silmukalla.
 * @author vesal
 * @version 19.1.2014
 */
public class Vaihtaminen {

    /**
     * Kutsutaan Taunolla tehtyjä aliohjelmia
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int[] t = { 2, 32, 76, 62, 31, 86 };
        System.out.println(Arrays.toString(t));
        kaanna(t);
        System.out.println(Arrays.toString(t));

        vaihdaJokaToinen(t);
        System.out.println(Arrays.toString(t));

        int[] t2 = {32, 32, 76, 62, 31, 86};
        int s = summa(t2);
        System.out.println("Lukujen summa = " + s);

        s = summaParillisissaPaikoissa(t2);
        System.out.println("Lukujen summa = " + s);

        int[] t3 = { 32, 32, 76, 62, 31, 86 };
        s = summaVastaavienErotuksista(t3);
        System.out.println("Lukujen summa = " + s);

        s = summaPerattaistenErotuksista(t3);
        System.out.println("Lukujen summa = " + s);

        int[] t4 = {32, 32, 76, 62, 31, 86};
        System.out.println(Arrays.toString(t4));
        lisaaArvoihin(t4, 5);
        System.out.println(Arrays.toString(t4));

        laskePerakkaiset(t4);
        System.out.println(Arrays.toString(t4));
    }


    // BYCODEBEGIN
    /**
     * Foreach ei toimi, koska se ei tiedä järjestyksestä mitään. Kun käytetään
     * foreachia, saadaan kyllä käytyä kaikki alkiot läpi, mutta järjestys ei
     * ole taattu kuten for-silmukalla. Tästä johtuen ei voida käyttää kääntämään
     * päinvastaiseen järjestykseen. 
     * 
     * Lisäksi for (int luku : t)
     *            luku , jolle tehdään jotain
     *            
     *     luku jota käsitellään foreach-silmukan sisällä ei ole taulukon luku vaan kopio siitä.
     *     Eli jos luku alustetaan uudestaan, niin taulukon alkuperäinen luku ei muutu. Ainoastaan
     *     silmukan sisällä oleva kopio muuttuu.
     * 
     * 
     * Käännetään taulukon alkiot päinvastaiseen järjestykseen
     * @param t taulukko jonka alkiot käännetään
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     *    int[] t = {2, 32, 76, 62, 31, 86};
     *    kaanna(t);
     *    Arrays.toString(t) === "[86, 31, 62, 76, 32, 2]";
     *    int[] t2 = {2, 32, 76, 62, 31, 86, 99};
     *    kaanna(t2);
     *    Arrays.toString(t2) === "[99, 86, 31, 62, 76, 32, 2]";
     * </pre>
     */
    public static void kaanna(int[] t) {
        for (int i1 = 0, i2 = t.length - 1; i1 < i2; i1++, i2--) {
            int tmp = t[i1];
            t[i1] = t[i2];
            t[i2] = tmp;
        }
    }


    /**
     * Foreach ei toimi, koska se ei tiedä järjestyksestä mitään. Kun käytetään
     * foreachia, saadaan kyllä käytyä kaikki alkiot läpi, mutta järjestys ei
     * ole taattu kuten for-silmukalla. Tästä johtuen ei voida käyttää vaihtamaan paikkoja. 
     * 
     * Lisäksi for (int luku : t)
     *            luku , jolle tehdään jotain
     *            
     *     luku jota käsitellään foreach-silmukan sisällä ei ole taulukon luku vaan kopio siitä.
     *     Eli jos luku alustetaan uudestaan, niin taulukon alkuperäinen luku ei muutu. Ainoastaan
     *     silmukan sisällä oleva kopio muuttuu.
     * Vaihdetaan taulukon joka toinen alkio keskenään
     * @param t taulukko jonka alkiot käännetään
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     *    int[] t = {2, 32, 76, 62, 31, 86};
     *    vaihdaJokaToinen(t);
     *    Arrays.toString(t) === "[32, 2, 62, 76, 86, 31]";
     *    int[] t2 = {2, 32, 76, 62, 31, 86, 99};
     *    vaihdaJokaToinen(t2);
     *    Arrays.toString(t2) === "[32, 2, 62, 76, 86, 31, 99]";
     * </pre>
     */
    public static void vaihdaJokaToinen(int[] t) {
        for (int i1 = 0, i2 = 1; i2 < t.length; i1 += 2, i2 += 2) {
            int tmp = t[i1];
            t[i1] = t[i2];
            t[i2] = tmp;
        }
    }


    /**
     * Tässä foreach:n käyttö pakottaisi käyttämään if-lausetta.
     * Täytyisi erikseen laskea ollaanko parillisessa/parittomassa.
     * 
     *  public static int summaParillisissaPaikoissa(int[] t) {
     *   int tulos = 0;
     *   int i = 0;
     *   for (int luku : t) {
     *       if (i%2 == 0)tulos += luku;
     *       i++;
     *   }
     *   return tulos;
     *  }
     *  
     * @param t taulukko jonka luvut lasketaan
     * @return parillisissa paikoissa olevien lukujen summa
     * @example
     * <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summaParillisissaPaikoissa(t) === 9;
     *   summaParillisissaPaikoissa(new int[]{1,1,1,1,1,1}) === 3;
     *   summaParillisissaPaikoissa(new int[]{}) === 0;
     *   summaParillisissaPaikoissa(new int[]{1}) === 1;
     *   summaParillisissaPaikoissa(new int[]{1,2}) === 1;
     *   summaParillisissaPaikoissa(new int[]{1,2,3}) === 4;
     * </pre>
     */
    public static int summaParillisissaPaikoissa(int[] t) {
        int tulos = 0;
        for (int i = 0; i < t.length; i += 2)
            tulos += t[i];
        return tulos;
    }


    /**
     * Tässä foreach toimii. Nyt ei olla kiinnostuttu järjestyksestä vaan ainoastaan kaikista
     * taulukon luvuista, joita käytetään summan laskemiseen. Taulukkoa ei myöskään yritetä muuttaa,
     * joten ongelmia ei tule.
     * Lasketaan yhteen taulukon kaikki luvut
     * @param t taulukko jonka luvut lasketaan
     * @return lukujen summa
     * @example
     * <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summa(t) === 21;
     *   summa(new int[]{1,1,1,1,1,1}) === 6;
     *   summa(new int[]{}) === 0;
     *   summa(new int[]{1}) === 1;
     *   summa(new int[]{1,2}) === 3;
     * </pre>
     */
    public static int summa(int[] t) {
        int tulos = 0;
        for (int luku : t)
            tulos +=luku;
        return tulos;
    }


    /**
     * Tämä vaatisi if-lauseiden käyttöä kuten parillisessa paikassa oleva summakin.
     * Lasketaan taulukon parillisissa paikoissa olevien lukujen summa miinus
     * parittomissa paikoissa olevien summa.  Jos lukuja pariton määrä, viimeinen
     * jätetään huomioimatta.
     *
     * @param t taulukko jonka luvut lasketaan
     * @return erotusten summa
     * @example <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summaPerattaistenErotuksista(t) === -3;
     *   summaPerattaistenErotuksista(new int[]{1,1,1,1,1,1}) === 0;
     *   summaPerattaistenErotuksista(new int[]{1}) === 0;
     *   summaPerattaistenErotuksista(new int[]{1,2}) === -1;
     *   summaPerattaistenErotuksista(new int[]{1,2,3}) === -1;
     * </pre>
     */
    public static int summaPerattaistenErotuksista(int[] t) {
        int tulos = 0;
        for (int i = 0, j = 1; j < t.length; i += 2, j += 2)
            tulos += t[i] - t[j];
        return tulos;
    }


    /**
     * Vaatisi if-lausetta foreachilla. 
     * Lasketaan taulukon summa (1. - viimeinen) + (2. - toiseksi viimeinen)
     * jne...
     *
     * @param t taulukko jonka luvut lasketaan
     * @return erotusten summa
     * @example <pre name="test">
     *   int[] t = {1,2,3,4,5,6};
     *   summaVastaavienErotuksista(t) === -9;
     *   summaVastaavienErotuksista(new int[]{1,1,1,1,1,1}) === 0;
     *   summaVastaavienErotuksista(new int[]{1}) === 0;
     *   summaVastaavienErotuksista(new int[]{1,2}) === -1;
     *   summaVastaavienErotuksista(new int[]{1,2,3}) === -2;
     * </pre>
     */
    public static int summaVastaavienErotuksista(int[] t) {
        int tulos = 0;
        for (int i = 0, j = t.length - 1; i < j; i++, j--)
            tulos += t[i] - t[j];
        return tulos;
    }


    /**
     * Forachilla ei kannata yrittää muuttaa taulukkoa, koska
     *   for (int luku : t) tarkoittaa sitä, että luku jota käsitellään
     *   on kopio taulukon arvosta. Jos silmukassa muutetaan muuttujan luku
     *   arvoa, niin se ei muuta varsinaisen taulukon arvoa.
     * Lisätään kuhunkin taulukon alkiooon lisättävä arvo
     * @param t taulukko johon lisätään (vain 6 paikkainen)
     * @param lisattava mikä luku lisätään kuhunkin alkioon
     * @return viite muutettuun taulukkoon (sama kuin kutsussa tuotu)
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     *   int[] t = {1,2,3,4,5,6};
     *   lisaaArvoihin(t,5);
     *   Arrays.toString(t) === "[6, 7, 8, 9, 10, 11]";
     *   Arrays.toString(lisaaArvoihin(new int[]{},5)) === "[]";
     *   Arrays.toString(lisaaArvoihin(new int[]{1},5)) === "[6]";
     *   Arrays.toString(lisaaArvoihin(new int[]{1,2},3)) === "[4, 5]";
     * </pre>
     */
    public static int[] lisaaArvoihin(int[] t, int lisattava) {
        for (int i = 0; i < t.length; i++)
            t[i] += lisattava;
        return t;
    }


    /**
     * Forachilla ei kannata yrittää muuttaa taulukkoa, koska
     *   for (int luku : t) tarkoittaa sitä, että luku jota käsitellään
     *   on kopio taulukon arvosta. Jos silmukassa muutetaan muuttujan luku
     *   arvoa, niin se ei muuta varsinaisen taulukon arvoa.
     *   Tässä tehtävässä täytyisi jotenkin myös huolehtia siitä, että tulos
     *   laitetaan parilliseen paikkaan yms. Se ei ole mahdollista ilman if-lauseita.
     *   
     * Lasketaan yhteen peräkkäisissä paikoissa olevat taulukon alkiot ja
     * laitetaan tulos aina parilliseen (0,2,4) paikaan.
     * Vastaavaan parittomaan paikkaan laitetaan arvo 0.
     * Eli taulukon summa pysyy samana, mutta parittomissa (1,3,5)
     * paikoissa olevat alkiot nollautuvat.
     *
     * @param t taulukko jonka luvut lasketaan (vain 6 paikkainen)
     * @return viite muutettuun taulukkoon (sama kuin kutsussa tuotu)
     * @example
     * <pre name="test">
     * #import java.util.Arrays;
     *   int[] t = {1,2,3,4,5,6};
     *   laskePerakkaiset(t);
     *   Arrays.toString(t) === "[3, 0, 7, 0, 11, 0]";
     *   Arrays.toString(laskePerakkaiset(new int[]{})) === "[]";
     *   Arrays.toString(laskePerakkaiset(new int[]{1})) === "[1]";
     *   Arrays.toString(laskePerakkaiset(new int[]{1,2})) === "[3, 0]";
     *   Arrays.toString(laskePerakkaiset(new int[]{1,2,3})) === "[3, 0, 3]";
     * </pre>
     */
    public static int[] laskePerakkaiset(int[] t) {
        for (int i = 0, j = 1; j < t.length; i += 2, j += 2) {
            t[i] += t[j];
            t[j] = 0;
        }
        return t;
    }
    // BYCODEEND
}


