/**
 * 
 */
package demo.d9;
public class KuvastaLuokat {

 
    /**
     * Luokka henkilöille. Henkilöillä nimi ja osoite, "postinumero" ja viite kavereiden määrään.
     * ESIM:
     * Kassinen Katto
     * Katto
     * 3452
     * Viite (kaverit-taulukkoon) ---> 9  
     */
    public static class Henkilo {
       private String nimi = "";
       private String osoite = "";
       private String pNro = "";
       private Integer kaverit;
       
       /**
        * Alustetaan henkilö
        * @param nimi henkilön nimi
        * @param osoite henkilön osoite
        * @param pNro henkilön postinumero
        */
        public Henkilo(String nimi, String osoite, String pNro) {
           this.nimi = nimi;
           this.osoite = osoite;
           this.pNro = pNro;
           this.kaverit = 0;
        }
        
        
        /**
         * Muuttaa henkilön merkkijonoksi
         */
        @Override
        public String toString() {
            return "" +this.nimi +"|" +this.osoite + "|" +pNro +"|kavereita:" +kaverit.intValue();
        }
        
        
        /**
         * asettaa viitteen integer-olioon, jos annettu kaverimäärä löytyy kaverit-luokassa määritellystä taulukosta.
         * @param n kaverimäärä
         */
        public void kaverit(int n) {
            this.kaverit = Kaverit.anna(n);  // kysytään kaveriluokalta viitettä olioon, jonka arvo on n.
        }
       
     }
    
    //=======================================================================    
    
    /**
     * Kaverit luokka, joka tallentaa tiedon henkilön kavereiden määrästä.
     */
    public static class Kaverit {
        private static final Integer[] maara = new Integer[] {5,9,3,2,1,0};  // Tämä kaveritaulukko on vakio, jota ei muuteta ollenkaan
        
        
        /**
         * Muuttaa kaverit-taulukon merkkijonoksi. Käyttää hyödyksi PoistaTaulukosta.Merkkijonoksi.
         */
        @Override
        public String toString() {
            int pituus = maara.length;
            int[] t = new int[pituus] ;
            for (int i = 0; i < pituus; i++) {
                t[i] = maara[i].intValue();
            }
            return PoistaTaulukosta.merkkijonoksi(t, pituus);
         }
        
        
        /**
         * antaa viitteen taulukon paikkaan, jossa sijaitsee annettu int. Palauttaa null, jos lukua ei löydy
         * @param n luku jota etsitään
         * @return viite taulukon paikkaan, jossa luku n sijaitsee. Jos ei löydetä, palautetaan null.
         */
        public static Integer anna(int n) {
            int pituus = maara.length;
            for (int i = 0; i < pituus; i++)
                if (maara[i].intValue() == n) return maara[i];
            return null;
        }
    }

    //=====================================================
    
    
    /**
     * Henkilöt-luokka, jossa kaikki lisätyt henkilöt tallennettuna taulukkoon
     */
    public static class Henkilot {
        private Henkilo[] henkilot;
        
        
        /**
         * luodaan henkilöt-luokka, jossa taulukko kaikkia henkilöitä varten.
         * @param lkm kuinka suuri taulukko luodaan henkilöiden tallentamista varten.
         */
        public Henkilot(int lkm) {
            henkilot = new Henkilo[lkm];
        }
        
        
        /**
         * tallentaa tuodun henkilön taulukkoon
         * @param henkilo tallennettava henkilö
         */
        public void tallenna(Henkilo henkilo) {
            int i = 0;
            while (henkilot[i] != null) {
                i++;
            }
            henkilot[i] = henkilo;
        }
        
        
        @Override
        public String toString() {
            StringBuilder hlot = new StringBuilder("");
            for (int i = 0; i < henkilot.length; i++)
                hlot.append(henkilot[i] +"\n");
            return hlot.toString();
        }

    }
    
    // ========================================================
    
    /**
     * kaveriApp-luokka, jossa tieto siitä, kuinka paljon henkilöt-luokan taulukkoon on tallennettu henkilöitä
     * sekä tieto taulukon koosta. Lisäksi luokasta viitteen ensimmäiseen lisättyyn jäseneen, kaverit-olioon ja henkilot-olioon.
     */
    public static class kaveriApp {
        private final int MAXHENKILOT = 7; // paljonko henkilöitä voidaan tallentaa
        private int lkm; // montako henkilöä taulukkoon on tallennettu
        private Henkilot henkilot = new Henkilot(MAXHENKILOT);
        private Henkilo ekaJasen;
        private Kaverit kaverit = new Kaverit();
        
        
        /**
         * tallennetaan henkilö taulukkoon. Kasvatetaan samalla tallennettujen henkilöiden lukumäärää.
         * @param henkilo tallennettava henkilö
         */
        public void tallenna(Henkilo henkilo) {
            if (lkm == 0) ekaJasen = henkilo;
            henkilot.tallenna(henkilo);
            lkm++;
        }
 
        
        @Override
        public String toString() {
            StringBuilder tiedot = new StringBuilder("");
                tiedot.append(MAXHENKILOT +"\n" +lkm + "\n" +"eka jäsen: " +ekaJasen +"\n\n" + "HENKILOT TAULUKKO NÄYTTÄÄ TÄLTÄ:" +"\n" +henkilot);
                
            return tiedot.toString(); 
        }
        
        
        /**
         * Pääohjelma  testaamista varten
         * @param args ei käytössä
         */
        public static void main(String[] args) {
            kaveriApp sovellus = new kaveriApp(); 
            Henkilo kassinen = new Henkilo("Kassinen Katto", "Katto", "3452");         
            Henkilo sepe = new Henkilo("Susi Sepe", "Takametsä", "-");
            //System.out.println(kassinen);
            
            sovellus.tallenna(kassinen);
            sovellus.tallenna(kassinen);
            sovellus.tallenna(sepe);
            

            kassinen.kaverit(9);  // Yritetään laittaa kassiselle 9 kaveri. Ei onnistu jos lukua ei löydy kaverit-taulukosta. Tällöin otetaan kiinni poikkeus.
            sepe.kaverit(2);      // Ei toimi järkevästi, jos laitetaan jokin sellainen määrä, jota ei taulukosta löydy. Tällöin tulostaminen ei onnistu. 
                                  // Rakenne vastaa kuitenkin käsittääkseni tehtävänantoa, vaikka toiminnallisuus onkin hieman kökköä.
            
            System.out.println(sovellus.henkilot);
            System.out.println();
            System.out.println(sovellus);
            System.out.println("Kaverit-taulukko näyttää tältä:");
            System.out.println(sovellus.kaverit);
        
        }
    }
}
