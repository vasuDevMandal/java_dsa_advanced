package dsa_practice;

import java.util.NoSuchElementException;

public class CircularLinkedList {
	
	private ListNode last;
	private int length;

	private static class ListNode{
		private int data; // data stored in node
		private  ListNode next;// reference to next node

	
		// Constructor to initialize the node
		private ListNode(int data) {
			this.data = data;
		}
	}
	
	public CircularLinkedList() {
		last = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	void printList() {
		if(last==null) {
			return;
		}
		ListNode first = last.next;
		while(first != last) {
			System.out.print( first.data + " -> ");
			first = first.next;
		}
		System.out.print(first.data + "\n");
	}
	
	void insertFirst(int val) {
		ListNode newNode = new ListNode(val);
		if(last == null) {
			last = newNode;
		}else {
			newNode.next = last.next;
			
		}
		last.next = newNode;
		length++;
	}
	
	void insertLast(int val) {
		ListNode newNode = new ListNode(val);
		if(last==null) {
			last = newNode;
			last.next = last;
		}else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;			
		}
		length++;
	}
	
	ListNode removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode first = last.next;
		if(last == first) {
			last = null;
		}else {
			last.next = first.next;
			
		}
		first.next = null;
		length--;
		return first;
	}

	public static void main(String[] args) {
		
		CircularLinkedList cll = new CircularLinkedList();
//		ListNode first = new ListNode(1);
//		ListNode second = new ListNode(5);
//		ListNode third = new ListNode(10);
//		ListNode forth = new ListNode(15);
//		
//		first.next = second;
//		second.next = third;
//		third.next = forth;
//		forth.next = first;
//		
//		cll.last = forth;
		
		//inserting manually
		cll.insertFirst(5);
		cll.insertFirst(10);
		cll.insertFirst(15);
		cll.insertFirst(20);
		
		cll.insertLast(40);
		cll.insertLast(45);
		
		cll.printList();
		System.out.println("deleted first: " + cll.removeFirst().data); 
		System.out.println("deleted first: " + cll.removeFirst().data); 
		System.out.println("deleted first: " + cll.removeFirst().data); 
		System.out.println("deleted first: " + cll.removeFirst().data); 
		System.out.println("deleted first: " + cll.removeFirst().data); 
		System.out.println("deleted first: " + cll.removeFirst().data); 
		cll.printList();
		
	}
}
