/*
Dada uma árvore binária de inteiros desenvolva um algoritmo que determina se
nessa árvore existe um caminho raiz-­‐folha cuja soma dos nodos é igual a um
inteiro específico. Por exemplo, na árvore mostrada abaixo existem exatamente
quatro caminhos raiz-­‐folha. As somas dos caminhos são 27, 22, 26 e 18.
Considere como entrada um número inteiro (x) e a raiz da árvore, que inclui
nodos com um campo pra número inteiro, nodos esquerdo e direito. Faça a análise
de custo e memória do seu algoritmo.
*/

public class Questao05 {

    private static class No {
        private int valor;
        private No esquerda;
        private No direita;

        private No(int valor, No esquerda, No direita) {
            this.valor = valor;
            this.esquerda = esquerda;
            this.direita = direita;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        No raiz = criaArvore();
    }


    public static No criaArvore() {
        No no4 = new No( 7, null, null);
        No no5 = new No( 2, null, null);
        No no3 = new No(11, no4, no5);
        No no2 = new No( 4, no3, null);

        No no9 = new No( 1, null, null);
        No no8 = new No( 4, null, no9);

        No no7 = new No(13, null, null);
        No no6 = new No( 8, no7, no8);

        No no1 = new No( 5, no2, no6);

        return no1;
    }

}
