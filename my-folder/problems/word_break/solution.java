public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1][s.length()+1];
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }
    Boolean[][] dp;
    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length() ) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if(dp[start][end] !=null){
                if(!dp[start][end])
                    continue;
                else return true;
            }
            else if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) 
            {
                return dp[start][end] = true;
            }else
                dp[start][end] = false;
        }
        return false;
    }
}