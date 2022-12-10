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
    long max = Integer.MIN_VALUE, sum = 0;
    int MOD = 1_000_000_000+7;
    public int maxProduct(TreeNode root) {
        sum = getSum(root);
        sum %= MOD;
        getProduct(root);
        return (int)(max%MOD);
    }
    public long getProduct(TreeNode root) {
        if(root == null)
            return 0;
        long r = getProduct(root.left) + getProduct(root.right) +root.val;
        max = Math.max(max, r*(sum-r));
        return r;
    }
    public long getSum(TreeNode root) {
        if(root == null)
            return 0;

        return getSum(root.left) + getSum(root.right) + root.val;
    }
}