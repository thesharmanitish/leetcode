class Solution {
    public int removePalindromeSub(String s) {
       if(isPalindrome(s.toCharArray()))
             return 1;
	    return 2;  
    }
    
    
    public boolean isPalindrome(char[] arr) {
        if(arr.length ==1)
            return true;
        for(int i=0;i<arr.length/2;i++){
            if(arr[i]!=arr[arr.length-i-1]){
                return false;
            }
        }
        return true;
    }
        
}