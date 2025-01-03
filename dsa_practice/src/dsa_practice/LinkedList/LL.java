package dsa_practice.LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size +=1;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertAtIndex(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertLast(value);
            return;
        }

        Node newNode = new Node(value);
        Node temp = head;
        int count = 1;
        while(count < index ){
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
        printList();
    }

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

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
