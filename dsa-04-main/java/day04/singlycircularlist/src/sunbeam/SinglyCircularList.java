package sunbeam;

public class SinglyCircularList {
	
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
	
	public SinglyCircularList() {
		head = null;
	}
	
	public void addLast(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, assign node to head and make it circular.
		if(head == null) {
			head = newNode;
			newNode.next = head;
		}
		else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// new node (new last) next to head
			newNode.next = head;
			// trav's next to new node
			trav.next = newNode;
		}
	}
	
	public void addFirst(int val) {
		// create and init new node
		Node newNode = new Node(val);
		// if list is empty, assign node to head and make it circular.
		if(head == null) {
			head = newNode;
			newNode.next = head;
		}
		else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// new node (new last) next to head
			newNode.next = head;
			// trav's next to new node
			trav.next = newNode;
			// head to new node
			head = newNode;
		}
	}
	
	public void display() {
		System.out.print("LIST: ");
		if(head != null) {
			Node trav = head;
			do {
				System.out.print(trav.data + ", ");
				trav = trav.next;
			} while(trav != head);
		}
		System.out.println();
	}
	
	public void addAtPos(int val, int pos) {
		// if list is empty or pos is 1, add node at the start
		if(head == null || pos == 1)
			addFirst(val);
		else 
		{
			// create new node and init it.
			Node newNode = new Node(val);
			// traverse till pos - 1.
			Node trav = head;
			for(int i=1; i<pos-1; i++) {
				// if pos > count, then stop if reach to last node
				if(trav.next == head)
					break;
				trav = trav.next;
			}
			// assign new node next to trav's next
			newNode.next = trav.next;
			// trav's next to new node
			trav.next = newNode;
		}
	}
	
	public void delFirst() {
		// if list is empty, do nothing
		if(head == null)
			return;
		// if list has single element, make head null
		if(head.next == head)
			head = null;
		else {
			// traverse till last node
			Node trav = head;
			while(trav.next != head)
				trav = trav.next;
			// take head to the next node
			head = head.next;
			// last node (trav) next to the new head
			trav.next = head;
		}
	}
	
	public void delLast() {
		// if list empty, do nothing
		if(head == null)
			return;
		// if list has single element, make head null
		if(head.next == head)
			head = null;
		else {
			// traverse till last node along with prev node.
			Node prev = null;
			Node trav = head;
			while(trav.next != head) {
				prev = trav;
				trav = trav.next;
			}
			// second last node next to head
			prev.next = head;
		}
	}
	
	public void delAll() {
		head = null;
	}
	
	public void delAtPos(int pos) {
		// if list is empty or to delete at first pos
		if(head == null || pos == 1)
			delFirst();		
		else {
			// traverse till last node along with prev node.
			Node prev = null;
			Node trav = head;
			for(int i=1; i<pos; i++) {
				// if pos is beyond the list node count
				if(trav == head && prev != null)
					return; // you may show message and then return.
				prev = trav;
				trav = trav.next;
			}
			// second last node next to head
			prev.next = trav.next;
		}
	}
}







