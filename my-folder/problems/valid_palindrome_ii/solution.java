class Solution {
    public boolean validPalindrome(String s) {
        int i=0, n= s.length()-1;
        if(isPalindrome(s,i,n))
           return true; 
        
        while(i<n){
            if(s.charAt(i)!= s.charAt(n))
                return isPalindrome(s,i,n-1) || isPalindrome(s,i+1,n);
            i++;
            n--;
        }
        return true;
    }
    public boolean isPalindrome(String s,int i, int n) {
     while(i<n)   {
         if(s.charAt(i++)!= s.charAt(n--))
             return false;
     }
        return true;
    }
}