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
    TreeNode prev = new TreeNode(Integer.MIN_VALUE), first, second;
    
    public void recoverTree(TreeNode root) {
        traversal(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void traversal(TreeNode root) {
        if(root == null)
            return;
        traversal(root.left);
        if(first == null && prev.val > root.val)
            first = prev;
        if(first !=null && prev.val > root.val)
            second = root;
            
        
        prev = root;
        
        traversal(root.right);
       
    }       
}