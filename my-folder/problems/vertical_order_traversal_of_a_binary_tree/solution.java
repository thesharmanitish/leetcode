
class Triplet<F, S, T> {
    F value;
    S row;
    T column;
    
    public Triplet( F f, S s, T t){
        value = f;
        row = s;
        column = t;
    }
}

class Solution {
    List<Triplet<Integer, Integer, Integer>> nodeList = new ArrayList<>();

    private void bfs(TreeNode root) {
        // tuples of <column, <row, value>>
        Queue<Triplet<TreeNode, Integer, Integer>> queue = new ArrayDeque();
        int row = 0, column = 0;
        queue.add(new Triplet(root, row, column));
        while(!queue.isEmpty()){
            Triplet<TreeNode, Integer, Integer> triplet = queue.poll();
            root = triplet.value;
            row = triplet.row;
            column = triplet.column;
            if(root!=null){
                nodeList.add(new Triplet(root.val, row, column));
                queue.offer(new Triplet(root.left, row+1,column-1));
                queue.offer(new Triplet(root.right, row+1,column+1));
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }
        
        
        bfs(root);
        
        Collections.sort(nodeList, (a,b) -> {
           if(a.column == b.column) {
               return a.row == b.row ? a.value - b.value:a.row - b.row;
           }else
               return a.column - b.column;
        });
        
        List<Integer> currColumn = new ArrayList();
        Integer currColumnIndex = this.nodeList.get(0).column;

        for (Triplet<Integer, Integer, Integer> triplet : this.nodeList) {
            Integer column = triplet.column, value = triplet.value;
            if (column == currColumnIndex) {
                currColumn.add(value);
            } else {
                output.add(currColumn);
                currColumnIndex = column;
                currColumn = new ArrayList();
                currColumn.add(value);
            }
        }
        output.add(currColumn);

        return output;        
        
    }
}