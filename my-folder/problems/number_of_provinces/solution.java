class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected, boolean[] isVisited, int ind) {
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[ind][i] ==0 || i==ind || isVisited[i])
                continue;
            isVisited[i] = true;
            dfs(isConnected, isVisited, i);
        }

    }
    /**
        public int findCircleNum(int[][] isConnected) {
        int[] root = new int[isConnected.length];
        for(int i=0;i<root.length;i++){
            root[i] = i;
        }
        for(int i=0;i<root.length;i++){
            for(int j=0;j<root.length;j++){
                if(isConnected[i][j] ==0 || i ==j)
                    continue;
                union(root,i, j);
            }
        }
        int i=1, count=0;
        for(i=0;i<root.length;i++){
            if(root[i] == i)
                count++;
        }
        
        return count;
        
    }
    public int find(int[] root, int x) {
        return root[x];
    }
    
    public void union(int[] root, int x, int y) {
        int rootX = find(root,x);
        int rootY = find(root,y);
        if(rootX!=rootY){
            for(int i=0;i<root.length;i++){
                if(root[i] ==rootY)
                    root[i] = rootX;
            }
        }
    }
     */
}