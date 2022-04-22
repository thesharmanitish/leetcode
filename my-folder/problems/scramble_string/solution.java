class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        
        if(s1.equals(s2)) 
            return true;
        if(s1.length() != s2.length())
            return false;
        if(s1.length() <=1)
            return false;
        if(map.containsKey(s1+"_"+s2))
            return map.get(s1+"_"+s2);
        int n = s1.length();
        boolean flag = false;
        for( int i=1;i<n;i++){
            
            boolean equal = (isScramble( s1.substring(0,i) , s2.substring(0,i))) && (isScramble(s1.substring(i),s2.substring(i)));

            boolean notEqual = (isScramble(s1.substring(0,i),s2.substring(n-i))) && (isScramble(s1.substring(i), s2.substring(0,n-i)));
            if(equal || notEqual){
                flag = true;
                break;
            }
            
        }
        map.put(s1+"_"+s2, flag);
        return flag;
    }
}