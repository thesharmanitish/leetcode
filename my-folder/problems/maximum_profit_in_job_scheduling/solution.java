class Solution {
    private int findMaxProfit(int[][] jobs) {
        int n = jobs.length, maxProfit = 0;
        // min heap having {endTime, profit}
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek()[0]<=jobs[i][0]){
                maxProfit = Math.max(maxProfit, pq.poll()[1]);
            }
            pq.offer(new Integer[]{jobs[i][1], jobs[i][2]+maxProfit});

        }
        while(!pq.isEmpty()){
            maxProfit = Math.max(maxProfit, pq.poll()[1]);
        }
        return maxProfit;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        // storing job's details into one list 
        // this will help in sorting the jobs while maintaining the other parameters
        int length = profit.length;
        for (int i = 0; i < length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        return findMaxProfit(jobs);
    }
}