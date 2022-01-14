class Solution {
    public int minDays(int[] A, int m, int k) {
        int n = A.length, left =Integer.MAX_VALUE, right = 1;
        if(m*k>A.length) return -1;
        for(int i:A){
            right = right<i?i:right;
            left = left>i?i:left;

        }
        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (A[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}