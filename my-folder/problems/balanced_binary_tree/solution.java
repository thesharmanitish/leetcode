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
    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    	private static int depth(TreeNode root) {
		if(root == null) return 0;
		int lH = depth(root.left);
		int rH = depth(root.right);
		if(lH== -1 || rH ==-1 || Math.abs(lH-rH)>1) return -1;
		return 1+Math.max(lH,rH);
	}
}