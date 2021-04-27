package demo.d12;

/**
 *
 */
public class Kuva {

    public static void main(String[] args) {
        String[] rokotteet = new String[] {new String("Korona"), new String("Possunuha"), new String("Ebola")};
        
        String[] t1 = a(rokotteet);
        String[] t2 = b(rokotteet);
        String[] t3 = c(rokotteet);
        System.out.println(t1.toString() +t2 +t3);
    }

    private static String[] a(String[] rokotteet) {
        return rokotteet;
    }

    private static String[] b(String[] rokotteet) {
        String[] rokotteet2 = new String[rokotteet.length];
        
        for (int i = 0; i < rokotteet.length; i++) {
            rokotteet2[i] = rokotteet[i];
        }
        
        return rokotteet2;
    }

    private static String[] c(String[] rokotteet) {
        String[] rokotteet2 = new String[rokotteet.length];
        
        for (int i = 0; i < rokotteet.length; i++) {
            rokotteet2[i] = new String(rokotteet[i]);
        }
        return rokotteet2;
    }
}
