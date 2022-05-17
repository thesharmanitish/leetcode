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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original ==null || target == original)
            return cloned;
        TreeNode tmp = null;;
        if(original.left !=null)
            tmp = getTargetCopy(original.left, cloned.left, target);
        if(tmp !=null)
            return tmp;
        
        return getTargetCopy(original.right, cloned.right, target);
    }
}