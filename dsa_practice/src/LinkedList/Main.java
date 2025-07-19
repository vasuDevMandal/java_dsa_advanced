package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list  = new LL();

        list.insertFirst(411);
        list.insertFirst(45);
        list.insertFirst(25);
        list.insertFirst(24);

//        list.InsertViaRecursion(111,2);
        list.insertLast(155);
        list.insertLast(66);
//
//        list.insertAtIndex(101, 4);
        list.display();


        list.sortViaBubble();
        list.display();

        list.reverseListRecursive(list.get(0));
        list.display();;

        list.reverseIter();

//        list.removeDuplicates();
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
