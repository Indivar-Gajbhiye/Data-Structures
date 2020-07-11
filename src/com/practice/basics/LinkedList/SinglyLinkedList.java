package com.practice.basics.LinkedList;

public class SinglyLinkedList {

	private Node headNode;
	
	public SinglyLinkedList() {
	}
	
	public boolean isEmpty() {
		return headNode == null;
	}
	
	//used to insert at the beginning of the list.
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = headNode;
		headNode = newNode;
	}
	
	public Node deleteFirst() {
		Node tempNode = headNode;
		headNode = headNode.next;
		return tempNode;
	}
	
	public void displayList() {
		Node currentNode = headNode;
		while (currentNode != null) {
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		Node currentNode = headNode;
		
		while (currentNode.next != null) { // we will loop until current.next is null
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	public void insertAtPosition(int data, int index) {
		Node newNode = new Node();
		newNode.data = data;

		if (index == 0) {
			insertFirst(data);
		} else {
			Node currentNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;

			currentNode.next = newNode;
		}
	}
	
	public void deleteAtPosition(int index) {
		if (index == 0) {
			headNode = headNode.next;
		} else {
			Node tempNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}

			Node node = tempNode.next;
			tempNode.next = node.next;
			node = null;
		}
	}
	
	public Node reverse() {
		Node headOfUnreversedLL = headNode;
		Node headOfReversedLL = null;
		Node nodeToReverse = null;

		while (headOfUnreversedLL != null) {
			headOfReversedLL = nodeToReverse;
			nodeToReverse = headOfUnreversedLL;
			headOfUnreversedLL = headOfUnreversedLL.next;
			nodeToReverse.next = headOfReversedLL;
		}
		
		headOfReversedLL = nodeToReverse;
		return headOfReversedLL;
	}

}
