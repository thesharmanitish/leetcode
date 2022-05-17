class Solution {
    public int trap(int[] height) {
        int start = 0, end = height.length-1, sum=0, maxLeft=0, maxRight = 0;
        
        while(start<end){
            if(height[start]<height[end]){
                if(height[start] > maxLeft)
                    maxLeft = height[start];
                sum+=maxLeft - height[start];
                start++;
            }else{
                if(height[end] > maxRight)
                    maxRight = height[end];
                sum+=maxRight - height[end];
                end--;
            }
            
            
        }
        return sum;
    }
}