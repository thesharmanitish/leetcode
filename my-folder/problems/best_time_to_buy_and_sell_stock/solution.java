class Solution {
    public int maxProfit(int[] prices) {
        int prev = prices[0], maxDiff = Integer.MIN_VALUE;
        
        for(int i=1;i<prices.length;i++){
            int  diff=prices[i]-prev;
            maxDiff = Math.max(diff, maxDiff);
            if(diff<0)
                prev = prices[i];
        }
        return maxDiff>0?maxDiff:0;
        
    }
}