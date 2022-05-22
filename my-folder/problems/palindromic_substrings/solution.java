class Solution {
    public int countSubstrings(String s) {
        char[] carr = s.toCharArray();
        int count = 0;
        dp = new boolean[carr.length][carr.length];
        for(int i=0;i<carr.length;i++){
            for(int j=i;j<carr.length;j++){
                count += isPalindrome(carr, i, j)?1:0;
                
            }
            
        }
        return count;
    }
    boolean[][] dp;
    public boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if(dp[start][end])
                return true;
            else if (arr[start++] != arr[end--]) 
                return false;
        }
        dp[start][end] = true;
        return true;
    }
}