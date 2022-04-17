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
        
    public TreeNode increasingBST(TreeNode root ) {
        return increasingBST(root, null ) ;
    }
    public TreeNode increasingBST(TreeNode root, TreeNode next ) {
        if(root==null)
            return next;
        root.right = increasingBST(root.right, next ) ;
        TreeNode tmp = increasingBST(root.left, root ) ;
        root.left = null;
        return tmp;
    }
}
