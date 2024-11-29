package dsa_practice;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;

	private static class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;
		
		// Constructor to initialize the node
		private ListNode(int data){
			this.data = data;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;//head == null
	}
	
	public int length() {
		return length;
	}
	
	public void displayForward() {
		if(head==null) {
			System.out.println("--Empty List--");
			return;
		}
		ListNode temp = head;
		while(temp!=null) {
			System.out.print( temp.data +" -> ");
			temp = temp.next;
		}
		System.out.print("null\n");
	}
	
	public void displayBackward() {
		if(tail==null) {
			return;
		}
		ListNode temp = tail;
		while(temp!=null) {
			System.out.print( temp.data +" -> ");
			temp = temp.previous;
		}
		System.out.print("null\n");
	}
	
	public void insertFirst(int val) {
		ListNode newNode = new ListNode(val);
		if(isEmpty()) {
			tail = newNode;
		}else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	

	public void insertLast(int val) {
		ListNode newNode = new ListNode(val);
		if(isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;		
		length++;
	}
	
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		if(head == tail) {
			tail = null;
		}else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
		
	}
	
	ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = tail;
		if(tail == head) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertFirst(1);
		dll.insertFirst(10);
		dll.insertFirst(20);
		dll.insertFirst(30);
		
		
//		dll.insertLast(1);
//		dll.insertLast(10);
		
		dll.displayForward();
//		dll.displayBackward();
		
		//deletefirst
		System.out.println("deleted from start: " + dll.deleteFirst().data);
		
		//deleteLAst
		System.out.println("deleted from end: " + dll.deleteLast().data);
		
		
		
		dll.displayForward();
	}
}
