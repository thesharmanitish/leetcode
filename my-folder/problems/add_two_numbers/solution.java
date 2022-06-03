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
        ListNode head = l1, prev = null;
        int carry =0;
        while(l1 != null && l2 != null){
            int sum = l1.val+l2.val+carry;
            l1.val = sum>9?sum-10:sum;
            carry = sum>9?1:0;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2!=null){
           l1 = prev; 
           l1.next = l2;
           l1 = l1.next;
           addTillEnd(l1, carry);
            
        }
        else if(l1 != null){
            addTillEnd(l1, carry);   

        }else{
            if(carry>0)
               prev.next = new ListNode(carry);
        }
        
        return head;
    }
    public void addTillEnd(ListNode l1, int carry) {
            ListNode prev = null;
            while(l1 !=null){
                int sum = l1.val + carry;
                l1.val = sum>9?sum-10:sum;
                carry = sum>9?1:0;  
                prev = l1;
                l1 = l1.next;
            }
        if(carry>0)
            prev.next = new ListNode(carry);
        
        
            
    }
}