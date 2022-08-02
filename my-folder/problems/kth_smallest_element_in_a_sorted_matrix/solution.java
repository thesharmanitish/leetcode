class Node{
    int data;
    int x;
    int y;
    
    public Node(int data, int x, int y){
        this.data = data;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data - b.data);
        
        for(int i=0;i<matrix.length;i++)
            pq.add(new Node(matrix[i][0], i, 0 ));
        
        Node node = pq.peek();
        while (k-- > 0) {
             node = pq.poll();
             int x =  node.x;
             int y =  node.y;
             if(y<matrix.length-1){
                pq.add(new Node(matrix[x][y+1], x, y+1));
             }            
        }
        return node.data;
            
        
    }
}