// class Solution {
//     public int maxProfit(int[] prices) {
//         int firstBuy = Integer.MAX_VALUE, firstBuyFirstSell=0;
        
//         for(int i=0;i<prices.length;i++){
//             firstBuy = Math.min(firstBuy, prices[i]);
//             firstBuyFirstSell = Math.max(firstBuyFirstSell, prices[i]-firstBuy);
//         }

//         return firstBuyFirstSell;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int curProfit = 0,boughtPrice = prices[0];
        for(int i=1;i< prices.length;i++){
            if(boughtPrice > prices[i])
                boughtPrice = prices[i];
            curProfit = Math.max(prices[i] - boughtPrice, curProfit);
                
        }
        return curProfit;
    }
}