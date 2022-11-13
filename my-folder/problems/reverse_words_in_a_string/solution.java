class Solution {
    public String reverseWords(String str) {
        
        StringBuilder s = new StringBuilder(str);
        int i=0;
        while(s.charAt(i) ==' ')
            s.deleteCharAt(i++);
        i = s.length()-1;    
        while(s.charAt(i) ==' ')
            s.deleteCharAt(i--);    
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(i=0;i<s.length();i++){
            
            char c = s.charAt(i);
            sb.append(c);
            if(c ==' '){
                result.insert(0, sb);
                sb.setLength(0);
                while(i+1<s.length() && s.charAt(i+1)==' ')
                    i++;

            }
        }
        if(sb.length()>0){
            sb.append(" ");
            result.insert(0, sb);
        }
        i = result.length()-1;    
        while(result.charAt(i) ==' ')
            result.deleteCharAt(i--);   
        return result.toString();

    }
}