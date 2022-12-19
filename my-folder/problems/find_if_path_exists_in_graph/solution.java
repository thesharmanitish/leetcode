class Solution {
	int[] root;
	int[] rank;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
		if(source == destination)
			return true;
        root = new int[n];
		rank = new int[n];
		for(int i=0;i<n;i++){
			root[i] = i;
		}

		for(int[] edge:edges){
			if(edge[0] == edge[1])
				continue;
			union(edge[0], edge[1]);
			// if(find(source) == find(destination))
			// 	return true;
		}
		return find(source) == find(destination);
    }

	public int find(int x){
		if(root[x] == x)
			return x;
		return root[x] = find(root[x]);
	}
	public void union(int x, int y){
		int rootX = find(root[x]);
		int rootY = find(root[y]);
		
		if(rootX!=rootY){
			if(rank[rootX]>rank[rootY]){
				root[rootY] = rootX;
			}else if(rank[rootX]<rank[rootY]){
				root[rootX] = rootY;
			}else{
				root[rootX] = rootY;
				rank[rootY] +=1;
			}
		}
	}
}


// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
// 		boolean[] visited = new boolean[n];
// 		HashSet<Integer>[] graph = new HashSet[n];

// 		for (int i = 0; i < n; i++) {
// 			graph[i] = new HashSet<Integer>();
// 		}
// 		for (int[] edge : edges) {
// 			graph[edge[0]].add(edge[1]);
// 			graph[edge[1]].add(edge[0]);
// 		}

// 		if (graph[source].contains(destination)) { // direct connection exists
// 			return true;
// 		}
// 		Queue<Integer> queue = new LinkedList<Integer>();
// 		queue.offer(source);
// 		visited[source] = true;

// 		while (!queue.isEmpty()) {
// 			int N = queue.size();
// 			for (int i = 0; i < N; i++) {
// 				int current = queue.poll();
// 				if (current == destination) {
// 					return true;
// 				}
// 				for (Integer h : graph[current]) {
// 					if(!visited[h]) {
// 						queue.offer(h);
// 						visited[h] = true;
// 					}
// 				}
// 			}
// 		}
// 		return false;
	
//     }
// }