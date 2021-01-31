package demo.d3;

import fi.jyu.mit.ohj2.Syotto;
import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author Henri
 * @version Jan 29, 2021
 *
 */
public class Jarjesta {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        String s = Syotto.kysy("Anna jono");
        String tulos = jarjesta1ja2(s);
        System.out.println(tulos);
    }
    
    
    /**
     * Järjestää syötteen kaksi ensimmäistä sanaa aakkosjärjestykseen.
     * @param syote syöte josta 1. ja 2. sana tulostetaan aakkosjärjestyksessä
     * @return syötteen 1. ja 2. sana aakkosjärjestyksessä
     * @example
     * <pre name="test">
     * jarjesta1ja2("").equals("");
     * jarjesta1ja2("kissa").equals("kissa");
     * jarjesta1ja2("kissa ").equals("kissa");
     * jarjesta1ja2(" kissa").equals("kissa");
     * jarjesta1ja2("aa ab").equals("aa ab");
     * jarjesta1ja2("ab aa").equals("aa ab");
     * jarjesta1ja2("ah ihanaa").equals("ah ihanaa");
     * jarjesta1ja2("ihanaa ah").equals("ah ihanaa");
     * jarjesta1ja2("ihanaa ah tämä ohjelmointi").equals("ah ihanaa");
     * jarjesta1ja2("ah ihanaa tämä ohjelmointi").equals("ah ihanaa");
     * </pre>
     */
    public static String jarjesta1ja2(String syote) {
       StringBuilder s = new StringBuilder(syote);
       String ekaSana = Mjonot.erota(s, ' ', true);
       String tokaSana =Mjonot.erota(s, ' ', true);
       if (ekaSana =="" || tokaSana =="") return ekaSana +tokaSana;
       if (ekaSana.compareTo(tokaSana) < 0) return ekaSana + " " +tokaSana;
       return tokaSana + " " +ekaSana;
    }
}
