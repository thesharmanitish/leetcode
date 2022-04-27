class Pair{
    int x;
    int y;
    int ind;
    public Pair(int x, int y, int ind){
        this.x = x;
        this.y = y;
        this.ind= ind;
    }
}
class Edge{
    Pair a;
    Pair b;
    int dist;
    public Edge(Pair a, Pair b){
        this.a = a;
        this.b = b;
        dist = Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
    }
    
}
class Solution {
    public int minCostConnectPoints(int[][] points) {

        boolean[] visited = new boolean[points.length];
        int cost = 0, count = 1;
        PriorityQueue<Edge> q = new PriorityQueue<>((o1,o2)-> {return o1.dist - o2.dist;});
        for(int i=1;i<points.length;i++)
            q.add(new Edge(new Pair(points[0][0], points[0][1], 0), new Pair(points[i][0], points[i][1],i)));
        visited[0] = true;
        
        
        
        while(count<points.length){
            Edge edge = q.poll();
            if(visited[edge.b.ind])
               continue; 
            visited[edge.b.ind] = true;
            cost+= Math.abs(edge.a.x - edge.b.x)+Math.abs(edge.a.y - edge.b.y);
            count++;
            for(int i=0;i<points.length;i++)
                q.add(new Edge(new Pair(points[edge.b.ind][0], points[edge.b.ind][1], edge.b.ind), new Pair(points[i][0], points[i][1],i)));            
        }
        return cost;
        
    
    }
}