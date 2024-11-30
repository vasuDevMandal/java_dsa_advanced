package dsa_practice;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
	//stack via linked list
		
	private ListNode top;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	//initialize the stack
	public Stack(){
		top = null;
		length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	//methods
	
	public void push(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = top;//new nodeElement.next is previous-top element
		top = newNode;
		length++;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.push(4);
		stack.push(5);
		
		System.out.println("top: "+ stack.peek());
		stack.pop();
		System.out.println("top: "+ stack.peek());
		
		
		
		
	}

}
