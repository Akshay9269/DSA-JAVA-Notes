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
		// start traversing from first node
		Node trav = head;
		// repeat for all nodes
		while(trav != null) {
			// print data of the node
			System.out.print(trav.data + ", ");
			// go to the next node
			trav = trav.next;
		}
		System.out.println();
	}

	public void addLast(int val) {
		// create new node and init it
		Node newNode = new Node(val);
		// if list is empty, assign new node to head
		if(head == null)
			head = newNode;
		else {
			// traverse till last node of list
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			// keep addr of new node in last node next
			trav.next = newNode;
		}
	}

	public void addFirst(int val) {
		// create node and init it
		Node newNode = new Node(val);
		// assign new node next to head
		newNode.next = head;
		// assign head to new node
		head = newNode;
	}

	public void addAtPos(int val, int pos) {
		// if list is empty or pos is 1, add node at the start
		if(head == null || pos == 1)
			addFirst(val);
		else {
			// create new node and init it.
			Node newNode = new Node(val);
			// traverse till pos - 1.
			Node trav = head;
			for(int i=1; i<pos-1; i++) {
				// if pos > count, then stop if reach to last node
				if(trav.next == null)
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
		// if list is not empty
		if(head != null) {
			// take head to next (second) node
			head = head.next;
		}
	}

	public void delAll() {
		head = null;
		// all nodes will be garbage collected
	}

	public void delLast() {
		// if list empty, do nothing
		if(head == null)
			return;
		// if list has single element, make head null
		if(head.next == null)
			head = null;
		else {
			// traverse till last node along with prev node.
			Node prev = null;
			Node trav = head;
			while(trav.next != null) {
				prev = trav;
				trav = trav.next;
			}
			prev.next = null;
		}
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
				if(trav == null)
					return; // you may show message and then return.
				prev = trav;
				trav = trav.next;
			}
			// second last node next to head
			prev.next = trav.next;
		}
	}
}






