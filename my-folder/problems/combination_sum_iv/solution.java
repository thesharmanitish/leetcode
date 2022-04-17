class Solution {
    public int combinationSum4(int[] nums, int b) {
		int n = nums.length;        
		int[] dp = new int[b + 1]; 
        dp[0] = 1;       
		
        for(int j=1;j<=b;j++){
            for (int i=1;i<=n;i++) {
                if( nums[i-1]<=j)
                    dp[j] += dp[j-nums[i-1]];
            }
		}
        return dp[b];
    }
}