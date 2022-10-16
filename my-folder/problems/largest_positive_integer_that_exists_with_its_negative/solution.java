class Solution {
    public int findMaxK(int[] nums) {
        int[] arr = new int[1001];
        int[] brr = new int[1001];
        for(int num:nums){
            if(num<0)
                arr[-num] =1;
            else
                brr[num] =1;
        }
        for(int i=1000;i>=0;i--){
            // if(arr[i] ==1)
            //     return -1;
            if(arr[i] +brr[i] ==2)
                return i;
        }
        return -1;
        
    }
}