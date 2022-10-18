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
        Queue<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>>  res = new ArrayList<>();
        if(root ==null)
            return res;
        bfs.add(root);
        
        while(!bfs.isEmpty()){
            List<Integer> lst = new ArrayList<>();
            int size = bfs.size();
            for(int i=0;i<size;i++){
                TreeNode t = bfs.poll();
                lst.add(t.val);
                if(t.left !=null) bfs.add(t.left);
                if(t.right !=null) bfs.add(t.right);
            }
            res.add(lst);
        }
        
        return res;
    }
}