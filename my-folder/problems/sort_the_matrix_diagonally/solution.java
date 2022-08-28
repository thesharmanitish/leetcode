class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> tset = new PriorityQueue<>();
        
        
        for(int i=mat.length-2;i>=0 ;i--){
            int j=0;
            int row =i, col = j;
            while(row< mat.length && col < mat[0].length){
                tset.add(mat[row][col]);
                row++;
                col++;
            }
            row =i; col = j;
            while(row< mat.length && col < mat[0].length){
                mat[row][col] = tset.poll();
                row++;
                col++;
            }            
        }
        for(int j=mat[0].length-2;j>0 ;j--){
            int i=0;
            int row =i, col = j;
            while(row< mat.length && col < mat[0].length){
                tset.add(mat[row][col]);
                row++;
                col++;
            }
            row =i; col = j;
            while(row< mat.length && col < mat[0].length){
                mat[row][col] = tset.poll();
                row++;
                col++;
            }            
        }        
        
        return mat ;
    }
}