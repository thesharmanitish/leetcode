class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        spiralOrder(matrix, 0, 0, matrix.length,matrix[0].length);
        return res;
    }
    public void spiralOrder(int[][] mat, int rstart, int cstart, int r, int c) {
        if(r<rstart || c < cstart)
            return ;
        if(r== rstart && c == cstart) {
            return ;
        }

        for(int i=cstart;i<c;i++){
            if(mat[rstart][i] == -111)
                continue;
            res.add(mat[rstart][i]);
            mat[rstart][i] = -111;
        }
        for(int i=rstart+1;i<r;i++){
            if(mat[i][c-1] == -111)
                continue;
            res.add(mat[i][c-1]);
            mat[i][c-1] = -111;
        }
        for(int i=c-2;i>=cstart;i--){
            if(mat[r-1][i] == -111)
                continue;
            res.add(mat[r-1][i]);
            mat[r-1][i] = -111;
        }
        for(int i=r-2;i>rstart;i--){
            if(mat[i][cstart] == -111)
                continue;
            res.add(mat[i][cstart]);
            mat[i][cstart] = -111;
        }
        spiralOrder(mat, rstart+1, cstart+1, r-1,c-1);
    }
}