class Solution {
    public boolean isPalindrome(String s) {
        //    String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // String rev = new StringBuffer(actual).reverse().toString();
        // return actual.equals(rev);
        
               char[] charMap = new char[256];
        for (int i = 0; i < 10; i++)
            charMap['0'+i] = (char) (1+i);  // numeric - don't use 0 as it's reserved for illegal chars
        for (int i = 0; i < 26; i++)
            charMap['a'+i] = charMap['A'+i] = (char) (11+i);  //alphabetic, ignore cases, continue from 11
        
        for (int start = 0, end = s.length()-1; start < end;) {
            while (start <s.length() && charMap[s.charAt(start)] == 0)
                start++;
            if(start>end) 
                return true;
            while (charMap[s.charAt(end)] == 0)
                end--;
            if (charMap[s.charAt(start++)] != charMap[s.charAt(end--)])
                return false;
        }
        return true;
    // } 
    //     s =s.toLowerCase();
    //     // s=s.replaceAll("[^a-zA-Z0-9]","");
    //      int i=0, m=s.length()-1;
    //     System.out.print(s);
    //     while(i<m){
    //        while(i<s.length()  &&(s.charAt(i)<48 || (s.charAt(i)>57 && s.charAt(i)<97) || s.charAt(i)>122) )
    //            i++;
    //         if(i>m)
    //             return true;
    //         while(s.charAt(m)<48 || (s.charAt(m)>57 && s.charAt(m)<97) || s.charAt(m)>122) 
    //            m--;
    //         if(s.charAt(i) != s.charAt(m))
    //             return false;
    //         i++;
    //         m--;
    //     }
    //     return true;
    }
}