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
    private static Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();

            if(prev !=null && prev.val>=root.val)
                    return false;
            prev = root;
            root = root.right;
            
        }
        return true;
        
        
    }
//     public boolean isValidBST(TreeNode root) {

//         return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
//     public boolean isValidBST(TreeNode root, long min, long max) {
//         if(root == null)
//             return true;
//         if(root.val>= max || root.val <= min)
//             return false;
        
//         return isValidBST(root.left, min, root.val) &&
//             isValidBST(root.right, root.val, max);
//     }
}