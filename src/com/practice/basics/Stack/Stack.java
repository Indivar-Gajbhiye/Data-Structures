package com.practice.basics.Stack;

public interface Stack {
	public boolean isEmpty();

	public int pop() throws StackException;

	public int peek() throws StackException;

	public void push(int e) throws StackException;
}
