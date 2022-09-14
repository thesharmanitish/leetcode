class Solution {
    public int minimumOperations(int[] nums) {
        // return (int)Arrays.stream(nums).filter(a -> a > 0).distinct().count();
        Set<Integer> set = new HashSet<>();
        for (int a: nums)
            if (a > 0)
                set.add(a);
        return set.size();
    }
}