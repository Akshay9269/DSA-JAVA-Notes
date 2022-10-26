package sunbeam;

import java.util.Scanner;

public class QueueMain {
	public static void main(String[] args) {
		int choice, val;
		Scanner sc = new Scanner(System.in);
		//LinearQueue q = new LinearQueue(6);
		CircularQueue q = new CircularQueue(6);
		do {
			System.out.print("\n\n1. Push\n2. Pop\n3. Peek\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // push
				if(q.isFull())
					System.out.println("Queue is Full.");
				else {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					q.push(val);
				}
				break;
			case 2: // pop
				if(q.isEmpty())
					System.out.println("Queue is Empty.");
				else {
					val = q.peek();
					q.pop();
					System.out.println("Value Popped: " + val);
				}			
				break;
			case 3: // peek
				if(q.isEmpty())
					System.out.println("Queue is Empty.");
				else {
					val = q.peek();
					System.out.println("Value Peeked: " + val);
				}
				break;
			}
		} while(choice != 0);
	}
}

