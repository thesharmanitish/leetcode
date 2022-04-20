class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;     
        for(int x=31;x>=0;x--){
            if((a>>>x)-b>=0){
                res += 1<<x;
                a -= b<<x;
            } 
            
        }
        return dividend>0 ==divisor > 0 ?res:-res ;
    }
}