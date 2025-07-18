package LinkedList;

public class DLL {

    private Node head;
    int size = 0;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;//forward link
        node.prev = null;
        if(head != null){
            head.prev = node;//backword link
        }
        head = node;//now change head
        size++;
    }

    public void insertAtIndex(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
//        node.next = temp.next;
        temp.next = node;

        size++;

    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            node.prev = null;//not req - already null
            head = node;
            return;
        }
        //without tail - get last element
        Node last = head;
        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        node.next = null;//not req - already null
        size++;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+ " -> ");
            temp = temp.next;
        }
        System.out.print("END \n");
    }

    public void displayReverse(){
        Node last = head;
        while (last.next != null){
            last = last.next;
        }

        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.print("START \n");

    }

    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
