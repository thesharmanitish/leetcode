class Solution {
    public int peakIndexInMountainArray(int[] x) {
        int start = 0, n = x.length, end = n-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid>0 && x[mid-1]<x[mid] && mid<n && x[mid+1]<x[mid])
                return mid;
            else if(mid>0 && x[mid-1]>x[mid])
                end = mid-1;
            else if(mid<n && x[mid+1]>x[mid])
                start = mid +1;
        }
        return start;
    }
}