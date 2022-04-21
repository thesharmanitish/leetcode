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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAllLeftNodes(root);
    }
    public void addAllLeftNodes(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }        
    }
    public int next() {
        TreeNode root = stack.pop();
        if(root.right !=null){
          addAllLeftNodes(root.right);  
        }
        return root.val;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */