class Solution {
    public int maxProfit(int[] prices) {
        int curProfit = 0,boughtPrice = prices[0];
        for(int i=1;i< prices.length;i++){
            if(boughtPrice > prices[i])
                boughtPrice = prices[i];
            curProfit = Math.max(prices[i] - boughtPrice, curProfit);
                
        }
        return curProfit;
        
//         int max =0, min = prices[0];
//         for(int i=1;i<prices.length;i++){
//             max = Math.max(max, prices[i]-min);
//             min = Math.min(prices[i], min);
//         }
//         return max;
    }
    
}