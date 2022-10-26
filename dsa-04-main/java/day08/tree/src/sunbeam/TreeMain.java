package sunbeam;

import sunbeam.BinSearchTree.Node;

public class TreeMain {
	public static void main(String[] args) {
		BinSearchTree t = new BinSearchTree();
		t.add(50);
		t.add(30);
		t.add(90);
		t.add(10);
		t.add(40);
		t.add(70);
		t.add(100);
		t.add(20);
		t.add(60);
		t.add(80);
		t.preorder();
		t.nonrecPreorder();
		t.inorder();
		t.nonrecInorder();
		t.postorder();
		t.nonrecPostorder();
		
		Node temp = t.bfs(60);
		System.out.println("BFS result: " + temp);
		
		temp = t.dfs(60);
		System.out.println("DFS result: " + temp);
		
		Node[] result = t.find(40);
		System.out.println("Node Found : " + result[0]);
		System.out.println("Parent Found : " + result[1]);
		
		System.out.println("Height: " + t.height());
		
		t.preorder();
		t.del(40);
		t.preorder();
	}
}


