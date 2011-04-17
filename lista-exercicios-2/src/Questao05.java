
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
        Node root = new Node(23, null, null);
        System.out.println("True: " + somaIgualA(root, 23));
        root.left = new Node(1, null, null);
        root.right = new Node(1, null, null);
        System.out.println("False: " + somaIgualA(root, 23));
        root.value = 22;
        System.out.println("True: " + somaIgualA(root, 23));

    }

    public static boolean somaIgualA(Node root, int x) {
    	if (root == null || root.value > x) {return false;}
        return somaIgualA(root.left, x - root.value) ||
               somaIgualA(root.right, x - root.value) ||
               (root.left == null && root.right == null && root.value == x);
    }

    
}
