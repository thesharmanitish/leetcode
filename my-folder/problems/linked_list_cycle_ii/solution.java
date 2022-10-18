/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head ==null || head.next == null)
            return null;
        ListNode slow = head, fast = head;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(fast !=slow && fast != null &&  fast.next !=null);
        if(slow != fast)
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;        
    }
}