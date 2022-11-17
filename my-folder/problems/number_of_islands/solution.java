class Solution {
    public int numIslands(char[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] =='0')
                    continue;
                sum +=1;    
                dfs(grid,i, j);
            }
        }
        return sum;
    }
    static int[] row = {-1,1,0,0};
    static int[] col = {0,0,-1,1};
    
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 ||j<0 || i>=grid.length || j>= grid[0].length || grid[i][j] =='0')
            return;
        
        grid[i][j] = '0';
        
        for(int x =0;x<4;x++){
            dfs(grid,i+row[x], j+col[x]);
        }

    }
}