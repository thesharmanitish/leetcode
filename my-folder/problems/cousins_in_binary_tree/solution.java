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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> bfs = new LinkedList<>();
        
        bfs.add(root);
        boolean foundX = false , foundY = false;
        while(!bfs.isEmpty()){
            
            int size = bfs.size();
            for(int i=0;i<size;i++){
                TreeNode node = bfs.poll();
                
                if(node.left !=null && node.right !=null && ((node.left.val == x && node.right.val ==y) || (node.left.val == y && node.right.val ==x)))
                    return false;
                if(node.val == x)
                    foundX = true;
                else if(node.val == y)
                    foundY = true;
                if(node.left!=null) bfs.add(node.left);
                if(node.right!=null) bfs.add(node.right);
            }
            if(foundX && foundY)
                return true;
            else if(foundX || foundY)
                return false;
            
        }
        return false;
        
    }
}