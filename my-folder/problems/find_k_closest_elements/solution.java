class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-k;
        
        while(start<end){
            int mid = (start+end)>>1;
            if(x-arr[mid] > arr[mid+k]-x){
                start =mid +1;
            }else{
                end = mid;
            }
        }
        return Arrays.stream(arr, start, start+k).boxed().collect(Collectors.toList());
    }
}