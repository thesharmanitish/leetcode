class Solution {
    public int coinChange(int[] coins, int amount) {
        
        
        int[] dp = new int[amount+1];
        
        
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE-1;
            
        }
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[j] = Math.min(1+dp[j-coins[i-1]], dp[j]);
                }else
                    dp[j] = dp[j];
            }
        }
        return dp[amount] >= Integer.MAX_VALUE-1? -1:dp[amount];
        
    }
}