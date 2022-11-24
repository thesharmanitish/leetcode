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
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next == null)
            return head;
        ListNode prev = head, p =head;
        boolean flag = false;
        while(head!=null && head.next!=null){
            
            ListNode root = head.next;
            head.next = root.next;
            root.next = head;
            if(!flag){
                prev = root;
                flag = true;
            }else{
                p.next = root;
            }
            p = head;
            head = head.next;
        }
        return prev;
    }
}