class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, mid = n/2;
        
        for(int i=0;i<mid;i++){
            swap(matrix, i, n-1-i);
        }
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
    public void swap(int[][] matrix, int s, int t) {
        int[] temp = matrix[s];
        matrix[s] = matrix[t];
        matrix[t] = temp;
    }
}