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
    ListNode root;
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        reverseListHelper(head);
        head.next = null;
        return root;
    }
    public ListNode reverseListHelper(ListNode head) {
        if(head.next == null){
            root = head;
            return head;
        }
        
        ListNode prev = reverseListHelper(head.next);
        prev.next = head;
        return head;
    }    
}