class Solution {
    private int longestPath = 1;

    public int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        // If the node is the only child, return 1 for the currentNode itself.
        if (!children.containsKey(currentNode)) {
            return 1;
        }
        if(!children.containsKey(currentNode))
            return 1;
        int longestChain = 0, secondLongestChain = 0;
        for(int child:children.get(currentNode)){
            int t = dfs(child, children, s);
            if(s.charAt(child) == s.charAt(currentNode))
                continue;
            if(t>longestChain){
                secondLongestChain = longestChain;
                longestChain = t;
            }else if(t>secondLongestChain){
                secondLongestChain = t;
            }
            
        }


        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();
        // Start from node 1, since root node 0 does not have a parent.
        for (int i = 1; i < n; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<Integer>()).add(i);
        }

        dfs(0, children, s);

        return longestPath;
    }
}