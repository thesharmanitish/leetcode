class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set =  new HashSet<>();
        int min = Integer.MAX_VALUE;
        int x= min, y = min;
        for(int num:nums1){
            x = Math.min(x, num);
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num))
                min =  Math.min(min, num);
            y = Math.min(y, num);
        }
        if(x == y)
            return x;
        int res = Math.max(x,y)+ 10*  Math.min(x,y);
        return Math.min(res,min);
    }
}