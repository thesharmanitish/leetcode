class Solution {
    public int fib(int n) {
        int cur = 1, prev =0;
        if(n <=1)
            return n;
        for(int i=2;i<=n;i++){
            int sum =  cur + prev;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
}