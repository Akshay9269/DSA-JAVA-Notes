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
	private Node tail;
	
	public SinglyList() {
		head = null;
		tail = null;
	}
	
	// O(n)
	public void display() {
		System.out.print("LIST: ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.next;
		}
		System.out.println();
	}
	
	// O(1)
	public void addLast(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}


	// O(1)
	public void addFirst(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	// O(1)
	public int delFirst() {
		// if list is empty, do nothing
		if(head == null)
			return 0;
		int val = head.data;
		// if list has single element, set head & tail to null
		if(head.next == null) {
			head = null;
			tail = null;
		}
		else {
			// take head to next node
			head = head.next;
		}
		return val;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}












