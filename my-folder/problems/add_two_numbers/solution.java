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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1, head2 = l2, prev=null;
        int carry = 0;
        
        while(l1 !=null && l2 !=null){
            int sum = l1.val+l2.val +carry;
            l1.val = sum%10;
            carry = sum/10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 !=null){
            l1 = prev;          
            l1.next = l2;
            l1 = l1.next;  
            while(l1 !=null){
                int sum = l1.val +carry;

                l1.val = sum%10;
                carry = sum/10;
                prev = l1;
                l1 = l1.next;
            }
        }else if(l1!=null){
            while(l1 !=null){
                int sum = l1.val +carry;

                l1.val = sum%10;
                carry = sum/10;
                prev = l1;
                l1 = l1.next;
            }            
        }
        if(carry>0){
            ListNode t = new ListNode(carry);
            prev.next = t;
        }
            
        return head1;
    }
}