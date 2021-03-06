package demo.d9.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import demo.d9.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.12 17:41:11 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaulukkoTest {



  // Generated by ComTest BEGIN
  /** 
   * testTaulukko8 
   * @throws Taulukko.TaulukkoTaysiException when error
   */
  @Test
  public void testTaulukko8() throws Taulukko.TaulukkoTaysiException {    // Taulukko: 8
    Taulukko luvut = new Taulukko(); 
    luvut.lisaa(0); luvut.lisaa(2); luvut.lisaa(99); 
    assertEquals("From: Taulukko line: 12", "0,2,99", luvut.toString()); 
    luvut.set(1,4); assertEquals("From: Taulukko line: 13", "0,4,99", luvut.toString()); 
    int luku = luvut.get(2); 
    assertEquals("From: Taulukko line: 15", 99, luku); 
    assertEquals("From: Taulukko line: 16", 99, luvut.get(2)); 
    try {
    luvut.set(21, 4); 
    fail("Taulukko: 17 Did not throw IndexOutOfBoundsException");
    } catch(IndexOutOfBoundsException _e_){ _e_.getMessage(); }
    luvut.lisaa(0); luvut.lisaa(0);  //taulukko täyteen
    try {
    luvut.lisaa(0); 
    fail("Taulukko: 19 Did not throw Taulukko.TaulukkoTaysiException");
    } catch(Taulukko.TaulukkoTaysiException _e_){ _e_.getMessage(); }
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testClone107 */
  @Test
  public void testClone107() {    // Taulukko: 107
    Taulukko luvut = new Taulukko(5); 
    luvut.lisaa(1); luvut.lisaa(2); 
    Taulukko luvut2 = luvut.clone(); 
    assertEquals("From: Taulukko line: 111", "1,2", luvut2.toString()); 
    luvut.lisaa(3); 
    assertEquals("From: Taulukko line: 113", "1,2", luvut2.toString()); 
    assertEquals("From: Taulukko line: 114", "1,2,3", luvut.toString()); 
    luvut2.lisaa(4); 
    assertEquals("From: Taulukko line: 116", "1,2,4", luvut2.toString()); 
    assertEquals("From: Taulukko line: 117", "1,2,3", luvut.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testPoista134 */
  @Test
  public void testPoista134() {    // Taulukko: 134
    Taulukko luvut2 = new Taulukko(7); 
    luvut2.lisaa(1); luvut2.lisaa(2); luvut2.lisaa(1); 
    assertEquals("From: Taulukko line: 137", "1,2,1", luvut2.toString()); 
    luvut2.poista(2); 
    assertEquals("From: Taulukko line: 139", "1,1", luvut2.toString()); 
    luvut2.poista(1); 
    assertEquals("From: Taulukko line: 141", "", luvut2.toString()); 
    luvut2.poista(1); 
    assertEquals("From: Taulukko line: 143", "", luvut2.toString()); 
  } // Generated by ComTest END
}