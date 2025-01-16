package dsa_practice.stackNqueues;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks(){
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void add( int item){
        first.push(item);
    }

    public int remove() throws Exception{
        //put item in second stack, as first inserted item need to removed according to queue rules
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        //remove the item,as only last inserted item is removed from stack
        int removed = second.pop();

        //place all the items in first again
        while(second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() throws Exception{
        //put item in second stack, as first inserted item need to removed according to queue rules
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        //remove the item,as only last inserted item is removed from stack
        int peeked = second.peek();

        //place all the items in first again
        while(second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean isEmpty(){
        return first.isEmpty();
    }

}
