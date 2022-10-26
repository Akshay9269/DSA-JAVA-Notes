package sunbeam;

public class HeapMain {
	public static void kthHighestElement() {
		int[] arr = {0, 20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		int k = 2;
		int max = 0;
		MaxHeap mh = new MaxHeap(arr);
		mh.makeHeap();
		for(int i=1; i <= k; i++) {
			max = mh.delMax();
		}// O(k log n)
		System.out.println(k + "th Max Elem = " + max);
	}
	
	public static void heapSort() {
		int[] arr = {0, 20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		MaxHeap mh = new MaxHeap(arr);
		mh.makeHeap(); // O(n log n)
		for(int i=1; i<arr.length; i++) {
			int max = mh.delMax(); // O(log n)
			arr[arr.length - i] = max;
		} // itrs = n --> O(n log n)
		for (int i = 1; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();
	} // O(n log n)
	
	public static void main(String[] args) {
		int[] arr = {0, 20, 12, 35, 15, 10, 80, 30, 17, 2, 1};
		MaxHeap mh = new MaxHeap(arr);
		mh.display();
		mh.makeHeap();
		mh.display();
		kthHighestElement();
		heapSort();
	}
}




