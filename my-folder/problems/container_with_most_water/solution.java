class Solution {
    public int maxArea(int[] height) {
        int max = 0, start = 0, end = height.length-1, minpiller = 0, res = Integer.MIN_VALUE;
        while(start<end){
            if(height[start]<height[end]){
              minpiller = start;
              max = height[minpiller]*(end-start);
              start++;  
                
            }else{
                minpiller = end;
                max = height[minpiller]*(end-start);
                end--;
            }
            
            res = Math.max(res, max);
        }
        return res;
    }
}