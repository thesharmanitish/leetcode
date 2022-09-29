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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head, cur = head;
        for(int i=0;i<=n;i++){
            if(cur ==null && i ==n){
                return head.next;
            }
            cur = cur.next;
        }
        while(cur!=null){
            cur = cur.next;
            root = root.next;
        }
        root.next = root.next.next;
        return head;
    }
}