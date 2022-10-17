class Solution {
    static int[][] dp;
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if(d>n)
            return -1;
        dp = new int[jobDifficulty.length+1][d+1];
        
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        return solve(jobDifficulty, 0,d);
    }
    public int solve(int[] jobDifficulty, int i, int d) {

        if(dp[i][d]!=Integer.MAX_VALUE)
            return dp[i][d];
        int max = 0;
        if(d ==1){
            
            for(int j=i;j<n;j++)
                max = Math.max(max, jobDifficulty[j]);
            return dp[i][d]= max;
        }
        int res =Integer.MAX_VALUE;
        for(int j=i;j<n-d+1;j++){
            max = Math.max(max, jobDifficulty[j]);
            dp[i][d] = Math.min(dp[i][d], max+solve(jobDifficulty, j+1, d-1));
            
        }
        return dp[i][d];
    }
}