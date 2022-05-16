class Solution {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int res = 0;
    
    public int treeDiameter(int[][] edges) {
        if(edges.length ==0)
            return 0;
        graph = new HashMap();
        visited = new boolean[edges.length + 1];
        
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            
            graph.computeIfAbsent(a, k -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<Integer>()).add(a);
        }
        
        dfs(edges[0][0]);
        
        return res;
    }
    private int dfs(int node) {
        visited[node] =true;
        
        int top1 = 0;
        int top2 = 0;        
        for(int next:graph.get(node)){
            if(!visited[next]){
                int len = dfs(next);
                if(len>=top1){
                    top2 = top1;
                    top1 = len;
                }else if(len>=top2)
                    top2 = len;
                
            }
            
            
        }
        res = Math.max(top1+top2, res);
        
        return top1 +1;
        
        
    }

}