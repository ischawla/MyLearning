package com.isc;

import java.util.NoSuchElementException;

public class MyQueueExample {

	
	static MyLinkedList front ;
	static MyLinkedList rear ;
	static int length;
	
	public int count(){
		return length;
		
	}
	
	public static boolean isEmpty() {
		return length == 0;
	}
	
	
	public static void addNode(int data) {
		MyLinkedList newNode = new MyLinkedList(data);
		if(isEmpty()) {
			front =  newNode;
			
		}else {
			rear.nextNode =  newNode;
			rear = newNode;
		}
		rear =  newNode;
		length++;
	}
	
	
	
	public static void deQueue() {
		
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}else {
			MyLinkedList frontMost = front;
			if(frontMost !=null) {
				System.out.println("\n Item Dequeued: " + frontMost.data);
				front = frontMost.nextNode;
				length--;	
			}
			
		}
		
	}
	
	
	public static void display() {
		if(isEmpty()) {
			return;
		}
		
		MyLinkedList tmp = front;
		while(tmp != null) {
			System.out.print(" " + tmp.data);
			tmp = tmp.nextNode;
		}
	}
	
	
	
	public static void main(String[] args) {
		addNode(5);	addNode(10); addNode(15); addNode(25);	
	
		display();
		deQueue();
		display();
	}

}
