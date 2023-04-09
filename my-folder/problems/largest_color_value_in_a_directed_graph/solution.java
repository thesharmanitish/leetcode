class Solution {
  public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int answer = 1, nodesSeen = 0;
        while (!q.isEmpty()) {
            int node = q.poll();


            answer = Math.max(answer, ++count[node][colors.charAt(node) - 'a']);
            nodesSeen++;
            if (!adj.containsKey(node)) {
                continue;
            }

            for(int neighbour:adj.get(node)){
                for(int i=0;i<26;i++){
                    count[neighbour][i] = Math.max(count[neighbour][i], count[node][i]);
                } 
                indegree[neighbour]--;
                if(indegree[neighbour] ==0)
                    q.offer(neighbour);
            }
            
        }

        return nodesSeen < n ? -1 : answer;
    }
}