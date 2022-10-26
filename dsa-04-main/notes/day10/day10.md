# Data Structures and Algorithms

## Agenda
* BFS & DFS based algorithms
	* DFS Spanning Tree
	* BFS Spanning Tree
	* Single source path length
	* Check Bi-partiteness
* Greedy programming
* Kruskal's MST algorithm
* Union-Find algorithm
* Prim's MST algorithm

## Greedy Approach
* Write a function that returns minimum number of coins for the given amount.
	* arg 1: The amount
	* arg 2: Available coins (in desc order)

```Java
public static int getMinNumOfCoins(int amount, int[] coins) {

}
public static void main(String[] args) {
	int[] coins = { 100, 50, 20, 10, 5, 1 };
	int count = getMinNumOfCoins(46, coins);
	System.out.println("Number of coins " + count);
}
// 36 = 20 + 10 + 5 + 1
// 46 = 20 + 20 + 5 + 1
// 43 = 20 + 20 + 1 + 1 + 1
```

