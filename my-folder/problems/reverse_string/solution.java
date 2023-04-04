class Solution {
    public void reverseString(char[] s) {
        int start =0, end = s.length-1;
        while(start<end){
            swap(s, start++, end--);
        }
    }
    public void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
        // s[i] = s[i]^s[j];
        // s[j] = s[i]^s[j];
        // s[i] = s[i]^s[j];
    }
}