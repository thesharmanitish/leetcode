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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        boundaryOfLeftBinaryTreeUtil(root.left,res);
        leaves(root.left, res);
        leaves(root.right, res);
        boundaryOfRightBinaryTreeUtil(root.right,res);
        return res;
    }    
    public void boundaryOfLeftBinaryTreeUtil(TreeNode root, List<Integer> res) {
        if(root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if(root.left == null)
            boundaryOfLeftBinaryTreeUtil(root.right,res);
        else
            boundaryOfLeftBinaryTreeUtil(root.left,res);
    }
    public void boundaryOfRightBinaryTreeUtil(TreeNode root, List<Integer> res) {
        if(root == null || (root.left == null && root.right == null)) return;
        
        if(root.right == null)
            boundaryOfRightBinaryTreeUtil(root.left,res);
        else
            boundaryOfRightBinaryTreeUtil(root.right,res);
        
        res.add(root.val);
    }
    public void leaves(TreeNode root, List<Integer> res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }
}