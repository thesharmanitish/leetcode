class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n<=1)
            return "";
        int mid = n/2;
        char[] arr = palindrome.toCharArray();
        for(int i=0;i<mid;i++){
            if(arr[i]!='a'){
                arr[i] = 'a';
                return String.copyValueOf(arr);
            }
        }
        arr[n - 1] = 'b';
        return String.copyValueOf(arr);
            
    }
}