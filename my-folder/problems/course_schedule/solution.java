class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Boolean> seen = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        // Building the graph
        for(int[] courses : prerequisites) {
            int to = courses[0];
            int from = courses[1];
            var list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
            indegree[to]++;
        }
        
        // Implementation of Kahn's Alg
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            if(map.containsKey(node)) {
                for(int nei : map.get(node)) {
                    indegree[nei]--;
                    if(indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }
        return count == numCourses;
//     }
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         if(prerequisites.length==0) return true;
//         boolean[][] grid = new boolean[numCourses][numCourses];
//         int[] indegree = new int[numCourses];
        
//         for(int i=0;i<prerequisites.length;i++){
//           grid[prerequisites[i][0]][prerequisites[i][1]] = true;
//           indegree[prerequisites[i][1]]++;  
//         }
        
//         Deque<Integer> bfs = new LinkedList<>();
//         for(int i=0;i<numCourses;i++){
//             if(indegree[i]==0)
//                bfs.offer(i) ;
//         }
//         int count = 0;
//         while(!bfs.isEmpty()){
//             count++;
//             int num = bfs.pop();
//             for(int i=0;i<numCourses;i++){
//                 if(grid[num][i] && --indegree[i]==0){
//                     bfs.offer(i) ;
//                 }
//             }
//         }
//        return count==numCourses;
        // ArrayList<Integer>[] G = new ArrayList[n];
        // int[] degree = new int[n];
        // ArrayList<Integer> bfs = new ArrayList();
        // for (int i = 0; i < n; ++i) 
        //     G[i] = new ArrayList<Integer>();
        // for (int[] e : prerequisites) {
        //     G[e[1]].add(e[0]);
        //     degree[e[0]]++; 
        // }
        // for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        // for (int i = 0; i < bfs.size(); ++i)
        //     for (int j: G[bfs.get(i)])
        //         if (--degree[j] == 0) bfs.add(j);
        // return bfs.size() == n;
    }

}