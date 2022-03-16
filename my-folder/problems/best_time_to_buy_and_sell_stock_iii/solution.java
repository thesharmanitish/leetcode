class Solution {
    public int maxProfit(int[] prices) {
    	  int oneBuyOneSell = 0;
    	  int twoBuyTwoSell = 0;
    	  int oneBuy = Integer.MAX_VALUE;
    	  int twoBuy = Integer.MAX_VALUE;;
          for(int i=0;i<prices.length;i++){
              int pr = prices[i];
              oneBuy = Math.min(oneBuy,pr);
              oneBuyOneSell = Math.max(oneBuyOneSell, pr-oneBuy);
              twoBuy = Math.min(twoBuy,pr- oneBuyOneSell);
              twoBuyTwoSell = Math.max(twoBuyTwoSell,pr-twoBuy);
          }
    
        return twoBuyTwoSell;
        
    }
}