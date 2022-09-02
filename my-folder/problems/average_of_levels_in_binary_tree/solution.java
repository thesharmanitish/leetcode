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
    public List<Double> averageOfLevels(TreeNode root) {
        averageOfLevels(root, 0);
        for(int i=0;i<result.size();i++){
            result.set(i, result.get(i)/map.get(i));
        }
        return result;
    }
    
    
    List<Double> result = new ArrayList<>();
    Map<Integer, Double> map = new HashMap<>();
    public void averageOfLevels(TreeNode root, int level) {
        if(root == null)
                return;
        double x = 0;
        if(result.size() > level)
             x = result.remove(level);
        map.put(level, map.getOrDefault(level, 0.0)+1.0);
        result.add(level, x + root.val);
        averageOfLevels(root.left, level+1);
        averageOfLevels(root.right, level+1);
        
    }
}