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
    /**
    -1 need
    0 camera
    1 no need
    **/
    
    int res = 0;
    public int minCameraCover(TreeNode root) {
        return minCameraCoverHelper(root)==-1?1+res:res; 
    }
    public int minCameraCoverHelper(TreeNode root) {        
        if(root == null)
            return 1;
        int left =  minCameraCoverHelper(root.left);
        int right = minCameraCoverHelper(root.right);
        
        
        if(left == -1 || right ==-1){
            res++;
            return 0;
        }
        if(left ==0 || right ==0)
            return 1;
        return -1;

        
        
        
        
    }    
}