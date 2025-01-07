package dsa_practice;

import java.util.NoSuchElementException;

public class CircularLinkedList {

	private ListNode head;//extra pointer added check git history
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

	public boolean findCycle(ListNode node){
		ListNode fast = node;
		ListNode slow = node;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
				return true;
			}
		}
		return false;
	}

	public int findCycleLength(ListNode node){
		ListNode fast = node;//head
		ListNode slow = node;//head

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
				int length = 0;
				ListNode temp = slow;
				do{
					temp = temp.next;
					length++;
				}while(temp != slow);

				return length;
			}
		}
		return -1;
	}

	//floyed warshall cycle detection
	public ListNode findCycleStartNode(ListNode node){
		ListNode fast = node;
		ListNode slow = node;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
//				return floyedCycleDetect(slow);
				ListNode temp = head;
				while(slow != temp){
					temp = temp.next;
					slow = slow.next;
				}
				return temp;
			}
		}
		return null;
	}

	private ListNode floyedCycleDetect(ListNode slowPtr){
		ListNode temp = head;
		while(slowPtr != temp){
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}

	//cycle start point second version
	//https://youtu.be/70tx7KcMROc?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=4429
	public ListNode findCycleStartNode2(ListNode node){
		int length = 0;
		ListNode fast = node;
		ListNode slow = node;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow){
				length = findCycleLength(slow);
				break;
			}
		}
		//find the start node
		ListNode first = head;
		ListNode second = head;

		while(length > 0){
			second = second.next;
			length--;
		}

		//keep moving both forward the both meet at cycle start point
		while (first != second){
			first = first.next;
			second = second.next;
		}

		return first;
	}

	public static void main(String[] args) {
		
		CircularLinkedList cll = new CircularLinkedList();
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode forth = new ListNode(15);
		ListNode fifth = new ListNode(22);
		ListNode sixth = new ListNode(30);

		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;

		cll.last = sixth;
		cll.head = first;
		
		//inserting manually
//		cll.insertFirst(5);
//		cll.insertFirst(10);
//		cll.insertFirst(15);
//		cll.insertFirst(20);
//
//		cll.insertLast(40);
//		cll.insertLast(45);
		
//		cll.printList();
//		System.out.println("deleted first: " + cll.removeFirst().data);
//		System.out.println("deleted first: " + cll.removeFirst().data);
//		System.out.println("deleted first: " + cll.removeFirst().data);
//		System.out.println("deleted first: " + cll.removeFirst().data);
//		System.out.println("deleted first: " + cll.removeFirst().data);
//		System.out.println("deleted first: " + cll.removeFirst().data);
		cll.printList();

		System.out.println("cycle exist: " + cll.findCycle(cll.head));

		System.out.println("cycle length: " + cll.findCycleLength(cll.last.next));

		System.out.println("cycle start point: " + cll.findCycleStartNode(cll.head).data);
		System.out.println("cycle start point - 2 : " + cll.findCycleStartNode2(cll.head).data);

	}
}
