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

        while(low<high){
            int mid = low + (high-low)/2;
            if(mid>0 && arr[mid-1]>arr[mid])
                return arr[mid];
            else if (arr[low] <= arr[mid] && arr[mid] > arr[high]) 
                low = mid+1;
            else{
                high = mid-1;
            }
        }
        return arr[low];
    }
}