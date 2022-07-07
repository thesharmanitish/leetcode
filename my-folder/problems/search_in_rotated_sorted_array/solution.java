class Solution {
    public int search(int[] arr, int target) {
		int low = 0, high = arr.length - 1, n = high, res = -1, mid = 0;
		if (arr.length == 0)
			return -1;
		if (arr.length == 1) {
			if (arr[0] == target)
				return 0;
			return -1;
		}else if( arr[n] == target)
            return n;
        else if(arr[0] == target)
            return 0;
        
		while (low < high-1) {
			mid = low + (high - low) / 2;
            if(arr[mid] == target)
                return mid;
			if (arr[mid] < arr[high]) 
				high = mid;
			else
				low = mid;
		}
        res = arr[low] > arr[high] ? high:low;    
        if(arr[res] ==target)
             return res;
        
		else if ( target  <= arr[n]){
                    
            low = res;
            high = arr.length-1;
        }
			// Arrays.fill(arr, mid, high+1, Integer.MAX_VALUE);
		else if (target >  arr[n]){
                   
            low = 0;
            high = res; 
        }
			// Arrays.fill(arr, low, res+1, Integer.MIN_VALUE);
      
		while (low < high-1) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;

			else if (target > arr[mid])
				low = mid+1;
			else 
				high = mid - 1;

		}
        if (arr[low] == target)
            return low;
        else if(arr[high] == target)
            return high;
		else return -1;
	
    }
}