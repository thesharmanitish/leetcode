class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length+2];
        int n = prices.length;
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++)
                dp[i] = Math.max(prices[j]-prices[i]+dp[j+2],dp[i]);

            dp[i] = Math.max(dp[i], dp[i+1]);
            
        }
        return dp[0];
    }
}