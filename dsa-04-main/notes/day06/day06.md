# Data Structures and Algorithms

## Agenda
* Linked list interview questions

## Linked list interview questions

### Question 4
* Find middle of singly linear linked list using single pointer.
	```Java
	int recFindMid(Node cur, int count) {
		if(cur == null) {
			max = count;
			return 0;
		}
		int mid = recFindMid(cur.next, count+1);
		if(count == max / 2)
			mid = cur.data;
		return mid;
	}
	```

### Question 5
* Reverse singly linear linked list.
	```Java
	void reverse() {
		// consider list as old list
		Node oldhead = head;
		// consider new list as empty.
		head = null;
		
		while(oldhead != null) {
			// delete first node from old list
			Node temp = oldhead;
			oldhead = oldhead.next;
			// add that node into new list
			temp.next = head;
			head = temp;
		} // repeat until old list is finished
	}
	```

### Question 6
* Reverse singly linear linked list using recursion.
	```Java
	Node recReverse(Node cur) {
		// if single node left in list, then make it head
		if(cur.next == null) {
			head = cur;
			return cur;
		}
		// reverse rest of list & get last node
		Node last = recReverse(cur.next);
		// assign next of last node (of rest of list) to current node
		last.next = cur;
		// make current node as last (next = null)
		cur.next = null;
		// return current node (because it is last node for earlier call)
		return cur;
	}
	```

### Question 7
* Check if linked list contains a loop. Check if linked list is circular.
	* Logic: Use two pointers slow (incremented by 1) & fast (incremented by 2). If there is loop, slow and fast will point to same node eventually.

	```Java
	boolean containsLoop(Node cur) {
		Node slow = cur, fast = cur.next;
		while(slow != fast) {
			if(fast == null || fast.next == null)
				return false;
			slow = slow.next;
 			fast = fast.next.next;
		}
		return true;
	}
	```

### Question 8
* Check if given array is palindrome or not.
	
	```Java
	// Aux Space = O(1)
	// Iterations = n / 2
	boolean isPalindrome(int[] arr) {
		int i = 0, j = arr.length - 1;
		while(i < j) {
			if(arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	```

	```Java
	// Aux Space = O(n)
	// Iterations = 2 * n
	boolean isPalindrome(int[] arr) {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i < arr.length; i++)
			s.push(arr[i]);
		for(int i=0; i < arr.length; i++) {
			if(arr[i] != s.pop())
				return false;
		}
		return true;
	}
	```

### Question 9
* Check if singly linear linked list is palindrome or not.

	```Java
	// Aux Space = O(n)
	// Iterations = 2 * n
	boolean isPalindrome(int[] arr) {
		Stack<Integer> s = new Stack<>();
		for(Node i=head; i != null; i = i.next)
			s.push(i.data);
		for(Node i=head; i != null; i = i.next) {
			if(i.data != s.pop())
				return false;
		}
		return true;
	}
	```

* Implement in aux space O(1).
	* step 1: Find middle of the list (using fast & slow pointer). -- Iterations = n/2
	* step 2: Break list into two parts. 
	* step 3: Reverse second half of the list. -- Iterations = n/2
	* step 4: Compare first half list and second half list. If any element is mismatch, list is not palindrome. If all are matching (or if single element extra, list is palindrome). Iterations = n/2
	* step 5: Reverse second half of the list. -- Iterations = n/2
	* step 6: Append second half list to the fisrt half list.
	* Refer site: geeksforgeers.










