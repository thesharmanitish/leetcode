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
        if(head ==null) 
            return head;
        ListNode rightroot = new ListNode(-1), prev = null, right = rightroot, root = head;
        ListNode node = root;
        while(root!=null){
            if(root.val>= x){
                right.next = root;
                right = right.next;
                root = root.next;
                right.next = null;
                
            }else{
                if(prev !=null)
                    prev.next = root;
                else 
                    node =root;
                prev = root;
                root = root.next;
            }
            
        }
        rightroot = rightroot.next;
        if(prev!=null)
            prev.next = rightroot;
        
       return node;
    }
}