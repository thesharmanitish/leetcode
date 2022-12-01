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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumRec(root);
        return result;
    }
    public int maxPathSumRec(TreeNode root) {  
        if(root == null)
            return 0;
        int left = Math.max(maxPathSumRec(root.left), 0);
        int right = Math.max(maxPathSumRec(root.right),0);
        result = Math.max(result, root.val+left+right);
        return Math.max(left, right)+root.val;
    }
}