/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            long sum = 0;
            for(int i=0;i<size;i++){

                TreeNode node = queue.poll();
                sum = sum + (long) node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            // sum = sum % (long) 1_000_000_007;
            pq.add(sum);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.size()<k?-1:pq.peek();        
    }
}