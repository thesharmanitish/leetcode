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
    public String tree2str(TreeNode root) {
        String res = tree2strUtil(root);
        return res.substring(1, res.length()-1);
    }
    public String tree2strUtil(TreeNode root) {
        if(root==null)
            return null;

        String left = tree2strUtil(root.left) ;
        String right = tree2strUtil(root.right) ;

        if(left != null & right != null)
            return "("+root.val+left+right +")";
            
        else if(right !=null)
            return "("+root.val+"()"+right+")";
        else if(left !=null)
            return "("+root.val+left+")";
        else
            return "("+root.val+")";
            
    }
}