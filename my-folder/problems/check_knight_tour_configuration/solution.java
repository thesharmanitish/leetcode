class Solution {
    public boolean checkValidGrid(int[][] grid) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        int[] prev = new int[]{0,0};
        for(int i=1;i<grid.length*grid.length;i++){
            int[] ref = map.get(i);
            if(!isValid(ref, prev))
                return false;
            prev = ref;
        }
        return true;
    }
    public boolean isValid(int[] ref, int[] prev) {
        if(Math.abs(ref[0]-prev[0]) ==2){
            return Math.abs(ref[1]-prev[1]) ==1;
        }else if(Math.abs(ref[1]-prev[1]) ==2){
            return Math.abs(ref[0]-prev[0]) ==1;
        }
        return false;
    }
}