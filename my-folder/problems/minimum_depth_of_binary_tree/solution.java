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
 
 class Pair{
        TreeNode node;
        int level;
     public Pair(TreeNode node, int level){
         this.node = node;
         this.level = level;
     }
    }
class Solution {
   
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Deque<Pair> bfs = new LinkedList();
        
        bfs.push(new Pair(root,1));
        while(!bfs.isEmpty()){
            Pair p = bfs.pop();
            // if(p.node == null) 
            if(p.node.left == null && p.node.right == null)
                return p.level;
            if(p.node.left != null) bfs.offerLast(new Pair(p.node.left, p.level+1));
            if(p.node.right != null) bfs.offerLast(new Pair(p.node.right, p.level+1));
            
        }
        return 1;
    }
}

class Solution {
    int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        helper(root,1);
        if(min==2147483647)
        {
            return 0;
        }
        return min;
    }
    public void helper (TreeNode root,int depth) {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            min=Math.min(min,depth);
        }
        helper(root.left,depth+1);
        helper(root.right,depth+1);
       }
}*/



public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
       
    }
}