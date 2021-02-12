package demo.d5.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import demo.d5.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.09 15:47:18 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class PvmTest {



  // Generated by ComTest BEGIN
  /** testToString83 */
  @Test
  public void testToString83() {    // Pvm: 83
    Pvm pvm = new Pvm(10,2,2008); 
    assertEquals("From: Pvm line: 85", "10.2.2008", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testParse98 */
  @Test
  public void testParse98() {    // Pvm: 98
    Pvm pvm = new Pvm(); 
    pvm.parse("11.05.02"); assertEquals("From: Pvm line: 100", "11.5.2002", pvm.toString()); 
    pvm.parse("11.05.97"); assertEquals("From: Pvm line: 101", "11.5.1997", pvm.toString()); 
    pvm.parse("17.3"); assertEquals("From: Pvm line: 102", "17.3.1997", pvm.toString()); 
    pvm.parse("19"); assertEquals("From: Pvm line: 103", "19.3.1997", pvm.toString()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetPv117 */
  @Test
  public void testGetPv117() {    // Pvm: 117
    Pvm pvm = new Pvm(); 
    pvm.parse("3.4.2011"); 
    assertEquals("From: Pvm line: 120", 3, pvm.getPv()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetKk130 */
  @Test
  public void testGetKk130() {    // Pvm: 130
    Pvm pvm = new Pvm(); 
    pvm.parse("3.4.2011"); 
    assertEquals("From: Pvm line: 133", 4, pvm.getKk()); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testGetVv144 */
  @Test
  public void testGetVv144() {    // Pvm: 144
    Pvm pvm = new Pvm(); 
    pvm.parse("3.4.2011"); 
    assertEquals("From: Pvm line: 147", 2011, pvm.getVv()); 
  } // Generated by ComTest END
}