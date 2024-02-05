package com.isc;

public class MyStack {
	
	static MyLinkedList top = null;
	int count=0;
	
	public void pushNode(int data) {
		
		
	}
	
	 public static  void addNode(int data) {  
		 MyLinkedList newNode = new MyLinkedList(data);  
	            newNode.nextNode = top;
	            top.nextNode = newNode;  
	            top = newNode;  
	        
	    }  
	 
	 
	 public static void display() {  
		 MyLinkedList current = top;  
	        if(top == null) {  
	            System.out.println("List is empty");
	            return;  
	        }  
	        System.out.println("Nodes of Stack: ");  
	        while(current != null) {  
	            //Prints each node by incrementing the pointer.  
	            System.out.print(current.data + " ");  
	            current = current.nextNode;  
	        }  
	    }  
	 
	 
	 
public static void main(String ar[]) {
	addNode(7);
	addNode(8);
	addNode(9);
	addNode(10);
	display();
}
}
