class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[][] matrix = new HashSet[3][3];

        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] =='.')
                    continue;                  
                if(matrix[i/3][j/3] == null)
                    matrix[i/3][j/3] = new HashSet<>();                

                if(cols[j]==null)
                    cols[j] = new HashSet<>();      

                if(!cols[j].add(board[i][j]) || !rows[i].add(board[i][j]) || !matrix[i/3][j/3].add(board[i][j]))
                    return false;
            }
        }
               
        return true;
    }
}