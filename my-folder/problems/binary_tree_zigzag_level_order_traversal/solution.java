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
        List<List<Integer>> ans = new LinkedList<>();
        
        if(root ==null)
            return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode x = queue.poll();
                if(x == null)
                    continue;
                if(x.left !=null) queue.add(x.left);
                if(x.right !=null) queue.add(x.right);
                list.add(x.val);
            }
            if(flag){
                Collections.reverse(list);
            }
            ans.add(list);
            flag = !flag;
        }

        return ans;
    }
}