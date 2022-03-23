class Solution {
    public String longestPalindrome(String s) {
        String res ="";
        StringBuilder sb = new StringBuilder(s.length());
        if(s.length()==0)
            return s;
        
        for(int i=s.length()-1;i>=0;i--)
            sb.append(s.charAt(i));
        if(s.equals(sb.toString()))
            return s;
        int n = s.length();
        boolean[][] dp  = new boolean[n][n];
       for(int i=n-1;i>=0;i--){
           for(int j=i;j<n;j++){
               if(s.charAt(i) == s.charAt(j) && ((j<i+3) || dp[i+1][j-1])){
                   dp[i][j] =  true;
                   if(res.length()<j-i+1 || res == null)
                     res = s.substring(i, j + 1);
               }
               
             
               
           }
           
       }
        //s.substring(right-max-1));
    
       return res; 
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i<=j && i<s.length() && j< s.length())
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}