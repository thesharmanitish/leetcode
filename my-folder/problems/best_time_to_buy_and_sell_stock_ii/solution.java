class Solution {
    public int maxProfit(int[] prices) {
        int res = 0,  prev = prices[0];
        for(int i=1;i<prices.length;i++){

            if(prices[i] - prev>0)
                res+=prices[i] - prev;
            
            prev = prices[i];
        }
        return res;
    }
}