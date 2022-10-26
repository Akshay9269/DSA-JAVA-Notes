# Data Structures and Algorithms

## Agenda
* Sorting Algorithms
	* Selection sort
	* Bubble sort
	* Insertion sort
* Queue
	* Linear Queue
	* Circular Queue
	* De-queue
	* Priority Queue
* Stack
* Applications
	* Infix-Prefix-Postfix concepts

## Recursion
* Decimal to Binary conversion
	```Java
	void decimalToBinary(int n) {
		if(n == 0)
			return;
		decimalToBinary(n / 2);
		System.out.print(n % 2);
	}
	// from main()
	//	decimalToBinary(10);
	```

## Utility Data Structures
* Not for storing elements, but only for processing elements.
	* Stack -- Last In First Out
	* Queue -- First In First Out

### Queue Applications
* Queue of people.
* Printer maintains queue of documents to be printed.
* Operating Systems
	* CPU scheduling --> Ready queue.
	* IO management --> Waiting queue.
	* Inter-process communication --> Message Queue
* Used in advanced data structures to implement some algorithms e.g. Breadth first.

### Stack Applications
* Stack of plates.
* OS Process has stack for Function call -- Function activation record/Stack frame for each call.
* Used in compiler/calculator for expression evaluation.
* In compiler/calculator for paranthesis balancing.
* Used in advanced data structures to implement some algorithms e.g. Depth first.
