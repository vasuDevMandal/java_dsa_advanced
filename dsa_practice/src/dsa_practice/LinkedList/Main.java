package dsa_practice.LinkedList;

public class Main {

    public static void main(String[] args) {
        LL ll = new LL();

        ll.insertFirst(3);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertFirst(8);

        ll.insertLast(55);
        ll.insertLast(45);
        ll.printList();

        ll.insertAtIndex(12,3);
        ll.insertAtIndex(90,5);

//        ll.printList();
    }
}
