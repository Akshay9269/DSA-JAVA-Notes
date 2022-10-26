package sunbeam;

public class FIbonacciMain {
	
	private static int fnCallCount;
	
	public static int recFib(int n) {
		fnCallCount++;
		if(n == 1 || n == 2)
			return 1;
		return recFib(n-1) + recFib(n-2);
	}
	
	public static int memFib(int n, int[] terms) {
		fnCallCount++;
		if(terms[n] != 0)
			return terms[n];
		if(n == 1 || n == 2) {
			terms[n] = 1;
			return terms[n];
		}
		terms[n] = memFib(n-1, terms) + memFib(n-2, terms);
		return terms[n];
	}
	
	public static int memFib(int n) {
		int[] terms = new int[n+1];
		return memFib(n, terms);
	}
	
	public static int dpFib(int n) {
		fnCallCount++;
		int[] terms = new int[n+1];
		// db base condition/initialization
		terms[1] = terms[2] = 1;
		// calc terms in bottom-up approach
		for(int i = 3; i <= n; i++)
			terms[i] = terms[i-1] + terms[i-2];
		return terms[n];
	}
	
	public static void main(String[] args) {
		int result, term;
		term = 30;

		fnCallCount = 0;
		result = recFib(term);
		System.out.println("fib term " + term + " = " + result + " with rec calls " + fnCallCount);
	
		fnCallCount = 0;
		result = memFib(term);
		System.out.println("fib term " + term + " = " + result + " with rec calls " + fnCallCount);
	
		fnCallCount = 0;
		result = dpFib(term);
		System.out.println("fib term " + term + " = " + result + " with rec calls " + fnCallCount);
	}
}
