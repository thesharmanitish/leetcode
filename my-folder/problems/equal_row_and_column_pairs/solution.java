class Solution {
    public int equalPairs(int[][] grid) {
        int count =0;
        for(int i=0;i<grid.length;i++){
            
            for(int k=0;k<grid.length;k++){
                int c=0;
                for(int j=0;j<grid.length;j++){

                    if(grid[i][j] == grid[j][k])
                        c++;
                    else break;
                }
                if(c == grid[0].length){
                    count++;
                }
            }
            
        }
        return count;
    }
}