class Solution {
    int[][] dir = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
    public boolean exist(char[][] board, String word) {
        // Prune #1: 
        // If there aren't even enough letters in the board to fit word, then return false
        if(word.length() > board.length*board[0].length) 
            return false;
        
        // Prune #2: 
        // For each letter, the board must contain at least as many of that letter as word contains
        int ascii[] = new int[128];
        for(char[] b : board) {
            for(char c : b) 
            {
                ++ascii[c];
            }
        }
        for(char c : word.toCharArray()) {
            if(--ascii[c] < 0) {
                return false;
                }
        }
        
        // Prune #3: Find the longest prefix/suffix of the same character. If the longest suffix is longer
        // than the longest prefix, swap the strigns (so we are less likely to have a long prefix with a lot
        // of the same character)
        int left_pref = 0, size = word.length()-1;
        while(left_pref <= size && word.charAt(left_pref) == word.charAt(0))
            left_pref++;
        int right_pref = size;
        while(right_pref >=0 && word.charAt(right_pref) == word.charAt(size))
            right_pref--;
        if(size-right_pref> left_pref)
            word = reverse(word);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0))
                    if(backtrack(0, board, i, j, word))
                        return true;
            }
        }
        return false;
    }
    public boolean backtrack(int ind, char[][] visited, int i, int j, String word) {
        if(ind == word.length())
            return true;
        if(!isValid(i, j, ind, visited, word))
            return false;
        visited[i][j] = '#';
        for(int[] d:dir){
            if(backtrack(ind+1, visited, d[0]+i, d[1]+j, word))
                return true;
        }
        visited[i][j] = word.charAt(ind);
        return false;
    }
    public boolean isValid(int i, int j, int ind, char[][] visited, String word){
        if(i<0 || j<0 || i>= visited.length|| j >= visited[0].length|| word.charAt(ind) != visited[i][j])
            return false;
        return true;
    }
    public String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(char c:word.toCharArray())
            sb.append(c);
        return sb.toString();
    }
}