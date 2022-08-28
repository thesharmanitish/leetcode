class Solution {
    public int maxProfit(int[] prices) {
//         int max = 0, peak =0, valley = 0, i=0;
        
//         while(i<prices.length-1){
//             while(i< prices.length-1 && prices[i] >= prices[i+1])
//                 i++;
//             valley = prices[i];
//             while(i< prices.length-1 && prices[i] <= prices[i+1])
//                 i++;           
//             peak = prices[i];
            
//             max +=peak -valley;
//         }
//         return max;
        
        
        
        int sum = 0, prev = Integer.MAX_VALUE;
        for(int price:prices){
            if(prev>price ){
                prev = price;
                continue;
            }
            sum += price-prev;
            prev = price;
                
        }
        return sum;
    }
}