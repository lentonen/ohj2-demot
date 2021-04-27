package demo.d11.test;
// Generated by ComTest BEGIN
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;
import static demo.d11.Tauno.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2021.03.25 12:44:46 // Generated by ComTest
 *
 */
@SuppressWarnings({ "all" })
public class TaunoTest {



  // Generated by ComTest BEGIN
  /** testKaanna55 */
  @Test
  public void testKaanna55() {    // Tauno: 55
    int[] t = { 2, 32, 76, 62, 31, 86} ; 
    kaanna(t); 
    assertEquals("From: Tauno line: 59", "[86, 31, 62, 76, 32, 2]", Arrays.toString(t)); 
    int[] t2 = { 2, 32, 76, 62, 31, 86, 99} ; 
    kaanna(t2); 
    assertEquals("From: Tauno line: 62", "[99, 86, 31, 62, 76, 32, 2]", Arrays.toString(t2)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testVaihdaJokaToinen76 */
  @Test
  public void testVaihdaJokaToinen76() {    // Tauno: 76
    int[] t = { 2, 32, 76, 62, 31, 86} ; 
    vaihdaJokaToinen(t); 
    assertEquals("From: Tauno line: 80", "[32, 2, 62, 76, 86, 31]", Arrays.toString(t)); 
    int[] t2 = { 2, 32, 76, 62, 31, 86, 99} ; 
    vaihdaJokaToinen(t2); 
    assertEquals("From: Tauno line: 83", "[32, 2, 62, 76, 86, 31, 99]", Arrays.toString(t2)); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSummaParillisissaPaikoissa98 */
  @Test
  public void testSummaParillisissaPaikoissa98() {    // Tauno: 98
    int[] t = { 1,2,3,4,5,6} ; 
    assertEquals("From: Tauno line: 100", 9, summaParillisissaPaikoissa(t)); 
    assertEquals("From: Tauno line: 101", 3, summaParillisissaPaikoissa(new int[]{1,1,1,1,1,1})); 
    assertEquals("From: Tauno line: 102", 0, summaParillisissaPaikoissa(new int[]{})); 
    assertEquals("From: Tauno line: 103", 1, summaParillisissaPaikoissa(new int[]{1})); 
    assertEquals("From: Tauno line: 104", 1, summaParillisissaPaikoissa(new int[]{1,2})); 
    assertEquals("From: Tauno line: 105", 4, summaParillisissaPaikoissa(new int[]{1,2,3})); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSumma121 */
  @Test
  public void testSumma121() {    // Tauno: 121
    int[] t = { 1,2,3,4,5,6} ; 
    assertEquals("From: Tauno line: 123", 21, summa(t)); 
    assertEquals("From: Tauno line: 124", 6, summa(new int[]{1,1,1,1,1,1})); 
    assertEquals("From: Tauno line: 125", 0, summa(new int[]{})); 
    assertEquals("From: Tauno line: 126", 1, summa(new int[]{1})); 
    assertEquals("From: Tauno line: 127", 3, summa(new int[]{1,2})); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSummaPerattaistenErotuksista142 */
  @Test
  public void testSummaPerattaistenErotuksista142() {    // Tauno: 142
    int[] t = { 1,2,3,4,5,6} ; 
    assertEquals("From: Tauno line: 144", -3, summaPerattaistenErotuksista(t)); 
    assertEquals("From: Tauno line: 145", 0, summaPerattaistenErotuksista(new int[]{1,1,1,1,1,1})); 
    assertEquals("From: Tauno line: 146", 0, summaPerattaistenErotuksista(new int[]{1})); 
    assertEquals("From: Tauno line: 147", -1, summaPerattaistenErotuksista(new int[]{1,2})); 
    assertEquals("From: Tauno line: 148", -1, summaPerattaistenErotuksista(new int[]{1,2,3})); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testSummaVastaavienErotuksista165 */
  @Test
  public void testSummaVastaavienErotuksista165() {    // Tauno: 165
    int[] t = { 1,2,3,4,5,6} ; 
    assertEquals("From: Tauno line: 167", -9, summaVastaavienErotuksista(t)); 
    assertEquals("From: Tauno line: 168", 0, summaVastaavienErotuksista(new int[]{1,1,1,1,1,1})); 
    assertEquals("From: Tauno line: 169", 0, summaVastaavienErotuksista(new int[]{1})); 
    assertEquals("From: Tauno line: 170", -1, summaVastaavienErotuksista(new int[]{1,2})); 
    assertEquals("From: Tauno line: 171", -2, summaVastaavienErotuksista(new int[]{1,2,3})); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLisaaArvoihin188 */
  @Test
  public void testLisaaArvoihin188() {    // Tauno: 188
    int[] t = { 1,2,3,4,5,6} ; 
    lisaaArvoihin(t,5); 
    assertEquals("From: Tauno line: 192", "[6, 7, 8, 9, 10, 11]", Arrays.toString(t)); 
    assertEquals("From: Tauno line: 193", "[]", Arrays.toString(lisaaArvoihin(new int[]{},5))); 
    assertEquals("From: Tauno line: 194", "[6]", Arrays.toString(lisaaArvoihin(new int[]{1},5))); 
    assertEquals("From: Tauno line: 195", "[4, 5]", Arrays.toString(lisaaArvoihin(new int[]{1,2},3))); 
  } // Generated by ComTest END


  // Generated by ComTest BEGIN
  /** testLaskePerakkaiset215 */
  @Test
  public void testLaskePerakkaiset215() {    // Tauno: 215
    int[] t = { 1,2,3,4,5,6} ; 
    laskePerakkaiset(t); 
    assertEquals("From: Tauno line: 219", "[3, 0, 7, 0, 11, 0]", Arrays.toString(t)); 
    assertEquals("From: Tauno line: 220", "[]", Arrays.toString(laskePerakkaiset(new int[]{}))); 
    assertEquals("From: Tauno line: 221", "[1]", Arrays.toString(laskePerakkaiset(new int[]{1}))); 
    assertEquals("From: Tauno line: 222", "[3, 0]", Arrays.toString(laskePerakkaiset(new int[]{1,2}))); 
    assertEquals("From: Tauno line: 223", "[3, 0, 3]", Arrays.toString(laskePerakkaiset(new int[]{1,2,3}))); 
  } // Generated by ComTest END
}