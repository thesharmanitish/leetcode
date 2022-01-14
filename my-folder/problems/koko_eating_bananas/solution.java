class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MAX_VALUE;
        while(left<right){
            int mid = left +(right-left)/2, sum = 0;
            for(int pile:piles){
                sum += (pile+mid-1)/mid;
                
            }
            if(sum<=h){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}