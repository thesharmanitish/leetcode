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
    
        return isValidBSTUtil(root, null, null);
    }
    public boolean isValidBSTUtil(TreeNode root, Integer max, Integer min) {
        if(root ==null)
            return true;
        if((min!=null && root.val<=min) || (max !=null && root.val >=max))
            return false;
        return isValidBSTUtil(root.left,root.val , min) &&
            isValidBSTUtil(root.right ,max, root.val);
    }
}