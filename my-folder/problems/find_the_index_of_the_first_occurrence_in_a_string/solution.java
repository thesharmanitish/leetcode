class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() ==0 || needle.length() == 0)
            return -1;
        int size = needle.length(), hash= 0, start=0, end = haystack.length();
        for(char ch:needle.toCharArray())
            hash+=ch;
        
        if(end<size)
            return -1;
        int temp = 0, i=0;
        for(i=0;i<size-1;i++)
            temp += haystack.charAt(i);
        while(i<end){
            temp+=haystack.charAt(i);
            if(temp==hash){
                String st = haystack.substring(i-size+1,i+1);
                if(st.equals(needle))
                    return i-size+1;
            }
            temp -= haystack.charAt(i-size+1);
            i++;
        }
        return -1;
    }
}