/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA =  lowestCommonAncestorUtil(root, p, q);
        return pFound && qFound ? LCA : null;

    }
    boolean pFound, qFound;
    
    public TreeNode lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root  == null)
            return null;

        
        
        TreeNode left = lowestCommonAncestorUtil(root.left, p, q);
        TreeNode right = lowestCommonAncestorUtil(root.right, p, q);
                
        if(root ==p){
            pFound = true;
            return root;
        }
        else if(root ==q){
            qFound = true;
            return root;
            }
        return left == null ? right : right == null ? left : root;
    }
}