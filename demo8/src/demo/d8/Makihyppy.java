/**
 * 
 */
package demo.d8;


/**
 * Mäkihyppy-luokka, jossa on kilpailijoita
 */
public class Makihyppy {
    
    
    
    /**
     * Pääohjelma mäkikisalle
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Makihyppy kisa = new Makihyppy(); 
        kisa.kisa(); 
    }
    
    
    /**
     * Käynnistää kisan
     */
    public void kisa() { 
        Kilpailija toni = new Kilpailija("Toni",3); 
        Kilpailija matti = new Kilpailija("Matti",7); 
        toni.tulosta(); 
        matti.tulosta(); 

        toni.setPituus(1,107);       // 1. kierros, 107 m
        toni.setPituus(2,100);       // 2. kierros, 100 m
        toni.setTuomari(2,1,19.0);   // 2. kierros, 1. tuomari, 19 p 
        toni.setTuomari(2,2,18.0);   // 2. kierros, 2. tuomari, 18 p
        toni.setTuomari(2,3,19.5); 
        toni.setTuomari(2,4,18.0); 
        toni.setTuomari(2,5,20.0); 

        matti.setPituus(1,125); 
        matti.setTuomari(1,1,20.0); 
        matti.setTuomari(1,2,20.0); 
        matti.setTuomari(1,3,20.0); 
        matti.setTuomari(1,4,20.0); 
        matti.setPituus(2,109); 
        matti.setTuomari(2,1,20.0); 
        matti.setTuomari(2,2,20.0); 
        matti.setTuomari(2,3,20.0); 
        matti.setTuomari(2,4,20.0); 

        toni.tulosta(); 
        matti.tulosta();
        
        if (toni.annaLoppuTulos() > matti.annaLoppuTulos())
            System.out.println("Voittaja on Toni!");
        else 
            System.out.println("Voittaja on Matti!");
    }
}


//-------------------------------------------------------------------------------------------

/**
 * Kilpailija-luokka. Kilpailijoilla on nimi, nro ja tulokset.
 */
class Kilpailija {
    private String nimi;
    private int nro;
    private Tulokset tulokset;
    
    
    /**
     * Muodostaja kilpailijalle
     * @param nimi kilpailijan nimi
     * @param nro kilpailijan numero
     */
    public Kilpailija (String nimi, int nro) {
        this.nimi = nimi;
        this.nro = nro;
        this.tulokset = new Tulokset();
    }
    
    
    /**
     * Saantimetodi nimelle
     * @return kilpailijan nimi
     */
    public String annaNimi() {
        return this.nimi;
    }

    
    /**
     * Tulostaa kilpailijan tiedot
     */
    public void tulosta () {
        System.out.println("" +nro +": " +nimi +"\n"
                +"Kierros 1   " +getPituus(1) +" m  Tuomarit:  " +taulukkoMerkkijonoksi(getTuomariPisteet(1)) +"=  " +annaPisteet(1) + " pistettä"  + "\n"
                +"Kierros 2   " +getPituus(2) +" m  Tuomarit:  " +taulukkoMerkkijonoksi(getTuomariPisteet(2)) +"=  " +annaPisteet(2) + " pistettä"  + "\n"
                +"Yhteensä:   " +annaLoppuTulos()    +"    pistettä"+"\n");
    }
    
    
    /**
     * Asettaa tuomaripisteet
     * @param kierros mille kierrokselle pisteet annetaan
     * @param tuomari monesko tuomari pisteitä antaa
     * @param pisteet paljonko pisteitä annetaan
     */
    public void setTuomari(int kierros, int tuomari, double pisteet) {
        tulokset.setTuomari(kierros, tuomari, pisteet);     
    }

    
    /**
     * Asettaa hypyn pituuden
     * @param kierros mille kierrokselle pituus asetetaan
     * @param pituus hypyn pituus
     */
    public void setPituus(int kierros, double pituus) {
        tulokset.setPituus(kierros, pituus);
    }
    

    /**
     * Saantimetodi tuloksille
     * @return tulokset
     */
    public Tulokset getTulokset() {
        return this.tulokset;
    }
    
    
    /**
     * saantimedodi pituudelle
     * @param kierros minkä kierroksen hyppy halutaan selvittää
     * @return hypyn pituus
     */
    public double getPituus(int kierros) {
        return getTulokset().pituus(kierros);
    }
    
    
    /**
     * Saantimetodi tuomaripisteille
     * @param kierros minkä kierroksen tuomaripisteet halutaan
     * @return tuomaripisteet
     */
    public double[] getTuomariPisteet(int kierros) {
        return getTulokset().tuomariPisteet(kierros);
    }
    
    
    public double annaLoppuTulos() {
        return tulokset.annaLopputulos();
    }
    
    
    /**
     * Muuttaa taulukon merkkijonoksi
     * @param t taulukko joka muutetaan
     * @return taulukko merkkijonona
     */
    public String taulukkoMerkkijonoksi(double[] t)  {
        int pituus = t.length;
        StringBuilder mj = new StringBuilder("");
        for (int i = 0; i < pituus; i++) {
            mj.append(t[i]);
            mj.append("  ");
        }  
        return mj.toString();
    }
    
    
    /**
     * Antaa valitun kierroksen pisteet
     * @param kierros minkä kierroksen pisteet lasketaan
     * @return kierroksen pisteet
     */
    public double annaPisteet(int kierros) {
        return tulokset.annaPisteet(kierros);
    }  
 }


//-----------------------------------------------------------------------------------------

/**
 *Tulokset-luokka. Tulokset koostuvat yksittäisten kierrosten tuloksista
 *sekä lopputuloksesta.
 */
class Tulokset {
    private Kierros[] kierrokset;
    private double lopputulos;
    
    
    /**
     * Muodostaja Tulokset-oliolle.
     */
    public Tulokset() {
        this.kierrokset = new Kierros[2];
        this.kierrokset[0] = new Kierros();
        this.kierrokset[1] = new Kierros();
    }
    
    
    /**
     * Antaa kilpailijan lopputuloksen
     * @return lopputulos
     */
    public double annaLopputulos() {
        return this.lopputulos;    
    }

    
    /**
     * Asettaa valitun kierroksen tuomaripisteet valitulle tuomarille
     * @param kierros mille kierrokselle tuomaripisteet annetaan
     * @param tuomari mikä tuomari pisteitä antaa
     * @param pisteet paljonko pisteitä tuomari antaa
     */
    public void setTuomari(int kierros, int tuomari, double pisteet) {
        this.annaKierros(kierros).setTuomari(tuomari, pisteet);
        paivitaLoppuTulos();      
    }


    /**
     * Asettaa valitun kierroksen hypyn pituuden. Päivittää samalla lopputulosta.
     * @param kierros kierros jolle pituus asetetaan
     * @param pituus hypyn pituus
     */
    public void setPituus(int kierros, double pituus) {
        annaKierros(kierros).setPituus(pituus);
        paivitaLoppuTulos();
    }
    
    
    /**
     * Päivittää lopputuloksen kierrosten 1 ja 2 pisteiden avulla.
     */
    private void paivitaLoppuTulos() {
        this.lopputulos = annaKierros(1).annaPisteet() + annaKierros(2).annaPisteet();   
    }


    /**
     * Saantimetodi yksittäiselle kierrokselle
     * @param i mitä kierrosta haetaan
     * @return kierros
     */
    public Kierros annaKierros(int i) {
        return kierrokset[i-1];
    }
    
    
    /**
     * Antaa valitun kierroksen pisteet
     * @param kierros kierros jonka pisteet halutaan
     * @return kierroksen pisteet
     */
    public double annaPisteet(int kierros) {
        return annaKierros(kierros).annaPisteet();
    }


    /**
     * Saantimetodi kierroksen pisteille
     * @param kierros minkä kierroksen pisteet annetaan
     * @return valitun kierroksen pisteet taulukkona
     */
    public double[] tuomariPisteet(int kierros) {
        return annaKierros(kierros).tuomaripisteet();
    }


    /**
     * Palauttaa kierroksen hypyn pituuden
     * @param kierros kierros jonka hypyn pituus palautetaan
     * @return hypyn pituus
     */
    public double pituus(int kierros) {
        return kierrokset[kierros-1].getPituus();
    }
    
    
    /**
     * Saantimetodi lopputulokselle
     * @return lopputulos
     */
    public double getLopputulos() {
        return this.lopputulos;
    }

    
    /**
     * Saantimetodi tuloksille
     * @return lopputulos
     */
    public Kierros[] getKierrokset() {
        return this.kierrokset;
    }
 }


//-----------------------------------------------------------------------------------------


/**
 *Kierros-luokka. Luokalla on yksittäisen kierroksen hypyn pituus,
 *tuomaripisteet sekä kokonaispisteet.
 */
class Kierros {
    private final static int TUOMAREITA = 5;
    private double pituus;
    private double[] tuomarit;
    private double pisteet;
    
    
    /**
     * Muodostaja Kierros-oliolle.
     */
    public Kierros() {
        this.tuomarit = new double[TUOMAREITA];
    }
    

    /**
     * Asettaa hypyn pituuden ja päivittää kierroksen pisteet
     * @param pituus hypyn pituus
     */
    public void setPituus(double pituus) {
        this.pituus = pituus;
        laskePisteet();
    }
    
    
    /**
     * Laskee pisteet olion attribuuttien avulla.
     */
    private void laskePisteet() {
        double K_PISTE = 60.0;
        double METRIKERROIN = 1.0;
        double summa = demo.d7.Taulukot.summaHuonoinJaParasPois(tuomarit);
        this.pisteet = summa > 0 ? METRIKERROIN * this.pituus - K_PISTE + summa : 0;  
    }

    
    /**
     * Asettaa tuomaripisteet. Pisteiden asettamisen jälkeen päivittää kierroksen pisteet
     * @param tuomari mille tuomarille pisteitä laitetaan
     * @param pisteet pisteiden määrä
     */
    public void setTuomari(int tuomari, double pisteet) {
        this.tuomarit[tuomari -1] = pisteet; 
        laskePisteet();
    }
    

    /**
     * Saantimetodi yksittäisen kierroksen pisteille
     * @return kierroksen pisteet
     */
    public double annaPisteet() {
        return this.pisteet;
    }

    
    /**
     * saantimetodi yksittäisen kierroksen tuomaripisteille
     * @return kierroksen tuomaripisteet
     */
    public double[] tuomaripisteet() {
        return this.tuomarit;
    }
    
    
    /**
     * Saantimetodi hypyn pituudelle
     * @return hypyn pituus
     */
    public double getPituus() {
        return this.pituus;
    }
 }
