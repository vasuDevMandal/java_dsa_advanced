package LinkedList;

import org.w3c.dom.Node;

public class CycleQus {

    public static void main(String[] args) {
//[-1,5,3,4,0]
//        ListNode head = new ListNode(-1);
//        ListNode two = new ListNode(5);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(0);
//        head.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = null;

        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(8);
        display(head);

//        sortList(head);
        rotateRight(head, 8);
        display(head);
    }

    static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0){
            return head;
        }
        int length = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1 ; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;

    }

    static ListNode get(ListNode head,int index){
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    static ListNode sortList(ListNode head) {
//        System.out.println("\n- sortList - ");
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNodeForMergerSort(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 :  list2;
        return dummyHead.next;
    }

    static ListNode middleNodeForMergerSort(ListNode head) {
        //break the list, bcoz, we are running loop till null in merge
        //two list should not be connected
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast != null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        return slow;
    }

//  works on single list only
    static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
//find if list has cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true; 
            }
        }
        return false;
    }

//    find length of the cycle
public int cycleLength(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            int count = 1;
            ListNode temp = slow.next;
            while(temp != fast){
                count++;
                temp = temp.next;
            }

            return count;
        }
    }
    return 0;
}
//https://leetcode.com/problems/linked-list-cycle-ii/description/?envType=problem-list-v2&envId=linked-list
//  find where cycle begins
public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            ListNode start = head;
            ListNode meet = slow;
            while(start != meet){
                start = start.next;
                meet = meet.next;
            }
            return meet;
        }
    }
    return null;
}

//find happy number
public boolean isHappy(int n) {
    int slow = n;
    int fast = n;

    do{
        slow = findSquare(slow);
        fast = findSquare(findSquare(fast));
    }while(slow != fast);

    if(slow == 1){
        return true;
    }else{
        return false;
    }
}

    public int findSquare( int num){
        int ans = 0;
        while(num > 0){
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }

    static void display(ListNode head){
        ListNode temp = head;
        System.out.println("\n- display -");
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END\n");
    }

//      Definition for singly-linked list.

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
