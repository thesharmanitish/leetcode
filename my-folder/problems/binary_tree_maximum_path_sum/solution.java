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
        int res ;
    public int maxPathSum(TreeNode root) {
              res = Integer.MIN_VALUE;
        if(root.left ==null && root.right ==null)
            return root.val;
        solve(root);
        return res;
    }
    
      int solve(TreeNode root){
        if(root ==null){
            return 0;
        }
        else{  
             
            int l = Math.max(solve(root.left),0);
            int r = Math.max(solve(root.right),0);

            res = Math.max(res, l+r+root.val );
            
            return Math.max(l,r)+root.val;
        }
      }
}