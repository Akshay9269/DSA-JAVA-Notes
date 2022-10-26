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
		System.out.print("FWD LIST : ");
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + ", ");
			trav = trav.next;
		}
		System.out.println();
	}
	
	public void displayRev() {
		System.out.print("REV LIST : ");
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
	
	public void addLast(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, make new node as first node
		if(head == null)
			head = newNode;
		else {
			// traverse till last node of the list
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			// after last node add new node.
			trav.next = newNode;
			// new node prev to last node
			newNode.prev = trav;
		}
	}
	
	public void addFirst(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, make new node as first node
		if(head == null)
			head = newNode;
		else {
			// new node next to head
			newNode.next = head;
			// head prev to new node
			head.prev = newNode;
			// make head to new node
			head = newNode;
		}
	}
	
	public void addAtPos(int val, int pos) {
		// special case: if list is empty or to add at first pos, add node at first
		if(head == null || pos == 1) 
			addFirst(val);
		else {
			// create and init new node
			Node newNode = new Node(val);
			// traverse till pos-1
			Node trav = head;
			for(int i=1; i<pos-1; i++) {
				// special case: if pos is beyond the count
				if(trav.next == null)
					break;
				trav = trav.next;
			}
			// get addr of node after trav
			Node temp = trav.next;
			// set new node next and prev to temp and trav.
			newNode.next = temp;
			newNode.prev = trav;
			// trav next to new node
			trav.next = newNode;
			// temp prev to new node
			if(temp != null) // special case: if adding node at the end, temp will be null.
				temp.prev = newNode;	
		}
	}
	
	public void delFirst() {
		// if list is empty, do nothing
		if(head == null)
			return;
		// if list has single element, make head null
		if(head.next == null)
			head = null;
		else {
			// take head to next node
			head = head.next;
			// new head's prev to null
			head.prev = null;
		}
	}
	
	public void delAtPos(int pos) {
		// special case: if list is empty or delete at pos 1, call delFirst()
		if(head == null || pos == 1)
			delFirst();
		else {
			// traverse up to pos
			Node trav = head;
			for(int i=1; i < pos; i++) {
				// special case: if pos to be deleted is beyond the count then do nothing.
				if(trav == null)
					return;
				trav = trav.next;
			}
			// trav's prev node should connected to trav's next
			trav.prev.next = trav.next;
			// trav's next node should connected to trav's prev
			if(trav.next != null) // special case: for deleting last node, trav.next is null. 
				trav.next.prev = trav.prev;
		}
	}
	
	public void delLast() {
		// homework
	}
	
	public void delAll() {
		head = null;
	}
}
















