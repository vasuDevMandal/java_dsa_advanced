package LinkedList.Questions;

public class LLEasyQus {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n1.next.next = n3;

//        System.out.println(getDecimalValue(n1));


    }
    static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
        return prev;
    }

    static int getDecimalValue(ListNode head) {
        int count  = 0 ;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        ListNode temp2 = head;
        int result = 0;
        for (int i = count; i >= 0 ; i--) {
            result += temp2.val * (int)Math.pow(2,i);
            temp2 = temp2.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
