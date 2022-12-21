class UnionFind{
    int[] root;
    int[] rank;
    public UnionFind(int n){
        root = new int[n];
        rank = new int[n];

        for(int i=1;i<n;i++)
            root[i] = i;   
    } 
    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    public void union(int x, int y){
        int rootX = find(root[x]);
        int rootY = find(root[y]);

        if(rootX !=rootY){
            if(rank[x] > rank[y]){
                root[y] = rootX;
            }else if(rank[y] > rank[x]){
                root[x] = rootY;
            }else{
                root[y] = rootX;
                rank[rootX] +=1;
            }
        }
            
    }    
}

class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        UnionFind dsu = new UnionFind(n + 1);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        for(int i=0;i<=n;i++){
            if(!adj.containsKey(i))
                continue;
            for(int neighbour:adj.get(i)){
                if(dsu.find(i) == dsu.find(neighbour))
                    return false;
                dsu.union(adj.get(i).get(0), neighbour);
            }
        }
        return true;
    }
}