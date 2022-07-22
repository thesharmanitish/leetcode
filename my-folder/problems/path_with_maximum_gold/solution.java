class Solution {
    int[] row = {0, 1, 0,-1};
    int[] col = {1, 0,-1, 0};

    public int getMaximumGold(int[][] grid) {
        
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxGold = 0; 
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0)
                    continue;
                maxGold = Math.max(maxGold,getMaximumGold(grid, i, j, visited));

            }
        }
        return maxGold;
    }
     public int getMaximumGold(int[][] grid, int i, int j, boolean[][] dp) {
        if(!isValid(grid, i,j, dp))
            return 0;
        dp[i][j] = true;
        int maxGold = 0; 
        for(int k=0;k<4;k++){
           int r  = i+row[k];
           int c = j+col[k];
           maxGold = Math.max(maxGold,getMaximumGold(grid, r, c, dp));
        }         
        dp[i][j]  = false;
        return maxGold+grid[i][j]; 
     }
    
    
    public boolean isValid(int[][] grid, int r, int c, boolean[][] visited){


        if( r>=grid.length || c>= grid[0].length || r<0 ||c<0 || grid[r][c] ==0 || visited[r][c])
            return false;
        return true;
        
    }
}