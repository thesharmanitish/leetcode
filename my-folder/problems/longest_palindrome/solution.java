class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c:s.toCharArray()){
            freq[c] +=1;
        }
        boolean isSingle = false;
        int count = 0;
        for(int i=0;i<128;i++){
            if(!isSingle && freq[i]%2==1)
                isSingle = true;
            if(freq[i]>1)
                count+=(freq[i]/2);
        }
        return isSingle?(count*2)+1:(count*2);
    }
}