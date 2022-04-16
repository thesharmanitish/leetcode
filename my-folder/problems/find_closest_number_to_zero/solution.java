class Solution {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            if(Math.abs(num)<Math.abs(min)){
                min = num;
                System.out.print( min + " ");
            }
            else if(Math.abs(num) == Math.abs(min))
                    min = min>num? min:num;
            
        }
        return min;
    }
}