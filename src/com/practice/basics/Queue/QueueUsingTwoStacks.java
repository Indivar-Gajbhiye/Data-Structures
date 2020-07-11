package com.practice.basics.Queue;

import java.util.Stack;

public class QueueUsingTwoStacks {

	private Stack<Integer> inputStack;
	private Stack<Integer> outputStack;

	public QueueUsingTwoStacks() {
		inputStack = new Stack<>();
		outputStack = new Stack<>();
	}

	public void enqueue(int item) {
		inputStack.push(item);
	}

	public int dequeue() {
		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
		}
		
		return outputStack.pop();
	}

	public int size() {
		return inputStack.size() + outputStack.size();
	}

	public static void main(String[] args) {
		QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
		queue.enqueue(100);
		queue.enqueue(250);
		queue.enqueue(24);
		
		System.out.println(queue.dequeue());
	}

}
