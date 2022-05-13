class Solution {
    
    
     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { 
         
         Map<Long, Long> map = new HashMap<>();
         
         for(int i=0;i<nums.length;i++){
             long temp = (long) nums[i] - Integer.MIN_VALUE;
             long bucket = temp/((long)t+1);
             
             if(map.containsKey(bucket) ||
               (map.containsKey(bucket-1) && temp <= map.get(bucket-1)+t )||
               (map.containsKey(bucket+1) && map.get(bucket+1)<= temp +t ))
                 return true;
             map.put(bucket, temp);
             
             if(map.size()>k){
                 long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                 map.remove(lastBucket);
             }            
         }
       return false;
     }
// Bucket approch
    
//     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { 
//         if (k < 1 || t < 0) return false;
//         Map<Long, Long> map = new HashMap<>();
        
//         for(int i=0;i<nums.length;i++){
//             long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
//             long bucket = remappedNum/((long)t+1);
//             if(map.containsKey(bucket) ||
//               (map.containsKey(bucket-1) && remappedNum-map.get(bucket-1)<=t) ||
//               (map.containsKey(bucket+1) && map.get(bucket+1)- remappedNum<=t))
//                 return true;
            
//             if(map.size()>=k){
//                 long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
//                 map.remove(lastBucket);
//             }
//             map.put(bucket, remappedNum);
//         }
//         return false;
//     }

//     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { 
//         TreeSet<Integer> treeset = new TreeSet<>();
        
//         for(int i=0;i<nums.length;i++){
//             if(treeset.ceiling(nums[i])!=null && (long) treeset.ceiling(nums[i]) <= nums[i]+ t)
//                 return true;
//             if(treeset.floor(nums[i])!=null && nums[i] <= (long) treeset.floor(nums[i])+ t)
//                 return true;
//             treeset.add(nums[i]);      
//             if(treeset.size() > k)
//                 treeset.remove(nums[i-k]);
            
  
            
//         }
//         return false;
        
//     }
}