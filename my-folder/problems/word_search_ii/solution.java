// class Solution {
//     Set<String>  result = new HashSet<>();
//     Map<Character, List<Integer[]>> map = new HashMap<>();
//     char[][] b;
//     public List<String> findWords(char[][] board, String[] words) {
//         b = board;
//         for(int i=0;i<board.length;i++){
//             for(int j=0;j<board[0].length;j++){
//                 map.computeIfAbsent(board[i][j], ArrayList::new);
                
//                 List<Integer[]> ll = map.get(board[i][j]);
//                 ll.add(new Integer[]{i,j});
//                 map.put(board[i][j], ll);

//             }
//         }
//         boolean[][] visited = new boolean[board.length][board[0].length];

//         for(String word:words){
//             if(!map.containsKey(word.charAt(0)))
//                 continue;
//             List<Integer[]> t = map.get(word.charAt(0));
//             for(Integer[] pos:t)
//                 dfs(visited, word, pos , 0);
//         }
//         return result.stream().collect(Collectors.toList());
        
//     }
//     int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0, 1}};
//     public void dfs(boolean[][] visited, String word,Integer[] pos, int ind) {
        

//         if(ind >= word.length() || pos[0]<0 || pos[1]<0 || pos[0]>= visited.length || pos[1] >= visited[0].length || word.charAt(ind) != b[pos[0]][pos[1]] || visited[pos[0]][pos[1]])
//             return;
//         if(ind == word.length()-1){
//             result.add(word);
//             return; 
//         }          
//         visited[pos[0]][pos[1]] = true;
//         for(int[] d:dir){
//             Integer[] x = new Integer[2];
//             x[0] = pos[0] + d[0];
//             x[1] = pos[1] + d[1];
//             dfs(visited, word, x, ind+1);

//         }
//         visited[pos[0]][pos[1]] = false;

      

//     }
// }



class Solution {
    HashMap<String,Integer> map=new HashMap<>();
     Set<String> ans=new HashSet<>();
    int max=-1;
    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            map.put(words[i],1);
            max=Math.max(max,words[i].length());
        }
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][board[0].length];
        StringBuilder sb;
        for(int i=0;i<n;i++){
            for(int j=0;j<board[i].length;j++){
                
                sb = new StringBuilder();
                dfs(i,j,sb,board,vis);
            }
        }
        return new ArrayList<>(ans);
        
    }
    void dfs(int i,int j,StringBuilder sb,char board[][],boolean vis[][]){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && vis[i][j]==false && sb.length()<max){
           
            sb.append(board[i][j]);
            String x=sb.toString();
             if(map.containsKey(x))
                ans.add(x);
            vis[i][j]=true;
            dfs(i+1,j,sb,board,vis);
            dfs(i,j+1,sb,board,vis);
            dfs(i-1,j,sb,board,vis);
            dfs(i,j-1,sb,board,vis);
            vis[i][j]=false;
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}