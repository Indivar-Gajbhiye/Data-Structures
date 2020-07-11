package com.practice.basics.LinkedList;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insertFirst(100);
		myList.insertFirst(210);
		myList.insertFirst(23);
		myList.insertFirst(74);
		myList.insertLast(42);
		
		myList.displayList();
	}

}
