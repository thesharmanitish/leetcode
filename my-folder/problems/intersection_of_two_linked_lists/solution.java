/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rootA = headA, rootB = headB;
        while(headA != null && headB!=null){
            headA = headA.next;
            headB = headB.next;
        }
        int countA =0, countB = 0;
        if(headA !=null){
            while(headA !=null){
                if(headB == headA)
                    return headB;
                headA= headA.next;
                countA++;
            }
        }else if(headB != null){
            while(headB!=null){
                if(headB == headA)
                return headB;
            headB = headB.next;
            countB++;
            }
        }
        headA = rootA;
        headB = rootB;
        while(countA-- >0){
            headA = headA.next;
        }
        while(countB-- >0){
            headB = headB.next;
        }
        
        
        while(headA!=null && headB!=null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }        
        
        return headA;
    }
}