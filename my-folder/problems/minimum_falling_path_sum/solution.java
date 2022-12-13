// class Solution {
// public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         if(matrix.length == 1 && matrix[0].length==1)
//             return matrix[0][0];      
//         int mini = Integer.MAX_VALUE;;
//         for(int i=1; i<n; i++){
//             for(int j =0; j<n; j++){
//                 if(j == 0){
//                     matrix[i][j] += Math.min( matrix[i-1][j],  matrix[i-1][j+1]);
//                 }
//                 else if(j == n-1){
//                     matrix[i][j] += Math.min( matrix[i-1][j],  matrix[i-1][j-1]);
//                 }
//                 else{
//                     matrix[i][j] += Math.min( matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i-1][j+1]));
//                 }
//                 if(i==n-1)
//                     mini = Math.min(mini, matrix[i][j]);
//             }
//         }
//         return mini;
//     }
// }


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix.length == 1 && matrix[0].length ==1)
            return matrix[0][0];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = matrix[i][j] + Math.min(j>0?Math.min(matrix[i-1][j-1], matrix[i-1][j]):matrix[i-1][j],
                        j+1<matrix[0].length?Math.min(matrix[i-1][j+1], matrix[i-1][j]):matrix[i-1][j]);
                if(i==matrix.length-1){
                    min = Math.min(min, matrix[i][j]);
                }
            }

        }

        return min;
    }
}