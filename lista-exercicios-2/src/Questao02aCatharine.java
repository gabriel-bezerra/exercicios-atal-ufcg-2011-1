public class Questao02aCatharine {

	private static class Node {

		private Node next;
		private boolean visited = false;;
		@SuppressWarnings("unused")
		private int value;

		private Node(int value) {
			this.next = null;
			this.value = value;
		}

		private void setAsVisited() {
			visited = true;
		}
	}
	
	public static void main(String[] args) {
		Node a = new Node(3); Node b = new Node(2);
		Node c = new Node(4); Node d = new Node(6);
		Node e = new Node(2);
		
		a.next = b; b.next = c;
		c.next = d; d.next = e;
		e.next = c;

		System.out.println(verificaCiclo(a));
	}

	private static boolean verificaCiclo(Node node) {
		if (node.visited == true) {
			return true;
		}

		if (node == null || node.next == null) {
			return false;
		}

		node.setAsVisited();
		return verificaCiclo(node.next);
	}
}