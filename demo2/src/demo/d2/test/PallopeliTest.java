package demo.d2.test;
// Generated by ComTest BEGIN
import java.util.List;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d2.Pallopeli.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.01.20 20:47:25 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class PallopeliTest {



  // Generated by ComTest BEGIN
  /** testBoolean67 */
  @Test
  public void testBoolean67() {    // Pallopeli: 67
    List<Integer> rivi = Arrays.asList(0,1,  1,0,1,2); 
    assertEquals("From: Pallopeli line: 71", true, voitto(1,rivi)); 
    assertEquals("From: Pallopeli line: 72", true, voitto(2,rivi)); 
    assertEquals("From: Pallopeli line: 73", false, voitto(3,rivi)); 
    rivi = Arrays.asList( 1,1,  1,0,0,2); 
    assertEquals("From: Pallopeli line: 75", true, voitto(1,rivi)); 
    assertEquals("From: Pallopeli line: 76", false, voitto(2,rivi)); 
  } // Generated by ComTest END
}