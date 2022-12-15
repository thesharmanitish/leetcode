class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if(m<n)
            longestCommonSubsequence(text2, text1);

        if(text2.length() ==1 )
            return text1.indexOf(text2) >=0 ?1:0;        
        dp = new int[m+1][n+1];
        return longestCommonSubsequenceRec(text1.toCharArray(), text2.toCharArray(), 0, 0);

    }
    public int longestCommonSubsequenceRec(char[] text1, char[] text2, int i, int j){
        if(i>= text1.length || j>= text2.length)
            return 0;
        if(dp[i][j]>0)
            return dp[i][j];
        if(text1[i] == text2[j])
            return dp[i][j] = 1+longestCommonSubsequenceRec(text1, text2, i+1, j+1);

        return dp[i][j] = Math.max(longestCommonSubsequenceRec(text1, text2, i+1, j),longestCommonSubsequenceRec(text1, text2, i, j+1));
    }
}