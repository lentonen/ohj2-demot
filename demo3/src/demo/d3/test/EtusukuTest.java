package demo.d3.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d3.Etusuku.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.01 11:04:35 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class EtusukuTest {



  // Generated by ComTest BEGIN
  /** testErota23 */
  @Test
  public void testErota23() {    // Etusuku: 23
    StringBuilder jono = new StringBuilder("123 456"); String s; 
    s = erota(jono,' ',false); jono.toString().equals("456"); s.equals("123"); 
    s = erota(jono,' ',false); jono.toString().equals(""); s.equals("456"); 
    jono = new StringBuilder("1 2 3"); 
    erota(jono,' ',false).equals("1"); 
    erota(jono,' ',false).equals("2"); 
    erota(jono,' ',false).equals("3"); 
    erota(jono,' ',false).equals(""); 
    erota(jono,' ',false).equals(""); 
    jono = new StringBuilder("123 456 789"); 
    erota(jono,' ',true).equals("123 456"); 
    erota(jono,' ',true).equals("789"); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testErota62 */
  @Test
  public void testErota62() {    // Etusuku: 62
    StringBuilder jono = new StringBuilder("1 2 3"); 
    assertEquals("From: Etusuku line: 64", "1", erota(jono,' ')); 
    assertEquals("From: Etusuku line: 65", "2", erota(jono,' ')); 
    assertEquals("From: Etusuku line: 66", "3", erota(jono,' ')); 
    assertEquals("From: Etusuku line: 67", "", erota(jono,' ')); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testErota80 */
  @Test
  public void testErota80() {    // Etusuku: 80
    StringBuilder jono = new StringBuilder("1 2 3"); 
    assertEquals("From: Etusuku line: 82", "1", erota(jono)); 
    assertEquals("From: Etusuku line: 83", "2", erota(jono)); 
    assertEquals("From: Etusuku line: 84", "3", erota(jono)); 
    assertEquals("From: Etusuku line: 85", "", erota(jono)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testVaihdaAlkuLoppu101 */
  @Test
  public void testVaihdaAlkuLoppu101() {    // Etusuku: 101
    vaihdaAlkuLoppu("Aku Ankka", ' ', false).equals("Ankka Aku"); 
    vaihdaAlkuLoppu("Jukka Pekka Palo", ' ', true).equals("Palo Jukka Pekka"); 
    vaihdaAlkuLoppu("Aku", ' ', false).equals("Aku"); 
    vaihdaAlkuLoppu("", ' ', false).equals(""); 
    vaihdaAlkuLoppu("toimii.tama", '.', false).equals("tama.toimii"); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testVaihdaEtuSuku124 */
  @Test
  public void testVaihdaEtuSuku124() {    // Etusuku: 124
    vaihdaEtuSuku("").equals(""); 
    vaihdaEtuSuku(" ").equals(""); 
    vaihdaEtuSuku("Pele").equals("Pele"); 
    vaihdaEtuSuku("Aku Ankka").equals("Ankka Aku"); 
    vaihdaEtuSuku("Jukka Pekka Palo").equals("Palo Jukka Pekka"); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testVaihdaSukuEtu143 */
  @Test
  public void testVaihdaSukuEtu143() {    // Etusuku: 143
    vaihdaSukuEtu("").equals(""); 
    vaihdaSukuEtu("Pele").equals("Pele"); 
    vaihdaSukuEtu("Ankka Aku").equals("Aku Ankka"); 
    vaihdaSukuEtu("Palo Jukka Pekka").equals("Jukka Pekka Palo"); 
  } // Generated by ComTest END
}