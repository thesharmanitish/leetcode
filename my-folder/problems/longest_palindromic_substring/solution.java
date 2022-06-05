class Solution {
    public String longestPalindrome(String s) {
        String res ="";
        if(s.length()==0)
            return s;
        char[] arr= s.toCharArray();
        int n = s.length()-1, start= 0, end= 0;
        int i=n, j=0;
        for(i=n, j=0 ; i>j;i--,j++){
            if(arr[i] != arr[j]){
                break;
            }
        }
        if(j>=i)
            return s;        

       
       boolean[][] dp  = new boolean[n+1][n+1];
       for(i=n;i>=0;i--) {
           for(j=i;j<=n;j++){
               if(arr[i] == arr[j] && (j<i+2 || dp[i+1][j-1])){
                   dp[i][j] = true;
                   if(end-start < j-i || res == null){
                           start = i;
                           end = j;
                   }
               }
           }
       }
        
       return s.substring(start, end+1); 
    }
}