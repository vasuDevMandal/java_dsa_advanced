package dsa_practice;

public class SinglyLinkedList {

	private ListNode head;// Head of the node (starting point).
	
	private static class ListNode{
		private int data; // data stored in node
		private ListNode next;// reference to next node

	
		// Constructor to initialize the node
		private ListNode(int data) {
			this.data = data;
			this.next = null;// Initially, the next node is null 
		}
	}
	
	public void display() {
		
		if(head == null) {
			System.out.println("list is empty");
			return;
		}
		
		ListNode current = head;// Start from the head		
		while(current != null) {				
			System.out.print( current.data +" -> ");// Print current node data				
			current = current.next;// move to next node			
		}		
		System.out.print("null\n");
		
	}
	
	int listSize() {
		
		if(head == null) {
			System.out.println("list-size: Empty list!");
			return 0;
		}
		ListNode current = head;
		int count = 0;
		while(current != null) {
			count++;
			current = current.next;
		}
		System.out.print("\nlist-size: "+count+"\n");
		return count;
	}
	
	void insertFirst(int value) {
		System.out.println("inserFirst - "+value);
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	void insertEnd(int value) {
		System.out.println("inserEnd - "+value);
		ListNode newNode = new ListNode(value);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode; 
	}
	
	void insertAtPosition(int position, int value) {
		System.out.println("insert at pos: "+position +" -> "+value);
		ListNode newNode = new ListNode(value);
		
		int size = listSize();
		if( 0 > position || position > size) {
			System.out.println("position not in range 1-"+size);
			return;
		}
		if(position == 1) {
			 newNode.next = head;
			 head = newNode;
			
		}else {
			
			ListNode previous = head;
			int count = 1;
			while( count < position - 1 ) {
				count++;
				previous=previous.next;
			}

			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;
		}
	}
	
	ListNode deleteFirst() {
		System.out.println("\ndeleteFirst() called..\n");
		if(head == null) {
			return head;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	ListNode deleteLast() {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
		
	}
	
	ListNode deleteAtPosition(int position) {
		if (position == 1) {
			head = head.next; 
			return head;
		}else {
//			my version------
//			ListNode current = head;
//			ListNode previous = null;
//			int count=1;
//			while(count < position) {
//				previous = current;
//				current = current.next;
//				count++;
//			}
//			previous.next = current.next;
//			return current;
			
			ListNode previous = head;
			int count = 1;
			while(count < position -1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
			
			return current;
			
		}
		
	}
	
	boolean search(int val) {
		
		ListNode current = head;
		while(current != null) {
			if(val == current.data) {
				return true;
			}
			current = current.next;
		}
		return false;
		
	}
	
	void reverseList() {
		ListNode previous = null;
		ListNode current = head;
		ListNode next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	ListNode FindMiddleNode() {
		if(head == null) {
			return null;
		}
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next; 
		}
		return slowPtr;
	}
	
	
	ListNode FindNodeFromEnd(int position) {
		if(head==null || position > listSize() || position < 1) {
//			throw new IllegalArgumentException("Invalid value entered or List is Empty!");
			return null;
		}
		ListNode mainPtr = head;
		ListNode refPtr = head;
		
		int count = 0;
		while(count < position) {
			refPtr = refPtr.next ;
			count++;
		}
		while(refPtr!=null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		System.out.println("\nnode at position:" + 
		position +" from END is -> " + mainPtr.data);
		
		return mainPtr;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode forth = new ListNode(4);
		
		
		// Connect all node to form a chain
		sll.head.next = second;// 10 -> 5
		second.next = third;// 10 -> 5 -> 45
		third.next = forth;// 10 -> 5 -> 45 -> 56 -> null
		
		//insertFirst
//		sll.insertFirst(101);
		//insert at end
//		sll.insertEnd(44);
		//insert at position
//		sll.insertAtPosition(4, 65);
		//deleteFirst
//		System.out.println("deleted node: " + sll.deleteFirst().data); 
		
//		sll.display();
//		System.out.println("delete item: "+sll.deleteAtPosition(2).data);
		
//		System.out.println("search: " + sll.search(4));
		
//		sll.display();
		
//		System.out.println("reverseList: ");
//		sll.reverseList();
		
//		System.out.println("middle: " + sll.FindMiddleNode().data);
		
		sll.FindNodeFromEnd(7);
		
		sll.display();
		sll.listSize();
		
		
	}
}
