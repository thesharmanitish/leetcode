class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == target || matrix[matrix.length-1][i] == target)
                return true;
            if(matrix[0][i]< target && matrix[matrix.length-1][i]> target){
                if(searchMatrix(matrix, i, target))
                    return true;
            }
            
            
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int col, int target) {
        int start = 0, end = matrix.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid][col] == target)
                return true;
            else if(matrix[mid][col] < target)
                start = mid+1;
            else
                end = mid-1;
            
            
        }
        return false;
        
    }
}