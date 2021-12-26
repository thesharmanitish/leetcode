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
        List<List<Integer>> traverse = new ArrayList();
        Deque<TreeNode> queue = new LinkedList();
        Deque<TreeNode> level = new LinkedList();
        if(root == null) return traverse;
        queue.add(root);
        while(!queue.isEmpty()){
            while(!queue.isEmpty())
                level.add(queue.poll());
            List<Integer> levelArr = new ArrayList();
            while(!level.isEmpty()){
                TreeNode curNode = level.poll();
                if(curNode!=null){
                    levelArr.add(curNode.val);
                    if(curNode.left != null) queue.add(curNode.left);
                    if(curNode.right != null) queue.add(curNode.right);
             }
            }
            
            traverse.add(levelArr);
        }
    return traverse;
    }
}