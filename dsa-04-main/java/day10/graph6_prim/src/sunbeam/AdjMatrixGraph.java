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
		
	public AdjMatrixGraph(int vCount) {
		vertCount = vCount;
		mat = new int[vertCount][vertCount];
		for (int i = 0; i < vertCount; i++)
			for (int j = 0; j < vertCount; j++)
				mat[i][j] = INF;
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
	
	public List<Edge> primMst(int start) {
		// initially no vertex is added into mst
		boolean[] mstVert = new boolean[vertCount];
		// initially parent of each vertex as -1
		int[] parent = new int[vertCount];
		for(int v=0; v < vertCount; v++)
			parent[v] = -1;
		// key of each vertex as INF and start vertex key is 0
		int[] key = new int[vertCount];
		for(int v=0; v < vertCount; v++)
			key[v] = INF;
		key[start] = 0;
		int mstVertCount = 0;
		// repeat until all vertices are added into mst
		while(mstVertCount < vertCount) {
			// pick a vertex with min key (which is not in mst)
			int u = getMin(key, mstVert);
			// include vertex in mst
			mstVert[u] = true;
			mstVertCount++;
			// update keys of non-mst neighbors (if connect edge weight < key of the neighbor)
			for(int v = 0; v < vertCount; v++) {
				if(mat[u][v] != INF && !mstVert[v] && mat[u][v] < key[v]) {
					key[v] = mat[u][v];
					// also update parent of v as u
					parent[v] = u;
				}
			}
		}
		// return mst
		List<Edge> mst = new ArrayList<>();
		for (int v = 0; v < vertCount; v++) {
			int src = parent[v];
			if(src != -1) {
				Edge e = new Edge(parent[v], v, mat[src][v]);
				mst.add(e);
			}
		}
		return mst;
	}

	public int getMin(int[] key, boolean[] mstVert) {
		int minKey = INF, minKeyVert = -1;
		for(int v = 0; v < vertCount; v++) {
			if(!mstVert[v] && key[v] < minKey) {
				minKey = key[v];
				minKeyVert = v;
			}
		}
		return minKeyVert;
	}
}





