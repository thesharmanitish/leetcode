/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        inorderTraversalUtil(root);
        return result;
    }
    public void inorderTraversalUtil(Node root) {
        if(root  == null)
            return;
        
        for(Node node:root.children)
            inorderTraversalUtil(node);
        result.add(root.val);
    }  
}