class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp  = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++)
            Arrays.fill(dp[i], 0);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,longestIncreasingPathHelper(matrix, i, j,dp));
            }
        }
        return max+1;
    }
    
    public int longestIncreasingPathHelper(int[][] matrix, int i, int j, int[][] dp) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        validate(matrix, i,j);
        if(dp[i][j]!=0)
            return dp[i][j];
        
        for(int[] d:dir){
            if(validate(matrix, i+d[0],j+d[1]) && matrix[i][j]<matrix[i+d[0]][j+d[1]])
                dp[i][j] = Math.max(dp[i][j], 1+longestIncreasingPathHelper(matrix, i+d[0], j+d[1],dp));
        }
        return dp[i][j];
    }
    
    public boolean validate(int[][] matrix, int i, int j){
        if(i<0 || j<0 || i>= matrix.length || j>=matrix[0].length)
            return false;
        return true;
    }
}