package sunbeam;

import java.util.Scanner;

public class SearchingMain {
	public static int linearSearch(int arr[], int key) {
		int i;
		for(i = 0; i < arr.length; i++) {
			if(key == arr[i])
				return i;
		}
		return -1;
	}
	
	public static int binarySearch(int arr[], int key) {
		int left = 0, right = arr.length - 1, mid;
		while(left <= right) {
			mid = (left + right) / 2;
			if(key == arr[mid])
				return mid;
			if(key < arr[mid])
				right = mid - 1;
			else // (key > arr[mid])
				left = mid + 1;
		}
		return -1;
	}
	
	public static int recBinarySearch(int arr[], int left, int right, int key) {
		if(left > right)
			return -1;
		int index, mid = (left + right) / 2;
		if(key == arr[mid])
			return mid;
		if(key < arr[mid])
			index = recBinarySearch(arr, left, mid-1, key);
		else //(key > arr[mid])
			index = recBinarySearch(arr, mid+1, right, key);
		return index;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		System.out.println("Enter number to search: ");
		int key = sc.nextInt();
		/*
		int index = linearSearch(arr, key);
		if(index == -1)
			System.out.println("Element is not found.\n");
		else
			System.out.println("Element is found at index " + index);
		*/
		/*
		int index = binarySearch(arr, key);
		if(index == -1)
			System.out.println("Element is not found.\n");
		else
			System.out.println("Element is found at index " + index);
		*/
		int index = recBinarySearch(arr, 0, arr.length-1, key);
		if(index == -1)
			System.out.println("Element is not found.\n");
		else
			System.out.println("Element is found at index " + index);
	}
}





