class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for(int num:nums){
            if((num&1)==1)
                continue;
            if(num%3 ==0){
                sum +=num;
                count++;
            }
        }
        return count == 0?0:sum/count;
    }
}