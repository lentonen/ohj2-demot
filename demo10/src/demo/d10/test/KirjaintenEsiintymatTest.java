package demo.d10.test;
// Generated by ComTest BEGIN
import fi.jyu.mit.ohj2.Suuntaaja;
import java.io.IOException;
import fi.jyu.mit.ohj2.VertaaTiedosto;
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d10.KirjaintenEsiintymat.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.16 16:10:56 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class KirjaintenEsiintymatTest {



  // Generated by ComTest BEGIN
  /** 
   * testMain17 
   * @throws IOException when error
   */
  @Test
  public void testMain17() throws IOException {    // KirjaintenEsiintymat: 17
    Suuntaaja.StringOutput so = new Suuntaaja.StringOutput(); 
    VertaaTiedosto.kirjoitaTiedosto("luettava.txt",
    "Testaaminen on kivaa."); 
    String tulos =
    " : 2\n" +
    ".: 1\n" +
    "a: 4\n" +
    "e: 2\n" +
    "i: 2\n" +
    "k: 1\n" +
    "m: 1\n" +
    "n: 3\n" +
    "o: 1\n" +
    "s: 1\n" +
    "t: 2\n" +
    "v: 1\n"
    ; 
    main(new String[]{"luettava.txt"}); 
    assertEquals("From: KirjaintenEsiintymat line: 42", null, so.ero(tulos)); 
    so.palauta(); 
    VertaaTiedosto.tuhoaTiedosto("luettava.txt"); 
  } // Generated by ComTest END
}