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
		System.out.print("null");
		
	}
	
	int listSize() {
		
		if(head == null) {
			System.out.println("Empty list!");
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
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	void insertEnd(int value) {
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
		sll.insertFirst(101);
		
		//insert at end
		sll.insertEnd(44);
		
		//insert at position
		sll.insertAtPosition(4, 65);
		
		sll.display();
		
		sll.listSize();
		
		
	}
}
