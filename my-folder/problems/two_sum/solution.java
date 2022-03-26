class Solution {

    public int[] twoSum(int[] arr, int target) {
        
	    Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
	    for(int i=0;i<arr.length;i++){
	        if(map.containsKey(target-arr[i])){
                res[1] = i;
                res[0] = map.get(target - arr[i]);
                return res;
                
            }
            map.put(arr[i],i);
        }
	    return res;
	
    }
}