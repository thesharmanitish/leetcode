class Solution {
    public int peakIndexInMountainArray(int[] arr) {
                      // Your code here
      int l=0,r=arr.length-1,mid;
      while(l<r)
      {
          mid = l + (r-l) / 2;
          if(arr[mid+1]>arr[mid])
          {
              l = mid+1;
          }
          else
          {
              r = mid;
          }
      }
        return r;
    }
}