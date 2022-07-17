class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[101];
        int count = 0;
        for(int n:nums){
            arr[n] +=1;
            
        }
        int[] res = new int[2];
        int i = 0;
        for(int n:arr){
            res[0] += n/2;
            res[1] += n%2;
        }
        
        return res;
    }
}