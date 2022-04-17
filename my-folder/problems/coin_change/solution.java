class Solution {
    public int coinChange(int[] nums, int b) {
		int n = nums.length;        
		int[][] dp = new int[n+1][b + 1]; 
		for (int i = 1; i <= b; i++) 
			dp[0][i] = Integer.MAX_VALUE - 1;
		    
		for (int i=1;i<=n;i++) {
            for(int j=1;j<=b;j++){
                if( nums[i-1]<=j){
                    dp[i][j] = Math.min(1 + dp[i][j - nums[i - 1]], dp[i - 1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
		}
        return dp[n][b] >= Integer.MAX_VALUE-1?-1:dp[n][b];
	
            
        
    }
}