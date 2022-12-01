
class Solution {
    class Edge{
    int[] nodeA;
    int[] nodeB;
    int distance;
    int b;
    public Edge(int[] nodeA, int[] nodeB,int b){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.b = b;
        distance = Math.abs(nodeA[0]-nodeB[0])+ Math.abs(nodeA[1]-nodeB[1]);
        }
    }
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);

        for(int i=1;i<points.length;i++){
            pq.add(new Edge(points[0], points[i], i));
        }
        int sum = 0, n = points.length-1;
        boolean[] visited = new boolean[points.length];
        visited[0] = true;
        for(int count = 0;count<points.length-1;){
            Edge edge = pq.poll();
            if(visited[edge.b])
                continue;
            sum += edge.distance;
            visited[edge.b] = true;

            for(int i=1;i<=n;i++){
                if(!visited[i])
                    pq.add(new Edge(edge.nodeB, points[i], i));
                if(!pq .isEmpty() &&  visited[pq.peek().b])
                    pq.poll();                    
            }
            count++;
        }
        return sum;
    }
}