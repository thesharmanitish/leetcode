class Solution {
    public int trap(int[] height) {
        int start =0, end = height.length-1, sum = 0;
        int maxLeft = height[start], maxRight = height[end];
        while(start<end){
            if(height[start]<height[end]){
                if(maxLeft<height[start]){
                    maxLeft = height[start];
                    
                }
                
                sum+= maxLeft - height[start];
                start++;
            }else{
                if(maxRight<height[end]){
                    maxRight = height[end];
                    
                }
                
                sum+= maxRight - height[end];                
                end--;
            }
        }
        return sum;
    }
}