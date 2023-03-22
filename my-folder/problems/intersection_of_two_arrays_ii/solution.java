class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> res = new ArrayList<>();
        int start1 = 0, start2 = 0;
        while(start1<nums1.length && start2<nums2.length){
            if(nums1[start1]> nums2[start2]){
                start2++;
            }else if(nums1[start1]< nums2[start2]){
                start1++;
            }else{
                res.add(nums1[start1++]);
                start2++;
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
            
    }
}