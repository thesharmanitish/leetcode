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
    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();
    
    public void preorder(TreeNode node, long currSum) {
        if(node == null)
            return;
        currSum += node.val;
        if(h.containsKey(currSum-k))
            count += h.get(currSum-k); 
        h.put(currSum,h.getOrDefault(currSum,0)+1); 
        preorder(node.left, currSum);
        preorder(node.right, currSum);
        h.put(currSum,h.get(currSum)-1);
    }    
            
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        h.put(0L,1);
        preorder(root, 0L);
        return count;
    }
}

// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null)
//             return 0;
//         return pSum(root, targetSum) + pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
         
//     }
//     public int pSum(TreeNode root, long targetSum) {
//         int res = 0;
//         if(root == null){
//             return res;
//         }
//         if(root.val == targetSum)
//             res++;
//         return res +=pSum(root.left, targetSum-root.val) + pSum(root.right, targetSum-root.val);
//     }
// }