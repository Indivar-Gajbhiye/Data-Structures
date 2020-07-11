package com.practice.basics.Heap;

/**
 * @author Indivar
 * 
 * This is an array based implementation of Heap data structure. It can also be achieved by Linked List
 */
public class Heap {

	private Node[] heapArray;
	private int maxSize; // size of the array;
	private int currentSize; // number of the nodes in array
	
	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size];
	}
	
	public int getSize() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public boolean insert(int key) {
		
		if (currentSize == maxSize) {
			return false;
		}
		
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		
		trickleUp(currentSize);
		currentSize++;
		
		return true;
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		
		trickleDown(0);
		return root;
	}

	/**
	 * @param index is the position in the array where we have placed our newly created node
	 */
	private void trickleUp(int index) {

		int parentIndex = (index - 1) / 2;
		Node nodeToInsert = heapArray[index];

		// loop as long as we haven't reached the root and key of nodeToInsert's
		// parent is less than new node
		while (index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {

			heapArray[index] = heapArray[parentIndex]; // move parent down
			index = parentIndex;
			parentIndex = (parentIndex - 1) / 2; // move up to next parent
		}
		
		heapArray[index] = nodeToInsert;
	}
	
	private void trickleDown(int index) {

		int largerChildIndex;
		Node top = heapArray[index]; // save last into top variable

		// will run as long as index has not reached at the bottom row
		while (index < currentSize / 2) {
			
			// left child index position
			int leftChildIndex = 2 * index + 1;

			// right child index position
			int rightChildIndex = 2 * index + 2;
			
			// determine which child is larger
			if (rightChildIndex < currentSize
					&& heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
				largerChildIndex = rightChildIndex;
			} else {
				largerChildIndex = leftChildIndex;
			}

			if (top.getKey() >= heapArray[largerChildIndex].getKey()) {
				// successfully made root the largest key
				break;
			}

			heapArray[index] = heapArray[largerChildIndex];
			index = largerChildIndex;
		}

		heapArray[index] = top;
	}
}
