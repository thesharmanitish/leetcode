class Pair{
    int i;
    int j;
    public Pair(int i, int j){
        this.i =i;
        this.j = j;
    }
}
class Solution {
    int[][] da = {{0,1},{0,-1},{1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Deque<Pair> q = new LinkedList<>();
        if(grid[0][0] == 1)
            return -1;
        
        q.add(new Pair(0,0));
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        visited[0][0] = 1;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int[] d:da){
                int x = p.i + d[0];
                int y = p.j + d[1];
                if(x<0 || y<0 || x>=grid.length|| y>= grid[0].length || grid[x][y] !=0)
                    continue;
                
                    
                visited[x][y] =  Math.min(visited[x][y],visited[p.i][p.j]+1);
                q.add(new Pair(x,y));
                grid[x][y] = -1;
                if(x == grid.length-1 && y == grid[0].length-1)
                    return visited[x][y] ;
                    
            }    
            
            
        }
        return visited[grid.length-1][grid[0].length-1] ==Integer.MAX_VALUE ?-1:visited[grid.length-1][grid[0].length-1];
        
    }
    
    
}