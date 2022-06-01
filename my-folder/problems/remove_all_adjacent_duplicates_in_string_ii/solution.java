class Solution {
    public String removeDuplicates(String s, int k) {
        if(s.length()<k || k<2)
            return s;
        StringBuilder sb = new StringBuilder(s);
        int count[] = new int[sb.length()];
        count[0] = 1;
        for(int i=0;i<sb.length();i++){
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                 count[i] = 1;
             }
            else{
                count[i] = count[i-1]+1;
                if(count[i]==k){
                    sb.delete(i-k+1, i+1);
                    i = i-k;    
                }
            }
            
        }
        return sb.toString();
    }
}