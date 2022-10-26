package sunbeam;

import java.util.Iterator;

public class SortingMain {
	public static void selectionSort(int arr[]) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = { 5, 6, 3, 8, 2, 4 };
		
		System.out.print("Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();
		
		selectionSort(arr);
		
		System.out.print("Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();
	}
}
