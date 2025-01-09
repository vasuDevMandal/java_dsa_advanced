package dsa_practice.LinkedList;

import dsa_practice.CircularLinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
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

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteAtIndex(int index){
        if(index == 0){
            return deleteFirst();
        }
        
        if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value){
        Node current = head;
        while (current != null){
            if(current.value == value){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    // leetcode Q83
    public void deleteDuplicates(){

        Node temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            }else{
                temp = temp.next;
            }
        }
        tail = temp;
        temp.next = null;
    }


    // insert using recursion
    public void insertRec(int value, int index){
        head = insertRec(value,index,head);
    }

    private Node insertRec(int val,int index, Node node){
        if(index == 0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }
        node.next = insertRec(val,--index, node.next);
        return node;
    }

    //merge 2 list - LC Q21
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else{
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    //reverse LL recursive
    public void reverseLL(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseLL(node.next);
        //reverse the linkage
        tail.next = node;
        tail = node;
        tail.next = null;

    }

    //https://youtu.be/70tx7KcMROc?list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&t=7347
    //public void in-place reversal Q206
    //https://leetcode.com/problems/reverse-linked-list/
    public Node reverseList(Node node){
        if( node != null && node.next != null){
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }

    //Q92
    //https://leetcode.com/problems/reverse-linked-list-ii/
    //reverse part of list
    public Node reverseBetween(Node head, int left, int right) {

        if(left == right){
            return head;
        }

        //skip left-1 nodes
        Node current = head;
        Node prev = null;
        for(int i= 0;current != null && i < left - 1; i++){
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        // reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {

            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
            
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;
        return head;

    }

    //palindrome Q234
    //https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node reReverseHead = headSecond;

        //compare both halves
        while(head != null && headSecond != null){
            if(head.value != headSecond.value){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(reReverseHead);

        if(head == null || headSecond == null){
            return true;
        }
        return false;

    }


    public Node middleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
        }
        return slow;

    }

    //https://leetcode.com/problems/reorder-list/description/
    public void reorderList(Node head) {
        if(head == null || head.next == null){
            return;
        }
        Node mid = middleNode(head);

        Node first = head;
        Node second = reverseList(mid);

        // rearrange
        while(first != null && second != null){
            Node temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        if(first != null){
            first.next = null;
        }
    }
}
