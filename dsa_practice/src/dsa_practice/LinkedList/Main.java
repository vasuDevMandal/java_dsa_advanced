package dsa_practice.LinkedList;

public class Main {

    public static void main(String[] args) {
        LL ll = new LL();
//
//        ll.insertFirst(3);
//        ll.insertFirst(5);
//        ll.insertFirst(6);
//        ll.insertFirst(8);
//
//        ll.insertLast(55);
//        ll.insertLast(45);
//        ll.printList();
//
//        ll.insertAtIndex(12,3);
//        ll.insertAtIndex(90,5);
//
//        System.out.println( ll.deleteFirst());
//        ll.printList();

//        System.out.println(ll.deleteLast());
//        ll.printList();
//        System.out.println(ll.deleteLast());
//        ll.printList();
//        System.out.println(ll.deleteLast());
//        ll.printList();
//
//        System.out.println("delete at index");
//        System.out.println(ll.deleteAtIndex(2));
//        ll.printList();
//        System.out.println(ll.deleteAtIndex(1));
//        ll.printList();
//
//        System.out.println(ll.find(45));

//        DLL dll = new DLL();
//
//        dll.insertFirst(2);
//        dll.insertFirst(4);
//        dll.insertFirst(6);
//        dll.insertFirst(8);
//        dll.printDll();
//        dll.printDllReverse();
//
//        dll.insertLast(34);
//        dll.insertLast(44);
//
//        dll.printDll();


        // recursive insertion in ll
//        ll.insertRec(345,2);
//        ll.printList();

        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(2);
        ll.insertLast(2);
        ll.insertLast(4);
        ll.insertLast(4);
        ll.insertLast(4);
        ll.insertLast(4);
        ll.printList();
        ll.deleteDuplicates();
        ll.printList();
    }
}
