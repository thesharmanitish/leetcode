class Solution {
    public boolean search(int[] arr, int target) {
        
		int low = 0, high = arr.length - 1, n = high,l= low, res = -1, mid = 0;
		if (arr.length == 0)
			return false;
		if (arr.length == 1) {
			if (arr[0] == target)
				return true;
			return false;
		}

        low = l;
        high = n;
		while (low < high-1) {
            while(low<arr.length-1 && arr[low] == arr[low+1])
                low++;

            while(high>0 &&arr[high] == arr[high-1])
                high--;

			mid = low + (high - low) / 2;
            if(arr[mid]==target)
                return true;
			else if (arr[mid] < arr[high]) 
				high = mid;
			else
				low = mid;
		}
        res = arr[low] > arr[high] ? high:low;   

        if(arr[res] ==target)
             return true;
        
		else if ( target  <= arr[n]){
                    
            low = res;
            high = n;
        }
			// Arrays.fill(arr, mid, high+1, Integer.MAX_VALUE);
		else if (target >  arr[n]){
                   
            low = l;
            high = res; 
        }
			// Arrays.fill(arr, low, res+1, Integer.MIN_VALUE);
      
		while (low < high-1) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return true;

			else if (target > arr[mid])
				low = mid+1;
			else 
				high = mid - 1;

		}
        if (arr[low] == target || arr[high] == target)
            return true;
		else return false;
        
    }
}