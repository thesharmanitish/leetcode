/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Queue<Node> bfs = new LinkedList<>();

        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val,new Node(node.val));
        bfs.add(node);
        while(!bfs.isEmpty()){
            Node next = bfs.poll();
            for(Node child:next.neighbors){
                if(!map.containsKey(child.val) ){
                    map.put(child.val,new Node(child.val));                
                    bfs.add(child);
                }
                map.get(next.val).neighbors.add(map.get(child.val));
            }
        }

        return map.get(node.val);
    }
}