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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
//         ListNode tmp = new ListNode();
//         ListNode head = tmp;
//         while(list1!=null && list2!=null){
//             if(list1.val<list2.val){
//                 tmp.next = list1;
//                 list1 = list1.next;
//             }else{
//                 tmp.next = list2;
//                 list2 = list2.next;
                
//             }
//             tmp = tmp.next;
//             tmp.next = null;
//         }
//         if(list1!=null)
//             tmp.next = list1;
//         if(list2!=null)
//             tmp.next = list2;
        
//         return head.next;
    }
}