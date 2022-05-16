class Pair{
    int i;
    int j;
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};

    public void wallsAndGates(int[][] rooms) {
        Deque<Pair> q = new LinkedList<>();
        
        
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j] == 0)
                    q.add(new Pair(i,j));
                }
            }
    
    
    while(!q.isEmpty()){
        Pair p = q.poll();
        for (int[] dir: dirs) {
            int x = p.i+dir[0];
            int y = p.j+dir[1];
            
            if(x <0 || y <0 || x>=rooms.length || y >= rooms[0].length || rooms[x][y] != Integer.MAX_VALUE )
                continue;
             rooms[x][y] =rooms[p.i][p.j]+1;
             q.add(new Pair(x,y));
            }
        
        }
        
        
    }
}