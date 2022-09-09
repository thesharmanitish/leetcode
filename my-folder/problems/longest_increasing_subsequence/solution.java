class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp, 1);
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=i;j++){
                if(nums[i-1]>nums[j-1])
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
            }
        }
        int max = 0;
        for(int i=0;i<dp.length;i++)
            max = Math.max(max, dp[i]);
        
        return max;
    }
}