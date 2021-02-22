/**
 * 
 */
package demo.d7;

/**
 * Mäkihyppy-luokka, jossa on kilpailijoita
 */
public class Makihyppy {
    private Kilpailija[] kilpailijat;
    public static void main(String[] args) {
        // ei tehdä vielä mitään
    }

}

/**
 * Kilpailija-luokka. Kilpailijoilla on nimi, nro ja tulokset.
 */
class Kilpailija {
    private String nimi;
    private int nro;
    private Tulokset tulokset;
 }


/**
 *Tulokset-luokka. Tulokset koostuvat yksittäisten kierrosten tuloksista
 *sekä lopputuloksesta.
 */
class Tulokset {
    private Tulos[] kierrokset;
    private double lopputulos;
 }


/**
 *Tulos-luokka. Tuloksessa on yksittäisen kierroksen hypyn pituus,
 *tuomaripisteet sekä kokonaispisteet.
 */
class Tulos {
    private int pituus;
    private double[] tuomarit;
    private int pisteet;
 }
