class Solution {
    public String removeDuplicates(String s) {
        if(s.length()<2)
            return s;
        
        int start = 0, end =1, n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while(end < sb.length()){
            if(sb.charAt(start) == sb.charAt(end))    {
                sb.deleteCharAt(end);
                sb.deleteCharAt(start);
                if(start>0){
                    start--;
                    end--;
                    }
            }else{
                end++;
                start++;
            }
        }
        return sb.toString();
    }
}