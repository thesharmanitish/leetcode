class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> nums[i2]-nums[i1]);
//         int n= nums.length;
//         int[] output = new int[n-k+1];
//         int outputIndex = 0;
        
//         for(int i=0;i<k-1;i++)
//             pq.add(i);
        
//         for(int i=k-1;i<nums.length;i++){
//             while(!pq.isEmpty() && pq.peek()<i-k+1)
//                 pq.remove();
//             pq.add(i);
//             output[outputIndex++] = nums[pq.peek()];
//         }
        
//         return output;
//     }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length ==0 || k==0)
            return new int[0];
        int n= nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        
        left[0] = nums[0];
        right[n-1] = nums[n-1];
        
        
        for(int i=1;i<n;i++){
            if(i%k==0)
                left[i] = nums[i];
            else 
                left[i] = Math.max(left[i-1],nums[i]);
            
            if((n-i-1) %k ==0)
                right[n-i-1] = nums[n-i-1];
            else
                right[n-i-1] = Math.max(right[n-i],nums[n-i-1]);
        }
        int[] res = new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            res[i] = Math.max(left[i+k-1], right[i]);
        }
        return res;
    }
}