class Solution {
//     public int minGroups(int[][] intervals) {
//         Arrays.sort(intervals, (a,b)-> a[0] - b[0] );
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         pq.offer(intervals[0][1]);
        
//         for(int i=1;i<intervals.length;i++){
//             if(pq.peek()<intervals[i][0]){
//                 pq.poll();
                
//             }
//             pq.offer(intervals[i][1]);
            
//         }
//         return pq.size();
//     }
        public int minGroups(int[][] intervals) {
        int res = 0, cur = 0, n = intervals.length, A[][] = new int[n * 2][2];
        for (int i = 0; i < n; ++i) {
            A[i * 2] = new int[]{intervals[i][0], 1};
            A[i * 2 + 1] = new int[]{intervals[i][1] + 1, -1};
        }
        Arrays.sort(A, Comparator.comparingInt(o -> o[0] * 3 + o[1]));
        for (int[] a: A)
            res = Math.max(res, cur += a[1]);
        return res;
    }
}