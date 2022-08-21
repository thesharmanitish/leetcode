class Solution {
    
    // dp[i][j]: pick j stops to refill from [0, i] stops, how far away can we go
    // dp[i][j] = max {dp[i-1][j] >= stations[i-1][0] ? dp[i-1][j] : 0
    //          =      dp[i-1][j-1] >= stations[i-1][0] ? dp[i-1][j-1] + stations[i-1][1] : 0 }
    // 
    
    
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int[][] dp = new int[stations.length+1][stations.length+1];
        
        for(int i=0;i<=stations.length;i++){
            dp[i][0] = startFuel;
        }
        
        for(int i=1;i<=stations.length;i++){
            for(int j=1;j<=i;j++){
                if(dp[i-1][j]>= stations[i-1][0])
                    dp[i][j] =  dp[i-1][j];
                if(dp[i-1][j-1]>= stations[i-1][0])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+stations[i-1][1]);
                 
            }
        }
        for (int t = 0; t <= stations.length; ++t)
            if (dp[stations.length][t] >= target) return t;

        return -1;

    }
}