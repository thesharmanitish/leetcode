class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x = cost[0];
        int y = cost[1];
        for(int i=2;i<cost.length;i++){
            int t = y;
            y = cost[i] + Math.min(x, y);
            x = t;
        }
        return Math.min(x, y);
    }
}