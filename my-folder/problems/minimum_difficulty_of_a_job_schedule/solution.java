class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        // Edge case: make sure there is at least one job per day
        if (n < d) {
            return -1;
        }

        int[][] mem = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i],-1);
        }

        return minDiff(0, d, jobDifficulty, mem);
    }

    private int minDiff(int i, int daysRemaining, int[] jobDifficulty, int[][] memo) {
        if(memo[i][daysRemaining] !=-1)
            return memo[i][daysRemaining];
        
        if(daysRemaining ==1){
            int max = Integer.MIN_VALUE;
            for(int start =i;start<jobDifficulty.length;start++)
                max = Math.max(max, jobDifficulty[start]);
            return max;
        }
        
        int maxDiff = 0;
        int res = Integer.MAX_VALUE;
        for(int start=i; start< jobDifficulty.length-daysRemaining+1;start++){
            maxDiff = Math.max(maxDiff, jobDifficulty[start]);
            res = Math.min(res , maxDiff +  minDiff(start+1, daysRemaining-1, jobDifficulty, memo));
        }
        return memo[i][daysRemaining] =res;
        
    }
}