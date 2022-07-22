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
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        
        ListNode right = new ListNode(-1);
        
        ListNode prev = null, rightHead = right, root = head;
        while(head != null){
            if(head.val <x){
                prev = head;
                head = head.next;
                
            }
            else{
                if(prev ==null){
                    root = head.next;
                    right.next = head;
                    right = right.next;
                    head = head.next;
                    right.next = null;
                    
                }else{
                    prev.next = head.next;
                    
                    right.next = head;
                    right = right.next;
                    head = head.next;
                    right.next = null;
                }
            }
        }
        if(prev!=null)
            prev.next = rightHead.next;
        else
            root = rightHead.next;
        return root;
    }
}