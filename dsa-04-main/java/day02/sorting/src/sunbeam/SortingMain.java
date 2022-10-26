package sunbeam;

public class SortingMain {
	
	public static void printArray(int[] arr) {
		System.out.print("Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();
	}
	
	public static void selectionSort(int[] arr) {
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
	
	public static void bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				count++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Iterations = " + count);
	}
	
	public static void improvedBubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				count++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Iterations = " + count);
	}
	
	public static void furtherImprovedBubbleSort(int[] arr) {
		int count = 0, flag;
		for (int i = 0; i < arr.length-1; i++) {
			flag = 0;
			for (int j = 0; j < arr.length-1-i; j++) {
				count++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0)
				break;
		}
		System.out.println("Iterations = " + count);
	}
	
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j, temp = arr[i];
			for(j = i-1; j >= 0 && arr[j] > temp; j--) {
				arr[j+1] = arr[j]; 
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 6, 3, 8, 2, 4 };
		printArray(arr);
		//selectionSort(arr);
		//bubbleSort(arr);
		//improvedBubbleSort(arr);
		//printArray(arr);
		//furtherImprovedBubbleSort(arr);
		//printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}
}
