package sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Weighted Un-directed Graph
public class AdjMatrixGraph {
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
	
	public int[] dijkstraSpt(int start) {
		// initially no vertex is added into spt
		boolean[] sptVert = new boolean[vertCount];
		// initially parent of each vertex as -1
		int[] parent = new int[vertCount];
		for(int v=0; v < vertCount; v++)
			parent[v] = -1;
		// dist of each vertex as INF and start vertex dist is 0
		int[] dist = new int[vertCount];
		for(int v=0; v < vertCount; v++)
			dist[v] = INF;
		dist[start] = 0;
		int sptVertCount = 0;
		// repeat until all vertices are added into spt
		while(sptVertCount < vertCount) {
			// pick a vertex with min dist (which is not in spt)
			int u = getMin(dist, sptVert);
			// include vertex in spt
			sptVert[u] = true;
			sptVertCount++;
			// update dist of non-spt neighbors (if dist of cur + connect edge weight < dist of neighbor)
			for(int v = 0; v < vertCount; v++) {
				if(mat[u][v] != INF && !sptVert[v] && dist[u] + mat[u][v] < dist[v]) {
					dist[v] = dist[u] + mat[u][v];
					// also update parent of v as u
					parent[v] = u;
				}
			}
		}
		return dist;
	}

	public int getMin(int[] dist, boolean[] sptVert) {
		int minKey = INF, minKeyVert = -1;
		for(int v = 0; v < vertCount; v++) {
			if(!sptVert[v] && dist[v] < minKey) {
				minKey = dist[v];
				minKeyVert = v;
			}
		}
		return minKeyVert;
	}
}





