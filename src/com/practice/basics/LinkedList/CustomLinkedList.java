package com.practice.basics.LinkedList;
class CustomLinkedList {

	Node head;

	public void insert(int data) {

		// while adding, create a new Node as new element has to be added

		Node node = new Node();
		node.data = data;
		node.next = null; // as it will be added to the last of the linked list its next is null.

		// means the list is empty, our newly created node becomes the head.
		if (head == null) {
			head = node;
		} else {
			// start from the head node and then traverse till we find last node
			Node tempNode = head;
			// traversing till end node
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}

			// The last node will now point to the newly added node
			tempNode.next = node;
		}
	}

	public void display() {

		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}

	public void insertAtStart(int data) {

		Node node = new Node();
		node.data = data;
		node.next = head;

		// Our node becomes the new head
		head = node;
	}

	public void insertAtPosition(int index, int data) {

		Node node = new Node();
		node.data = data;
		node.next = null;

		if (index == 0) {
			insertAtStart(data);
		} else {
			Node tempNode = head;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}

			// The newly added node will now point to the pointer of current node
			node.next = tempNode.next;
			
			// current node will point to the new node which gets added
			tempNode.next = node;
		}
	}

	public void deleteAt(int index) {

		if (index == 0) {
			head = head.next;
		} 
		else {
			Node tempNode = head;
			for (int i = 0; i < index - 1; i++) {
				tempNode = tempNode.next;
			}

			// Get the node which we want to delete in another node
			Node n1 = tempNode.next;

			// Now the temp Node will directly point to the element after the deleted
			// element
			tempNode.next = n1.next;
			System.out.println("n1" + n1.data);
			n1 = null;
		}
	}
	
	public Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		if (head.next != null) {
			Node newHead = reverse(head.next);
			head.next.next = head;
			head.next = null;
			return newHead;
		}
		
		return null;
	}
	
	public Node middleElement(Node head) {
		Node hare = head;
		Node tortoise = head;
		while (hare != null && hare.next != null) {
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		
		return tortoise;
	}
}
 