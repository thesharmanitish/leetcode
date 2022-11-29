class Edge{
    int[] nodeA;
    int[] nodeB;
    int distance;
    int a;
    int b;
    public Edge(int[] nodeA, int[] nodeB, int a, int b){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.a = a;
        this.b = b;
        distance = Math.abs(nodeA[0]-nodeB[0])+ Math.abs(nodeA[1]-nodeB[1]);
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);

        for(int i=1;i<points.length;i++){
            pq.add(new Edge(points[0], points[i], 0, i));
        }
        int count = 0, sum = 0, n = points.length-1;
        boolean[] visited = new boolean[points.length];
        visited[0] = true;
        while(count < n){
            Edge edge = pq.poll();
            if(visited[edge.b])
                continue;
            sum += edge.distance;
            System.out.println("sum = "+sum+ " a: "+ edge.a + " b:"+edge.b);
            visited[edge.b] = true;
            for(int i=1;i<=n;i++){
                if(!visited[i])
                    pq.add(new Edge(edge.nodeB, points[i], edge.b, i));
            }
            count++;
        }
        return sum;
    }
}