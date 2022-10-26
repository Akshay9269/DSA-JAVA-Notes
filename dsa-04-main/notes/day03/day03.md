# Data Structures and Algorithms

## Agenda
* Stack applications
	* Infix to Postfix conversion
	* Infix to Prefix conversion
	* Postfix evaluation
	* Prefix evaluation
	* Parenthesis balancing
* Stack/Queue interview questions
* Linked list
	* Concepts
	* Singly linear linked list

## Reminder
* Videos are available for 7 days from date of lecture.
* Please plan your studies accordingly.
* Learning with deadlines only ensure that you can complete the subject.

## Circular Queue
```Java
class CircularQueue {
	private int[] arr;
	private int front, rear;
	private int count;
	public CircularQueue() {
		// ...
		count = 0;
	}
	public void push() {
		// ...
		count++;
	}
	public void pop() {
		// ...
		count--;
	}
	public int peek() {
		// ...
	}
	public boolean isEmpty() {
		return count == 0;
	}
	public boolean isFull() {
		return count == arr.length;
	}
}
```

## Char to Int converion
* '1' --> 1
	* char '1' ascii value 49.
	* char '0' ascii value 48.
	* '1' - '0' = 49 - 48 = 1


## Member (Nested) classes in Java
* Java has four types of member classes
	* Static member class
	* Non-static member class
	* Local class
	* Annoymous inner class

### Static member class
* Similar to static field/method in the class.
* Can be accessed with OuterClass.InnerClass. No need to create object of outer class.
* Outer class can access all members (including private) of the inner class.
