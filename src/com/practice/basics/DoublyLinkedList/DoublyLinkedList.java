package com.practice.basics.DoublyLinkedList;

public class DoublyLinkedList {

	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if (isEmpty()) {
			last = newNode;
		}
		else {
			first.previous = newNode;
		}
		newNode.next = first;
		this.first = newNode;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; // assigning old last to newNode
			newNode.previous = last; // the old last will be the new Nodes
										// previous
		}
		last = newNode;
	}
}
