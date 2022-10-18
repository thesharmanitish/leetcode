class Solution {
    public String count(String n) {
        char[] s = n.toCharArray();
        StringBuilder res = new StringBuilder();
        int count =1;
        for(int i=1;i<s.length;i++){
            if(s[i] == s[i-1])
                count++;
            else{
                res.append(count).append(s[i-1]);
                count = 1;
            }
        }
        res.append(count).append(s[s.length-1]);
        return res.toString();
    }
    public String countAndSay(int n) {
        String[] dp = new String[n+1]  ;
        dp[1] = ""+1;
        for(int i=2;i<=n;i++){
            dp[i] = count(dp[i-1]);
        }
        return dp[n];
    }
}