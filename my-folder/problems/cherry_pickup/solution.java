class Solution {

    public int cherryPickup(int[][] grid) {
    int N = grid.length;
    int[][] dp = new int[N][N];
    dp[0][0] = grid[0][0];
	    
    for (int n = 1; n < 2*N-1; n++) {
		for (int i = N - 1; i >= 0; i--) {
			for (int p = N - 1; p >= 0; p--) {
				int j = n - i, q = n - p;
                
				if (j < 0 || j >= N || q < 0 || q >= N || grid[i][j] < 0 || grid[p][q] < 0) {
                    dp[i][p] = -1;
                    continue;
                 }
		 
				 if (i > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
				 if (p > 0) dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
				 if (i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
		 
				 if (dp[i][p] >= 0) dp[i][p] += grid[i][j] + (i != p ? grid[p][q] : 0);
             }
		 }
    }
    
    return Math.max(dp[N - 1][N - 1], 0);
 }
    
    
    
    
//     private int[][] dp ;
//     public int cherryPickup(int[][] grid) {
//         dp = new int[grid.length+1][grid.length+1];
//         for(int i=1;i<=grid.length;i++){
//             for(int j=1;j<=grid.length;j++){
//                     if(grid[i-1][j-1] ==1)
//                         dp[i][j] = 1+Math.max(dp[i-1][j],dp[i][j-1]);
//                     else if(grid[i-1][j-1] ==0)
//                         dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                     else if(grid[i-1][j-1] ==-1)
//                         dp[i][j] = Integer.MIN_VALUE;
            
//                 }
//         }
//         int max = dp[grid.length][grid.length], i=grid.length, j=grid.length;
//         while(i>1 && j>1){
//             if(dp[i][j-1]>dp[i-1][j]){
//                 if(dp[i-1][j]!=Integer.MIN_VALUE) {
//                     max+= grid[i-2][j-1];
//                         i--;
//                     }
//                 else j--;
//                 }
//             else {
//                 if(dp[i][j-1]!=Integer.MIN_VALUE){
//                     max+= grid[i-1][j-2]    ;   
//                      j--;   
//                     }
//                 else i--;
                    
//                 }
            
//         }
//         return max<0?0:max;
//     }
}