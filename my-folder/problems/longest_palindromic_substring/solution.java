 class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1)
            return s;
        char[] arr = s.toCharArray();
        
        int n = arr.length-1, max = 0;
        
        boolean[][] dp = new boolean[arr.length][arr.length];
        StringBuilder result = new StringBuilder();
        
        for(int i=n;i>=0;i--){
            dp[i][i] = true;
            for(int j=i;j<arr.length;j++){
                if(arr[i] != arr[j])
                    continue;
                if(j-i>2 && !dp[i+1][j-1])
                    continue;
                dp[i][j] = true;
                if(j-i+1 > max){
                    max = j-i+1;
                    result = new StringBuilder(s.substring(i,j+1));
                }
                
            }
            
        }
        return result.toString();
    }
}