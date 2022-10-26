package sunbeam;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import sunbeam.AdjMatrixGraph.Edge;

public class WarshallFloydMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vCount);
		g.accept(sc);
		g.display();
		
		System.out.println("All pair distance matrix: ");
		int[][] dist = g.warshallFloyd();
		for (int s = 0; s < vCount; s++) {
			for (int d = 0; d < vCount; d++) 
				System.out.print(dist[s][d] + "\t");
			System.out.println();
		}
	}
}

/*
5
7
3 4 3
2 4 3
2 3 4
2 1 -2
1 3 -1
0 2 5
0 1 6
*/









