package sunbeam;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DijkstraMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vCount);
		g.accept(sc);
		g.display();
		
		int start = 0;
		int[] dist = g.dijkstraSpt(start);
		for (int i = 0; i < dist.length; i++)
			System.out.println("Distance of " + i + " from " + start + " = " + dist[i]);
	}
}

/*
9
14
7 6 1
8 2 2
6 5 2
0 1 4
2 5 4
8 6 6
2 3 7
7 8 7
0 7 8
1 2 8
3 4 9
5 4 10
1 7 11
3 5 14
*/









