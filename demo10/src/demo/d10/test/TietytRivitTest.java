package demo.d10.test;
// Generated by ComTest BEGIN
import java.io.IOException;
import fi.jyu.mit.ohj2.VertaaTiedosto;
import fi.jyu.mit.ohj2.Suuntaaja;
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d10.TietytRivit.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.16 15:56:22 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TietytRivitTest {



  // Generated by ComTest BEGIN
  /** 
   * testMain26 
   * @throws IOException when error
   */
  @Test
  public void testMain26() throws IOException {    // TietytRivit: 26
    Suuntaaja.StringInput si = new Suuntaaja.StringInput("testitulos.txt"); 
    Suuntaaja.StringOutput so = new Suuntaaja.StringOutput(); 
    VertaaTiedosto.kirjoitaTiedosto("lue.txt",
    "* hei\n" +
    "** moi\n" +
    "*** terve\n" +
    "\n" +
    "asd\n" +
    "**"); 
    String tulos =
    "** moi\n" +
    "*** terve\n" +
    "**"; 
    VertaaTiedosto.tuhoaTiedosto("testitulos.txt"); 
    main(new String[]{"lue.txt"}); 
    assertEquals("From: TietytRivit line: 48", null, VertaaTiedosto.vertaaFileString("testitulos.txt",tulos)); 
    si.palauta(); so.palauta(); 
    VertaaTiedosto.tuhoaTiedosto("testitulos.txt"); 
    VertaaTiedosto.tuhoaTiedosto("lue.txt"); 
  } // Generated by ComTest END
}