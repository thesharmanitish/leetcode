class Solution {
    public int jump(int[] nums) {
        if(nums.length <2)
            return 0;
        else if (nums.length ==2)
            return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[nums.length-1] = 0;
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] >=j-i)
                    dp[i] = Math.min(dp[i], dp[j]+1);
            }
            min = Math.min(min, dp[i]);
        }
        return dp[0];
    }
}