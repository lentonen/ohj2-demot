package demo.d4.test;
// Generated by ComTest BEGIN
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d4.TaulukonMuuttaminen.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.04 21:11:03 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaulukonMuuttaminenTest {



  // Generated by ComTest BEGIN
  /** testKasitteleTaulukko28 */
  @Test
  public void testKasitteleTaulukko28() {    // TaulukonMuuttaminen: 28
    int[] t; 
    t = new int[]{55, 44, 33, 2, 5, 9}; KasitteleTaulukko(t); assertEquals("From: TaulukonMuuttaminen line: 34", "[60, 49, 38, 7, 10, 14]", Arrays.toString(t));  
    t = new int[]{23, 45, -12, 9, 0, -5}; KasitteleTaulukko(t); assertEquals("From: TaulukonMuuttaminen line: 35", "[28, 50, -7, 14, 5, 0]", Arrays.toString(t));  
  } // Generated by ComTest END
}