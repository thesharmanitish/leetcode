class Solution {
    public int findTargetSumWays(int[] nums, int target) {


		int sum = Arrays.stream(nums).sum();
        if(((sum - target) % 2 == 1) || sum<target)
            return 0;
        int b = (sum -target )/2;
		int n = nums.length;
		int[][] dp = new int[n+1][b + 1];
        
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
		for (int i=1;i<=n;i++) {
            for(int j=0;j<=b;j++){
                if( nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
                else 
                    dp[i][j] = dp[i-1][j];
            }
		}

		return dp[n][b];
	        
    }
}