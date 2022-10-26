package sunbeam;

public class StackUsingQueueMain {
	public static void main(String[] args) {
		StackUsingQueue s = new StackUsingQueue();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		while(!s.isEmpty())
			System.out.println("Popped: " + s.pop());
	}
}
