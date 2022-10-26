package sunbeam;

public class MaxHeap {
	private int[] arr;
	private int size;
	
	public MaxHeap(int[] a) {
		arr = a;
		size = a.length - 1;
	}
	public void makeHeap() {
		// size of heap = num of elements in array - 1 (because element 0 is unused).
		size = arr.length - 1;
		// from mid elem to first elem, check if elem is greater than both of its child elems.
		for(int i = size/2; i >= 1; i--) {
			// take ith elem into temp var and it's left child = 2 * i.
			int temp = arr[i], ci = i * 2;
			// find appropriate pos for temp
			while(ci <= size) {
				// check if right child is avail and is greater than left child
				if((ci + 1) <= size && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				// if temp is greater than the greatest child, then break;
				if(temp > arr[ci])
					break;
				// promote greatest child to it's parent pos.
				arr[ci / 2] = arr[ci];
				// repeat process for child (check if temp is suitable at child pos)
				ci = ci * 2;
			} // itrs = height --> O(log n)
			// put temp into parent pos.
			arr[ci/2] = temp;
		} // itrs = n / 2 --> O(n log n)
	}
	public int delMax() {
		// get max elem from heap
		int max = arr[1];
		// get last elem and decrease size of heap
		int temp = arr[size];
		size = size - 1;
		// find appropriate pos for temp -- starting from root
		int i = 1, ci = i * 2;
		while(ci <= size) {
			// check if right child is avail and is greater than left child
			if((ci + 1) <= size && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			// if temp is greater than the greatest child, then break;
			if(temp > arr[ci])
				break;
			// promote greatest child to it's parent pos.
			arr[ci / 2] = arr[ci];
			// repeat process for child (check if temp is suitable at child pos)
			ci = ci * 2;
		} // itrs = height --> O(log n)
		// put temp into parent pos.
		arr[ci/2] = temp;
		return max;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() {
		for (int i = 1; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();
	}
}





