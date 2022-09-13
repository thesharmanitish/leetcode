class Solution {
    int[] arr;
    int[] backup;
    public Solution(int[] nums) {
        arr = nums;
        backup = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        return arr = Arrays.copyOf(backup, backup.length);
    }
    
    public int[] shuffle() {
        for(int i=0;i<arr.length;i++){
            swap(i, randRange(i, arr.length));
        }
        return arr;
    }
    public int randRange(int min, int max) {
        Random rand = new Random();
        return  rand.nextInt(max-min)+ min;
        
    }
    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */