package StacksQus;

import java.util.Stack;

public class QueueViaStacks {

    public static void main(String[] args) {

    }

    class MyQueue {

        Stack<Integer> first;
        Stack<Integer> sec;

        public MyQueue() {
            first = new Stack<>();
            sec = new Stack<>();
        }

        public void push(int x) {
            first.push(x);
        }

        public int pop() {

            while(!first.isEmpty()) {
                sec.push(first.pop());
            }
            int num = sec.pop();
            while(!sec.isEmpty())  {
                first.push(sec.pop());
            }
            return num;

        }

        public int peek() {

            while(!first.isEmpty()) {
                sec.push(first.pop());
            }
            int num = sec.peek();
            while(!sec.isEmpty())  {
                first.push(sec.pop());
            }
            return num;

        }

        public boolean empty() {
            return first.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
