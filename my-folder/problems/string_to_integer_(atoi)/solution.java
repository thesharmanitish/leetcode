class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() ==0)
            return 0;
        if(s.length()==1)
            return Character.isDigit(s.charAt(0))?s.charAt(0)-'0':0;
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        char sign = ' ';
        int i=0;
        while(i<s.length() && Character.isSpace(s.charAt(i)))
            i++;
        if(i<s.length() && (s.charAt(i) =='-' || s.charAt(i) =='+' )){
            sign = s.charAt(i);
            i++;
        }
        if(!Character.isDigit(s.charAt(i)))
            return 0;
        if(sign=='-')
            result.append('-');
        while(i<s.length() && s.charAt(i) == '0')
            i++;

        if(i<s.length() && !Character.isDigit(s.charAt(i)))
            return 0;            
        while(i<s.length() && Character.isDigit(s.charAt(i)))
            result.append(s.charAt(i++));
        if(result.length()<1)
            return 0;
 
        else if(result.length()>11) 
            if( sign == '-')
                return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        else if(Long.parseLong(result.toString())<= Integer.MIN_VALUE )
            return Integer.MIN_VALUE; 
        else if(Long.parseLong(result.toString())>= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else return Integer.parseInt(result.toString());    

    }
}