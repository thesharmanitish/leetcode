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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || right <= left)
            return head;
        
        int ind =1;
        ListNode root = head, l = null;
        while(ind<left){
            l = root;
            root = root.next;
            ind++;
        }

        
        ListNode prev = null, tail = root;
        while(ind<=right){
            ListNode next = root.next;
            root.next = prev;
            prev = root;
            root = next;
            ind++;
            
        }

        if(l!=null){
            l.next = prev;
        }
        else {
            head = prev;
        }
            
        tail.next = root;  // --> Crucial part
        return head;
        
        
        
        
    }
}