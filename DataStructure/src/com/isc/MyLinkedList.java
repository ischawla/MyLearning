package com.isc;

public class MyLinkedList {

	public int data;
	public MyLinkedList nextNode;
	
	MyLinkedList(int data){
		this.data =  data;
		nextNode=null;
	}
	
	public MyLinkedList getNextNode(){
		return this.nextNode;
	}
	
	
}
