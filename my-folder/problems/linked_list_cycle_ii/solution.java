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
         ListNode slow = head, fast = head;
         
        if(head == null || head.next == null)
            return null;
        
         while(fast!=null && fast.next !=null){
             fast = fast.next.next;
             slow = slow.next;
             if(fast == slow)
                break;
         } 
        if(slow !=fast){
            return null;
        }         
         slow = head;
         
         while(slow!= fast){
             slow = slow.next;
             fast = fast.next;
         }
         return slow;
    }
}