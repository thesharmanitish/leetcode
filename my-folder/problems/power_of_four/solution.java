class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1)
            return false;
        if(n==0 )
             return true;
        int i=0;
        if((n & ( n-1))==0){
            return (n & 0x55555555) != 0;  // little hack as 0x555555 = 1010101010101
// Working but less efficient
//             while(n>0){
//                 i++;
//                 n = n>>1;
                
//             }
//             if((i&1) ==1)
//                 return true;
            
        }
        return false;
    }
}