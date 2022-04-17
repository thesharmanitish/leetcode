class Solution {
    public int longestOnes(int[] arr, int k) {
    
		int max = 0, j = -1, count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				count++;

			while (count > k) {
				j++;
				if (arr[j] == 0) {
					count--;

				}
			}
			int len = i - j;
			if (max < len)
				max = len;
		}
		return max;
	     
    }
}