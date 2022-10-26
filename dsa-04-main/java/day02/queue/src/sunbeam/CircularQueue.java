package sunbeam;

public class CircularQueue {
	private int[] arr;
	private int front;
	private int rear;
	
	public CircularQueue(int size) {
		front = -1;
		rear = -1;
		arr = new int[size];
	}
	
	void push(int val) {
		rear = (rear + 1) % arr.length;
		arr[rear] = val;
	}
	
	void pop() {
		front = (front + 1) % arr.length;
		// after delete, if it was last element then reset the queue
		if(front == rear) {
			front = -1;
			rear = -1;
		}
	}
	
	int peek() {
		int next = (front + 1) % arr.length;
		return arr[next];
	}
	
	boolean isEmpty() {
		return (front == rear && front == -1);
	}
	
	boolean isFull() {
		return (front == -1 && rear == arr.length-1) || (front == rear && front != -1);
	}
}








