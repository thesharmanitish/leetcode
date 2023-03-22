class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();
    int m = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        for(int[] road:roads){
            map.computeIfAbsent(road[0], v-> new ArrayList<>()).add(new int[]{road[1], road[2]});
            map.computeIfAbsent(road[1], v-> new ArrayList<>()).add(new int[]{road[0], road[2]});
            m = Math.min(m, road[2]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(1);
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int x = queue.poll();

            for(int[] val:map.get(x)){
                if(val[1] ==m)
                    return m;
                min = Math.min(min, val[1]);
                if(visited[val[0]])
                    continue;
                queue.add(val[0]);
                min = Math.min(min, val[1]);
                visited[val[0]] = true;
            }
        }

        return min == Integer.MAX_VALUE? 0:min;
    }
}