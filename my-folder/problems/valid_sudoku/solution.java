class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        
        HashSet<Character>[][] matrix = new HashSet[3][3];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j] =='.')
                    continue; 
                if(rows[i] ==null)
                    rows[i] = new HashSet<>();
                if(cols[j] ==null)
                    cols[j] = new HashSet<>();
                if(matrix[i/3][j/3] ==null)
                    matrix[i/3][j/3] = new HashSet<>();
                
                if(rows[i].contains(board[i][j]) || cols[j].contains(board[i][j]) || 
                   matrix[i/3][j/3].contains(board[i][j]))
                    return false;
                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                matrix[i/3][j/3].add(board[i][j]);
            }
        }
        return true;                             
    }
}