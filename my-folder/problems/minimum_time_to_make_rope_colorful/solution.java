class Solution {
    public int minCost(String colors, int[] neededTime) {
        int start =0, end =0;
        int sum = 0, curSum=0, max = 0;
        while(end<neededTime.length){
            if(colors.charAt(start) == colors.charAt(end)){
                max = Math.max(max, neededTime[end]);
                curSum += neededTime[end];
            }
            else{
                sum += curSum-max;
                curSum =neededTime[end];
                max = neededTime[end];
                start = end;
            }
            end++;
        }
        sum += curSum-max;
        return sum;
    }
}