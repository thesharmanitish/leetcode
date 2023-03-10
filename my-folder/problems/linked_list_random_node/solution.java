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
    ListNode root;
    Map<Integer, ListNode> map;
    int size = 0;
    public Solution(ListNode head) {
        root = head;
        map = new HashMap();
        
        while(head!=null){
            map.put(size++, head);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int num  = new Random().nextInt(size);
        return map.get(num).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */