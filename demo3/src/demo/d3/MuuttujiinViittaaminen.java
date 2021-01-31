package demo.d3;

/**
 * @author Henri
 * @version Jan 29, 2021
 *
 */
public class MuuttujiinViittaaminen {

    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        int a;
        StringBuilder b = new StringBuilder("1");
        StringBuilder c = new StringBuilder("2");
        StringBuilder p;
        a = 19;
        p = b;
        p.append("0");
        p = c;
        p.append(a);
        c = b;
        c.append("3");

    }

}
