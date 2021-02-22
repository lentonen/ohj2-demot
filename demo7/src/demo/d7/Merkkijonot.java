package demo.d7;

import java.nio.charset.Charset;

/**
 * @author Henri
 * @version Feb 16, 2021
 *
 */
public class Merkkijonot {

   /**
 * @param args ei käytössä
 */
public static void main(String[] args)
   {
    
   //Onko merkkijonossa jono muita kirjaimia kuin joukon k kirjaimet
   // jono="kissa" k="aik" -> on, k="aiks" -> ei ole
    String jono = "kissa";
    String k = "aiks";
    
    System.out.println("Tutkitaan onko jonossa " +"\""  +jono +"\"" +" muita kirjaimia kuin jonon " +"\""+ k +"\"" +" kirjaimia");
    if (onkoMuita(jono,k)) System.out.println("on\n");
    else System.out.println("ei ole\n");
    
   // Missä on jonon viimeinen '\'-merkki.
   // "C:\mytemp\ohj2\vesal\Koe.java" viimeinen '\'-merkki
   String jono2 = "C:\\mytemp\\ohj2\\vesal\\Koe.java";
   int indeksi = viimeinen(jono2, '\\');
   
   System.out.println("Tutkitaan jonoa:\n"
                       +jono2 + "\n"
                       +"Viimeinen \\ merkki on indeksissä " +indeksi +"\n");
   
  
   // Onko jonossa jokin kirjain joukosta k
   // jono="kissa" k="ibm" -> on , k="pc"  -> ei ole
   String jono3 = "kissa";
   String j = "ibm";
   System.out.println("Tutkitaan onko jonossa " +"\""  +jono3 +"\"" +" joku jonon " +"\""+ j +"\"" +" kirjain");
   
   
   if (onkoJoku(jono3, j)) System.out.println("on\n");
   else System.out.println("ei ole\n");
   
   // onko " matti* " sama kuin "Matti Nykänen"?
   String syote = "mati*";
   String nimi ="Matti Nykänen";
   if (onkoSamat(syote, nimi))  
       System.out.println("syöte " +"\""  +syote +"\"" +" on sama kuin " +"\""+ nimi +"\"" +"\n");
   else System.out.println("syöte " +"\""  +syote +"\"" +" ei ole sama kuin " +"\""+ nimi +"\"" +"\n");
   
   // Paljonko jonossa "Kissa istuu puussa" on yhteensä merkkejä
   // jotka kuuluvat annettuun joukkoon, jossa joukko voi olla vaikka
   //  "a-jr-w"
   String jono4 = "Kissa istuu puussa";
   String merkit = "a-jr-w";
   int merkkienLkm = merkkienMaara(jono4, merkit);
   System.out.println("Jonossa " +"\""  +jono4 +"\"" +" on merkkejä " +"\""+ merkit +"\"" + " " +merkkienLkm + " kappaletta");
   
   String sana = "Saippuakauppias";
   if (palindromi(sana)) System.out.println("Sana " +"\"" +sana +"\"" +" on palindromi, eli toisinpäin " +"\"" +sana +"\"" +"\n");
   else System.out.println("Sana " +"\"" +sana +"\"" +" ei ole palindromi.\n");
   
   // TEHTÄVÄ 6 _____________________________________________________________________________________________
   
   String s="Kissa istuu";
   s = poistaLopusta(s,3); // => s = "Kissa is"          // Kuva 1
   System.out.println(s);
   // Tästä alkaa uusi koodi kuvaa 2 varten
   StringBuilder sb = new StringBuilder("Kissa istuu");
   poistaLopusta(sb,3);    // => sb= "Kissa is"          // Kuva2
   System.out.println(sb);
   }


    /**
     * poistaa Stringbuilder-merkkijonon lopusta annetun määrän kirjaimia
     * @param mj merkkijono josta poistetaan
     * @param poistettavienLkm montako lopusta poistetaan
     * @example
     * <pre name="test">
     * StringBuilder sb = new StringBuilder("Testataan toimiiko");
     * poistaLopusta(sb,5);
     * sb.toString() === "Testataan toi";
     * poistaLopusta(sb,4);
     * sb.toString() === "Testataan";
     * poistaLopusta(sb,0);
     * sb.toString() === "Testataan";
     * poistaLopusta(sb,-1);
     * sb.toString() === "Testataan";
     * poistaLopusta(sb,10);
     * sb.toString() === "";
     * </pre>
     */
    public static void poistaLopusta(StringBuilder mj, int poistettavienLkm) {
        if (poistettavienLkm < 0) return;
        int pituus = mj.length(); 
        if (poistettavienLkm > pituus)  mj.delete(0, pituus);   
        else mj.delete(pituus-poistettavienLkm, pituus);  
                    
    }


