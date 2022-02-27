class Solution {
public int[] searchRange(int[] A, int target) {
    
    
     int[] ret = {-1,-1};
    if(A.length <1) return ret;
        int i = 0, j = A.length-1;
 while (i < j)
    {
        int mid = (i + j) /2;
        if (A[mid] < target) i = mid + 1;
        else j = mid;
    }
    if (A[i]!=target) return ret;
    else ret[0] = i;

    
    // Search for the right one
    j = A.length-1;  // We don't have to set i to 0 the second time.
    while (i < j)
    {
        int mid = (i + j) /2 + 1;	// Make mid biased to the right
        if (A[mid] > target) j = mid - 1;  
        else i = mid;				// So that this won't make the search range stuck.
    }
    ret[1] = j;
    return ret; 
    }
}