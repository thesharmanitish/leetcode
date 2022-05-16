/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        diameterHelper(root);
        return res;
    }
    int res = 0 ;
    public int diameterHelper(Node root) {
        if(root == null)
            return 0;
        int max =0,secondMax = 0;
        for(int i=0;i<root.children.size();i++){
            int t = diameterHelper(root.children.get(i));
            if(max<t){
                secondMax = max;
                max = t;
                
            }else if(secondMax < t){
                secondMax = t;
            }
                
        }
        res = Math.max(max+secondMax, res);
        
        return max+1;
    }    
}