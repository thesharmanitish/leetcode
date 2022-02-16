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
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        int newpstart=0,newiend=0;
        if (pstart>pend || istart>iend) return null;
        int i=0;
        TreeNode root = new TreeNode(postorder[pend]) ;
        for( i=0;i<=iend;i++){
            if(inorder[i]==root.val){
                break;
            }
            
                
        }
        /*
           TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+leftlen, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, pe-1-rightlen, pe-1, hm);
        */
        root.left = buildTree(inorder,istart,i-1,postorder,pstart,pstart+i-istart-1);
        root.right = buildTree(inorder,i+1,iend,postorder,pend -(iend - i-1)-1,pend-1);
        return root;
    }
}