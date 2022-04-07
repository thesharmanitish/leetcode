class Solution {
    public int superPow(int a, int[] b) {
    long res = 1;
        
      for(int i=b.length-1;i>=0;i--)  {
          
          res = (res*myPow(a,b[i]))%1337;
          a = myPow(a,10);
          
      }
        return (int)res;
    }
    
    public int myPow(int x, int n) {
        int res =1;
        if(x==1 || n==0)
            return 1; 
        x %= 1337;
        while(n>0){
            if((n&1)==1){
                res = (res*x)%1337;
            }
            x = (x*x)%1337;
            n= n>>1;
        }

        return res%1337;
        
    }
}