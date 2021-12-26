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
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return  isSymmetric(root.left, root.right);
    }
        public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left == null || right == null || left.val != right.val) return false;
        else return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            
    }
    
    
    
}
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        Deque<TreeNode> stack  = new LinkedList();
        stack.add(root.left);
        stack.add(root.right);
        while(!stack.isEmpty()){
            TreeNode left = stack.removeFirst();
            TreeNode right = stack.removeFirst();
            
            if(left == null && right ==null) continue;
            else if(left == null || right == null || left.val != right.val) return false;
            else{
                stack.add(left.left); stack.add(right.right);
                stack.add(left.right); stack.add(right.left);
            }
            
        }
        return true;
    }
}
