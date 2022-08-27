class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int[] arr = new int[matrix.length];
        for(int i=0;i<matrix[0].length;i++){
            Arrays.fill(arr, 0);
            for(int j=i;j<matrix[0].length;j++){
                for(int l=0;l<matrix.length;l++){
                    arr[l] += matrix[l][j];
                }
                updateResult(arr, k);
                if (result == k)
                        return result;
            }
        }
        return result;
        
    }
    int result = Integer.MIN_VALUE;
    void updateResult(int[] nums, int k) {
        int sum = 0;

        // Container to store sorted prefix sums.
        TreeSet<Integer> sortedSum = new TreeSet<>();

        // Add 0 as the prefix sum for an empty sub-array.
        sortedSum.add(0);
        for (int num : nums) {
            // Running Sum.
            sum += num;

            // Get X where Running sum - X <= k such that sum - X is closest to k.
            Integer x = sortedSum.ceiling(sum - k);

            // If such X is found in the prefix sums.
            // Get the sum of that sub array and update the global maximum result.
            if (x != null)
                result = Math.max(result, sum - x);

            // Insert the current running sum to the prefix sums container.
            sortedSum.add(sum);
        }
    }
}