    /**
     * poistaa String-merkkijonon lopusta annetun määrän kirjaimia
     * @param mj merkkijono josta poistetaan
     * @param poistettavienLkm montako lopusta poistetaan
     * @return viite uuteen merkkijonoon, josta kirjaimet poistettu
     * @example
     * <pre name="test">
     * String s="Testataan toimiiko";
     *  s = poistaLopusta(s,5) === "Testataan toi";
     *  s = poistaLopusta(s,4) === "Testataan";
     *  s = poistaLopusta(s,0) === "Testataan";
     *  s = poistaLopusta(s,-1) === "Testataan";
     *  s = poistaLopusta(s,10) === "";
     * </pre>
     */
    public static String poistaLopusta(String mj, int poistettavienLkm) {
        if (poistettavienLkm < 0) return mj;
        if (poistettavienLkm > mj.length()) return "";
        StringBuilder jono = new StringBuilder(mj);
        poistaLopusta(jono, poistettavienLkm);
        return jono.toString();
    }


    /**
     * laskee paljonko jonossa on annettuja merkkejä. Isot ja pienet kirjaimet käsitellään samalla tavalla.
     * @param jono jono jota tutkitaan
     * @param merkit merkit jota etsitään
     * @return merkkien lkm
     * @example
     * <pre name="test">
     *  String jono = "Kissa istuu puussa";
     *  String merkit = "k";
     *  merkkienMaara(jono, merkit) === 1;
     *  merkit = "a";
     *  merkkienMaara(jono, merkit) === 2;
     *  merkit = "ak";
     *  merkkienMaara(jono, merkit) === 3;
     *  merkit = "b-j";
     *  merkkienMaara(jono, merkit) === 2;
     *  merkit = "a-jr-w";
     *  merkkienMaara(jono, merkit) === 14;
     *   merkit = "a-jpr-w";
     *  merkkienMaara(jono, merkit) === 15;
     * </pre>
     */
    public static int merkkienMaara(String jono, String merkit) {
        String ulkopuolistenRegExp = "(?i)[" + merkit +"]"; 
        String jononMerkit = jono.replaceAll(" ", "");
        return jononMerkit.length() - jononMerkit.replaceAll(ulkopuolistenRegExp, "").length(); 
    }


    /**
     * Vertaa löytyykö ensimmäinen merkkijono toisesta merkkijonosta.
     * Jos jokerimerkki, niin jokerimerkkiä edeltävä jono täytyy löytyä haetun nimen alusta tarkistettuna samanlaisena.
     * Ilman jokerimerkkiä löytää palauttaa true, jos syöte trimmattuna täsmälleen sama kuin merkkijono jota haetaan.
     * Jos halutaan, että nyk* etsii myös Matti Nykäsen, niin aliohjelmassa on kommenttina siihen tarkoitettu koodi.
     * @param syote ensimmäinen merkkijono
     * @param haettava toinen merkkijono
     * @return true jos ensimmäinen merkkijono löytyy toisesta merkkijonosta, false jos ei löydy
     * @example
     * <pre name="test">
     * String syote = "matti";
     * String nimi ="Matti Nykänen";
     * onkoSamat(syote, nimi) === false;
     * syote = "matti nykänen";
     * onkoSamat(syote, nimi) === true;
     * syote = "matti*";
     * onkoSamat(syote, nimi) === true;
     * syote = " mati* ";
     * onkoSamat(syote, nimi) === false;
     * syote = " atti* ";
     * onkoSamat(syote, nimi) === false;
     * </pre>
     */
    public static boolean onkoSamat(String syote, String haettava) {
        int viimeisenKirjaimenPaikka = syote.lastIndexOf('*')-1;
        if (syote.contains("*")) {
            // matti* löytää, mutta atti* ei löydä, nyk* ei löydä
            return haettava.substring(0, viimeisenKirjaimenPaikka+1).equalsIgnoreCase(syote.trim().substring(0, viimeisenKirjaimenPaikka+1));
            
            // VAIHTOEHTO 2: Poista käytöstä myös viimeisenKirjaimenPaikka, jos käytät tätä. 
            // matti* löytää, atti* löytää, nyk* löytää, mati* ei löydä
            // return haettava.toLowerCase().contains(syote.trim().toLowerCase().substring(0, syote.lastIndexOf('*')-1)) ;
        }
        return haettava.equalsIgnoreCase(syote.trim());
    }


