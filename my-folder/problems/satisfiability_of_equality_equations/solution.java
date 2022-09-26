class Solution {
    public boolean equationsPossible(String[] equations) {
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            graph[i] = new ArrayList();

        for (String eqn : equations) {
            if (eqn.charAt(1) == '=') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }

        int[] color = new int[26];
        Arrays.fill(color, -1);

        for (int i = 0; i < 26; i++) {
            if (color[i] == -1) {
                dfs(i, i, color, graph);
            }
        }

        for (String eqn : equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (color[x] == color[y])
                    return false;
            }
        }

        return true;
    }

    // mark the color of `node` as `c`
    private static void dfs(int node, int c, int[] color, List<Integer>[] graph) {
        if (color[node] == -1) {
            color[node] = c;
            for (int nei : graph[node])
                dfs(nei, c, color, graph);
        }
    }
}

// class Solution {
//     public boolean equationsPossible(String[] equations) {
//         int root[] = new int[26];
//         for (int i = 0; i < 26; i++) {
//             root[i] = i;
//         }

//         for (String eqn : equations) {
//             if (eqn.charAt(1) == '=') {
//                 int x = eqn.charAt(0) - 'a';
//                 int y = eqn.charAt(3) - 'a';
//                 union(root, x, y);
//             }
//         }

//         for (String eqn : equations) {
//             if (eqn.charAt(1) == '!') {
//                 int x = eqn.charAt(0) - 'a';
//                 int y = eqn.charAt(3) - 'a';
//                 if (find(root, x) == find(root, y))
//                     return false;
//             }
//         }

//         return true;
//     }

//     private static int find(int[] root, int x) {
//         if (root[x] != x)
//             root[x] = find(root, root[x]);
//         return root[x];
//     }

//     private static void union(int[] root, int x, int y) {
//         x = find(root, x);
//         y = find(root, y);
//         if (x != y)
//             root[x] = y;
//     }
// }
// class Solution {
//     public boolean equationsPossible(String[] equations) {
//         List<Integer>[] graph = new ArrayList[26];
//         boolean[] visited = new boolean[26];
//         for (int i = 0; i < 26; ++i)
//             graph[i] = new ArrayList();
        
//         for(String eq:equations){
//             if(eq.charAt(1)=='='){
//                 int x = eq.charAt(0)-'a';
//                 int y = eq.charAt(3)-'a';
//                 graph[x].add(y);
//                 graph[y].add(x);
//             }
//         }
//         for(String eq:equations){
//             if(eq.charAt(1)=='!'){
//                 if(eq.charAt(0)-'a' == eq.charAt(3)-'a' || dfs(eq.charAt(0)-'a',eq.charAt(3)-'a', graph, visited))
//                     return false;
//             }
//         }
//         return true;
//     }
//     public boolean dfs(int src, int target, List<Integer>[] graph, boolean[] visited) {
//         if(visited[src])
//                 return false;
//         visited[src] = true;
//         for(Integer l: graph[src]){
//             if(l == target)
//                 return true;
            
            
//             if(dfs(l, target, graph, visited))
//                 return true;
            
//         }
//         visited[src] = false;
//         return false;
//     }
// }