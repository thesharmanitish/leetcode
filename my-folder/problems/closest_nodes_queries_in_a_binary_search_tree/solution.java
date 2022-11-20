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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        popSet(root, set);
        List<List<Integer>> result = new ArrayList<>();
        
        for(Integer q:queries){
            Integer floor = set.floor(q);
            Integer ceil = set.ceiling(q);
            if(floor ==null)
                floor =-1;
            if(ceil ==null)
                ceil = -1;
            result.add(Arrays.asList(new Integer[]{floor, ceil}));
                
        }
        return result;
    }
    public void popSet(TreeNode root, TreeSet set){
        if(root ==null)
            return;
        set.add(root.val);
        popSet(root.left, set);
        popSet(root.right, set);
    }
}