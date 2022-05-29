class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s== null || s.length() ==0)
            return 0;
        int i=0;
        Boolean neg =null;
        for(char ch:s.toCharArray()){
            i++;
            if(ch=='-')  {
                if(neg !=null)
                    return 0;
                neg = true;
            }
            else if(ch=='+'){
                if(neg !=null)
                    return 0;
                neg = false;
            }
            else if(ch>='0' && ch<='9')
                break;
            else if(ch ==' '){
                if(neg!=null)
                    return 0;
                continue;
            }
            else if(ch=='0')
                continue;
            else 
                return 0;
            
        }
        long  sum=0;
        if(neg ==null)
            neg = false;        
        for(int j=i-1;j<s.length();j++){
            if(s.charAt(j) >='0' && s.charAt(j)<='9'){
                int diff = s.charAt(j)-'0';
                sum = sum*10+diff;
                
                if(sum>Integer.MAX_VALUE)
                    return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            else break;
        }
        
        return neg?(int)-sum:(int)sum;
    }
}