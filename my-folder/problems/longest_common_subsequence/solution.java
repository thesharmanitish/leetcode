class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() ==1 )
            return text2.indexOf(text1) >=0 ?1:0;
        if(text2.length() ==1)
            return text1.indexOf(text2.charAt(0)) >= 0?1:0;
        dp = new int[text1.length()+1][text2.length()+1];
        return longestCommonSubsequence(text1, text2, 0, 0);
        
    }
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if(i>=text1.length() || j>= text2.length())
            return 0;
        if(dp[i][j]!=0)
            return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1+ longestCommonSubsequence(text1, text2, i+1, j+1);
        else
            return dp[i][j] = Math.max(longestCommonSubsequence(text1, text2, i+1, j), longestCommonSubsequence(text1, text2, i, j+1));
    }
}