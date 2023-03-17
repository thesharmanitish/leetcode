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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length-1;
        return buildTree(inorder, 0, n, postorder, 0, n);
    }
    public TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
           int newpstart=0,newiend=0;
           if (pstart>pend || istart>iend) 
                return null;
           int i=0;
           
           if(istart == iend){
               return new TreeNode(inorder[istart]);
           }
           for(i=istart; i<=iend;i++){
               if(inorder[i] == postorder[pend]){
                    TreeNode t = new TreeNode(inorder[i]);
                    t.left = buildTree(inorder, istart, i-1, postorder, pstart, pstart+(i-1-istart));           
                    t.right = buildTree(inorder, i+1, iend, postorder, pstart+i-istart, pend-1); 
                    return t;
               }
           }



            return null;          
    }    
}