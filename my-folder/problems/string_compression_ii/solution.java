class Solution {
    char[] arr;
    int n;
    int[][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        arr = s.toCharArray();
        n = s.length();
        dp = new int[n][k+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], -1);
        return solve(0,k);
    }
    public int solve(int i, int k) {
        if(k<0)
            return n;
        if(i+k>=n)
            return 0;
        if(dp[i][k]!=-1)
            return dp[i][k];
        dp[i][k] = solve(i+1, k-1);
        int same=0, diff = 0, length =0;
        for(int j=i;j<n;j++){
            if(arr[i] == arr[j]){
                same++;
                if(same <=2 || same ==10 || same ==100)
                    length++;
            }
            else
                diff++;
        
            dp[i][k] = Math.min(dp[i][k], length+solve(j+1, k-diff));
        }
        return dp[i][k];
        
    }
    
}