package sunbeam;

import java.util.Scanner;

public class NonWeightedAdjMatrixGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjMatrixGraph g = new AdjMatrixGraph(vCount);
		g.accept(sc);
		g.display();
		g.bfsTrav(0);
		g.dfsTrav(0);
		System.out.println("Is Connected: " + g.isConnected());
	}
}

/*
6
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5
*/