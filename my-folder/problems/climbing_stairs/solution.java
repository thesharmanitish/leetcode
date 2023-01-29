class Solution {
    public int climbStairs(int n) {
        if(n <=3)
            return n;
        int last = 3, secondLast = 2;
        for(int i=4;i<=n;i++){
            int x = last;
            last = last+secondLast;
            secondLast = x;
        }
        return last;
    }
}