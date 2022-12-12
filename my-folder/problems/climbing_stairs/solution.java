class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2)
            return n;
            
        int prev = 1, cur =2;

        for(int i=3;i<=n;i++){
            int x = cur + prev;
            prev = cur;
            cur = x;
        }

        return cur;
    }
}