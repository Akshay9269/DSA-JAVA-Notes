package sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Non-weighted Un-directed Graph
public class AdjMatrixGraph {
	private int [][] mat;
	private int vertCount, edgeCount;
	
	public AdjMatrixGraph(int vCount) {
		vertCount = vCount;
		mat = new int[vertCount][vertCount];
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for(int i=0; i < edgeCount; i++) {
			System.out.print("Enter egde (src dest): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			mat[src][dest] = 1;
			mat[dest][src] = 1; // remove this line for directed graph
		}
	}
	
	public void display() {
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++)
				System.out.print("\t" + mat[i][j]);
			System.out.println();
		}
	}
	
	public void bfsTrav(int start) {
		System.out.print("BFS: ");
		boolean[] marked = new boolean[vertCount];
		Queue<Integer> q = new LinkedList<>();
		// push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		while(!q.isEmpty()) {
			// pop a vertex and visit it
			int trav = q.poll();
			System.out.print(trav+ ", ");
			// push all non-marked neighbors on the queue and mark them
			for(int dest = 0; dest < vertCount; dest++) {
				if(mat[trav][dest] != 0 && !marked[dest]) {
					q.offer(dest);
					marked[dest] = true;
				}
			}
		} // repeat until queue is empty
		System.out.println();
	}
	
	public void dfsTrav(int start) {
		System.out.print("DFS: ");
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<>();
		// push start vertex on stack and mark it
		s.push(start);
		marked[start] = true;
		while(!s.isEmpty()) {
			// pop a vertex and visit it
			int trav = s.pop();
			System.out.print(trav+ ", ");
			// push all non-marked neighbors on the stack and mark them
			for(int dest = 0; dest < vertCount; dest++) {
				if(mat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
				}
			}
		} // repeat until stack is empty
		System.out.println();
	}
	
	public boolean isConnected() {
		boolean[] marked = new boolean[vertCount];
		Stack<Integer> s = new Stack<>();
		// push start vertex on stack and mark it
		int start = 0;
		s.push(start);
		marked[start] = true;
		// count each vertex when push on stack
		int vCount = 1;
		while(!s.isEmpty()) {
			// pop a vertex and visit it
			int trav = s.pop();
			// push all non-marked neighbors on the stack and mark them
			for(int dest = 0; dest < vertCount; dest++) {
				if(mat[trav][dest] != 0 && !marked[dest]) {
					s.push(dest);
					marked[dest] = true;
					vCount++; // count each vertex when push on stack
					if(vCount ==  vertCount) // if all vertices are counted, then graph is connected
						return true;
				}
			}
		} // repeat until stack is empty		
		return false; // not all vertices are reached/counted.
	}
}
















