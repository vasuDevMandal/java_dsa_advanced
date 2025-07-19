package LinkedList;

public class CycleQus {

    public static void main(String[] args) {

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

//      Definition for singly-linked list.
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }


}
