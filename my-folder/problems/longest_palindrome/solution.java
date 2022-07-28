class Solution {
    public int longestPalindrome(String s) {
        if(s.length() <=1)
            return s.length();
        int[] freq =   new int[128];
        for(char c:s.toCharArray()){
            freq[c] +=1;
        }
        int count = 0;
        for(int f:freq){
            count+=(f/2)*2;
        }
        return s.length()==count?count:count+1;
    }
}