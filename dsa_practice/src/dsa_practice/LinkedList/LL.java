package dsa_practice.LinkedList;

public class LL {

    private Node head;
    private Node tail;

    private class Node{
        private int value;
        private Node next;

        public Node(int val) {
            this.value = val;
        }
        public Node(int val, Node next){
            this.value = val;
            this.next = next;
        }

    }


}
