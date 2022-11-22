class Solution {
    public int numSquares(int n) {
        
        int x = (int) Math.sqrt(n)+1;
        int[] dp = new int[n+1];

        int[] arr = new int[x+1];

        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int i=1;i<=x;i++){
            arr[i] = i*i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<=x;j++){
                if(i<arr[j])
                    break;
                dp[i] = Math.min(dp[i], 1+dp[i-arr[j]]);
            }
        }

        return dp[n];
    }
}