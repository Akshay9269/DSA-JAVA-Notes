package sunbeam;

public class DoublyCircularList {

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
	
	public DoublyCircularList() {
		head = null;
	}
	
	public void displayFwd() {
		System.out.print("FWD LIST : ");
		if(head != null) {
			Node trav = head;
			do {
				System.out.print(trav.data + ", ");
				trav = trav.next;
			} while(trav != head);
		}
		System.out.println();
	}
	
	public void displayRev() {
		System.out.print("REV LIST : ");
		if(head != null) {
			Node trav = head.prev;
			do {
				System.out.print(trav.data + ", ");
				trav = trav.prev;
			} while(trav != head.prev);
		}
		System.out.println();
	}
	
	public void addLast(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, make new node as first node and circular
		if(head == null) {
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		} else {
			// traverse till last node of the list
			Node trav = head.prev;
			// new node prev to last node and new node next to head
			newNode.prev = trav;
			newNode.next = head;
			// after last node add new node.
			trav.next = newNode;
			// head node prev to new node
			head.prev = newNode;
		}
	}
	
	public void addFirst(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, make new node as first node and circular
		if(head == null) {
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		} else {
			// traverse till last node of the list
			Node trav = head.prev;
			// new node prev to last node and new node next to head
			newNode.prev = trav;
			newNode.next = head;
			// after last node add new node.
			trav.next = newNode;
			// head node prev to new node
			head.prev = newNode;
			// head to new node
			head = newNode;
		}
	}
	public void addAtPos(int val, int pos) {
		// homework
	}
	
	public void delFirst() {
		// homework
	}
	
	public void delAtPos(int pos) {
		// homework
	}
	
	public void delLast() {
		// homework
	}
	
	public void delAll() {
		head = null;
	}
}
















