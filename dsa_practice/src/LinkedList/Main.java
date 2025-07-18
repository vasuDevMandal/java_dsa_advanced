package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list  = new LL();

        list.insertFirst(22);
        list.insertFirst(22);
        list.insertFirst(23);
        list.insertFirst(23);
        list.insertFirst(24);
        list.insertFirst(24);
        list.insertFirst(24);
        list.insertFirst(25);

//        list.InsertViaRecursion(111,2);
//        list.insertLast(55);
//        list.insertLast(66);
//
//        list.insertAtIndex(101, 4);
//
        list.display();

        list.removeDuplicates();
        list.display();

//        System.out.println();
//        list.deleteFirst();
//        list.display();
//
//        System.out.println();
//        list.deleteLast();
//        list.display();
//
//        System.out.println();
//        list.delete(3);
//        list.display();


//        System.out.println();
//        System.out.println(list.findIndex(55));


//        DLL dll = new DLL();
//        dll.insertFirst(4);
//        dll.insertFirst(8);
//        dll.insertFirst(6);
//        dll.insertFirst(2);

//        dll.display();
//        dll.displayReverse();

//        dll.insertLast(456);
//        dll.display();

    }
}
