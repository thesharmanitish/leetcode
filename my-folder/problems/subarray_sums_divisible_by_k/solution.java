class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         if(nums.length ==1){
//             return nums[0]%k==0?1:0;
//         }
//         int[] dp = new int[nums.length];
//         int count = 0;
        
//         for(int i=1;i<=nums.length;i++){
//             dp[i-1] = nums[i-1];
//              if(dp[i-1]%k ==0){
//                     count++;
//                 }
//             for(int j=i;j<nums.length;j++){
//                 dp[j] = dp[j-1]+nums[j];
//                 if(dp[j]%k ==0){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
    
    
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] dp = new int[k];
        int sum = 0;
        for(int n:nums){
            sum += ((n%k)+k)%k;
            dp[sum%k]++;
        }
        int count = dp[0];
        for(int d:dp){
            count += (d * (d-1))/2;
        }
        return count;
    }
}