class Solution {
    int target = 0;
    public int uniquePathsIII(int[][] grid) {
        int start =-1, end =-1;
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1)
                    target++;
                if(grid[i][j] == 1){
                    start = i;
                    end = j;
                    
                }
            }
        }
        uniquePathsIII(grid, start, end, new boolean[grid.length][grid[0].length]);
        return result;
    }

    int result = 0, count = 0;
    int[][] dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0, -1}};
    public void uniquePathsIII(int[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 ||j <0 || i>= grid.length || j>= grid[0].length || 
                grid[i][j] == -1 || visited[i][j])
            return;
        else if(grid[i][j] == 2){
            if(target == count+1){
                result++;
            }else
                return;
        }
        
        else {
            visited[i][j] = true;
            count +=1;
            for(int[] d:dir){
                uniquePathsIII(grid, i+d[0], j+d[1], visited);
            }
            visited[i][j] = false;
            count -=1;
        }
        
        
    }


}