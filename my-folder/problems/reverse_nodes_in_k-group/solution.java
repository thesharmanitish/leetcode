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
    public ListNode reverseList(ListNode head, int k) {  
        ListNode newHead = null;  
        while(k-->0){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head, prev = new ListNode(-1);
        ListNode newRoot = prev;
        while(cur != null){
            int n = k;
            cur = head;
            while(n-->0 && cur !=null){
                cur = cur.next;
            }
            if(n >=0){
                break;
            }  
            ListNode newHead = reverseList(head, k);
            prev.next = newHead;
            prev =  head;
            head = cur;
        }
        prev.next = head;
        return newRoot.next;
    }

    // public ListNode reverseKGroup(ListNode head, int k) {
    //     ListNode root = head, cur = head, prev = null;
    //     Stack<ListNode> stack = new Stack<>();
    //     while(cur != null){
    //         int n = k;
    //         while(n-->0 && cur !=null){
    //             stack.push(cur);
    //             cur = cur.next;
    //         }
    //         if(n >=0){
    //             stack.clear();
    //             break;
    //         }
    //         while(!stack.isEmpty()){
    //             ListNode end = stack.pop();
    //             if(prev!=null)  {  
    //                 prev.next = end;
    //                 prev = prev.next;
    //                 prev.next = null;
    //             }
    //             else{ 
    //                 prev = end;
    //                 root = end;
    //             }

    //         }
    //         prev.next = cur;

    //     }
    //     return root;
    // }
}