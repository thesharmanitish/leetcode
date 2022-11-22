class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
            rev.append(s.charAt(i));
        return lcs(s, rev.toString());
    }
    public int lcs(String s, String r) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            Arrays.fill(dp[i],1);
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;
        int max = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1) == r.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j],1+dp[i-1][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}