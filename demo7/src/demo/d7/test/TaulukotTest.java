package demo.d7.test;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d7.Taulukot.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.02.22 20:24:36 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaulukotTest {



  // Generated by ComTest BEGIN
  /** testParas39 */
  @Test
  public void testParas39() {    // Taulukot: 39
    double[] t1 = new double[] { 1, 2, 3, 4, 5} ; 
    assertEquals("From: Taulukot line: 41", 5, paras(t1), 0.000001); 
    double[] t2 = new double[] { 5, 2, 3, 4, 1} ; 
    assertEquals("From: Taulukot line: 43", 5, paras(t2), 0.000001); 
    double[] t3 = new double[] { 5, 2, 10, 4, 1} ; 
    assertEquals("From: Taulukot line: 45", 10, paras(t3), 0.000001); 
    double[] t4 = new double[] { -5, -2, -10, -4, -1} ; 
    assertEquals("From: Taulukot line: 47", -1, paras(t4), 0.000001); 
    double[] t5 = new double[] { } ; 
    assertEquals("From: Taulukot line: 49", Integer.MIN_VALUE, paras(t5), 0.000001); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testHuonoin67 */
  @Test
  public void testHuonoin67() {    // Taulukot: 67
    double[] t6 = new double[] { 1.2, 2, 3, 4, 5} ; 
    assertEquals("From: Taulukot line: 69", 1.2, huonoin(t6), 0.000001); 
    double[] t7 = new double[] { 5, 2, 3, 4, 1.4} ; 
    assertEquals("From: Taulukot line: 71", 1.4, huonoin(t7), 0.000001); 
    double[] t8 = new double[] { 5, 2, 0.7, 4, 1} ; 
    assertEquals("From: Taulukot line: 73", 0.7, huonoin(t8), 0.000001); 
    double[] t9 = new double[] { -5, -2, -10.2, -4, -1} ; 
    assertEquals("From: Taulukot line: 75", -10.2, huonoin(t9), 0.000001); 
    double[] t10 = new double[] { } ; 
    assertEquals("From: Taulukot line: 77", Integer.MAX_VALUE, huonoin(t10), 0.000001); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSumma94 */
  @Test
  public void testSumma94() {    // Taulukot: 94
    double[] taulukko = new double[] { 1.2, 2, 3, 4, 5} ; 
    assertEquals("From: Taulukot line: 96", 15.2, summa(taulukko), 0.000001); 
    double[] taulukko2 = new double[] { -1.2, -2, -3, -4, -5} ; 
    assertEquals("From: Taulukot line: 98", -15.2, summa(taulukko2), 0.000001); 
    double[] taulukko3 = new double[] { } ; 
    assertEquals("From: Taulukot line: 100", 0, summa(taulukko3), 0.000001); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSummaHuonoinJaParasPois118 */
  @Test
  public void testSummaHuonoinJaParasPois118() {    // Taulukot: 118
    double[] taulukko = new double[] { 1.2, 2, 3, 4, 5} ; 
    assertEquals("From: Taulukot line: 120", 9, summaHuonoinJaParasPois(taulukko), 0.000001); 
    double[] taulukko2 = new double[] { -1.2, 2, -3, 4, -5} ; 
    assertEquals("From: Taulukot line: 122", -2.2, summaHuonoinJaParasPois(taulukko2), 0.000001); 
    double[] taulukko3 = new double[] { } ; 
    assertEquals("From: Taulukot line: 124", 0, summaHuonoinJaParasPois(taulukko3), 0.000001); 
  } // Generated by ComTest END
}