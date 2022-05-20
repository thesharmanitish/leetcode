class Solution {
    public int[] frequencySort(int[] nums) {
        
        
       Map<Integer, Long> map =  Arrays.stream(nums).boxed().  collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
       
	return Arrays.stream(nums).boxed()
			.sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a).intValue()  - map.get(b).intValue()  : b - a)
			.mapToInt(n -> n)
			.toArray();
        
    }
}