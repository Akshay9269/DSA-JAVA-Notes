package sunbeam;

public class TreeMain {
	public static void main(String[] args) {
		BinSearchTree t = new BinSearchTree();
		t.add(50);
		t.add(25);
		t.add(75);
		t.add(10);
		t.add(35);
		t.add(65);
		t.add(85);
		t.add(30);
		t.add(40);
		t.add(70);
		t.add(80);
		t.add(90);
		t.preorder();
		t.nonrecPreorder();
		t.inorder();
		t.postorder();
	}
}
