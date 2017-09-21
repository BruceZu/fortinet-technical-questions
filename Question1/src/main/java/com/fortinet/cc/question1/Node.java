package com.fortinet.cc.question1;

public class Node {
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(data + " ");
		Node n = next;
		while(n.next != null) {
			sb.append(n.data + " ");
			n = n.next;
		}
		sb.append(n.data);
		
		return sb.toString();
	}
	
}
