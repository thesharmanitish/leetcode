class Solution {
    int[][] dp;
    final int MAX_DISTANCE = 0;
    public int maxDistance(int[][] grid) {
        // Queue<Integer> queue = new LinkedList<>();
        // boolean[][] visited = new boolean[grid.length][grid[0].length];
        dp = new int[grid.length][grid[0].length];
        
        int max = Integer.MIN_VALUE;;
        final int MAX_DISTANCE = grid.length + grid[0].length + 1;
        for(int[] arr:dp)
            Arrays.fill(arr, MAX_DISTANCE);
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    dp[i][j] = 0;
                else{
                    if(i>0){
                        dp[i][j]  = Math.min(dp[i-1][j]+1, dp[i][j]);
                    }
                    if(j>0){
                        dp[i][j]  =  Math.min(dp[i][j-1]+1, dp[i][j]);
                    }
                }
            }
        }


        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(grid[i][j]==1)
                    dp[i][j] = 0;
                else{
                    if(i<dp.length-1){
                        dp[i][j] = Math.min(dp[i+1][j]+1, dp[i][j]);
                    }
                    if(j<dp[0].length-1){
                        dp[i][j] =  Math.min(dp[i][j+1]+1, dp[i][j]);
                    }
                }
                max = Math.max(max, dp[i][j]);

            }
        }
        return max ==0 || max >=  MAX_DISTANCE? -1: max;

    }   
}