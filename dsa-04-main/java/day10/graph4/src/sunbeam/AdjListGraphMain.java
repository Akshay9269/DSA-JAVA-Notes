package sunbeam;

import java.util.Scanner;

public class AdjListGraphMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of vertices: ");
		int vCount = sc.nextInt();
		AdjListGraph g = new AdjListGraph(vCount);
		g.accept(sc);
		g.display();
		g.dfsTrav(0);
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