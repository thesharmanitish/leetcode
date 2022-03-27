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
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(), tmp = head;
		int[] arr = new int[lists.length];
		int min = Integer.MAX_VALUE, minInd = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				arr[i] = lists[i].val;
				if (min > arr[i]) {
					min = arr[i];
					minInd = i;
				}
			} else
				arr[i] = Integer.MAX_VALUE;
		}
		while (minInd >=0 && lists[minInd] != null) {
			tmp.next = lists[minInd];
			lists[minInd] = lists[minInd].next;
			if (lists[minInd] != null) {
				arr[minInd] = lists[minInd].val;

			} else {
				arr[minInd] = Integer.MAX_VALUE;
				
			}
			tmp = tmp.next;
			tmp.next = null;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < lists.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					minInd = i;
				}

			}
		}
		return head.next;

	
    }
}