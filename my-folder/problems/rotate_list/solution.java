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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 1;
        if(head == null || k==0)
            return head;
        ListNode root = head;
        while(head.next!=null){
            head = head.next;
            size++;
        }
        k = k%size;
        head = root;        
        if(k==size || size ==1|| k==0)
            return head;

        for(int i=0;i<size-k-1;i++){
            root = root.next;
        }
        ListNode tNode = root.next;
        root.next = null;
        root = tNode;
        while(root.next !=null){
            root = root.next;
        }
        root.next = head;
        return tNode;
    }
}