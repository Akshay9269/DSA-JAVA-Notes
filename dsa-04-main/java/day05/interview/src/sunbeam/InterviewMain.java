package sunbeam;

public class InterviewMain {
	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		
		list.revDisplay();
	}
}
