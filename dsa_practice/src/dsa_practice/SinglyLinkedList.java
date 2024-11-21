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
		System.out.print("\nlist-size: ");
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
		return count;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(10);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(45);
		ListNode forth = new ListNode(56);
		
		
		// Connect all node to form a chain
		sll.head.next = second;// 10 -> 5
		second.next = third;// 10 -> 5 -> 45
		third.next = forth;// 10 -> 5 -> 45 -> 56 -> null
		
		sll.display();
		
		System.out.println(sll.listSize());
		
		
	}
}
