class Solution {
    public boolean hasAllCodes(String s, int k) {
        int x = 1<<k, n = s.length();
        if(k> s.length())
            return false;
        if(n==0 || k==0)
            return true;
        else if(n==1){ 
            if(k>=1)
                return false;
            else return true;
        }
        boolean[] flag = new boolean[x];
        int temp = 0;
        for(int i=0;i<k-1;i++){
            temp = temp | (s.charAt(i)-'0');
            temp <<=1;
        }
        int j=(1<<k)-1;
        for(int i=k-1;i<s.length();i++){

            temp = temp | (s.charAt(i)-'0');
            flag[temp] = true;
            temp <<=1;
            temp = temp&j;
            
        }
        
        for(boolean f:flag)
            if(!f)
                return false;
        return true;
        
    }
}