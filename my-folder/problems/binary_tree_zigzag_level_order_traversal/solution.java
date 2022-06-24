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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root ==null)
            return res;
        bfs.add(root);
        boolean flag= false;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            List<Integer> ll = new LinkedList<>();
            
            for(int i=0;i<size;i++){
                TreeNode t = bfs.poll();
                if(t.left !=null)    
                    bfs.add(t.left);
                if(t.right !=null)    
                    bfs.add(t.right);
                ll.add(t.val);
            }
            if(!flag)
                res.add(ll);
            else {
                Collections.reverse(ll);
                res.add(ll);
            }
            flag = !flag;
        }
        return res;
    }
}