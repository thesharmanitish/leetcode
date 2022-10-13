class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc], new boolean[image.length][image[0].length]);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int color, int prev, boolean[][] visited) {
        if(sr<0 || sc<0 || sr>=image.length || sc >= image[0].length || image[sr][sc] != prev || visited[sr][sc])
            return;
        image[sr][sc] = color;
        visited[sr][sc] = true;
        
        dfs(image, sr+1, sc, color, prev, visited);
        dfs(image, sr-1, sc, color, prev, visited);
        dfs(image, sr, sc+1, color, prev, visited);
        dfs(image, sr, sc-1, color, prev, visited);
    }
}