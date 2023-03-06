class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]-mid-1<k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start+k;
    }
}



/**
class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int a :arr){
            if(a<=k)
                k++;
            else
                break;

        }
        return k;
    }
}
 */


/**
class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k <= arr[0] - 1) {
            return k;
        }

        if(arr[arr.length-1] == arr.length)
            return arr[arr.length-1]+k;
        
        k -= arr[0] - 1;

        for (int i = 0; i < arr.length - 1; ++i) {
            int curMissing = arr[i+1]-arr[i]-1;
            if(k<=curMissing)
                return arr[i]+k;
            
            k-=curMissing;
        }
        return arr[arr.length - 1] +k;
    }
}
*/