package sunbeam;

import java.util.Stack;

public class ExpressionMain {
	public static int pri(char op) {
		switch(op) {
			case '$':	return 10;
			case '*':	return 7;
			case '/':	return 7;
			case '+':	return 3;
			case '-':	return 3;
		}
		return 0;
	}
	
	public static int calc(int a, int b, char op) {
		switch(op) {
			case '$':	return (int)Math.pow(a, b);
			case '*':	return a * b;
			case '/':	return a / b;
			case '+':	return a + b;
			case '-':	return a - b;
		}
		return 0;		
	}
	
	public static String infixToPostfix(String infix) {
		Stack<Character> s = new Stack<>(); // stack of operators
		String postfix = ""; // postfix expr
		// process infix expr from left to right.
		for(int i=0; i < infix.length(); i++) {
			char sym = infix.charAt(i);
			// if symbol is operand, append to postfix.
			if(Character.isDigit(sym))
				postfix = postfix + sym;
			// if opening ( is found, push it on the stack
			else if(sym == '(')
				s.push(sym);
			// if closing ) is found, pop all operators from stack and append to postfix until opening ( is found.
			else if(sym == ')') {
				while(s.peek() != '(')
					postfix = postfix + s.pop();
				// discard opening (.
				s.pop();
			}
			else { // if symbol is operator, 
				// if priority of top-most operator on stack >= priority of current operator, pop and append it to postfix.
				while(!s.isEmpty() && pri(s.peek()) >= pri(sym))
					postfix = postfix + s.pop();
				// push to stack.
				s.push(sym);
			}
		}
		// if all symbols in infix expression are completed, pop all operators from stack and append to postfix.
		while(!s.isEmpty())
			postfix = postfix + s.pop();
		return postfix;
	}
	
	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<>();
		String prefix = "";
		// process infix expr from right to left.
		for(int i=infix.length()-1; i >= 0; i--) {
			char sym = infix.charAt(i);
			// if symbol is operand, append to prefix.
			if(Character.isDigit(sym))
				prefix = prefix + sym;
			// if closing ) is found, push it on the stack
			else if(sym == ')')
				s.push(sym);
			// if opening ( is found, pop all operators from stack and append to prefix until closing ) is found.
			else if(sym == '(') {
				while(s.peek() != ')')
					prefix = prefix + s.pop();
				// discard closing ).
				s.pop();
			}
			else { // if symbol is operator, 
				// if priority of top-most operator on stack > priority of current operator, pop and append it to prefix.
				while(!s.isEmpty() && pri(s.peek()) > pri(sym))
					prefix = prefix + s.pop();
				// push to stack.
				s.push(sym);
			}
		}
		// if all symbols in infix expression are completed, pop all operators from stack and append to prefix.
		while(!s.isEmpty())
			prefix = prefix + s.pop();
		// reverse the prefix expression and return
		prefix = new StringBuilder(prefix).reverse().toString();
		return prefix;
	}
	
	public static int postfixEvaluate(String postfix) {
		Stack<Integer> s  = new Stack<>(); // stack of operands
		// process postfix from left to right
		for(int i = 0; i < postfix.length(); i++) {
			char sym = postfix.charAt(i);
			// if current sym is operand, push on stack -- char to int converion
			if(Character.isDigit(sym))
				s.push(sym - '0');
			// if current sym is operator, pop two operands from stack, calculate result and push it on stack
			else {
				int b = s.pop(); // first popped is second operand
				int a = s.pop(); // second popped is first operand
				int res = calc(a, b, sym);
				s.push(res);
			}
		}
		// when all syms from postfix are completed, then get final result from stack & return
		int result = s.pop();
		return result;
	}
	
	public static int prefixEvaluate(String prefix) {
		Stack<Integer> s  = new Stack<>(); // stack of operands
		// process prefix from right to left
		for(int i = prefix.length()-1; i >= 0; i--) {
			char sym = prefix.charAt(i);
			// if current sym is operand, push on stack -- char to int converion
			if(Character.isDigit(sym))
				s.push(sym - '0');
			// if current sym is operator, pop two operands from stack, calculate result and push it on stack
			else {
				int a = s.pop(); // first popped is first operand
				int b = s.pop(); // second popped is second operand
				int res = calc(a, b, sym);
				s.push(res);
			}
		}
		// when all syms from prefix are completed, then get final result from stack & return
		int result = s.pop();
		return result;
	}
	
	public static boolean parenthesisBalancing(String expr) {
		// stack to store opening parenthesis
		Stack<Character> s = new Stack<>();
		String opening = "([{", closing = ")]}";
		// process expr from left to right
		for(int i=0; i<expr.length(); i++) {
			char sym = expr.charAt(i);
			// if sym is opening ([{, then push on stack
			if(opening.indexOf(sym) != -1)
				s.push(sym);
			else {
				int closingIndex = closing.indexOf(sym);
				// if sym is closing )]}, then pop one sym from stack.
				if(closingIndex != -1) {
					// if stack is empty, then return false
					if(s.isEmpty())
						// "sym" is not having matching opening par.
						return false;
					
					char open = s.pop();
					int openingIndex = opening.indexOf(open);
					// if index of opening & closing is not matching, then return false
					if(openingIndex != closingIndex)
						// "sym" is mismatched at index "i"
						return false;
				}
			}
		}
		// when all syms are completed and stack is not empty, then return false
		if(!s.isEmpty())
			// excess opening par in the expr -- no closing found.
			return false;
		return true; // return true -- balanced.
	}

	public static void main(String[] args) {
		/*
		String infix = "5+9-4*(8-6/2)+1$(7-3)";
		String postfix = "", prefix = "";
		postfix = infixToPostfix(infix);
		prefix = infixToPrefix(infix);
		System.out.println("Infix : " + infix);
		System.out.println("Postfix : " + postfix);
		System.out.println("Prefix : " + prefix);
		int result = postfixEvaluate(postfix);
		System.out.println("Postfix Result: " + result);
		result = prefixEvaluate(prefix);
		System.out.println("Prefix Result: " + result);
		*/
		
		String expr = "5+([9+4}*(8-{6/2}))";
		boolean balanced = parenthesisBalancing(expr);
		if(balanced)
			System.out.println("All parenthesis are correct.");
		else
			System.out.println("Parenthesis mismatch.");
	}
}