    /**
     * Tutkitaan sisältääkö merkkijono jonkin annetuista kirjaimista
     * @param mj merkkijono jota tutkitaan
     * @param kirjaimet merkkijono annetuista kirjaimista
     * @return true jos sisältää jonkin annetuista, false muuten, jos jompikumpi jonoista tyhjä niin palautetaan false.
     * @example
     * <pre name="test">
     * String mj = "Testi";
     * String kirjaimet = "a";
     * onkoJoku(mj, kirjaimet) === false;
     * kirjaimet ="aS";
     * onkoJoku(mj, kirjaimet) === false;
     * kirjaimet ="aSs";
     * onkoJoku(mj, kirjaimet) === true;
     * kirjaimet ="";
     * onkoJoku(mj, kirjaimet) === false;
     * mj = "";
     * kirjaimet ="a";
     * onkoJoku(mj, kirjaimet) === false;
     * </pre>
     */
    public static boolean onkoJoku(String mj, String kirjaimet) {
        // Merkkijono ei sisällä tyhjän merkkijonon merkkiä, tyhjä merkkijono ei sisällä minkään merkkijonon merkkejä.
        if (kirjaimet.length() <= 0 || mj.length() <= 0) return false;  
        return mj.matches(".*["+kirjaimet+"]+.*");
    
    }

    /**
     * Tutkii onko merkkijonossa muita kirjaimia kuin annetussa merkkijonossa
     * @param mj merkkijono jota tutkitaan
     * @param vertaa annettu merkkijono johon verrataan
     * @return true jos merkkijonossa mj on joitakin muita merkkejä kuin vertaa-jonossa, false muuten
     * @example
     * <pre name="test">
     * String testi = "Testi";
     * String vertaa = "esi";
     * onkoMuita(testi,vertaa) === true;
     * vertaa = "esti";
     * onkoMuita(testi,vertaa) === true;
     * vertaa = "eTsti";
     * onkoMuita(testi,vertaa) === false;
     * testi = "isopahasusi";
     * vertaa = "isuahpo";
     * onkoMuita(testi,vertaa) === false;
     * vertaa = "";
     * onkoMuita(testi,vertaa) === true;
     * testi = "";
     * vertaa = "a";
     * onkoMuita(testi,vertaa) === false;
     * </pre>
     */
    public static boolean onkoMuita(String mj, String vertaa) {
        // Nämä voisi jättää pois, jos määrittelee throws exception?
        if (vertaa.length() <= 0) return true;  // Merkkijonossa on aina muita merkkejä kuin tyhjässä merkkijonossa
        if (mj.length() <= 0) return false;     // tyhjässä merkkijonossa ei ole muita merkkejä kuin ei tyhjässä merkkijonossa    
        return !mj.matches("[" +vertaa + "]+");
    }
    
    
    /**
     * Palauttaa merkkijonon viimeisen indeksin, josta annettu merkki löytyy. Isot ja pienet kirjaimet luetaan eri merkeiksi.
     * @param mj merkkijono
     * @param merkki merkki jota etsitään 
     * @return viimeisen merkin paikka 
     * @example
     * <pre name="test">
     * String mj = "Siiseli on mahtava";
     * viimeinen(mj, 'i') === 6;
     * viimeinen(mj, 'l') === 5;
     * viimeinen(mj, 's') === 3;
     * viimeinen(mj, 'S') === 0;
     * viimeinen(mj, ' ') === 10;
     * viimeinen(mj, 'T') === -1;
     * mj = "";
     * viimeinen(mj, 'a') === -1;
     * </pre>
     */
    public static int viimeinen(String mj, char merkki) {
        return mj.lastIndexOf(merkki);  // Jos halutaan poistaa isojen ja pienten huomiointi, lisätään mj.toLowerCase,LastIndexOf...
    }
    
    
    /**
     * Tutkii onko sana palindromi. Ei välitetä isoista ja pienistä kirjaimista
     * @param sana tutkittava sana
     * @return true jos on, false jos ei ole
     * @example
     * <pre name="test">
     * String sana = "abba";
     * palindromi(sana) === true;
     * sana = "apua";
     * palindromi(sana) === false;
     * sana = "saippuakauppias";
     * palindromi(sana) === true;
     * sana = "Saippuakauppias";
     * palindromi(sana) === true;
     * </pre>
     */
    public static boolean palindromi(String sana) {
        int viimeinen = sana.length() -1;
        String sanaLower = sana.toLowerCase();
        int i = 0;
        while ( i  < viimeinen-i) {
            if (sanaLower.charAt(i) != sanaLower.charAt(viimeinen-i)) return false;
            i++;
        }
        return true;
   }

}
