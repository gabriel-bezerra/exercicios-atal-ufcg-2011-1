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

	private static class Node {
		private int value;
		private Node left;
		private Node right;

		private Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

    public static void main(String[] args) {
        System.out.println("Checking for simple tree:");
    	Node root = new Node(23, null, null);
        System.out.println("True: " + somaIgualA(root, 23));
        root.left = new Node(1, null, null);
        root.right = new Node(1, null, null);
        System.out.println("False: " + somaIgualA(root, 23));
        root.value = 22;
        System.out.println("True: " + somaIgualA(root, 23));

        Node tree = createTree();
        System.out.println("Checking for complex tree:");
        System.out.println("True: " + somaIgualA(tree, 27));
        System.out.println("True: " + somaIgualA(tree, 22));
        System.out.println("True: " + somaIgualA(tree, 26));
        System.out.println("True: " + somaIgualA(tree, 18));
        for (int i = 0; i < 18; ++i) {
        	System.out.println("False: " + somaIgualA(tree, i));
        }

    }
    
    public static Node createTree() {
    	Node n4 = new Node( 7, null, null);
    	Node n5 = new Node( 2, null, null);
    	Node n3 = new Node(11, n4, n5);
    	Node n2 = new Node( 4, n3, null);
    	
    	Node n9 = new Node( 1, null, null);
    	Node n8 = new Node( 4, null, n9);
    	
    	Node n7 = new Node(13, null, null);
    	Node n6 = new Node( 8, n7, n8);
    	
    	Node n1 = new Node( 5, n2, n6);
    	
    	return n1;
    }    

    public static boolean somaIgualA(Node root, int x) {
    	if (root == null || root.value > x) {return false;}
        return somaIgualA(root.left, x - root.value) ||
               somaIgualA(root.right, x - root.value) ||
               (root.left == null && root.right == null && root.value == x);
    }
}
