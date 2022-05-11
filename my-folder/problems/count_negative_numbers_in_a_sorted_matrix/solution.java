class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;        
        for(int i=0;i<grid.length;i++)   {
            res += search(grid[i]);
            // System.out.println(res);
        }
        return res;
    }
    public int search(int[] x) {
        if(x[0]<0)
            return x.length;
        if(x[x.length-1] >=0)
            return 0;
        int mid;
        int start = 0, end = x.length-1;
        while(start<end){
            mid = start+(end-start)/2;
            if(0 <= x[mid]){
                start = mid +1;
            }else
                end = mid;
            
        }
        return x.length-start;
                    
    }    
}