class Solution {
    public int findPeakElement(int[] nums) {
          int max = Integer.MIN_VALUE, ind = -1;
          if(nums.length<=0) return -1;
          if(nums.length==1) return 0;
          for(int i=0;i<nums.length;i++){
              if(max<nums[i]){
                  max= nums[i];
                 ind = i;
                  }
           }
          return ind==Integer.MIN_VALUE?-1:ind;
    }
}