class Solution {
    public int totalNQueens(int n) {
       boolean[][] board = new boolean[n][n];
      
       helper(board, 0);
       return count;  
    }
    int count =0;
    public void helper(boolean[][] board, int col) {
       if(col == board.length) {
           count++;
           return;
       }
      
       for(int row=0; row<board.length; row++) {
           if(isSafe(row, col, board)) {
               board[row][col] = true;
               helper(board, col+1);
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
}
