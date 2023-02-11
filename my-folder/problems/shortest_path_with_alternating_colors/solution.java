class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) {
            adj.computeIfAbsent(redEdge[0], ArrayList::new).add(new int[]{redEdge[1], 0});
        }

        for (int[] blueEdge : blueEdges) {
            adj.computeIfAbsent(blueEdge[0], ArrayList::new).add(new int[]{blueEdge[1], 1});
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visit = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();

        // Start with node 0, with number of steps as 0 and undefined color -1.
        q.offer(new int[] { 0, 0, -1 });
        answer[0] = 0;
        visit[0][1] = visit[0][0] = true;

        while (!q.isEmpty()) {
            
            int[] val = q.poll();
            int node = val[0], depth = val[1], parentType = val[2];

            if(!adj.containsKey(node))
                continue;
            
            for(int[] neighbour:adj.get(node)){
                if(neighbour[1] == parentType || visit[neighbour[0]][neighbour[1]])
                    continue;
                visit[neighbour[0]][neighbour[1]] = true;
                if(answer[neighbour[0]] ==-1)
                    answer[neighbour[0]] = depth +1;
                q.offer(new int[]{neighbour[0], 1+depth, neighbour[1]});
            }
        }
        return answer;
    }
}