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
	
	public void recRevDisplay() {
		System.out.print("REV : ");
		revDisplay(head);
		System.out.println();
	}
	
	private int max = 0;
	public int recFindMid(Node cur, int count) {
		if(cur == null) {
			max = count;
			return 0;
		}
		int mid = recFindMid(cur.next, count+1);
		if(count == max / 2)
			mid = cur.data;
		return mid;
	}

	public int recFindMid() {
		int mid = recFindMid(head, 1);
		return mid;
	}
	
	public void reverse() {
		// consider list as old list
		Node oldhead = head;
		// consider new list as empty.
		head = null;
		
		while(oldhead != null) {
			// delete first node from old list
			Node temp = oldhead;
			oldhead = oldhead.next;
			// add that node into new list
			temp.next = head;
			head = temp;
		} // repeat until old list is finished
	}
	
	public Node recReverse(Node cur) {
		// if single node left in list, then make it head
		if(cur.next == null) {
			head = cur;
			return cur;
		}
		// reverse rest of list & get last node
		Node last = recReverse(cur.next);
		// assign next of last node (of rest of list) to current node
		last.next = cur;
		// make current node as last (next = null)
		cur.next = null;
		// return current node (because it is last node for earlier call)
		return cur;
	}
	
	public void recReverse() {
		if(head != null)
			recReverse(head);
	}
}













