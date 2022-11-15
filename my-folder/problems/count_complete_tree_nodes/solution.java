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
    
    public int countNodesRec(TreeNode root) {
        int leftHeight = height(root);
        
        
        return leftHeight <0? 0:
                height(root.right) == leftHeight-1
                        ? (1<<leftHeight) + countNodes(root.right) 
                        : (1<<leftHeight-1) + countNodes(root.left);
        
    }
    
    
    public int countNodes(TreeNode root) {
        int leftHeight = height(root);
        int count =0;
        while(root !=null){
            if(height(root.right) == leftHeight-1){
                count+=1<<leftHeight;
                root = root.right;
            }else{
                count+=1<<leftHeight-1;
                root = root.left;
            }
            leftHeight--;
        }

        return count;
    }
    
    public int height(TreeNode root) {
        if(root==null)   
            return -1;
        return 1+ height(root.left);
        
    }    
}