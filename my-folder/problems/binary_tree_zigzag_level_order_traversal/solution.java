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
        List<List<Integer>> zigzagOrder = new ArrayList();
        Deque<TreeNode> bfs = new LinkedList();
        if(root == null) return zigzagOrder;
        bfs.add(root);
        int height = 0;
        while(!bfs.isEmpty()){
            List<Integer> level = new ArrayList();
            int queueSize = bfs.size();
            
           for(int i=0; i< queueSize;i++){
               TreeNode node = bfs.poll();
               if(node!=null){
            	 level.add(node.val);
                 if(node.left!=null) bfs.add(node.left);
                 if(node.right!=null) bfs.add(node.right);
                 
                }
           }
           if(height %2 != 0)
        	   Collections.reverse(level);
         zigzagOrder.add(level)  ;
         height++;
            
        }
        return zigzagOrder;
        
    }
}