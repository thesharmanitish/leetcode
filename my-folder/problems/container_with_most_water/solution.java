class Solution {
    public int maxArea(int[] height) {
		int start = 0, end = height.length - 1, max = 0, mul = 0;
		while (start < end) {
            mul = Math.min(height[start], height[end]) * (end - start);
			if (height[start] < height[end]) {
				start++;
			} else {
                end--;
			}
			max = Math.max(max, mul);

		}
        return max;
    }

}