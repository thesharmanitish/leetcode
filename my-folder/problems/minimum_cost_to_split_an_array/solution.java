class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++){
            int[] arr = new int[n];
            int c = 0;
            for (int j = i; j < n; j++){
                if (arr[nums[j]] == 0){}
                else if ((arr[nums[j]]) == 1) c += 2;
                else c++;
                arr[nums[j]]++;
                dp[i][j] = c;
                }
        }
            
        long[] dp2 = new long[n+1];
        Arrays.fill(dp2, Long.MAX_VALUE);
        dp2[0] = 0;
        dp2[1] = dp[0][0]+k;

        for (int i = 2; i <= n; i++)
        {
            dp2[i] = dp[0][i - 1] + (long)k;
            for (int j = i - 1; j >= 1; j--)
            {
                dp2[i] = Math.min(dp2[i], dp2[j] + dp[j][i - 1] + (long)k);
            }
        }            
        return (int)dp2[n];
    }
}