class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1)
            return false;
        if(n==0 )
             return true;
        int i=0;
        if((n & ( n-1))==0){
            return (n & 0x55555555) != 0;  // little hack as 0x555555 = 1010101010101
            // return (n & 0xaaaaaaaa) ==0 ;
            
            //a =1010 & 100
            // 5 = 10101 & 100

            
        }
        return false;
    }
}