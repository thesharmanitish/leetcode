class Solution {
   public static int count=0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0) return 0;
        int res=0;
        
        for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
                  if(grid[i][j]==1){
                       count=0;
                      floodfill(grid,i,j);
                      if(res<count){
                          res=count;
                      }
                  }
           }
        }
        return res;
    }
    public static void floodfill(int[][] grid ,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
        
        grid[i][j]=0;// marking it so that it would not be handled further as it is handled this time
        count++;
        
        floodfill(grid,i+1,j);
        floodfill(grid,i-1,j);
        floodfill(grid,i,j-1);
        floodfill(grid,i,j+1);
        
    }
}

// class Pair{
//     int x;
//     int y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }
// class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
//         boolean[][] visited = new boolean[grid.length][grid[0].length];
//         int[][] arr = {{0,-1},{0,1},{1,0},{-1,0}};
        
//         int max = 0;
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(grid[i][j] ==1 && !visited[i][j])
//                 {
//                 Deque<Pair> dq = new LinkedList<>();
//                 dq.add(new Pair(i,j));
//                 int count = 0;
//                 visited[i][j] = true;    
//                 while(!dq.isEmpty()){
//                     Pair p = dq.poll();
//                     count++; 
//                     for(int k=0;k<4;k++){
//                         int r = p.x+arr[k][0];
//                         int c = p.y+arr[k][1];
//                         if( r>=0 &&  c>=0 && r < grid.length && c <grid[0].length && grid[r][c] ==1 && !visited[r][c]){
                           
//                             visited[r][c]=true;
//                             dq.add(new Pair(r,c));
//                         }
                    
//                     }
//                     max = Math.max(max, count);
//                 }
//             }
//           }
            
//         }
//         return max;
//     }
// }