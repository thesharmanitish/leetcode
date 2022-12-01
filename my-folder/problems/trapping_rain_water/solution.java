class Solution {
    public int trap(int[] height) {
        int start =0 , end = height.length-1, leftMax=height[0], rightMax = height[end];
        int sum = 0;
		while(start<end){
			if(height[start]<height[end]){
                if(leftMax < height[start])
                    leftMax = height[start];
                sum += leftMax- height[start];
                // rightMax = Math.max(rightMax, height[end]);
				start++;
			}else{
                if(rightMax < height[end])
                    rightMax = height[end];
				sum += rightMax- height[end];
				end--;
			}
		}
		return sum;        
    }
}
        // while(start<end){
        //     if(height[start]<height[end]){
        //         if(maxLeft<height[start]){
        //             maxLeft = height[start];
                    
        //         }
                
        //         sum+= maxLeft - height[start];
        //         start++;
        //     }else{
        //         if(maxRight<height[end]){
        //             maxRight = height[end];
                    
        //         }
                
        //         sum+= maxRight - height[end];                
        //         end--;
        //     }
        // }
        // return sum;
