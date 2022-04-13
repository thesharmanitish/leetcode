public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int x = 0;
        for(int i=0;i<32;i++){
            x += (n&1)==1 ? 1:0;
            n = n>>1;
            
        }
        return x;        
    }
}