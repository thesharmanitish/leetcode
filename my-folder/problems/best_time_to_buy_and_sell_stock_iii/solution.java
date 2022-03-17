class Solution {
    
//     Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
// Then the tricky part comes, how to handle the twoBuy? Suppose in real life, you have bought and sold a stock and made $100 dollar profit. When you want to purchase a stock which costs you $300 dollars, how would you think this? You must think, um, I have made $100 profit, so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
// There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!! The twoBuyTwoSell is just making as much profit as possible.
// Hope this explanation helps other people to understand this!
    
    
//     public int maxProfit(int[] prices) {
//     	  int oneBuyOneSell = 0;
//     	  int twoBuyTwoSell = 0;
//     	  int oneBuy = Integer.MAX_VALUE;
//     	  int twoBuy = Integer.MAX_VALUE;;
//           for(int i=0;i<prices.length;i++){
//               int pr = prices[i];
//               oneBuy = Math.min(oneBuy,pr);
//               oneBuyOneSell = Math.max(oneBuyOneSell, pr-oneBuy);
//               twoBuy = Math.min(twoBuy,pr- oneBuyOneSell);
//               twoBuyTwoSell = Math.max(twoBuyTwoSell,pr-twoBuy);
//           }
    
//         return twoBuyTwoSell;
        
//     }
    
    public int maxProfit(int[] prices) {
     int oneBuy = Integer.MAX_VALUE;
     int oneBuyOneSell = 0;
     int twoBuy = Integer.MAX_VALUE;
     int twoBuyTwoSell = 0;        
     
     for(int i=0;i<prices.length;i++)   {
         int pr = prices[i];
         oneBuy = Math.min(oneBuy,prices[i] );
         oneBuyOneSell = Math.max(oneBuyOneSell, pr - oneBuy);
         twoBuy = Math.min(twoBuy, pr-oneBuyOneSell);
         twoBuyTwoSell = Math.max(twoBuyTwoSell, pr - twoBuy);
         
         
         }      
        return twoBuyTwoSell;
    }
    
    
}