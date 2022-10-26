package sunbeam;

public class InterviewMain {
	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.display();
		
		//list.recRevDisplay();
		
		//int mid = list.recFindMid();
		//System.out.println("Middle element: " + mid);
		
		//list.reverse();
		//list.display();
	
		list.recReverse();
		list.display();
	}
}
