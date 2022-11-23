class Solution {
    // Set<Character>[] rows = new HashSet[9];
    // Set<Character>[] cols = new HashSet[9];
    // Set<Character>[][] matrix = new HashSet[4][4];    
    public void solveSudoku(char[][] board) {
        // for(int i=0;i<9;i++){
        //     rows[i] = new HashSet<>();
        //     cols[i] = new HashSet<>();
        // }
        // for(int i=0;i<3;i++){
        //     for(int j=0;j<3;j++){
        //         matrix[i][j] = new HashSet<>();
        //     }
        // }
        // for(int i=0;i<9;i++){
        //     rows[i] = new HashSet<>();
        //     for(int j=0;j<9;j++){
        //         if(board[i][j] =='.')
        //             continue;

        //         cols[j].add(board[i][j]);
        //         rows[i].add(board[i][j]);
        //         matrix[i/3][j/3].add(board[i][j]);
        //     }
        // }
        int i = 0, j=0;
        boolean flag = false;
        for(i=0;i<board.length;i++){
            for(j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    flag = true;
                    break;
                }
            }
            if(flag)
             break;
        }
        solveSudokuRec(board, i, j);
    }
    // Map<Integer, Character> map = new HashMap<>();
    public boolean solveSudokuRec(char[][] board, int i, int j) {
        if(i == board.length )
            return true;
        if(j>8)
            return solveSudokuRec(board, i+1, 0);
        
        if(board[i][j]!='.'){
             if(j>=board[0].length-1)
                return solveSudokuRec(board, i+1, 0);
            else  
                return solveSudokuRec(board, i, j+1);
        }else{
            int k=1;
            for(k=1;k<=9;k++){
                char c=(char)(k+'0');    
                // if(cols[j].contains(c) || rows[i].contains(c) || matrix[i/3][j/3].contains(c))
                if(!check(board, i, j, c))
                    continue;
                board[i][j] = c;
                // rows[i].add(c);
                // cols[j].add(c);
                // matrix[i/3][j/3].add(c);
                if(j>=board[0].length? solveSudokuRec(board, i+1, 0):solveSudokuRec(board, i, j+1))
                    return true;
                board[i][j] = '.';
                // rows[i].remove(c);
                // cols[j].remove(c);
                // matrix[i/3][j/3].remove(c);                
            }
            if(k>9 && j<9)
                return false;

        }
        return false;

    }
    public static boolean check(char[][] board , int sr , int sc  , char ch  ){
        boolean flag =true;
        // cheak in row 
        for(int i =0;i<9;i++){
            
                    if(ch == board[i][sc] ){
                        return false;
                    }
            
        }
        // cheak in column 
        for(int i =0;i<9;i++){
            
                    if(ch== board[sr][i] ){
                        return false;
                    }
            
        } 
        // now cheak in 3*3 matrix 
        int r = (sr/3 )* 3;
        int c = (sc/3 )* 3;
        for(int i = r;i<r+3;i++){
            for(int j = c;j<c+3 ;j++){
                
                    if(ch == board[i][j]){
                        return false;
                    }
                
            }
        }
        return flag;
    }    
}