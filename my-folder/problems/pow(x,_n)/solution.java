class Solution {
    public double myPow(double x, int n) {
        double res =1;
        if(x == 0)
            return x;
        else if(x==1 || n==0)
            return 1;
        int t = n;
        if(n<0){
            x = 1/x;
            n = -(n+1);//for Integer.MIN_VALUE
            res = res*x;
            }
        while(n>0){
            if((n&1)==1){
                res = res*x;
            }
            x = x*x;
            n= n>>1;
        }

        return res;
        
    }
}