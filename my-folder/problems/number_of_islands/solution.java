class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0')
                    continue;
				count++;
                validNeighbour(grid,i,j);                
                
            }
        }
        return count;
    }
    public void validNeighbour(char[][] grid, int i, int j) {
        if(i>=grid.length || j>= grid[0].length || i<0 || j<0 || grid[i][j]=='0' )
            return ;
        
        grid[i][j] = '0';
        validNeighbour(grid,i-1,j);
        validNeighbour(grid,i+1,j);
        validNeighbour(grid,i,j-1);
        validNeighbour(grid,i,j+1);
    }
}
