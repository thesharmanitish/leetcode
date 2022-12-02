class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        boolean dstnPresent = false;
        for(int[] flight: flights){
            if(flight[1] == dst)
                dstnPresent = true;
            map.computeIfAbsent(flight[0], ArrayList::new).add(new Integer[]{flight[1], flight[2]});
        }
        if(map.get(src)==null || !dstnPresent)
            return -1;
        
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{src,0});

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while(k-->=0 && !bfs.isEmpty()){
            int size = bfs.size();
            while(size-->0){
                int[] tmp = bfs.poll();
                int dist = tmp[1], root = tmp[0];
                List<Integer[]> adjList = map.get(tmp[0]);
                if(adjList== null || adjList.size()==0)
                    continue;
                
                for(Integer[] node: adjList){
                    int next = node[0], d = node[1];
                    if(d+dist >= distance[next])
                        continue;
                    distance[next] = d+dist;
                    bfs.add(new int[]{next, distance[next]});
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE? -1:distance[dst];

    }
}