class Solution {
    public boolean PredictTheWinner(int[] nums) {
        dp = new Integer[nums.length+1][nums.length+1];
        return getMaxScore(nums,0,nums.length-1) >= 0;
    }
    Integer[][] dp;
    private int getMaxScore(int[] nums, int s, int e){
        if (s == e)
            return dp[s][e] = nums[s];
        if(dp[s][e] !=null)
            return dp[s][e];
        dp[s+1][e] = getMaxScore(nums,s+1,e);
        int first = nums[s] - dp[s+1][e];
        dp[s][e-1] = getMaxScore(nums,s,e-1);
        int last = nums[e] - dp[s][e-1];
        
        return dp[s][e] = Math.max(first,last);
    }
}