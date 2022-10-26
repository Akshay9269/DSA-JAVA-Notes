package sunbeam;

import java.util.Scanner;

public class SinglyCircularListMain {
	public static void main(String[] args) {
		SinglyCircularList list = new SinglyCircularList();
		Scanner sc = new Scanner(System.in);
		int choice, val, pos;
		do {
			System.out.print("\n1. display\n2. add first\n3. add last\n4. add at pos\n5. del first\n6. del last\n7. del at pos\n8. del all\nenter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				list.display();
				break;
			case 2:
				System.out.print("enter value: ");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3:
				System.out.print("enter value: ");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4:
				System.out.print("enter value: ");
				val = sc.nextInt();
				System.out.print("enter position: ");
				pos = sc.nextInt();
				list.addAtPos(val, pos);
				break;
			case 5:
				list.delFirst();
				break;
			case 6:
				list.delLast();
				break;
			case 7:
				System.out.print("enter position: ");
				pos = sc.nextInt();
				list.delAtPos(pos);
				break;
			case 8:
				list.delAll();
				break;
			}
		}while(choice != 0);
		
	}
}
