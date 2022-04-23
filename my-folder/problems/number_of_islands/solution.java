
class Pair{
    int x;
    int y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
//     public int numIslands(char[][] grid) {
// 		boolean[][] visited = new boolean[grid.length][grid[0].length];
// 		Deque<Pair> q = new LinkedList<>();
// 		int[] arr = { -1, 0, 1, 0 }, brr = { 0, -1, 0, 1 };
// 		int count = 0;
// 		for (int i = 0; i < grid.length; i++) {
// 			for (int j = 0; j < grid[0].length; j++) {
// 				if (grid[i][j] == '0')
// 					continue;
// 				if (visited[i][j])
// 					continue;

// 				count++;
// 				q.offer(new Pair(i, j));
// 				while (!q.isEmpty()) {
// 					Pair p = q.poll();
// 					visited[p.x][p.y] = true;
// 					for (int k = 0; k < arr.length; k++) {
// 							if (p.x + arr[k] >= 0 && p.x + arr[k] < grid.length && p.y + brr[k] >= 0 && p.y + brr[k] < grid[0].length
// 									&& grid[p.x + arr[k]][p.y + brr[k]] == '1' && !visited[p.x + arr[k]][p.y + brr[k]]) {
// 								q.offer(new Pair(p.x + arr[k], p.y + brr[k]));
// 								visited[p.x + arr[k]][p.y + brr[k]] = true;
// 							}
						
// 					}

// 				}
// 			}
// 		}
// 		return count;
	
//     }
    
public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0')
					continue;

				count++;
                validNeighbour(grid,i,j);
				

			}
		}
		return count;
    }  
    
    
    public void validNeighbour(char[][] grid, int x, int y) {
        if(x <0 || x >= grid.length || y < 0 || y >= grid[0].length
        || grid[x ][y] == '0')
            return;
        grid[x ][y] = '0';
        
        validNeighbour(grid,x-1,y);
        validNeighbour(grid,x,y-1);
        validNeighbour(grid,x,y+1);
        validNeighbour(grid,x+1,y);
        
    }
}