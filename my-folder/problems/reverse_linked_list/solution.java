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
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next ==null)
            return head;
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
        //  Iterative
//         ListNode prev = null;
//         while(head !=null){
//             ListNode next = head.next;
//             head.next = prev;
//             prev = head;
//             head  = next;
            
//         }
//         return prev;
//     }
}