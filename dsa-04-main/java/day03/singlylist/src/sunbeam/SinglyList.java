package sunbeam;

public class SinglyList {
	// self-referential class
	static class Node {
		private int data;
		private Node next;
		public Node() {
			data = 0;
			next = null;
		}
		public Node(int val) {
			data = val;
			next = null;
		}
	}
	
	private Node head;
	
	public SinglyList() {
		head = null;
	}
	public void addFirst(int val) {
		// ...
	}
	public void addLast(int val) {
		// ...
	}
	public void display() {
		Node trav = head;
		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
}






