class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            if(grid[0][i] ==0 || grid[grid.length-1][i]==0)
                floodfill(grid, 0, i);
            if(grid[i][0] ==0 || grid[i][grid[0].length-1]==0)
                floodfill(grid,i, 0);
            if(grid[grid.length-1][i]==0)
                floodfill(grid, grid.length-1, i);
            if(grid[i][grid[0].length-1]==0)
                floodfill(grid, i, grid[0].length-1);            
        }
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[0].length-1;j++){
                if(grid[i][j] ==0){
                    floodfill(grid,i, j);
                    count +=1;
                }
            }
        }
        
        
        return count;
    }
    public void floodfill(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] ==1)
            return ;
        
        grid[i][j] = 1;
        
        floodfill(grid, i, j+1);
        floodfill(grid, i, j-1);
        floodfill(grid, i+1, j);
        floodfill(grid, i-1, j);
    }   
}