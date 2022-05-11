class Solution {
    public int peakIndexInMountainArray(int[] x) {
        int mid =-1, start = 0, n = x.length, end = n-1;
        
        while(start<=end){
            mid = start+(end-start)/2;
            
            if(mid-1 >=0 && x[mid-1] > x[mid] ) {
                end = mid -1;
                
            }else if(mid+1 < n && x[mid+1] > x[mid]){
                start = mid+1;
            }else
                return mid;
            
        }
        return mid;
    }
}