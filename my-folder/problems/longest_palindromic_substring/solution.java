 class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1)
            return s;
        char[] arr = s.toCharArray();
        
        int n = arr.length-1, max = -1;
        
        boolean[][] dp = new boolean[arr.length][arr.length];
        int start =0, end =0;
        for(int i=n;i>=0;i--){
            dp[i][i] = true;
            for(int j=i;j<=n;j++){
                if(arr[i]==arr[j]&& (j-i<3 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(max<j-i+1){
                        max = j-i+1;
                        start =i;
                        end =j;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}