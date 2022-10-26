package sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Non-weighted Adj List Graph implementation
public class AdjListGraph {
	private List<Integer>[] adjlist;
	private int vertCount;
	private int edgeCount;

	public AdjListGraph(int vCount) {
		vertCount = vCount;
		adjlist = new List[vertCount];
		for (int i = 0; i < adjlist.length; i++)
			adjlist[i] = new ArrayList<Integer>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for(int i=0; i<edgeCount; i++) {
			System.out.print("Enter edge (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjlist[src].add(dest);
			adjlist[dest].add(src); // remove this line for directed graph implementation 
		}
		System.out.println();
	}
	
	public void display() {
		for (int v = 0; v < vertCount; v++) {
			System.out.print(v + " : ");
			for (int dest : adjlist[v])
				System.out.print(dest + " -> ");
			System.out.println();
		}
	}
	
	public void dfsTrav(int start) {
		System.out.print("DFS: ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<Integer>();
		// push start vertex on stack and mark it
		s.push(start);
		marked[start] = true;
		while(!s.isEmpty()) {
			// pop a vertex from stack and visit it
			int trav = s.pop();
			System.out.print(trav + ", ");
			// push all non-marked neighbors on stack and mark them
			for(int dest : adjlist[trav]) {
				if(!marked[dest]) {
					s.push(dest);
					marked[dest] = true;
				}
			}
		} // repeat until stack is empty
		System.out.println();
	}
}





