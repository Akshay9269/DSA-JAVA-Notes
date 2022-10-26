package sunbeam;

public class DoublyList {
	static class Node {
		private int data;
		private Node next;
		private Node prev;
		public Node() {
			data = 0;
			next = null;
			prev = null;
		}
		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	private Node head;
	public DoublyList() {
		head = null;
	}
	public void displayFwd() {
		System.out.print("FWD LIST: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.next;
		}
		System.out.println();
	}
	public void displayRev() {
		System.out.print("Rev LIST: ");
		if(head != null) {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			while(trav != null) {
				System.out.print(trav.data + ", ");
				trav = trav.prev;
			}
		}
		System.out.println();
	}

}






