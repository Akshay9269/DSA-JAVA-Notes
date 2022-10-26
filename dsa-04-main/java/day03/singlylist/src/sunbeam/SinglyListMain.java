package sunbeam;

public class SinglyListMain {
	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.addLast(11);
		list.addLast(22);
		list.addLast(33);
		list.addLast(44);
		list.display(); // not print anything ... addLast() is not implementd
	}
}

