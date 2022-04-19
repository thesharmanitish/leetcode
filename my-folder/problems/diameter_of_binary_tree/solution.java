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
    
    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return res -1;
    }
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null)
            return 0;
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);
        
        
        int tmp = Math.max(left,right)+1;
        int max = Math.max(tmp,left+right+1);
        res = Math.max(max, res);
        return tmp;
    }    
}