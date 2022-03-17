class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE, firstBuyFirstSell=0;
        
        for(int i=0;i<prices.length;i++){
            firstBuy = Math.min(firstBuy, prices[i]);
            firstBuyFirstSell = Math.max(firstBuyFirstSell, prices[i]-firstBuy);
        }

        return firstBuyFirstSell;
    }
}