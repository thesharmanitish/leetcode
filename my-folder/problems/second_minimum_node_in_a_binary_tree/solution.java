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
    public int findSecondMinimumValue(TreeNode root) {
       return findSecondMinimumValue(root, root.val);
    }
    public int findSecondMinimumValue(TreeNode root, int max) {
        if(root == null)
            return -1;
        if(root.left ==  null)
            return -1;
        int left = root.left.val ==root.val ? findSecondMinimumValue(root.left, root.val):root.left.val;
        
        int right = root.right.val ==root.val ? findSecondMinimumValue(root.right, root.val):root.right.val;
        
        return left ==-1 || right ==-1 ? Math.max(left,right): Math.min(left,right);
    }
}