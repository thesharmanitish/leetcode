/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Map<TreeNode, Integer> q = new HashMap<>();
        for(TreeNode n:nodes){
            q.put(n, 1);
            if(n== root)
                return root;
        }
        lowestCommonAncestorUtil(root, q);
        return node;
        
    }
    TreeNode node;
    public int lowestCommonAncestorUtil(TreeNode root, Map<TreeNode, Integer> q) {
        
        if(root == null)
            return 0;
        
        int left = lowestCommonAncestorUtil(root.left, q);

        int right = lowestCommonAncestorUtil(root.right, q);
        
        int count  = left + right;
        
        if(q.get(root)!=null)
            count += 1;
        
        if(node ==null && q.size() ==count)
            node = root;

        return count;
    }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes){
//         Set<Integer> set = new HashSet<>();
//         for(TreeNode t: nodes) set.add(t.val);
//         return dfs(root,set);
//     }
    
//     private TreeNode dfs(TreeNode root, Set<Integer> set){
//         if(root == null) return null;
//         if(set.contains(root.val)) return root;
        
//         TreeNode left = dfs(root.left, set);
//         TreeNode right = dfs(root.right, set);
        
//         if(left == right) return null;
//         else if(left !=null && right != null) return root;
//         else if(left == null) return right;
//         else return left;
//     }
}