package com.fortinet.cc.question1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {

	@Test
	public void testEmptyList() {
		Node head = null;
		Node reverse = ReverseLinkedList.reverse(head);
		assertTrue(reverse == null);		
	}
	
	@Test
	public void testValidList() {
		Node head = new Node(1);
		Node node = head;
		for(int i=2; i<10; i++) {
			node.setNext(new Node(i));
			node = node.getNext();
		}		
		
		String[] sList = head.toString().split(" "); 
		StringBuilder sb = new StringBuilder();
		for(int i=sList.length-1; i>0; i--) {
			sb.append(sList[i]+ " ");
		}
		sb.append(sList[0]);
		String inputReverse = sb.toString();
		
		Node reverse = ReverseLinkedList.reverse(head);
		
		Assert.assertTrue(inputReverse.equals(reverse.toString()));		
	}
	
	@Test
	public void testValidLargeList() {
		Node head = new Node(1);
		Node node = head;
		for(int i=2; i<5000; i++) {
			node.setNext(new Node(i));
			node = node.getNext();
		}		
		String[] sList = head.toString().split(" "); 
		StringBuilder sb = new StringBuilder();
		for(int i=sList.length-1; i>0; i--) {
			sb.append(sList[i]+ " ");
		}
		sb.append(sList[0]);
		String inputReverse = sb.toString();
		Node reverse = ReverseLinkedList.reverse(head);
		Assert.assertTrue(inputReverse.equals(reverse.toString()));	
	}

}
