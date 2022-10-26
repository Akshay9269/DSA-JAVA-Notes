package sunbeam;

import java.util.Arrays;

public class SortingMain {
	public static void mergeSort(int[] arr, int left, int right) {
		// if single elem or invalid part, do nothing
		if(left >= right)
			return;
		// find mid
		int mid = (left + right) / 2;
		// sort left partition
		mergeSort(arr, left, mid);
		// sort right partition
		mergeSort(arr, mid+1, right);
		// allocate temp array
		int[] temp = new int[right - left + 1];
		// merge both sorted parts into single partition
		int i = left, j = mid + 1, k = 0;
		while(i <= mid && j <= right) {
			//temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
			if(arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			}
			else {
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		while(i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		// copy temp array back to original array
		for(i=0; i < temp.length; i++)
			arr[left+i] = temp[i];
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		// if part contains single elem or invalid part, do nothing
		if(left >= right)
			return;
		// consider left most element as pivot
		int pivot = arr[left], i = left, j = right;
		while(i < j) {
			// from left find elem > pivot
			while(i <= right && arr[i] <= pivot)
				i++;
			// from right file elem <= pivot
			while(arr[j] > pivot)
				j--;
			// if i & j are not crossed, swap them
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		} // repeat until i & j cross each other.
		// swap pivot=arr[left] with arr[j]
		int temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;		
		// apply quick sort to left and right partition
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 7, 9, 2, 8, 1, 6, 3, 5};
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}



