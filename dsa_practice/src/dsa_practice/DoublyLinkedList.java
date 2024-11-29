package dsa_practice;


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
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.head = new ListNode(1);
	}
}
