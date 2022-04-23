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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode t = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                t = q.poll();
                if(t.left !=null) q.offer(t.left);
                if(t.right !=null)  q.offer(t.right);
            }
            res.add(t.val);
        }
        return res;
    }
}