class Solution {
    int[] root;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) 
           return false;
        root = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
            root[i] = i;
        Arrays.fill(rank, 1);
        for(int[] edge:edges){
            if(!union(edge[0], edge[1]))
                return false;
        }
        return true;
    }
    public int find(int n) {
        while(root[n]!=n){
            root[n] = root[root[n]];
            n = root[n];
        }
        return n;
    }
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)
            return false;
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }else{
            root[rootX] = rootY;
            rank[rootX] = Math.max(rank[rootY], 1+rank[rootX]);
        }
        return true;
    }
}