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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return result;
        Deque<TreeNode> bfs = new LinkedList<>();

        bfs.add(root);
        boolean flag = true;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            insert(bfs, flag, size);
            flag = !flag;
        }
        return result;
    }
    public void  insert(Deque<TreeNode> bfs, boolean flag, int size) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            TreeNode t = bfs.poll();
            if(t ==null) 
                continue;
            list.add(t.val);
            
            if(t.left !=null) bfs.addLast(t.left);
            if(t.right !=null) bfs.addLast(t.right);
        }
        if(!flag){
            Collections.reverse(list);
        }        
        result.add(list);

    }
}