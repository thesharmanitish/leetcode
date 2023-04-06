class Solution {
    public int closedIsland(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
                fill(grid, i, 0);
                fill(grid, i, grid[0].length-1);
        }
        for(int i=0;i<grid[0].length;i++){
                fill(grid, 0, i);
                fill(grid, grid.length-1, i);
        }
        int count = 0;
        for(int i=1;i<grid.length-1;i++){
            for(int j=1;j<grid[0].length-1;j++){
                if(grid[i][j] ==0){
                    fill(grid, i ,j);
                    count++;
                }

            }
        }
        return count;
    }
    public void fill(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j] ==1)
            return;
        grid[i][j] = 1;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        for(int k=0;k<dir.length-1;k++){
            fill(grid, i+dir[k], j+dir[k+1]);
        }
    }
}