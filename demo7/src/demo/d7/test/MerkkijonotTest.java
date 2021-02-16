package demo.d7.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d7.Merkkijonot.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.16 20:07:10 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class MerkkijonotTest {


  // Generated by ComTest BEGIN
  /** testOnkoJoku110 */
  @Test
  public void testOnkoJoku110() {    // Merkkijonot: 110
    String mj = "Testi"; 
    String kirjaimet = "a"; 
    assertEquals("From: Merkkijonot line: 113", false, onkoJoku(mj, kirjaimet)); 
    kirjaimet ="aS"; 
    assertEquals("From: Merkkijonot line: 115", false, onkoJoku(mj, kirjaimet)); 
    kirjaimet ="aSs"; 
    assertEquals("From: Merkkijonot line: 117", true, onkoJoku(mj, kirjaimet)); 
    kirjaimet =""; 
    assertEquals("From: Merkkijonot line: 119", false, onkoJoku(mj, kirjaimet)); 
    mj = ""; 
    kirjaimet ="a"; 
    assertEquals("From: Merkkijonot line: 122", false, onkoJoku(mj, kirjaimet)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testOnkoMuita138 */
  @Test
  public void testOnkoMuita138() {    // Merkkijonot: 138
    String testi = "Testi"; 
    String vertaa = "esi"; 
    assertEquals("From: Merkkijonot line: 141", true, onkoMuita(testi,vertaa)); 
    vertaa = "esti"; 
    assertEquals("From: Merkkijonot line: 143", true, onkoMuita(testi,vertaa)); 
    vertaa = "eTsti"; 
    assertEquals("From: Merkkijonot line: 145", false, onkoMuita(testi,vertaa)); 
    testi = "isopahasusi"; 
    vertaa = "isuahpo"; 
    assertEquals("From: Merkkijonot line: 148", false, onkoMuita(testi,vertaa)); 
    vertaa = ""; 
    assertEquals("From: Merkkijonot line: 150", true, onkoMuita(testi,vertaa)); 
    testi = ""; 
    vertaa = "a"; 
    assertEquals("From: Merkkijonot line: 153", false, onkoMuita(testi,vertaa)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testViimeinen170 */
  @Test
  public void testViimeinen170() {    // Merkkijonot: 170
    String mj = "Siiseli on mahtava"; 
    assertEquals("From: Merkkijonot line: 172", 6, viimeinen(mj, 'i')); 
    assertEquals("From: Merkkijonot line: 173", 5, viimeinen(mj, 'l')); 
    assertEquals("From: Merkkijonot line: 174", 3, viimeinen(mj, 's')); 
    assertEquals("From: Merkkijonot line: 175", 0, viimeinen(mj, 'S')); 
    assertEquals("From: Merkkijonot line: 176", 10, viimeinen(mj, ' ')); 
    assertEquals("From: Merkkijonot line: 177", -1, viimeinen(mj, 'T')); 
    mj = ""; 
    assertEquals("From: Merkkijonot line: 179", -1, viimeinen(mj, 'a')); 
  } // Generated by ComTest END
}