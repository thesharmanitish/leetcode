class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rsum = new int[grid.length];
        int[] csum = new int[grid[0].length];
        
        int i = 0;
        for(int[] g:grid){
            for(int num:g)
                rsum[i] +=  num;
            i++;
        }
        int k= 0;
        for(i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                csum[k] += grid[j][i];
            }
            k++;
        }
        for(i=0;i<grid.length;i++){
            for(k=0;k<grid[0].length;k++){
                grid[i][k] = 2*csum[k] +2*rsum[i]-grid.length -grid[0].length;
            }
        }
        return grid;
        
    }
}