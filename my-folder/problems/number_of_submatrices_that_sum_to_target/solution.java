class Solution {
    public int numSubmatrixSumTarget(int[][] A, int target) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                A[i][j] += A[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                
                counter.clear();
                counter.put(0,1);
                int sum = 0;
                for(int k=0;k<m;k++){
                    sum += A[k][j] - (i>0?A[k][i-1]:0);
                    res +=counter.getOrDefault(sum-target,0);
                    counter.put(sum, counter.getOrDefault(sum,0)+1);    
                }
                
                
                
            }
        }
        return res;
    }
}