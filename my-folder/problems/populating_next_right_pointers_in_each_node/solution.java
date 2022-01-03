/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
/*    public Node connect(Node root) {
        Deque<Node> bfs = new LinkedList<>();
        int flag = 1, count =1;
        bfs.add(root);
        Node prev_node = null;
        while(!bfs.isEmpty()){
            
            Node node = bfs.pop();
            if(node == null) continue;
            if(count > 1){
                prev_node.next = node;
                
            }
            if(count==flag){
                node.next=null;
                flag*=2;
                count =0;
            }
            count++;
            prev_node = node;
            if(node.left !=null) bfs.offerLast(node.left);
            if(node.right !=null) bfs.offerLast(node.right);
        }
        return root;
    }
 
    public Node connect(Node root) {
      if(root == null) return root;    
      helper(root.left, root.right);    
        return root;
    }
    
    void helper(Node node1, Node node2){
      if(node1 == null) return;    
      node1.next = node2;
      if(node1.left==null)  return;
      helper(node1.left, node1.right);
      helper(node2.left, node2.right);
      helper(node1.right, node2.left);

    }
 */
    public Node connect(Node root) {
        Node level_start=root;
        while(level_start!=null){
            Node cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
        return root;
    }
}