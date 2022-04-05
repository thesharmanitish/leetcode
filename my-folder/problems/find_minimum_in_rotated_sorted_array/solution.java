class Solution {
//     public int findMin(int[] nums) {
//     int left = 0;
//     int right = nums.length - 1;
//     while(left < right) {
//         int mid = left + (right - left) / 2;
//         if(nums[mid] < nums[right]) {
//             right = mid;
//         } else {
//             left = mid + 1;
//         }
//     }
//     return nums[left];
// }
    
    public int findMin(int[] arr) {
        int low = 0, high = arr.length-1;
        if(arr.length==0) 
            return -1;
        else if(arr.length==1) 
            return arr[0];

        while(low<high-1){
            int mid = low + (high-low)/2;
            if (arr[mid] <= arr[high]) 
                high = mid;
            else{
                low = mid;
                
            }
        }
        return arr[low]>arr[high]?arr[high]:arr[low];
    }
}