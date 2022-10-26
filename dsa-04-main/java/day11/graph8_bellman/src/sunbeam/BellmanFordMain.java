package sunbeam;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import sunbeam.AdjMatrixGraph.Edge;

public class BellmanFordMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vCount);
		g.accept(sc);
		g.display();
		
		int start = 0;
		int[] dist = g.bellmanFord(start);
		for (int i = 0; i < dist.length; i++)
			System.out.println("Distance of " + i + " from " + start + " = " + dist[i]);
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









