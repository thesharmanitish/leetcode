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
    public ListNode plusOne(ListNode head) {
        int c = plusOneHelper(head, 1);
        ListNode ret = new ListNode(c);
        ret.next = head;
        return c== 0?head: ret;
    }
    public int plusOneHelper(ListNode head, int carry) {
        if(head == null)
            return carry;
        int c = plusOneHelper(head.next, carry);
        head.val += c;
        if(head.val<=9)
            return 0;
        else{
            int r = head.val/10;
            head.val = head.val%10;
            return  r;
        }        
    }
}