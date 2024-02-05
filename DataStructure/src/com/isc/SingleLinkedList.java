package com.isc;

//https://www.youtube.com/watch?v=Fg4VIjTdHx4&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=38

public class SingleLinkedList {

	
	public static void main(String ar[]) {
		MyLinkedList head =  new MyLinkedList(8);  // new node created with data , but next pointer null
		MyLinkedList first =  new MyLinkedList(10); // new node created with data , but next pointer null
		MyLinkedList second =  new MyLinkedList(15); // new node created with data , but next pointer null
		MyLinkedList third =  new MyLinkedList(20); // new node created with data , but next pointer null
		
		head.nextNode = first;
		first.nextNode =  second;
		second.nextNode=third;
		third.nextNode=null;
	
		// printing the data of LinkedList
				MyLinkedList current =  head;
				int count=0;
				while(current != null) {
					count ++;
					System.out.println("Value of Node:" + current.data);
					current = current.nextNode;
				}
		  System.out.println("Count: " + count);
				
				
				
		  System.out.println("-------------------------------");
	      System.out.println("Adding new Node at FRONT");
			  // Creating new Node at the front
			  MyLinkedList newNode = new MyLinkedList(100);
			  newNode.nextNode =  head;
			  head =  newNode;
		
		
		  System.out.println("-------------------------------");
			// printing the data of LinkedList
			 current =  head;
			 count=0;
			while(current != null) {
				count ++;
				System.out.println("Value of Node:" + current.data);
				current = current.nextNode;
			}
			System.out.println("Count: " + count);
		
		
		
		 System.out.println("-------------------------------");
		 System.out.println("Adding new Node at the END");
		//Creating new node at the end
		MyLinkedList endNode =  new MyLinkedList(1000);
		current = head;
		while(current.nextNode != null) {
			current = current.nextNode;
		}
		current.nextNode = endNode;
		
		
		System.out.println("-------------------------------");
		current = head;
		count=0;
		while(current != null) {
			count ++;
			System.out.println("Value of Node:" + current.data);
			current = current.nextNode;
		}
		System.out.println("Count: " + count);
		
		
		
		System.out.println("-------------------------------");
		System.out.println("Adding new Node at the MIDDLE position say : 3");
		//Creating new node to be placed at positon = 3
		int position = 3;
		MyLinkedList middleNode =  new MyLinkedList(789);
		
		MyLinkedList previous = head;
		count=1;
		
		while(count < position -1) {
			previous = previous.nextNode;
			count ++;
		}
		MyLinkedList tmp = previous.nextNode;
		previous.nextNode = middleNode;
		middleNode.nextNode = tmp;
		
		
		
		
		System.out.println("-------------------------------");
		current = head;
		count=0;
		while(current != null) {
			count ++;
			System.out.println("Value of Node:" + current.data);
			current = current.nextNode;
		}
		System.out.println("Count: " + count);
		
		
		
	}
	
	
	
	
	
}
