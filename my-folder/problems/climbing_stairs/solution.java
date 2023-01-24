class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2)
            return n;
            
        int prev = 1, cur =2;
        int x = 0;
        for(int i=3;i<=n;i++){
            x = cur + prev;
            prev = cur;
            cur = x;
        }

        return cur;
    }
}

// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         dp[1] =1; dp[0]=1;
//         for(int i=2;i<=n;i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }