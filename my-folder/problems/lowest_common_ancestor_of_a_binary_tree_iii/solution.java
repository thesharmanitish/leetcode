/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// class Solution {
//     public Node lowestCommonAncestor(Node p, Node q) {
//         Node t = lowestCommonAncestorUtil(p, q);
//         if(t == null)
//             t = lowestCommonAncestorUtil(q, p);
//         while(t == null && p.parent!=null){
//             p = p.parent;
//             t = lowestCommonAncestorUtil(p, q);
//         }
            
//         if(t != null)
//             return t;
                
//         return null;
//     }
//     public Node lowestCommonAncestorUtil(Node p, Node q) {
//         if(p == null)
//             return p;
//         if(p == q)
//             return p;        
//         Node left = lowestCommonAncestorUtil(p.left, q);
//         Node right = lowestCommonAncestorUtil(p.right, q);
//         if(left !=null || right != null)
//             return p;

//         return null;
//     }
// }


class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> seen = new HashSet<>();
        while(p != null) {
            seen.add(p);
            p = p.parent;
        }
        
        while(q != null) {
            if (seen.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        
        return null;
    }
}