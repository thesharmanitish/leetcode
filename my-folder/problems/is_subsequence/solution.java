class Solution {
    public boolean isSubsequence(String s, String t) {
        // int i=0;
        // if(s.length() ==0)
        //     return true;
        // for(char c:t.toCharArray()){
        //     if(c == s.charAt(i))
        //         i++;
        //     if(i == s.length())
        //         return true;
        // }
        // return i == s.length();
            
        int[][] dp = new int[s.length()+1][t.length()+1];
        int j=0;
        if(s.length() ==0)
            return true;
        for(int i=1;i<=s.length();i++){
            for(j=1;j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }

        }
        return dp[s.length()][t.length()] == s.length();
    }
}