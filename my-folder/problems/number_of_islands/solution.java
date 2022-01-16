class Solution {
    public int numIslands(char[][] grid) {
        int noOfIsland = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              // if(grid[i][j] =='1' && !visited[i][j]){
              //     grid
              // }
                if(grid[i][j] =='1'){
              check(grid, i, j);
                  noOfIsland++;      
            }
            }
        }
        return noOfIsland;
    }
    public void check(char[][] grid, int i, int j){
   
        if(grid[i][j] =='1'){
           grid[i][j] ='0';
           
          if(i+1<grid.length)  check(grid, i+1, j);
          if(j+1<grid[0].length)  check(grid, i, j+1);  
          if(i-1>=0)  check(grid, i-1, j);
          if(j-1>=0)  check(grid, i, j-1);              
         }
        return ;
    }
}