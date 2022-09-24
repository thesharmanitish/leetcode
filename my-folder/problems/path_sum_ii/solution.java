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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, new ArrayList<>());
        
        return result;
    }
    public void pathSum(TreeNode root, int targetSum, List<Integer> current) {
        if( root ==null)
            return;
        
        current.add(root.val);
        
        if(targetSum == root.val && ((root.left ==null && root.right ==null))){
            result.add(new ArrayList(current));
        }
        else{        
            pathSum(root.left, targetSum-root.val, current);
            pathSum(root.right, targetSum-root.val, current);
        }
        current.remove(current.size()-1);
    }    
}