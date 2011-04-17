/*
 * Questão 03
 *
 * Desenvolva um algoritmo naoRepetido(String) que receba uma String como
 * entrada e retorne o primeiro caractere da String que não aparece duas vezes
 * na própria String. Depois analise o algoritmo em relação a tempo e memória.
 * Exemplos:
 *      naoRepetido('banana') = 'b'
 *      naoRepetido('papel') = 'a'
 */

/*
 * Análise assintótica:
 *
 * O algoritmo possui um custo espacial O(n) (o tamanho da própria String);
 * Contudo, se desconsiderarmos a entrada, o custo espacial é O(1).
 *
 * Em termos de tempo, no pior caso, o último caractere é o único não repetido
 * (ou não há caractere não repetido), o que nos dá uma complexidade de tempo
 * O(n²), o equivalente a varrer a String inteira n vezes.
 */

public class Questao03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(naoRepetido("banana"));
        System.out.println(naoRepetido("papel"));
        System.out.println(naoRepetido("esteatose"));
        System.out.println(naoRepetido("parangaricotirrimurruaro"));
        System.out.println(naoRepetido(
            "camponesa de nobre coracao que vai todos os dias ao bosque recolher lenha"
        ));
    }

    public static char naoRepetido(String s) {
        int pointer = 0;
        int pointer2 = 0;

        for (pointer = 0; pointer < s.length() ; ++pointer) {
            for (pointer2 = 0; pointer2 < s.length(); ++pointer2) {
                if (pointer != pointer2 && s.charAt(pointer) == s.charAt(pointer2)) {
                    break;
                }
            }

            if(pointer2 == s.length()) return s.charAt(pointer);
        }

        return 0;
    }
}

