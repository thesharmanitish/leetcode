class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean flag = false;
        // set = new HashSet<>();
        int i=0;
        for(boolean apple:hasApple){
            if(apple){
                flag = true;
                // set.add(i);
            }
            i++;
        }
        if(!flag)
            return 0;
        this.hasApple = hasApple;
        map = new HashMap<>();

        for(int[] edge: edges){
            map.computeIfAbsent(edge[0], value -> new ArrayList()).add(edge[1]);
            if(edge[1]!=0)
                map.computeIfAbsent(edge[1], value -> new ArrayList()).add(edge[0]);
        }
        dfs(0);
        return count-2;
    }
    static List<Boolean> hasApple;
    // static boolean[] visited;
    static Map<Integer, List<Integer>> map;
    // Set<Integer> set;
    int count = 0;
    public boolean dfs(int n){
        // visited[n] = true;
        boolean flag = false;
        if(hasApple.get(n)){
            flag = true;
        }
        List<Integer> neighbours = map.get(n);
        for(int neighbour:neighbours){
            List<Integer> temp = map.get(neighbour);
            temp.remove(temp.indexOf(n));
            map.put(neighbour, temp);
            flag |= dfs(neighbour);
        }
        map.remove(n);
        if(flag)
            count +=2;
        return flag;
    }
}