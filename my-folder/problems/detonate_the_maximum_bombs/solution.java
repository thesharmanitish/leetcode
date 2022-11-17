class Solution {
    int count = 0; // global variable, otherwise use an array
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            count = 0; // Start a new search, reset count
            dfs(i, new boolean[n], bombs);
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public void dfs(int i, boolean[] visited, int[][] bombs) {
        
        count++;
        visited[i] = true;
        for(int j=0;j<bombs.length;j++){
            if(visited[j] || !inRange(bombs[i], bombs[j]))
                continue;
            visited[j] = true;
            dfs(j, visited, bombs);
        }
        

    }
    public boolean inRange(int[] bomb1, int[] bomb2) {
        long dx = bomb1[0] -bomb2[0];
        long dy = bomb1[1] -bomb2[1];
        long c = (long)bomb1[2]*bomb1[2];
        return dx * dx + dy * dy <= c;
    }
}