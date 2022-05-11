class Solution {
    public int search(int[] x, int target) {
        
        if(x.length<1)
            return -1;
        else if(target == x[0])
            return 0;;
        int mid;
        int start = 0, end = x.length-1;
        while(start<=end){
            mid = start+(end-start)/2;
            
            if(target > x[mid] ){
                start = mid+1;
            }else if(target < x[mid]){
                end = mid -1;
            }else
                return mid;
            
        }
        return -1;
                    
    }
}