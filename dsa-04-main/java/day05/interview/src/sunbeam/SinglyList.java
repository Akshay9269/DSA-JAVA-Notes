package sunbeam;

public class SinglyList {
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
	
	public void display() {
		System.out.print("LIST: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.next;
		}
		System.out.println();
	}
	
	public void addLast(int val) {
		Node newNode = new Node(val);
		if(head == null)
			head = newNode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newNode;
		}
	}

	public void revDisplay(Node cur) {
		if(cur == null)
			return;
		revDisplay(cur.next);
		System.out.print(cur.data + ", ");
	}
	
	public void revDisplay() {
		System.out.print("REV : ");
		revDisplay(head);
		System.out.println();
	}
}












