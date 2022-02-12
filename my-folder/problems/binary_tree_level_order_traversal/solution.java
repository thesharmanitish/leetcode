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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Deque<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        bfs.addLast(root);
        while(!bfs.isEmpty()){
            int size = bfs.size();
            List<Integer> l = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode t = bfs.pollFirst();
                l.add(t.val);
                if(t.left !=null) bfs.addLast(t.left);
                if(t.right !=null) bfs.addLast(t.right);
                
            }
            res.add(l);
            
        }
        return res;
    }
}