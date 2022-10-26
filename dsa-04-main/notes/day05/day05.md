# Data Structures and Algorithms

## Agenda
* Linked List
* Interview questions
* Hashtable introduction

## Assignment
* contains() in Singly list

```Java
boolean contains(int val) {
	Node trav = head;
	while(trav != null) {
		if(val == trav.data)
			return true;
		trav = trav.next;
	}
	return false;
}
```

## Time complexity of Linked List operations

### Doubly Linear Linked List (with head pointer)
* displayFwd() -- O(n)
* displayRev() -- O(n)
* addLast() -- O(n)
* addFirst() -- O(1)
* addAtPos() -- O(pos) -- worst case: O(n)
* delFirst() -- O(1)
* delLast() -- O(n)
* delAtPos() -- O(pos) -- worst case: O(n)

### Doubly Circular Linked List (with head pointer)
* displayFwd() -- O(n)
* displayRev() -- O(n)
* addLast() -- O(1)
* addFirst() -- O(1)
* addAtPos() -- O(pos) -- worst case: O(n)
* delFirst() -- O(1)
* delLast() -- O(1)
* delAtPos() -- O(pos) -- worst case: O(n)

### Singly Circular Linked List (with head pointer)
* display() -- O(n)
* addLast() -- O(n)
* addFirst() -- O(n)
* addAtPos() -- O(pos) -- worst case: O(n)
* delFirst() -- O(n) 
* delLast() -- O(n)
* delAtPos() -- O(pos) -- worst case: O(n)

### Singly Circular Linked List (with tail pointer)
* tail pointer keeps address of last node of the list.
* display() -- O(n)
* addLast() -- O(1)
* addFirst() -- O(1)
* addAtPos() -- O(pos) -- worst case: O(n)
* delFirst() -- O(1) 
* delLast() -- O(n)
* delAtPos() -- O(pos) -- worst case: O(n)

### Singly Linear Linked List (with head pointer)
* display() -- O(n)
* addLast() -- O(n)
* addFirst() -- O(1)
* addAtPos() -- O(pos) -- worst case: O(n)
* delFirst() -- O(1)
* delLast() -- O(n)
* delAtPos() -- O(pos) -- worst case: O(n)

### Singly Linear Linked List (with head and tail pointer)
* display() -- O(n)
* addLast() -- O(1)
* addFirst() -- O(1)
* delFirst() -- O(1)

## Stack and Queue using Linked List
* Stack and Queue can be implemented using Linked List.
* Since linked list can grow/shrink dynamically, no need of isFull() function.
* Stack and Queue ideal time complexity of push & pop is O(1).
* Stack and Queue can be implemented using any of the following linked list -- O(1) time complexity.
	* Singly linear linked list with head and tail pointer
	* Singly circular linked list with tail pointer 
	* Doubly linear linked list with head and tail pointer
	* Doubly circular linked list

## Linked List Interview questions

### Question 1
* Sort a singly linear linked list using selection sort.
	```Java
	void selectionSort() {
		for (Node i = head; i !=null; i = i.next) {
			for (Node j = i.next; j !=null; j = j.next) {
				if(i.data > j.data) {
					int temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
			}
		}
	}
	```

### Question 2
* Display singly linear linked list in reverse order using recursion.
	```Java
	void revDisplay(Node cur) {
		if(cur == null)
			return;
		revDisplay(cur.next);
		System.out.print(cur.data + ", ");
	}
	```

### Question 3
* Find middle node in a singly linear linked list.
	```Java
	int mid() {
		Node slow = head, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
	}
	```
