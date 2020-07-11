package com.practice.basics.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	StackUsingTwoQueues() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int i) {
		if (queue1.size() == 0) {
			queue1.add(i);
		} else {
			int sizeOfQueue1 = queue1.size();
			// Move elements of Queue1 to Queue2
			for (int j = 0; j < sizeOfQueue1; j++) {
				queue2.add(queue1.remove());
			}
			// Add the new element into queue1
			queue1.add(i);
			// Move elements from Queue2 to Queue1
			for (int k = 0; k < sizeOfQueue1; k++) {
				queue1.add(queue2.remove());
			}
		}
	}

	public int pop() {
		if (queue1.size() == 0) {
			throw new StackException("Underflow Exception");
		}
		return queue1.remove();
	}
	
	@Override
	public String toString() {
		StringBuffer out = new StringBuffer("[");
		for (int i = 0; i < queue1.size(); i++) {
			out.append(queue1.poll() + ", ");
		}
		out.append("]");
		return out.toString();
	}

	public static void main(String[] args) {
		StackUsingTwoQueues stack = new StackUsingTwoQueues();
		stack.push(20);
		stack.push(40);
		stack.push(70);
		stack.push(50);
		stack.push(90);
		stack.push(110);
		stack.push(30);
		//System.out.println(stack);
		System.out.println("Removed element : " + stack.pop());
		stack.push(170);
		System.out.println("Removed element : " + stack.pop());
	}

}
