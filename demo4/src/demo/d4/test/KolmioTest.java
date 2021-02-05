package demo.d4.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d4.Kolmio.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.04 21:10:42 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class KolmioTest {



  // Generated by ComTest BEGIN
  /** testKolmionAla29 */
  @Test
  public void testKolmionAla29() {    // Kolmio: 29
    assertEquals("From: Kolmio line: 30", 6, kolmionAla(3.0, 4.0), 0.000001); 
    assertEquals("From: Kolmio line: 31", 0, kolmionAla(0.0, 4.0), 0.000001); 
    assertEquals("From: Kolmio line: 32", 0, kolmionAla(3.0, 0.0), 0.000001); 
    assertEquals("From: Kolmio line: 33", 0, kolmionAla(0.0, 0.0), 0.000001); 
    assertEquals("From: Kolmio line: 34", 3.5, kolmionAla(3.5, 2.0), 0.000001); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testHypotenuusa48 */
  @Test
  public void testHypotenuusa48() {    // Kolmio: 48
    assertEquals("From: Kolmio line: 49", 5.0, hypotenuusa(3.0, 4.0), 0.000001); 
    assertEquals("From: Kolmio line: 50", 0, hypotenuusa(0.0, 4.0), 0.000001); 
    assertEquals("From: Kolmio line: 51", 0, hypotenuusa(3.0, 0.0), 0.000001); 
    assertEquals("From: Kolmio line: 52", 0, hypotenuusa(0.0, 0.0), 0.000001); 
    assertEquals("From: Kolmio line: 53", 7.071067, hypotenuusa(5.0, 5.0), 0.000001); 
  } // Generated by ComTest END
}