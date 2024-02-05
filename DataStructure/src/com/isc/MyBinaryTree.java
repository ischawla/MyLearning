package com.isc;

import java.util.Stack;

public class MyBinaryTree {

	
	static MyTreeNode root;
	int count=0;
	
	public static void addNode(int data) {
		MyTreeNode tmp = new MyTreeNode(data);
		
		//root = first;
		
	}
	
	public static void main(String[] args) {
			MyTreeNode first = new MyTreeNode(1);
			MyTreeNode second = new MyTreeNode(2);
			MyTreeNode third = new MyTreeNode(3);
			MyTreeNode forth = new MyTreeNode(4);
			MyTreeNode fifth = new MyTreeNode(5);

			root =  first;
			first.left = second;
			first.right= third;
			second.left = forth;
			second.right =  fifth;
			
			//p
			preOrderUsingStack();
			//preOrder(root);
			
			
			System.out.println("Max #" + findMaxElement(root));
		}

	
	
	// THis is a Recursive way of iterating
	public static void preOrder(MyTreeNode node) {
		if(root == null) {
		return;	
		}
		if(node != null) {
			System.out.println("data : " + node.data);	
		}
		if(node.left != null) {
			preOrder(node.left);	
		}
		if(node.right != null) {
			preOrder(node.right);	
		}
		
	}
	

	public static void preOrderUsingStack() {
		if(root == null) {
			return ;
		}
		Stack<MyTreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.empty()) {
			MyTreeNode tmp = stack.pop();
			System.out.println("data : " + tmp.data);	
			if(tmp.right != null) {
				stack.push(tmp.right);
			}
			if(tmp.left != null) {
				stack.push(tmp.left);
			}
			
		}
	}
	
	
	public static int findMaxElement(MyTreeNode root) {
		
		if(root == null) {
			return Integer.MIN_VALUE ;
		}
		
		int result =  root.data;
		int left =  findMaxElement(root.left);
		int right =  findMaxElement(root.right);
		
		if(left > result) {
			result =  left;
		}
		if(right > result) {
			result =  right;
		}
		return result;
		
	}
	
	
}
