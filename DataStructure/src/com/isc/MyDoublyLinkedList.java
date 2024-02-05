package com.isc;

public class MyDoublyLinkedList {
	
	public int data;
	public MyDoublyLinkedList nextNode;
	public MyDoublyLinkedList previousNode;
	
	MyDoublyLinkedList(int data){
		this.data =  data;
		nextNode=null; 
	}
	
	public MyDoublyLinkedList getNextNode(){
		return this.nextNode;
	}
	
	public MyDoublyLinkedList getPreviousNode(){
		return this.previousNode;
	}
}
