package com.practice.basics.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		
		CustomLinkedList linkedList = new CustomLinkedList();
		linkedList.insert(100);
		linkedList.insert(200);
		linkedList.insert(150);
		linkedList.insert(21);
		linkedList.insert(101);
		//linkedList.insert(47);
		
		//linkedList.display();
		
		//linkedList.insertAtStart(177);
		
		//linkedList.insertAtPosition(4, 72);
		
		linkedList.display();
		
		linkedList.head = linkedList.reverse(linkedList.head);
		System.out.println("Reverse List:");
		//Node reverse = linkedList.middleElement(linkedList.head);
		//System.out.println(reverse);
		linkedList.display();
		
	}

}
