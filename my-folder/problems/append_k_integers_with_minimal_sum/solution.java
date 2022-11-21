class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int prev = -1;
        long sum = 0;
        
        for (int num: nums) {
            if (prev != num && num <= k) {
                k++;
                sum += num;        
            }            
            prev = num;
        }
        
        long res = (long)(1 + k) * k / 2 - sum;
        return res;        
    }    
    // public long minimalKSum(int[] nums, int k) {
    //     TreeSet<Integer> tset = new TreeSet<>();
    //     long sum = ((long)(k + 1) * (long)k) / 2;
    //     int count = 0;
    //     for(int num:nums){
    //         tset.add(num);
    //     }
    //     for(int num:tset){
    //         if(num>k)
    //             break;
    //         else {
    //             sum-=num;
    //             count++;
    //         }
    //     }        
        
    //     ++k;
    //     while(count>0){
    //         if(!tset.contains(k)){
    //             count--;
    //             sum+=k;
    //         }
    //         k++;
    //     }
    //     return sum;
    // }
}