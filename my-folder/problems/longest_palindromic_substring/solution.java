 class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1)
            return s;
        char[] arr = s.toCharArray();
        
        int n = arr.length, max = -1;
        
        boolean[][] dp = new boolean[arr.length][arr.length];
        int start =0, end =0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]==arr[j]&& (i-j<3 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(max<i-j+1){
                        max = i-j+1;
                        start =j;
                        end =i;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}