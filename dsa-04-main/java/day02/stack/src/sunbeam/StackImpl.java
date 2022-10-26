package sunbeam;

public class StackImpl {
	private int[] arr;
	private int top;
	
	public StackImpl(int size) {
		top = -1;
		arr = new int[size];
	}

	public void push(int val) {
		top++;
		arr[top] = val;
	}
	
	public int peek() {
		return arr[top];
	}
	
	public void pop() {
		top--;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == arr.length-1;
	}
}


