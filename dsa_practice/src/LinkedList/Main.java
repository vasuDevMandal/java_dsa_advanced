package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list  = new LL();

        list.insertFirst(22);
        list.insertFirst(23);
        list.insertFirst(24);
        list.insertFirst(25);

        list.insertLast(55);
        list.insertLast(66);

        list.insertAtIndex(101, 4);

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


        System.out.println();
        System.out.println(list.findIndex(55));


    }
}
