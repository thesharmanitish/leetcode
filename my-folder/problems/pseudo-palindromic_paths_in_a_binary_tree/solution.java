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
    private int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        solve(root, new HashSet<Integer>());
        return result;
    }

    private void solve(TreeNode root, HashSet<Integer> set) {
        if (root == null) return;

        if (set.contains(root.val)) set.remove(root.val); 
        else set.add(root.val);

        if (root.left == null && root.right == null && set.size() <= 1) result++;

        solve(root.left, set);
        solve(root.right, set);
        
        if (set.contains(root.val)) set.remove(root.val); 
        else set.add(root.val);
    }
}
// class Solution {
//     Map<Integer, Integer> map = new HashMap<>();
//     int res = 0;
//     public int pseudoPalindromicPaths (TreeNode root) {
//         return pseudoPalindromicPathsHelper(root);
        
//     }
//     public int pseudoPalindromicPathsHelper (TreeNode root) {
//         if(root.left == null && root.right ==null){
//             int count = 0;
//             map.put(root.val, map.getOrDefault(root.val, 0)+1);
//             // System.out.println(res);
//             for(int num:map.values()){
//                 if(num%2!=0)
//                     count+=1;
//             }
//             map.put(root.val, map.get(root.val)-1);
//             if(count>1)
//                 return 0;
//             else return 1;
//         }
//         map.put(root.val, map.getOrDefault(root.val, 0)+1);
//          int x = 0, y = 0;
//          if(root.left!=null)
//              x = pseudoPalindromicPathsHelper(root.left);
//          if(root.right!=null) 
//              y = pseudoPalindromicPathsHelper(root.right);
        
//         map.put(root.val, map.get(root.val)-1);
//         return x+y;
//     }
// }