class Solution {
    int[] lps;
    public int strStr(String haystack, String needle) {
        
        int m = haystack.length(), n = needle.length();

        if(n>m)
            return -1;
        
        if(m == n)
            return haystack.equals(needle)?0:-1;
        
        int i = 0, j = 0;
        lps = new int[n];
        
        lps(needle.toCharArray());

        while((m-i)>=(n-j)){   // if chars left in haystack are less than needle, no need to check, return -1
            while(i<m && j<n && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == n)
                return i-j;
            

            else if(i<m && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }else
                    i += 1;
            }
        }
        return -1;

    }
    public void lps(char[] needle){
        
        int j = 0, i = 1;
        
        while(i<needle.length){
            if(needle[i] == needle[j]){
                lps[i] = ++j;
                i++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
}

// class Solution {
//     public int strStr(String haystack, String needle) {
//         int hash = 0, j= 0, cHash = 0;
//         if(needle.length()>haystack.length())
//             return -1;
//         if(needle.length() == haystack.length())
//             return needle.equals(haystack)? 0 : -1;

//         for(j=0;j<needle.length()-1;j++){
//             hash += (needle.charAt(j)-'a');
//             cHash += (haystack.charAt(j) -'a');
//         }
//         hash += (needle.charAt(j)-'a');
//         int i=0;
//         for(;j<haystack.length();j++){
//             cHash += (haystack.charAt(j)-'a');
//             if(cHash == hash && haystack.substring(i,j+1).equals(needle)){
//                 return i;
//             }else{
//                 cHash -= (haystack.charAt(i++)-'a');
                
//             }
//         }
//         return -1;
//     }
// }