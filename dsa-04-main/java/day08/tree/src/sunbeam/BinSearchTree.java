package sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinSearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		private boolean visited;
		public Node() {
			data = 0;
			left = null;
			right = null;
			visited = false;
		}
		public Node(int val) {
			data = val;
			left = null;
			right = null;
			visited = false;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
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

	public void nonrecInorder() {
		System.out.print("IN  : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while(trav != null || !s.isEmpty()) {
			while(trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if(!s.isEmpty()) {
				trav = s.pop();
				System.out.print(trav.data + ", ");
				trav = trav.right;
			}
		}
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

	public void nonrecPostorder() {
		System.out.print("POST: ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while(trav != null || !s.isEmpty()) {
			while(trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if(!s.isEmpty()) {
				trav = s.pop();
				if(trav.right == null || trav.right.visited) {
					System.out.print(trav.data + ", ");
					trav.visited = true;
					trav = null;
				}
				else {
					s.push(trav);
					trav = trav.right;
				}
			}
		}
		System.out.println();
	}
	
	public Node bfs(int key) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node trav = q.poll();
			if(key == trav.data)
				return trav;
			if(trav.left != null)
				q.offer(trav.left);
			if(trav.right != null)
				q.offer(trav.right);
		}
		return null;
	}
	
	public Node dfs(int key) {
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node trav = s.pop();
			if(key == trav.data)
				return trav;
			if(trav.right != null)
				s.push(trav.right);
			if(trav.left != null)
				s.push(trav.left);
		}
		return null;
	}
	
	public Node[] find(int key) {
		Node trav = root, parent = null;
		while(trav != null) {
			if(key == trav.data)
				return new Node[] { trav, parent };
			parent = trav;
			if(key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		return new Node[] { null, null };
	}
	
	public void del(int key) {
		// find the node along with it's parent
		Node[] result = find(key);
		Node succ, temp = result[0], parent = result[1];
		if(temp == null)
			return;
		// delete node with both child
		if(temp.left != null && temp.right != null) {
			// find inorder succ with it's parent
			parent = temp;
			succ = temp.right;
			while(succ.left != null) {
				parent = succ;
				succ = succ.left;
			}
			// overwrite temp's data by succ's data
			temp.data = succ.data;
			// delete succ node
			parent.left = succ.right;
		}
		// delete node with only left child
		else if(temp.right == null) {
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else
				parent.right = temp.left;
		}
		// delete node with only right child
		else if(temp.left == null) {
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else
				parent.right = temp.right;			
		}
	}

	public int height(Node trav) {
		if(trav == null)
			return -1;
		int hl = height(trav.left);
		int hr = height(trav.right);
		int max = (hl > hr ? hl : hr);
		return max + 1;
	}
	public int height() {
		return height(root);
	}
}

























