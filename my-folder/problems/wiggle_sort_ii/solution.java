class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = new int[nums.length];
        
        arr = IntStream.of(nums).boxed()
                              .sorted(Collections.reverseOrder())
                              .mapToInt(value -> value.intValue()).toArray();
        int start = 0;
        for(int i=1;i<nums.length;i+=2){
            nums[i] = arr[start++];
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i] = arr[start++];
        }
    }   
    
}