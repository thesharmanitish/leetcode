class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        int i=0;
        long rem = 0;
        for(char c: word.toCharArray()){
            rem = (rem*10 + (c-'0'))%m;      
            res[i++] = rem==0? 1:0;
        }
        return res;
    }
}