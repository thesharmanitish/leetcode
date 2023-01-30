class Solution {
    public int tribonacci(int n) {
        if(n<2)
            return n;
        int t0=0;
        int t1 = 1;
        int t2 = 1;

        for(int i=3;i<=n;i++){
            int x = t2;
            t2 +=t1+t0;
            t0 =t1;
            t1 = x;
        }
        return t2;
    }
}