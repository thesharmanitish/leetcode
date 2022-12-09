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
    int result =0;
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(maxAncestorDiff(root.left, root.val, root.val), maxAncestorDiff(root.right, root.val, root.val));
    }
    public int maxAncestorDiff(TreeNode root, int max, int min) {
        if(root == null)
            return 0;
        result = Math.max(max-root.val, root.val-min);
        return Math.max(result, 
                        Math.max(maxAncestorDiff(root.left, Math.max(root.val, max), Math.min(root.val, min)), 
                                maxAncestorDiff(root.right, Math.max(root.val, max), Math.min(root.val, min))));

    }
    
}