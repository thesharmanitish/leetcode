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
    /*
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            for(int i=0;i<size;i++){
                Node temp = queue.pollFirst();
                if(temp == null)
                    continue;
                if(prev !=null) 
                    prev.next = temp;
                
                if(temp.left !=null)
                    queue.addLast(temp.left);
                if(temp.right !=null)
                    queue.addLast(temp.right);     
                
                prev = temp;
            }
            
        }
        return root;
    }
    public Node connect(Node root) {
        Deque<Node> bfs = new LinkedList<>();
        bfs.add(root);
        Deque<Node> layer = new LinkedList<>();
        while(!bfs.isEmpty()){
            while(!bfs.isEmpty())
            layer.offerLast(bfs.pop());
               
        Node prev_node =  layer.pop();
        if(prev_node == null ) return root;
        if(prev_node.left !=null) bfs.offerLast(prev_node.left);
        if(prev_node.right !=null) bfs.offerLast(prev_node.right);            
        int size  = layer.size();
         for(int i=0;i<size;i++){
            Node node = layer.pop();
             if(node!=null) 
                 prev_node.next = node;
             prev_node = node;
            if(node.left !=null) bfs.offerLast(node.left);
            if(node.right !=null) bfs.offerLast(node.right);
        }
      }
        return root;
    }
    
    public Node connect(Node root) {
        Node cur = root, levelHead = new Node(0);
        
        while(cur!=null){
            Node needle = levelHead;
            while(cur!=null){
                if(cur.left!=null){
                    needle.next = cur.left;
                    needle = needle.next;
                }
                if(cur.right!=null){
                    needle.next = cur.right;
                    needle = needle.next;
                }
                cur = cur.next;
            }
            cur = levelHead.next;
            levelHead.next = null;
        }
        return root;
    }
    */
        
    public Node connect(Node root) {
        if(root ==null) return root;
        Node cur = root, levelHead = new Node(0);
        
        Node needle = levelHead;
        
        while(cur !=null){
            if(cur.left != null){
                needle.next = cur.left;
                needle = needle.next;
            }
            if(cur.right != null){
                needle.next = cur.right;
                needle = needle.next;
            }
            
            if(cur.next !=null)
                cur = cur.next;
            else{
                cur = levelHead.next;
                levelHead.next = null;
                needle = levelHead;
            }
            
        }
        
        return root;
    }    
}