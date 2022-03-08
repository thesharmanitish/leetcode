class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        
           int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    dp[0] = true;
    
    for (int num : nums) {
        if(dp[sum])
           return true;
        for (int i = sum; i >= num; i--) {
            dp[i] = dp[i] || dp[i-num];
            if (i == num) 
                break;
            
        }
    }
    
    return dp[sum];
        
        
        
//         int sum = 0;
//         for(int a:nums)
//             sum+=a;
//         if(sum%2 !=0) return false;
        
//         sum = sum/2;
//         dp = new boolean[nums.length+1][sum+1];
//       return  subsetSum(nums,nums.length,sum);
        
    }
    
//     boolean subsetSum(int[] nums, int n, int sum){
        
//         // Arrays.fill(dp[0],false);
//         // dp[0][0] = true;
//         for(int i =0;i<=n;i++)
//             dp[i][0] = true;
//         for(int i =1;i<=sum;i++)
//             dp[0][i] = false;
//         for(int i=1;i<=n;i++){
//            for(int j=1;j<=sum;j++){
//                 dp[i][j]  =  dp[i-1][j]; 
//                 if(nums[i-1]<=j){
//                     dp[i][j]  = dp[i-1][j-nums[i-1]] || dp[i][j];
//                 }
                    
            
//             } 
            
//         }
            
//         return dp[n][sum];
//     }
}