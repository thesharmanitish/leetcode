class Solution {
    public int firstUniqChar(String s) {
        int[] carr = new int[26];
        char[] d = s.toCharArray();
        for(char c:d)    {
            carr[c-'a'] += 1;
        }
        
        int i=0;
        for(char c:d){
            if(carr[c-'a'] ==1)
                return i;
            i++;
        }
        return -1;
    }
}