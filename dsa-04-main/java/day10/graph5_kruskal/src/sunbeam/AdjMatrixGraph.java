package sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Weighted Un-directed Graph
public class AdjMatrixGraph {
	
	static class Edge {
		private int src;
		private int dest;
		private int weight;
		public Edge() {
			src = 0;
			dest = 0;
			weight = 0;
		}
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}
		public int getWeight() {
			return weight;
		}
		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
		}
	}
	
	
	public static final int INF = 999;
	private int [][] mat;
	private int vertCount, edgeCount;
	
	private List<Edge> edgeList;
	
	public AdjMatrixGraph(int vCount) {
		vertCount = vCount;
		mat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++)
			for (int j = 0; j < vertCount; j++)
				mat[i][j] = INF;
		edgeList = new ArrayList<>();
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter number of edges: ");
		edgeCount = sc.nextInt();
		for(int i=0; i < edgeCount; i++) {
			System.out.print("Enter egde (src dest weight): ");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			mat[src][dest] = wt;
			mat[dest][src] = wt;
		
			Edge e = new Edge(src, dest, wt);
			edgeList.add(e);
		}
	}
	
	public void display() {
		for (int i = 0; i < vertCount; i++) {
			for (int j = 0; j < vertCount; j++) {
				if(mat[i][j] == INF)
					System.out.print("\t##");
				else
					System.out.print("\t" + mat[i][j]);
			}
			System.out.println();
		}
	}
	
	public void union(int sr, int dr, int[] parent) {
		parent[sr] = dr;
	}
	
	public int find(int v, int[] parent) {
		while(parent[v] != -1)
			v = parent[v];
		return v;
	}
	
	public boolean containsCycle(List<Edge> mst) {
		// initially consider each vertex as independent (dis-joint) i.e. parent = -1
		int[] parent = new int[vertCount];
		for (int v = 0; v < parent.length; v++)
			parent[v] = -1;
		// for each edge in graph/mst
		for(Edge e : mst) {
			// find root of src vertex
			int sr = find(e.src, parent);
			// find root of dest vertex
			int dr = find(e.dest, parent);
			// if roots are same, cycle is detected
			if(sr == dr)
				return true;
			// otherwise union src and dest sets
			union(sr, dr, parent);
		}
		return false;
	}
	
	public List<Edge> kruskalMst() {
		List<Edge> mst = new ArrayList<>();
		// sort all edges in ascending order of their weights
		edgeList.sort((e1, e2) -> e1.weight - e2.weight);
		int i = 0;
		while(mst.size() < (vertCount-1)) {
			// pick edge with minimum weight
			Edge e = edgeList.get(i);
			i++;
			// add it into MST
			mst.add(e);
			// if forming cycle in MST, discard (last added edge) it
			if(containsCycle(mst))
				mst.remove(mst.size()-1);
		} // repeat until V-1 edges
		return mst;
	}
}







