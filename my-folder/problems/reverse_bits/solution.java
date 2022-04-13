public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 0;
        for(int i=0;i<32;i++){
            x = x<<1;
            x = (x| (n&1));
            n = n>>1;
            
        }
        return x;
    }
}