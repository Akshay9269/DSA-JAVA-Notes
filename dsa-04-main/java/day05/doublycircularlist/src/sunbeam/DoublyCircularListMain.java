package sunbeam;

public class DoublyCircularListMain {
	public static void main(String[] args) {
		DoublyCircularList list = new DoublyCircularList();
		list.addLast(11);
		list.addLast(22);
		list.addLast(33);
		list.addLast(44);
		list.displayFwd();
		list.displayRev();
		list.addFirst(55);
		list.displayFwd();
		list.displayRev();
	}
}
