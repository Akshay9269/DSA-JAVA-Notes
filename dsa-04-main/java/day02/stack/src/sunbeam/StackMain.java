package sunbeam;

import java.util.Scanner;

public class StackMain {
	public static void main(String[] args) {
		int choice, val;
		Scanner sc = new Scanner(System.in);
		StackImpl s = new StackImpl(6);
		do {
			System.out.print("\n\n1. Push\n2. Pop\n3. Peek\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // push
				if(s.isFull())
					System.out.println("Stack is Full.");
				else {
					System.out.print("Enter value to push: ");
					val = sc.nextInt();
					s.push(val);
				}
				break;
			case 2: // pop
				if(s.isEmpty())
					System.out.println("Stack is Empty.");
				else {
					val = s.peek();
					s.pop();
					System.out.println("Value Popped: " + val);
				}			
				break;
			case 3: // peek
				if(s.isEmpty())
					System.out.println("Stack is Empty.");
				else {
					val = s.peek();
					System.out.println("Value Peeked: " + val);
				}
				break;
			}
		} while(choice != 0);
	}
}
