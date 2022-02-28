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
    
public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next ==null) return head;
        ListNode slow = head, fast=head, prev=null;
        int size = 0;

    
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
    
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
    
    
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
      ListNode h = new ListNode();
      ListNode t = h;
        while(l1 !=null && l2 != null){
            if(l1.val >l2.val){
                t.next = l2;
                l2 = l2.next;
            }else{
                t.next = l1;
                l1 = l1.next;
            }
            t = t.next;
        }
      if(l1!=null){
          t.next = l1;
      }
      if(l2!=null){
          t.next = l2;
      }
      return h.next;
  }
    
}
    
    
    
    










    
    
    
    
    
    
    
//     if (head == null || head.next == null)
//       return head;
        
//     // step 1. cut the list to two halves
//     ListNode prev = null, slow = head, fast = head;
    
//     while (fast != null && fast.next != null) {
//       prev = slow;
//       slow = slow.next;
//       fast = fast.next.next;
//     }
    
//     prev.next = null;
    
//     // step 2. sort each half
//     ListNode l1 = sortList(head);
//     ListNode l2 = sortList(slow);
    
//     // step 3. merge l1 and l2
//     return merge(l1, l2);
//   }
  
//   ListNode merge(ListNode l1, ListNode l2) {
//     ListNode l = new ListNode(0), p = l;
    
//     while (l1 != null && l2 != null) {
//       if (l1.val < l2.val) {
//         p.next = l1;
//         l1 = l1.next;
//       } else {
//         p.next = l2;
//         l2 = l2.next;
//       }
//       p = p.next;
//     }
    
//     if (l1 != null)
//       p.next = l1;
    
//     if (l2 != null)
//       p.next = l2;
    
//     return l.next;
//   }


// }