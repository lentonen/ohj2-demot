package demo.d3.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d3.Esiintymat.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.01.29 10:44:26 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class EsiintymatTest {



  // Generated by ComTest BEGIN
  /** testPoistaEsiintymat27 */
  @Test
  public void testPoistaEsiintymat27() {    // Esiintymat: 27
    assertEquals("From: Esiintymat line: 28", "Cc", poistaEsiintymat("Catcat", "at")); 
    assertEquals("From: Esiintymat line: 29", "Pi", poistaEsiintymat("Paatti", "at")); 
    assertEquals("From: Esiintymat line: 30", "Puit", poistaEsiintymat("Puatit", "at")); 
    assertEquals("From: Esiintymat line: 31", "iu", poistaEsiintymat("atiu", "at")); 
    assertEquals("From: Esiintymat line: 32", "iu", poistaEsiintymat("atatiu", "at")); 
    assertEquals("From: Esiintymat line: 33", "ksa", poistaEsiintymat("kissaisis", "is")); 
  } // Generated by ComTest END
}