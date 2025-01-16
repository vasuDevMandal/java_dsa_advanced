package dsa_practice.stackNqueues;

import java.util.Stack;

public class QueueUsingStackRemoveEfficient {

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStackRemoveEfficient(){
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void add( int item){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        second.push(item);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }

    public int remove() throws Exception{
        return first.pop();
    }

    public int peek() throws Exception{

        return first.peek();
    }

    public boolean isEmpty(){
        return first.isEmpty();
    }

}

