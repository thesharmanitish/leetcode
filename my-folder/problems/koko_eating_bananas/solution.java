class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Integer.MAX_VALUE;

        // for(int i=0;i<piles.length;i++){
        //     if(max<piles[i]){
        //         max= piles[i];
        //     }
        //     if(min>piles[i]){
        //         min = piles[i];
        //     }
        // }
        
        while(max>min){
            int mid = min + (max-min)/2;
            if(check(piles, mid, h)){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean check(int[] piles, int speed, int h) {
        int timeTaken = 0;
        for(int pile:piles){
            timeTaken += (pile/speed) + (pile%speed==0?0:1);
            if(timeTaken>h)
                return false;
        }
        return timeTaken <= h;
    }
}