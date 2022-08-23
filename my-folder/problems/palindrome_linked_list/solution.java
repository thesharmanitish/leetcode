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
    public boolean isPalindrome(ListNode head) {
        root = head;
        return isPalindromeHelper(head);
    }
    public boolean isPalindromeHelper(ListNode head) {
        if(head == null )
            return true;
        boolean res = isPalindromeHelper(head.next);
        if(!res)
            return false;
        if(head.val != root.val)
            return false;
        root = root.next;
        return true;
    }
}