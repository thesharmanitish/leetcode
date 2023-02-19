class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int num = 1;
        while(set.contains(num)){
            num <<=1;
        }
        return num;
    }
}