# Data Structures And Algorithms

## Agenda
* A* Search Algorithm
* Merge Sort
* Quick Sort
* Sorting Algorithm Comparisons

## Merge Sort

```Java
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
```
