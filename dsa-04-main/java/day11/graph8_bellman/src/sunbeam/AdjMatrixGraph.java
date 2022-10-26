package sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Weighted Directed Graph
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
	
	public int[] bellmanFord(int start) {
		// mark dist of all vertices as INF and dist of start vertex as 0
		int[] dist = new int[vertCount];
		for (int v = 0; v < vertCount; v++)
			dist[v] = INF;
		dist[start] = 0;
		
		// for V-1 passes process all edges
		for(int i = 1; i < vertCount; i++) {
			for (Edge e : edgeList) {
				int u = e.src, v = e.dest, wt = e.weight;
				if(dist[u] != INF && (dist[u] + wt) < dist[v])
					dist[v] = dist[u] + wt;
			}
		}
		
		// check if -ve weight cycle exists
		for (Edge e : edgeList) {
			int u = e.src, v = e.dest, wt = e.weight;
			if(dist[u] != INF && (dist[u] + wt) < dist[v])
				return null; // bellman ford is not applicable (-ve weight cycle)
		}
		
		return dist;
	}
}







