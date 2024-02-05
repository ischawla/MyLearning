package com.isc;

public class DoublyLinkedListExample {

	static MyDoublyLinkedList head = null;
	static MyDoublyLinkedList tail = null;
	int count=0;
	
	
	
	public int getLength() {
		return this.count;
	}
	
	 public static void addNode(int data) {  
	        //Create a new node  
		 MyDoublyLinkedList newNode = new MyDoublyLinkedList(data);  
	  
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.previousNode = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.nextNode = null;  
	        }  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.nextNode = newNode;  
	            //newNode's previous will point to tail  
	            newNode.previousNode = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.nextNode = null;  
	        }  
	    }  
	 
	 
	    public static void display() {  
	        //Node current will point to head  
	    	MyDoublyLinkedList current = head;  
	        if(head == null) {  
	            System.out.println("List is empty");
	            return;  
	        }  
	        System.out.println("Nodes of doubly linked list: ");  
	        while(current != null) {  
	            //Prints each node by incrementing the pointer.  
	            System.out.print(current.data + " ");  
	            current = current.nextNode;  
	        }  
	    }  
	  
	    
	 
	public static void main(String arg[]) {
		addNode(4);
		addNode(8);
		addNode(12);
		
		nodeAtLast();
		display();		
	}
	
	
	
	public static void nodeAtLast() {
		MyDoublyLinkedList lastNode =  new MyDoublyLinkedList(14);
		tail.nextNode = lastNode;
		lastNode.previousNode =  tail;
		tail=lastNode;
	}
	
}
