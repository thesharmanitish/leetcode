class Solution {
    public double myPow(double x, int n) {
        if(x ==0 || n==1)
            return x;
        else if(n==0)
            return 1;
        
        double res=1;
        if(n<0){
            x= (1/x);
            n = -(n+1);
            res = res*x;
        }
        
        while(n>0){
            if((n&1)==1)
                res *=x;
            x *= x;
            n >>=1;
        }
        return res;
    }
}