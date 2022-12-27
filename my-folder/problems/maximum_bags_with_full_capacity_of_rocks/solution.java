class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++){
            capacity[i] -= rocks[i];
        } 
        int count = 0;
        Arrays.sort(capacity);
        for(int i=0;i<capacity.length;i++){
            if(additionalRocks>=capacity[i]){
                additionalRocks -= capacity[i];
            }else if(capacity[i]>0)
                break;

            count++;
        }
        return count;  
    }
}