package com.fortinet.cc.question1;

public class ReverseLinkedList {
	
	// Reverse a single linked list
	// Time Complexity - O(n)
	// Space Complexity - O(1)
	public static Node reverse(Node head) {
		Node current = head;
		Node previous = null;
		Node next = null;
		
		while(current != null) {
			next = current.getNext();
			Node temp = previous;
			previous = current;
			previous.setNext(temp);			
			current = next;			
		}
		return previous;
	}
	
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node node = head;
		for(int i=2; i<10; i++) {
			node.setNext(new Node(i));
			node = node.getNext();
		}
		System.out.println(head.toString());
		
		Node reverse = reverse(head);
		
		System.out.println(reverse.toString());
		
		
	}
}
