class Solution {
    public boolean hasAlternatingBits(int n) {
        // int x = (n&1) ==1?n+1:n, hbit =  31-(int)((Math.log(Integer.highestOneBit(n))+1)/Math.log(2));
        // System.out.print((0x55555555>>hbit) + " "+ (0xAAAAAAAA>>hbit)+" "+hbit);
        // return (n ^ 0x55555555>>hbit) ==0 || (n ^ 0xAAAAAAAA>>hbit) ==0;
        
        
        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}