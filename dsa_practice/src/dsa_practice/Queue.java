package dsa_practice;

import java.util.NoSuchElementException;

public class Queue {

	private ListNode front;
	private ListNode rear;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data){
			this.data = data;
			this.next = null;
		}
	}
	public int length() {
		return length;
	}
	public boolean isEmpty() {
		return length == 0;		
	}
	public void Enqueue(int data) {
		ListNode newNode = new ListNode(data);
		if(isEmpty()) {
			front = newNode;
		}else {
			rear.next = newNode;
		}
		rear = newNode;
		System.out.println("Enqueue: " + rear.data);
		length++;
	}
	public ListNode Dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = front;
		front = front.next;
		temp.next = null;
		if(front==null) {
			rear = null;
		}
		length--;
		System.out.println("Dequeue: " + temp.data);
		return temp;
		
	}
	public void print() {
//		if(isEmpty()) {
//			return;
//		}
		ListNode temp = front;
//		System.out.print("*QUEUE* | length: " + length() +"\nfront => ");
		while(temp!=null) {
			System.out.print( temp.data + " -> ");
			temp = temp.next;
		}
//		System.out.print("null <= rear\n" );
		System.out.print("null\n" );
	}
	
	
	public static void main(String[] args) {
		Queue q = new Queue();
		
		q.Enqueue(1);q.print();
		q.Enqueue(2);q.print();
		q.Enqueue(3);q.print();
		q.Enqueue(4);q.print();
		
		q.Dequeue();q.print();
		q.Dequeue();q.print();
		q.Dequeue();q.print();
		q.Dequeue();q.print();
		
		System.out.println("frontNode: " + q.front);
		System.out.println("rearNode: " + q.rear);
		
		q.Dequeue();q.print();
	}
	
}
