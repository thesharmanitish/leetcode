class NumArray {
    int[] nums, sum;
    public NumArray(int[] nums) {
        this.nums = nums;
        sum =  new int[nums.length+1];
        sum[1] = nums[0];
        for(int i=2;i<=nums.length;i++){
            sum[i] += nums[i-1] +sum[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */