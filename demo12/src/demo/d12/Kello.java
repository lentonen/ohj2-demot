package demo.d12;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * Tarkistetaan kellonaika. Jos syötetty kellonaika on väärin, kerrotaan mistä vikaa tulee etsiä.
 */
public class Kello {
    
    
    /**
     * tarkistaa onko annettu jono kellonaika
     * @param jono josta kellonaikaa etsitään
     * @return null jos jono on ok, virheilmoitus ja ohjeet oikeasta muodosta jos ongelmia.
     * @example
     * <pre name="test">
     * Kello kello = new Kello();
     * kello.tarkista("12:30") === null;
     * kello.tarkista("09:23") === null;
     * kello.tarkista("9:23") === null;
     * kello.tarkista("23:59") === null;
     * kello.tarkista("00:00") === null;
     * 
     * kello.tarkista("kissa") === "Kellonaika \"kissa\" on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
     * kello.tarkista("12 30") === "Kellonajan \"12 30\" välimerkki on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
     * kello.tarkista("12.30") === "Kellonajan \"12.30\" välimerkki on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
     * kello.tarkista("1230") === "Kellonajan \"1230\" välimerkki on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
     * kello.tarkista("12:301") === "Kellonaika \"12:301\" on virheellinen. Ilmoita minuutit kahdella numerolla väliltä 00-59.";
     * kello.tarkista(":30") === "Kellonaika \":30\" on virheellinen. Ilmoita tunnit yhdellä tai kahdella numerolla.";
     * kello.tarkista("25:23") === "Kellonaika \"25:23\" on virheellinen. Tarkista tunnit.";
     * kello.tarkista("01:65") === "Kellonaika \"01:65\" on virheellinen. Tarkista minuutit.";
     * </pre>
     */
    public String tarkista(String jono) {
        if (jono.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$"))  // Jos on oikeaa muotoa niin lopetetaan heti
            return null;
        if (!jono.matches(".*\\d.*")) return "Kellonaika \"" +jono +"\" on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
        if (!(jono.contains(":"))) return "Kellonajan \"" +jono +"\" välimerkki on virheellinen. Ilmoita kellonaika muodossa \"hh:mm\".";
       
        StringBuilder sb = new StringBuilder(jono);
        String tunnitMerkkeinä = Mjonot.erota(sb, ':');
        String minuutitMerkkeinä = sb.toString();
        if (minuutitMerkkeinä.length() != 2 ) return "Kellonaika \"" +jono +"\" on virheellinen. Ilmoita minuutit kahdella numerolla väliltä 00-59.";
        if (tunnitMerkkeinä.length() > 2 || tunnitMerkkeinä.length() == 0 )    return "Kellonaika \"" +jono +"\" on virheellinen. Ilmoita tunnit yhdellä tai kahdella numerolla.";
        
        int tunnit = Integer.parseInt(tunnitMerkkeinä);
        int minuutit = Integer.parseInt(minuutitMerkkeinä);
        if (0 > tunnit ||  tunnit > 23 ) return "Kellonaika \"" +jono +"\" on virheellinen. Tarkista tunnit.";
        if (0 > minuutit || minuutit > 59) return "Kellonaika \"" +jono +"\" on virheellinen. Tarkista minuutit.";
        return null;
    }
    

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Kello kello = new Kello();
        String virhe = kello.tarkista("3:00");
        System.out.println(virhe);
        virhe = kello.tarkista("kissa");
        System.out.println(virhe);
        virhe = kello.tarkista("12.30");
        System.out.println(virhe);
        virhe = kello.tarkista("12:123");
        System.out.println(virhe);
        virhe = kello.tarkista(":12");
        System.out.println(virhe);
        virhe = kello.tarkista("24:12");
        System.out.println(virhe);
        virhe = kello.tarkista("15:61");
        System.out.println(virhe);
    }
}
