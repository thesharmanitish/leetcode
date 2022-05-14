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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new LinkedList<>();
        int height = root == null ? 1 : getHeight(root);
        int rows = height, columns = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for(int i = 0; i < columns; i++)  row.add("");
        for(int i = 0; i < rows; i++)  res.add(new ArrayList<>(row));
        populateRes(root, res, 0, rows, 0, columns - 1);
        return res;        
    }
    public void populateRes(TreeNode root, List<List<String>> res, int row, int  totalrows, int  col, int  totalCols){
        
        if (row == totalrows || root == null) return;
        res.get(row).set((col+totalCols)/2, Integer.toString(root.val));
        populateRes(root.left, res, row+1, totalrows, col, (col+totalCols)/2-1);
        populateRes(root.right, res, row+1, totalrows, (col+totalCols)/2+1, totalCols);
        
    }
    public int getHeight(TreeNode root){
        if(root ==null)
            return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}