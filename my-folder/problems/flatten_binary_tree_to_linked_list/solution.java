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
    public void flatten(TreeNode root) {
        flattenUtil(root);
    }
    public TreeNode flattenUtil(TreeNode root) {
        if(root == null)
            return root;
        
        TreeNode left = flattenUtil(root.left);
        TreeNode right = flattenUtil(root.right);
        
        if(left !=null){
            left.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return right!=null? right :left!=null?left:root; 
    }
}