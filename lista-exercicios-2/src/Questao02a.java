
/*
 * Desenvolva um algoritmo VerificaCiclo(No) que recebe um No representando a
 * cabeça de uma lista simplesmente encadeada e retorna um booleano  indicando
 * se essa lista possui um ciclo.
 * 
 * Obedeça as restrições abaixo e analise o algoritmo em relação ao custo de
 * tempo e memória. Considere que cada No tem um valor inteiro (carga) e um
 * apontador para o próximo No (prox).
 * 
 * Lembre-se que uma lista encadeada é
 * cíclica se o último nó não aponta para NULL ou algum nó interno ou o último
 * aopnta para um nó anterior.
 * 
 * Restrições:
 * a. É possível alterar a estrutura de cada No.
 * b. Não é possível alterar a estrutura de cada No.
 * 
 */

public class Questao02a {

	private static class No {
		private int carga;
		private No proximo;
		private boolean visitado;

		private No(int carga, No proximo) {
			this.carga = carga;
			this.proximo = proximo;
		}
	}

    /**
     * @param args
     */
    public static void main(String[] args) {
    	No n0 = new No(2, null);
        No n1 = new No(6, n0);
        No n2 = new No(4, n1);
        No n3 = new No(2, n2);
        No n4 = new No(3, n3);

        System.out.println("sem ciclo:" + verificaCiclo(n4));

        n0.proximo = n2;
        System.out.println("com ciclo:" + verificaCiclo(n4));

    }

    public static boolean verificaCiclo(No n) {
    	if (n == null) {return false;}
    	if (n.visitado) {return true;}
    	n.visitado = true;
    	return verificaCiclo(n.proximo);
    }
}
