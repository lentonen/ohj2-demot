package demo.d10.bonus.test;
// Generated by ComTest BEGIN
import java.io.ByteArrayOutputStream;
import demo.d10.bonus.Koulu;
import static org.junit.Assert.*;
import org.junit.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.18 13:22:47 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class KouluTest {



  // Generated by ComTest BEGIN
  /** testLisaa109 */
  @Test
  public void testLisaa109() {    // Koulu: 109
    ByteArrayOutputStream bs  = new ByteArrayOutputStream(); 
    String alku =  "%n%nLuokka: 1b oppilaita: %d%n" +
    "==========================================%n"; 
    String loppu = "==========================================%n"; 
    String t = ""; 
    Koulu luokka = new Koulu("1b"); 
    ; 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 126", String.format(alku+(t="")+loppu,0), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Ankka Aku",5.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 127", String.format(alku+(t+="Ankka Aku              keskiarvo:  5.00%n")+loppu,1), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Ankka Tupu",7.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 128", String.format(alku+(t+="Ankka Tupu             keskiarvo:  7.00%n")+loppu,2), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Hiiri Mikki",9.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 129", String.format(alku+(t+="Hiiri Mikki            keskiarvo:  9.00%n")+loppu,3), bs.toString()); bs.reset();  
    luokka.poistaKaikki(); 
    ; 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 140", String.format(alku+(t="")+loppu,0), bs.toString()); bs.reset();  
    luokka.lisaa(new Koulu.Oppilas("Hiiri Mikki",9.0)); 
    luokka.tulosta(bs); 
    assertEquals("From: Koulu line: 141", String.format(alku+(t+="Hiiri Mikki            keskiarvo:  9.00%n")+loppu,1), bs.toString()); bs.reset();  
    Koulu kakkosluokka = new Koulu("2a"); 
    kakkosluokka.lisaa(new Koulu.Oppilas("Seppo Siili",7.5)); 
    assertEquals("From: Koulu line: 146", "Seppo Siili            keskiarvo:  7.50", kakkosluokka.annaEka().toString()); 
    assertEquals("From: Koulu line: 147", 1, kakkosluokka.oppilasMaara()); 
    assertEquals("From: Koulu line: 148", "Seppo Siili            keskiarvo:  7.50", kakkosluokka.annaEka().toString()); 
    assertEquals("From: Koulu line: 149", "Seppo Siili            keskiarvo:  7.50", kakkosluokka.annaVika().toString()); 
    kakkosluokka.lisaa(new Koulu.Oppilas("Keijo Kala",9.5)); 
    assertEquals("From: Koulu line: 151", "Keijo Kala             keskiarvo:  9.50", kakkosluokka.annaEka().annaSeuraava().toString()); 
    assertEquals("From: Koulu line: 152", 2, kakkosluokka.oppilasMaara()); 
    assertEquals("From: Koulu line: 153", "Seppo Siili            keskiarvo:  7.50", kakkosluokka.annaEka().toString()); 
    assertEquals("From: Koulu line: 154", "Keijo Kala             keskiarvo:  9.50", kakkosluokka.annaVika().toString()); 
    kakkosluokka.lisaa(new Koulu.Oppilas("Sulo Siiseli",4.5)); 
    assertEquals("From: Koulu line: 156", "Sulo Siiseli           keskiarvo:  4.50", kakkosluokka.annaEka().annaSeuraava().annaSeuraava().toString()); 
    assertEquals("From: Koulu line: 157", 3, kakkosluokka.oppilasMaara()); 
    assertEquals("From: Koulu line: 158", "Seppo Siili            keskiarvo:  7.50", kakkosluokka.annaEka().toString()); 
    assertEquals("From: Koulu line: 159", "Sulo Siiseli           keskiarvo:  4.50", kakkosluokka.annaVika().toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testPoistaKaikki176 */
  @Test
  public void testPoistaKaikki176() {    // Koulu: 176
    Koulu kolmosluokka = new Koulu("3a"); 
    kolmosluokka.lisaa(new Koulu.Oppilas("Seppo Siili",7.5)); 
    kolmosluokka.lisaa(new Koulu.Oppilas("Keijo Kala",9.5)); 
    kolmosluokka.lisaa(new Koulu.Oppilas("Sulo Siiseli",4.5)); 
    assertEquals("From: Koulu line: 181", 3, kolmosluokka.oppilasMaara()); 
    kolmosluokka.poistaKaikki(); 
    assertEquals("From: Koulu line: 183", 0, kolmosluokka.oppilasMaara()); 
    assertEquals("From: Koulu line: 184", null, kolmosluokka.annaEka()); 
    assertEquals("From: Koulu line: 185", null, kolmosluokka.annaVika()); 
  } // Generated by ComTest END
}