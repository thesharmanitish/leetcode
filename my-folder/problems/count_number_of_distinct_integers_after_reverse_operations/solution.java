class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
            String str = String.valueOf(num);
            String rev = "";
            for(int i = str.length() - 1; i >= 0; i--) 
             { 
                rev = rev + str.charAt(i); 
             } 
            set.add(Integer.parseInt(rev));
        }
        return set.size();
    }
}