class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2))
            return 0;
        dp = new Integer[word1.length()+1][word2.length()+1];
   
        return minDistance(word1, word2, 0, 0);
    }
    Integer[][] dp;
    public int minDistance(String word1, String word2, int a, int b) {
        if(a==word1.length() && b== word2.length())
            return 0;
        else if(word1.length() == a)
            return word2.length()-b;
        else if(word2.length() == b)
            return word1.length()-a;
        
        if(dp[a][b] != null)
            return dp[a][b];

        if(word1.charAt(a) == word2.charAt(b))
            return dp[a][b] = minDistance(word1, word2, a+1, b+1);
        else
            return dp[a][b] = 1+ Math.min(Math.min(minDistance(word1, word2, a+1, b),minDistance(word1, word2, a, b+1)), minDistance(word1, word2, a+1, b+1));
        
    }    
}