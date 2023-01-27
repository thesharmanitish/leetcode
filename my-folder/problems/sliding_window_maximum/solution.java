class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[b]-nums[a]);
    //     for(int i=0;i<k-1;i++){
    //         pq.add(i);
    //     }

    //     int[] result = new int[nums.length-k+1];
    //     int j=0;
    //     for(int i=k-1;i<nums.length;i++){
    //         if(!pq.isEmpty()){
    //             if(nums[i]>nums[pq.peek()])
    //                 pq.clear();
            
    //             while(!pq.isEmpty() && pq.peek()<i-k+1){
    //                 pq.poll();
    //             }
    //         }
            
    //         pq.add(i);            
    //         result[j++] = nums[pq.peek()];
    //     }
    //     return result;
    // }

public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0 || k==0)
            return new int[0];
        int n = nums.length;

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i=1;i<nums.length;i++){
            if(i%k==0)
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i-1], nums[i]);
            
            if((n-i-1)%k ==0)
                right[n-i-1] = nums[n-i-1];
            else{
                right[n-i-1] = Math.max(right[n-i] , nums[n-i-1]);
            }
        }
        int[] res = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            res[i] = Math.max(left[i+k-1], right[i]);
        }
        return res;
    }

}