class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n]; 
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) 
            G[i] = new ArrayList<Integer>(); //
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);           // link in to out
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) 
            if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        int[] arr = new int[n];
         for (int i = 0; i<bfs.size(); i++)
            arr[i] = bfs.get(i);
        if(bfs.size() ==n)
            return arr;
        return new int[0];
    }
}