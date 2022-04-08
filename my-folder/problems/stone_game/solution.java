class Solution {
    
    public boolean stoneGame(int[] piles) {
    	//3,7,2,3
        int[] dp = Arrays.copyOf(piles,piles.length);
        int k=0;
		for (int windowSize = 2; windowSize <= piles.length; windowSize++) {
			for (int start = 0; start <= piles.length - windowSize; start++) {
				int end = start + windowSize - 1;
				dp[start] = Math.max(piles[start] - dp[start + 1], piles[end] - dp[start]);
			}
		}
        return dp[0]>0?true:false;
        
    
    }
    
//     public boolean stoneGame(int[] piles) {
//         int[][] dp = new int[piles.length+1][piles.length+1];
//         for(int i=1;i<=piles.length;i++){
//             dp[i][i] = piles[i-1];
//         }
//         for(int i=1;i<=piles.length;i++){
//             for(int j=i+1;j<=piles.length;j++){
//             	dp[i][j] = Math.max(piles[i-1] - dp[i+1][j], piles[j-1] - dp[i][j-1]);
              
//             }
//         }
        
//         return dp[1][piles.length]>0?true:false;
        
//     }

//     public boolean stoneGame(int[] piles) {
//         int[][][] dp = new int[piles.length+1][piles.length+1][2];
//         for(int i=1;i<=piles.length;i++){
//             dp[i][i][0] = piles[i-1];
//         }
//         for(int i=1;i<=piles.length;i++){
//             for(int j=i+1;j<=piles.length;j++){
//             	dp[i][j][0] = Math.max(dp[i][j-1][1]+piles[j-1], dp[i+1][j][1]+piles[i-1]);
//                 dp[i][j][1] = Math.min(dp[i][j-1][1]+piles[j-1], dp[i+1][j][1]+piles[i-1]);
                
//             }
//         }
        
//         return dp[1][piles.length][0]>dp[0][piles.length][1]?true:false;
        
//     }    
}