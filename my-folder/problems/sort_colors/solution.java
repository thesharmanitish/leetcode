class Solution {
    
    public void sortColors(int[] nums) {
    int last = nums.length-1;
    int start = 0;
    int size= last;
    int i=0;
    if(nums.length <2)     return ;
     while(i <= last){
       if(nums[i] == 0 ){
           swap(nums,i, start);
           start++;
           i++;
       }
        else if(nums[i] == 2 && i != last){
           swap(nums,i, last);
           last--;
       }else{
            i++;
        }
     }
    }
    
    
    
//     public void sortColors(int[] nums) {
//         int last = nums.length-1;
//         int start = 0;
//         int size= last;
        
//         for(int i=0;i<nums.length;i++){
//            while(last>=0 && nums[last]==2) last--;
//            if(nums[i] ==2 && i<last){
//                swap(nums,i, last);
//                last--;
//            }             
               
//         }
//         for(int i=last;i>=0;i--){
//            while(start < size && nums[start]==0) start++;
//            if(nums[i] ==0 && i>start){
//                swap(nums,i, start);
//                start++;
//            }             
               
//         }
//     }
    
    public void swap(int[] nums, int a, int b){
        nums[a] = nums[a]^nums[b];
        nums[b] = nums[a]^nums[b];
        nums[a] = nums[a]^nums[b];    
    }
}