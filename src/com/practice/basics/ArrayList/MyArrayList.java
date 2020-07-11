package com.practice.basics.ArrayList;

import java.util.Arrays;

public class MyArrayList<E> {
	
	private Object[] arr;
	private int size = 0;
	
	public MyArrayList() {
		arr = new Object[10];
	}

	public void add(E e) {
		if(arr.length-size <= 5){
            increaseListSize();
        }
        arr[size++] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < size) {
			return (E) arr[index];
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	
	public E remove(int index) {
		if (index < size) {
			
			@SuppressWarnings("unchecked")
			E element = (E) arr[index];
			arr[index] = null;
			int tmp = index;
			
			while (tmp < size) {
				arr[tmp] = arr[tmp + 1];
				arr[tmp + 1] = null;
				tmp++;
			}
			size--;
			return element;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int size() {
		return size;
	}
	
	private void increaseListSize() {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}
	
	
	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(new Integer(2));
		list.add(new Integer(5));
		list.add(new Integer(1));
		list.add(new Integer(23));
		list.add(new Integer(14));
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		list.add(new Integer(29));
		System.out.println("Element at Index 5:" + list.get(5));
		System.out.println("List size: " + list.size());
		System.out.println("Removing element at index 2: " + list.remove(4));
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
