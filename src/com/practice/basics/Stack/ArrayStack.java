package com.practice.basics.Stack;

public class ArrayStack implements Stack {

	   private int top;       // reference to the top element
	   private int[] arr;
	  
	 /**
	   * Creates a Stack of the size initialCapacity
	   */
	public ArrayStack(int initialCapacity) {
		if (initialCapacity <= 0) {
			arr = new int[10];
		} else {
			arr = new int[initialCapacity];
		}
		top = 0; // stack is empty
	}
	  
	 /**
	   * Creates a Stack with the default capacity
	   */
	public ArrayStack() {
		this(10);
	}
	   
	@Override
	public boolean isEmpty() {
		return top == 0;
	}
	   
	@Override
	public int pop() throws StackException {
		int x = peek();

		//arr[top] = null; // make sure the object is destroyed
		return x;
	}
	   
	@Override
	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Stack is empty");
		}
		return arr[--top];
	}
	   
	@Override
	public void push(int e) throws StackException {
		if (top == arr.length) {
			throw new StackException("Stack is full");
		}

		arr[top++] = e;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[ ]";
		}

		StringBuffer out = new StringBuffer("[");
		for (int i = 0; i < top; i++) {
			out.append(arr[i] + ", ");
		}
		out.append(arr[top] + "]");
		
		return out.toString();
	}
	   
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(6);

		try {
			for (int i = 0; i < 6; i++) {
				s.push(i);
			}
			//System.out.print(s);
			for (int i = 0; i < 2; i++) {
				System.out.println(s.pop());
			}
			s.push(21);
			System.out.println(s.pop());
			s.push(11);
			System.out.println(s.pop());

		} catch (StackException e) {
			System.err.println(e);
		}
	}

}
