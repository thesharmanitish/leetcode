/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode fast = head.next, slow = head, tmp = null, prev = null;
        
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        tmp = slow.next;
        slow.next = null;
        prev = null;
        while(tmp!=fast){
           
            slow = tmp;
            tmp = tmp.next;
            slow.next = prev;
             prev = slow;
            
        }
        if(fast!=null){
              slow = tmp;
            slow.next = prev;
        }
        prev = head;
        while(slow!=null){
            if(slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}