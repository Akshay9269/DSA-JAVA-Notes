package sunbeam;

public class LinearQueue {
	private int[] arr;
	private int front;
	private int rear;
	
	public LinearQueue(int size) {
		front = -1;
		rear = -1;
		arr = new int[size];
	}
	
	void push(int val) {
		rear++;
		arr[rear] = val;
	}
	
	void pop() {
		front++;
	}
	
	int peek() {
		int next = front + 1;
		return arr[next];
	}
	
	boolean isEmpty() {
		return (front == rear);
	}
	
	boolean isFull() {
		return (rear == arr.length-1);
	}
}








