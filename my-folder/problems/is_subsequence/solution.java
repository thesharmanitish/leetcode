class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        int j=0;
        if(s.length() ==0)
            return true;
        for(j=1;j<=t.length();j++){
            for(int i=1;i<=s.length();i++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            if(s.length() == dp[s.length()][j])
                return true;
        }
        return false;
    }
}