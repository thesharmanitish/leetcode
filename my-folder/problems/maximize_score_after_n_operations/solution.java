class Solution {
    public int gcd(int x, int y){
        return y == 0 ? x :gcd(y,x%y);
    }

    public int dfs(int[] nums, int[][] dp, int mask, int ind) {
        if (ind > nums.length / 2)
            return 0;
        if(dp[ind][mask] == 0){
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    int new_mask = (1<<i) + (1<<j);
                    
                    if((new_mask & mask)==0){
                        dp[ind][mask] = Math.max(dp[ind][mask],  dfs(nums, dp, mask+new_mask, ind+1)+ind*gcd(nums[i], nums[j]));
                        
                        
                        
                    }
                    
                    
                }
            }
        }
    return dp[ind][mask];
    }
    public int maxScore(int[] nums) {
        int[][] dp = new int[nums.length/2+1][1<<nums.length];
        return dfs(nums, dp, 0, 1);
     
        
    }
}