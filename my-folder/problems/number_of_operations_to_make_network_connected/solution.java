class DSU{
    int[] root;
    int[] rank;

    public DSU(int n){
        root = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            root[i] = i;
        }
    }

    public void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if(roota!=rootb){
            if(rank[roota]> rank[rootb]){
                root[rootb] = roota;
            }else if(rank[roota] < rank[rootb]){
                root[roota] = rootb;
            }else{
                root[rootb] = roota;
                rank[roota]++;
            }
        }
    }
    public int find(int x) {
        if (root[x] != x)
            root[x] = find(root[x]);
        return root[x];
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        
        DSU dsu = new DSU(n);
        int numberOfConnectedComponents = n;
        for(int[] connection:connections){
            if (dsu.find(connection[0]) != dsu.find(connection[1])) {
                numberOfConnectedComponents--;            
                dsu.union(connection[0], connection[1]);
            }
        }
        return numberOfConnectedComponents-1;
    }
}