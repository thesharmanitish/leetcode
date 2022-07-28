class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.length()<=1)
            return true;
        int[] arr = new int[26];
        
        for(char c:s.toCharArray())
            arr[c-'a'] +=1;
        
        int count =0;
        for(int i=0;i<26;i++){
            if(count>1)
                return false;
            if(arr[i]%2 ==1)
                count++;
        }
        return count<=1;
    }
}