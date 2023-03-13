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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode child1, TreeNode child2) {
        if(child1 == null && child2 == null)
            return true;
        else if( child1 == null || child2 == null || child1.val != child2.val)
            return false;
        
        return isSymmetric(child1.left, child2.right) &&  isSymmetric(child1.right, child2.left) ;
    }    
}