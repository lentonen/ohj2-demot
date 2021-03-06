package demo.d11.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d11.Valuutat.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.25 21:00:43 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class ValuutatTest {



  // Generated by ComTest BEGIN
  /** testVaihdaValuutta88 */
  @Test
  public void testVaihdaValuutta88() {    // Valuutat: 88
    Valuutta euro    = new Valuutta("eur", 1.00); 
    Valuutta dollari = new Valuutta("usd", 0.85); 
    Valuutta punta   = new Valuutta("gbp", 1.17); 
    assertEquals("From: Valuutat line: 93", 1.0, vaihdaValuutta(euro, euro, 1), 0.000001); 
    assertEquals("From: Valuutat line: 94", 1.176470, vaihdaValuutta(euro, dollari, 1), 0.000001); 
    assertEquals("From: Valuutat line: 95", 0.85, vaihdaValuutta(dollari, euro, 1), 0.000001); 
    assertEquals("From: Valuutat line: 96", 0.7264957, vaihdaValuutta(dollari, punta, 1), 0.000001); 
    assertEquals("From: Valuutat line: 97", 1.376470588, vaihdaValuutta(punta, dollari, 1), 0.000001); 
  } // Generated by ComTest END
}