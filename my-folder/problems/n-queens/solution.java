class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> allBoards = new ArrayList<>();
       boolean[][] board = new boolean[n][n];
      
       helper(board, allBoards, 0);
       return allBoards;  
    }
    public void helper(boolean[][] board, List<List<String>> allBoards, int col) {
       if(col == board.length) {
           saveBoard(board, allBoards);
           return;
       }
      
       for(int row=0; row<board.length; row++) {
           if(isSafe(row, col, board)) {
               board[row][col] = true;
               helper(board, allBoards, col+1);
               board[row][col] = false;
           }
       }
   }
       public boolean isSafe(int row, int col, boolean[][] board) {
       //horizontal
       for(int j=0; j<board.length; j++) {
           if(board[row][j] || board[j][col]) {
               return false;
           }
       }
            
       //upper left
       int r = row;
       for(int c=col; c>=0 && r>=0; c--, r--) {
           if(board[r][c]) {
               return false;
           }
       }
      
       //upper right
       r = row;
       for(int c=col; c<board.length && r>=0; r--, c++) {
           if(board[r][c]) {
               return false;
           }
       }
      
       //lower left
       r = row;
       for(int c=col; c>=0 && r<board.length; r++, c--) {
           if(board[r][c]) {
               return false;
           }
       }
      
       //lower right
       for(int c=col; c<board.length && r<board.length; c++, r++) {
           if(board[r][c]) {
               return false;
           }
       }
      
       return true;
   }
public void saveBoard(boolean[][] board, List<List<String>> allBoards) {
       String row = "";
       List<String> newBoard = new ArrayList<>();
      
       for(int i=0; i<board.length; i++) {
           row = "";
           for(int j=0; j<board[0].length; j++) {
               if(board[i][j])
                   row += 'Q';
               else
                   row += '.';
           }
           newBoard.add(row);
       }
      
       allBoards.add(newBoard);
   }


}