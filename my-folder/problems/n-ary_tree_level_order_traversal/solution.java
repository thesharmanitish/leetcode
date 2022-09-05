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
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Deque<Node> bfs = new LinkedList<>();
        
        bfs.add(root);
        List<Integer> current;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            current = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node node = bfs.pollFirst();
                current.add(node.val);
                bfs.addAll(node.children);
            }
            result.add(current)    ;
            
        }
        return result;
    }
}