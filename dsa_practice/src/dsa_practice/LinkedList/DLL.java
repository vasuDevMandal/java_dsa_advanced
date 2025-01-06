package dsa_practice.LinkedList;

public class DLL {
   private class Node{
       int value;
       Node next;
       Node prev;

       public Node(int value){
           this.value = value;
       }

       public Node(int value, Node next, Node prev) {
           this.value = value;
           this.next = next;
           this.prev = prev;
       }
   }

   private Node head;

   public void insertFirst(int val){
       Node node = new Node(val);
       node.next = head;
       if(head != null){
           head.prev = node;
       }
       node.prev = null;
       head = node;
   }

   public void insertLast(int val){
       Node node = new Node(val);
       if(head == null){
           insertFirst(val);
           return;
       }
       Node current = head;
       while(current.next!=null){
           current = current.next;
       }
       current.next = node;
       node.prev = current;
       node.next = null;
   }

   public void printDll(){
       Node current = head;
       while(current!=null){
           System.out.print(current.value + " -> ");
           current = current.next;
       }
       System.out.print("END\n");
   }

    public void printDllReverse(){
        Node current = head;
        Node last = null;
        while(current!=null){
//            System.out.print(current.value + " -> ");
            last = current;
            current = current.next;
        }
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.print("Start \n");
    }
}
