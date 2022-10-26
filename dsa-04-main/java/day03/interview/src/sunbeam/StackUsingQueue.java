package sunbeam;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	private Queue<Integer> main;
	
	public StackUsingQueue() {
		main = new LinkedList<>();
	}
	
	public void push(int ele) {
		Queue<Integer> temp = new LinkedList<>();
		// pop all from main queue and push into temp queue
		while(!main.isEmpty())
			temp.offer( main.poll() );
		// push new element into main queue
		main.offer(ele);
		// pop all from temp queue and push into main queue
		while(!temp.isEmpty())
			main.offer( temp.poll() );
	}
	
	public int pop() {
		return main.poll();
	}
	
	public boolean isEmpty() {
		return main.isEmpty();
	}
}





