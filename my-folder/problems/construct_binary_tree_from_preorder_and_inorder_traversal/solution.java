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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int istart, int iend, int[] preorder, int pstart, int pend) {
        int newpstart=0,newiend=0;
        if (pstart>pend || istart>iend) return null;
        int i=0;
        TreeNode root = new TreeNode(preorder[pstart]) ;
        for( i=0;i<=iend;i++){
            if(inorder[i]==root.val){
                break;
            }
            
                
        }
        /*
           TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+leftlen, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, pe-1-rightlen, pe-1, hm);
        */
        root.left = buildTree(inorder,istart,i-1,preorder,pstart+1,pstart+i-istart);
        root.right = buildTree(inorder,i+1,iend,preorder,pend -(iend - i)+1,pend);
        return root;
    }
}