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
    public boolean isValidBST(TreeNode root) {
        if(root ==null )
            return true;
        else if(root.left ==null && root.right ==null)
            return true;
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if((min !=null && root.val <= min ) || (max !=null && root.val >= max))
            return false;
        return isValidBST(root.right, root.val, max) && isValidBST(root.left, min, root.val);
    }
}