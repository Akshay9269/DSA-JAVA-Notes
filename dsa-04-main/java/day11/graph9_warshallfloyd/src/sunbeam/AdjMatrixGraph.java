package sunbeam;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public int[][] warshallFloyd() {
		// maintain dist matrix to keep track of dist from each vertex to every other vertex
		int[][] dist = new int[vertCount][vertCount];
		// dp init -- initially dist[s][d] = adjmat[s][d] and dist[v][v] = 0
		for (int s = 0; s < vertCount; s++) {
			for (int d = 0; d < vertCount; d++)
				dist[s][d] = mat[s][d];
			dist[s][s] = 0;
		}
		// consider each vertex as intermediate between source and dest
		for(int i = 0; i < vertCount; i++) {
			for (int s = 0; s < vertCount; s++) {
				for (int d = 0; d < vertCount; d++) {
					if(dist[s][i] != INF && dist[i][d] != INF && dist[s][i] + dist[i][d] < dist[s][d])
						dist[s][d] = dist[s][i] + dist[i][d];
				}
			}
		}
		return dist;
	}
}







