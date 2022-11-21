class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            nums[i] -= 1; 
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==-1)
                continue;
            int x = nums[i];
            while(x>=0 && nums[x]!=-1){
                int t = nums[x];
                nums[x] = -1;
                x =t;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0)
                result.add(i+1);
        }
        return result;
    }
}