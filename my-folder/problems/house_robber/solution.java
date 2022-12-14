class Solution {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }else if(nums. length <3)
            return Math.max(nums[0], nums[1]);
            
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        dp[2] = nums[1];

        for(int i=3;i<dp.length;i++){
            dp[i] = Math.max(dp[i-3], dp[i-2])+nums[i-1];
        }
        return Math.max(dp[nums.length], dp[nums.length-1]);
    }
}