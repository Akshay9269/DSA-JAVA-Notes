package sunbeam;

import java.util.Stack;

public class BinSearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		public Node() {
			data = 0;
			left = null;
			right = null;
		}
		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	private Node root;
	public BinSearchTree() {
		root = null;
	}
	public void add(int val) {
		// create a new node and init it
		Node newNode = new Node(val);
		// if tree is empty, add node at root
		if(root == null)
			root = newNode;
		else {
			// traverse to find correct pos for new node
			Node trav = root;
			while(true) {
				// if new node is less than trav data, add node in left sub-tree
				if(val < trav.data) {
					// if left is null, add node there
					if(trav.left == null) {
						trav.left = newNode;
						break;
					}
					else // otherwise, go to left
						trav = trav.left;
				}
				// if new node is greater or equal trav data, add node in right sub-tree
				else {
					// if right is null, add node there
					if(trav.right == null) {
						trav.right = newNode;
						break;
					}
					else // otherwise, go to right
						trav = trav.right;					
				}
			}
		}
	}
	
	public void preorder(Node cur) {
		if(cur == null)
			return;
		System.out.print(cur.data + ", ");
		preorder(cur.left);
		preorder(cur.right);
	}
	public void preorder() {
		System.out.print("PRE : ");
		preorder(root);
		System.out.println();
	}
	
	public void nonrecPreorder() {
		System.out.print("PRE : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while(trav != null || !s.isEmpty()) {
			while(trav != null) {
				System.out.print(trav.data + ", ");
				if(trav.right != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if(!s.isEmpty())
				trav = s.pop();
		}
		System.out.println();
	}
	
	public void inorder(Node cur) {
		if(cur == null)
			return;
		inorder(cur.left);
		System.out.print(cur.data + ", ");
		inorder(cur.right);
	}
	public void inorder() {
		System.out.print("IN  : ");
		inorder(root);
		System.out.println();
	}

	public void postorder(Node cur) {
		if(cur == null)
			return;
		postorder(cur.left);
		postorder(cur.right);
		System.out.print(cur.data + ", ");
	}
	public void postorder() {
		System.out.print("POST: ");
		postorder(root);
		System.out.println();
	}

}






