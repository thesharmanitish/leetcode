class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0, res =-1, prev = 0;
        for(int[] log:logs){
            if(log[1]-prev> max ||(log[1]-prev == max && res > log[0])){
                max = log[1]-prev;
                
                res = log[0];
            }
            prev = log[1];
        }
        return res;
    }
}