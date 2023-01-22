class Solution {
    int[][] dir = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int ref = image[sr][sc];
        while(!queue.isEmpty()){
            int[] t = queue.poll();
            image[t[0]][t[1]] = color;
            for(int[] d:dir){
                int x = d[0]+t[0];
                int y =  d[1]+t[1];
                if(isValid(image, x, y, color, ref)){
                    queue.add(new int[]{x, y});
                }
            }
        }
        return image;
    }
    public boolean isValid(int[][] image, int sr, int sc, int color, int ref){
        if(sr<0 || sc <0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != ref)
            return false;
        return true;
    }
}