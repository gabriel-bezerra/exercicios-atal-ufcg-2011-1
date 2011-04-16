import java.util.Vector;

/**
*
* @author Catharine
*/
public class Questao01 {

    public static void main(String[] args) {
            Vector<Integer> v = new Vector<Integer>();
            v.add(0);
            v.add(3);
            v.add(4);
            v.add(6);
            v.add(17);
            int s = 23;
            System.out.println(verificaSoma(v, s));
    }

    private static boolean verificaSoma(Vector<Integer> v, int soma) {
            return soma(v, soma, 0, 3);
    }

    private static boolean soma(Vector<Integer> v, int soma, int somaParcial, int quantidade) {
        if ((somaParcial > soma) || (quantidade < 0))  {
                return false;
        }

        if (somaParcial == soma) {
                return true;
        }

        for (int i = 0; i < v.size(); i++) {
                soma(v, soma, somaParcial + v.get(i), quantidade-1);
        }

        return false;
    }
}
