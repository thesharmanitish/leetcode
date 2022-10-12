class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] ==0)
                continue;
            for(int j=0;j<grid.length;j++){
                grid[j][i] = grid[j][i] ==1?0:1;
            }
        }
        
        for(int i=1;i<grid.length;i++){
            boolean flag = false;
            if(grid[i][0] ==1)
                flag =true;
            for(int j=0;j<grid[0].length;j++){
                if((flag && grid[i][j] ==0) || (!flag && grid[i][j] ==1))
                    return false;
            }
        }
        return true;
    }
}