class Solution {
    int[][] dir = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        

        Deque<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Integer[] point = queue.pollFirst();
                if(point[0]==0 || point[1]==0|| point[0] == maze.length-1 || point[1]== maze[0].length-1)
                    if(count!=0)
                        return count;
                
                for(int[] d:dir){
                    int x = point[0]+d[0], y= point[1]+d[1];
                    if(validate(maze, x, y)){
                       queue.add(new Integer[]{x, y});
                       maze[x][y] = '+';
                    }
                }
                if(queue.isEmpty() && count==0)
                    return -1;
            }
            count++;
        }
        return -1;
    }
    public boolean validate(char[][] maze, int i, int j) {
       if(i <0 || i >=maze.length || j <0 || j >= maze[0].length ||
                maze[i][j] =='+')
            return false;
       return true;
    }
}