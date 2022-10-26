# Data Structures and Algorithms

## Agenda
* Linked List

## Expression
* Multi-digit expressions
* Infix Input: 12 + 34 * 45

```Java
boolean isOperand(String str) {
	try{
		Integer.parseInt(str);
		return true;
	} catch(Exception e) {
	}
	return false;
}
String infixToPostfix(String in) {
	String[] infix = in.split(" ");
	String postfix = "";
	Stack<Character> s = new Stack<>();
	for(int i=0; i<infix.length; i++) {
		String sym = infix[i];
		if(isOperand(sym))
			postfix = postfix + sym + " ";
		else if(sym.equals("("))
			s.push(sym.charAt(0));
		else if(sym.equals(")")) {
			// ...
		} else // operator {
			// ...
		}
	}
	// ...
	return postfix;
}

```

## Queue
* java.util.Queue<> interface
	* java.util.LinkedList<> class inherited from Queue<> interface.
	* LinkedList<> is derived/sub class and Queue<> is base/super interface.
* Derived/sub class object can be referenced from Base/super class reference.

```Java
Queue<Integer> main = new LinkedList<>();
```

## Linked List
* Linked list is list of items linked together.
	* Item --> Node --> Data + Next.
* Java Implementation
	* Node --> class
	* Linked List --> class
	* Node class as static member of LinkedList class. Outer class (Linked List class) can access private members of Inner class (Node class) directly.
