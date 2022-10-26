def selectionSort(arr):
	# select i th element
	for i in range(len(arr)-1):
		# compare selected element with all elements after that
		for j in range(i+1, len(arr)):
			# if i th element > j th element, swap them
			if(arr[i] > arr[j]):
				temp = arr[i]
				arr[i] = arr[j]
				arr[j] = temp


def main():
	arr = [ 5, 4, 2, 6, 3, 1 ]
	selectionSort(arr)
	print(arr)


if __name__ == "__main__":
	main()
