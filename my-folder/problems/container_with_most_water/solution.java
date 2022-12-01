class Solution {
    public int maxArea(int[] height) {
        int start =0 , end = height.length-1, max=0;

		while(start<end){
			if(height[start]<height[end]){
				max = Math.max(max, height[start]*(end-start));
				start++;
			}else{
				max = Math.max(max, height[end]*(end-start));
				end--;
			}
		}
		return max;
    }
}