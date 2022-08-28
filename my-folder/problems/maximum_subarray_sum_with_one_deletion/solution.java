class Solution {
    public int maximumSum(int[] arr) {
        int max = arr[0], oneDelete = 0, noDelete = arr[0];
        for(int i=1;i<arr.length;i++){
            oneDelete = Math.max(oneDelete+arr[i], noDelete);
            noDelete = Math.max(noDelete+arr[i], arr[i]);
            
            max = Math.max(max, Math.max(noDelete, oneDelete));
            
        }
        return max;
    }
}