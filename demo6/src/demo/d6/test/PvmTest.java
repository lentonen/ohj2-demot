package demo.d6.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d6.Pvm.*;
import demo.d6.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.25 09:19:11 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class PvmTest {



  // Generated by ComTest BEGIN
  /** testPvm25 */
  @Test
  public void testPvm25() {    // Pvm: 25
    Pvm pv1 = new Pvm (15, 3, 2015); 
    assertEquals("From: Pvm line: 27", "15.3.2015", pv1.toString()); 
    Pvm pv2 = new Pvm (45, 3, 2015); 
    assertEquals("From: Pvm line: 30", "0.0.0", pv2.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testKarkausvuosi99 */
  @Test
  public void testKarkausvuosi99() {    // Pvm: 99
    assertEquals("From: Pvm line: 100", 0, karkausvuosi(1900));
    assertEquals("From: Pvm line: 101", 0, karkausvuosi(1900));
    assertEquals("From: Pvm line: 102", 0, karkausvuosi(1901));
    assertEquals("From: Pvm line: 103", 1, karkausvuosi(1996));
    assertEquals("From: Pvm line: 104", 1, karkausvuosi(2000));
    assertEquals("From: Pvm line: 105", 0, karkausvuosi(2001));
    assertEquals("From: Pvm line: 106", 1, karkausvuosi(2004));
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testAlusta141 */
  @Test
  public void testAlusta141() {    // Pvm: 141
    Pvm pvm = new Pvm(20,2,2012); 
    pvm.alusta(1,3,0); assertEquals("From: Pvm line: 143", "1.3.2012", pvm.toString()); 
    pvm.alusta(2,13,2012); assertEquals("From: Pvm line: 144", "1.3.2012", pvm.toString()); 
    pvm.alusta(28,2,2012); assertEquals("From: Pvm line: 145", "28.2.2012", pvm.toString()); 
    pvm.alusta(29,2,2011); assertEquals("From: Pvm line: 146", "28.2.2012", pvm.toString()); 
    pvm.alusta(29,2,2012); assertEquals("From: Pvm line: 147", "29.2.2012", pvm.toString()); 
    pvm.alusta(31,3,2012); assertEquals("From: Pvm line: 148", "31.3.2012", pvm.toString()); 
    pvm.alusta(31,4,2012); assertEquals("From: Pvm line: 149", "31.3.2012", pvm.toString()); 
    pvm.alusta( 0,2,2012); assertEquals("From: Pvm line: 150", "31.3.2012", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testCompareTo182 */
  @Test
  public void testCompareTo182() {    // Pvm: 182
    Pvm pv1 = new Pvm(15,6,2013); 
    Pvm pv2 = new Pvm(14,5,2014); 
    Pvm pv3 = new Pvm(15,7,2014); 
    Pvm pv4 = new Pvm(16,7,2014); 
    Pvm pv5 = new Pvm(16,7,2014); 
    Pvm pv6 = new Pvm(16,7,2012); 
    assertEquals("From: Pvm line: 189", -1, Pvm.compareTo(pv1,pv2));  // ero vuodessa
    assertEquals("From: Pvm line: 190", 1, Pvm.compareTo(pv2,pv1)); 
    assertEquals("From: Pvm line: 191", -1, Pvm.compareTo(pv2,pv3));  // ero kuukaudessa
    assertEquals("From: Pvm line: 192", 1, Pvm.compareTo(pv3,pv2)); 
    assertEquals("From: Pvm line: 193", -1, Pvm.compareTo(pv3,pv4));  // ero p??iv??ss??
    assertEquals("From: Pvm line: 194", 1, Pvm.compareTo(pv4,pv3)); 
    assertEquals("From: Pvm line: 195", 0, Pvm.compareTo(pv4,pv5));  // kaikki samoja
    assertEquals("From: Pvm line: 196", -1, Pvm.compareTo(pv6,pv2));  // ero kuukaudessa, mutta vuodessa toisinp??in
    assertEquals("From: Pvm line: 197", 1, Pvm.compareTo(pv2,pv6)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testCompareTo222 */
  @Test
  public void testCompareTo222() {    // Pvm: 222
    Pvm pv1 = new Pvm(15,6,2013); 
    Pvm pv2 = new Pvm(14,5,2014); 
    Pvm pv3 = new Pvm(15,7,2014); 
    Pvm pv4 = new Pvm(16,7,2014); 
    Pvm pv5 = new Pvm(16,7,2014); 
    Pvm pv6 = new Pvm(16,7,2012); 
    assertEquals("From: Pvm line: 229", -1, pv1.compareTo(pv2));  // ero vuodessa
    assertEquals("From: Pvm line: 230", 1, pv2.compareTo(pv1)); 
    assertEquals("From: Pvm line: 231", -1, pv2.compareTo(pv3));  // ero kuukaudessa
    assertEquals("From: Pvm line: 232", 1, pv3.compareTo(pv2)); 
    assertEquals("From: Pvm line: 233", -1, pv3.compareTo(pv4));  // ero p??iv??ss??
    assertEquals("From: Pvm line: 234", 1, pv4.compareTo(pv3)); 
    assertEquals("From: Pvm line: 235", 0, pv4.compareTo(pv5));  // kaikki samoja
    assertEquals("From: Pvm line: 236", -1, pv6.compareTo(pv2));  // ero kuukaudessa, mutta vuodessa toisinp??in
    assertEquals("From: Pvm line: 237", 1, pv2.compareTo(pv6)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testEquals259 */
  @Test
  public void testEquals259() {    // Pvm: 259
    Pvm pv1 = new Pvm(15,3,2015); 
    Pvm pv2 = new Pvm(15,3,2015); 
    assertEquals("From: Pvm line: 262", true, pv1.equals(pv2)); 
    pv2.alusta(16,0,0); 
    assertEquals("From: Pvm line: 265", false, pv1.equals(pv2)); 
    pv1.alusta(17,0,0); 
    assertEquals("From: Pvm line: 268", false, pv1.equals(pv2)); 
  } // Generated by ComTest END
}