class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1)) ==0;
        
        
    }
    public boolean isPowerOfTwoMine(int n) {
        if(n==0)
            return false;
        if(n <0){
            return false;
            
        }
        n = n-1;
       while(n>0) {
           if((n&1)==0)
               return false;
           n = n>>1;
       }
           
       return true;    
    }
}