# Data Structures and Algorithms

## Agenda
* Types of binary tree
* Heap data Structure
* Heap sort
* Graph introduction
* Graph Adj Matrix implementation
* Graph DFS & BFS

## Sorting Linked list

```Java
// SinglyList class
void bubbleSort() {
	for(Node i = head; i != null; i = i.next) {
		for(Node j = head; j.next != null; j = j.next) {
			if(j.data > j.next.data) {
				int temp = j.data;
				j.data = j.next.data;
				j.next.data = temp;
			}
		}
	}
}

void improvedBubbleSort() {
	Node last = null;
	for(Node i = head; i != null; i = i.next) {
		for(Node j = head; j.next != last; j = j.next) {
			if(j.data > j.next.data) {
				int temp = j.data;
				j.data = j.next.data;
				j.next.data = temp;
			}
		}
		last = j;
	}
}

void furtherImprovedBubbleSort() {
	Node last = null;
	boolean flag;
	for(Node i = head; i != null; i = i.next) {
		flag = false;
		for(Node j = head; j.next != last; j = j.next) {
			if(j.data > j.next.data) {
				int temp = j.data;
				j.data = j.next.data;
				j.next.data = temp;
				flag = true;
			}
		}
		last = j;
	}
}
```

