
public class Questao1Reul {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] vetor1 = new int[] {
                0, 3, 4, 6, 17
        };
        
        int[] vetor2 = new int[] {
                3, 4, 6, 17
        };
        
        System.out.println(verificaSoma(vetor1, 23));
        System.out.println(verificaSoma(vetor2, 30));
        
    }
    
    public static boolean verificaSoma(int[] vetor, int x) {
        for (int i = 0; i < vetor.length; ++i) {
            for (int j = i; j < vetor.length; ++j) {
                for (int k = j; k < vetor.length; ++k) {
                    if ((vetor[i] + vetor [j] + vetor[k]) == x) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

}
