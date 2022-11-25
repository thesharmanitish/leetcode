class Solution {
    int[] root;
    int[] rank;
    public int find(int n) {
        while(root[n]!=n){
            root[n] = root[root[n]];
            n = root[n];
        }
        return n;
    }
    public int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY)
            return 0;
        if(rank[rootX] > rank[rootY]){
            root[rootY] = rootX;
        }else{
            root[rootX] = rootY;
            rank[rootX] = Math.max(rank[rootY], 1+rank[rootX]);
        }
        return 1;
    }    
    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            root[i] = i;
            rank[i] =1;
        }
        int count =n;
        for(int[] edge:edges){
            count -= union(edge[0], edge[1]);
        }
        // Set<Integer> set = new HashSet<>();
        
        // for(int i=0;i<root.length;i++){
        //     if(root[i] == i)
        //         count++;
        // }
        return count;
    }
}