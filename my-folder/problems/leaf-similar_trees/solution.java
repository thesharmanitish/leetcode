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
    int[] visited = new int[200];
    int i=0, j =0;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Arrays.fill(visited, -1);
        leafSimilar(root1);
        if(!checkLeafs(root2))
            return false;
        return i==j;
    }
    public void leafSimilar(TreeNode root) {
        if(root ==null)
            return;
        if(root.left ==null && root.right ==null){
            visited[i++] = root.val;
            return;
        }
        leafSimilar(root.left);
        leafSimilar(root.right);
    }
    public boolean checkLeafs(TreeNode root) {
        if(root ==null)
            return true;
        if(root.left ==null && root.right ==null){
            if(visited[j]==-1 || visited[j] != root.val)
                return false;
            j++;
            return true;
        }
        if(!checkLeafs(root.left)) return false;
        if(!checkLeafs(root.right)) return false;
        return true;
    }         
}


//  class Solution {
// public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//     Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
//     s1.push(root1); s2.push(root2);
//     while (!s1.empty() && !s2.empty())
//         if (dfs(s1) != dfs(s2)) return false;
//     return s1.empty() && s2.empty();
// }

// public int dfs(Stack<TreeNode> s) {
//     while (true) {
//         TreeNode node = s.pop();
//         if (node.right != null) s.push(node.right);
//         if (node.left != null) s.push(node.left);
//         if (node.left == null && node.right == null) return node.val;
//     }
// } 
// }