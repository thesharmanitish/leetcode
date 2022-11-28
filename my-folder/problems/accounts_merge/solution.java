class Solution {
    int[] root;
    int[] rank;

	// The find function here is the same as that in the disjoint set with path compression.
    public int find(int x){
        while(root[x] != x){
            root[x] = root[root[x]];
            x = root[x];
        }
        return root[x];
    }

	// The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        root = new int[accounts.size()];
        rank = new int[accounts.size()];

        for(int i=0;i<root.length;i++){
            root[i] = i;
            rank[i] = 1;
        }
        Map<String, Integer> map = new HashMap<>();
        int i=0;
        for(List<String> account: accounts){
            for(int j=1;j<account.size();j++){
                String email = account.get(j);
                if(!map.containsKey(email))
                    map.put(email, i);
                else{
                    union(map.get(email), i);
                }
            }
            i++;
        }
        List<List<String>> result = new ArrayList<>();

        Map<Integer, List<String>> resultMap = new HashMap<>();
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            resultMap.computeIfAbsent(find(entry.getValue()), ArrayList::new).add(entry.getKey());
        }

        for(Map.Entry<Integer, List<String>> entry:resultMap.entrySet()){
            List<String> ll = new ArrayList<>();
            
            ll.addAll(entry.getValue());
            // ll.sort(Comparator.comparing(a -> a));
            Collections.sort(ll);
            ll.add(0, accounts.get(entry.getKey()).get(0));
            result.add(ll);
        }
        return result;

    }
}