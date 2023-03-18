class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n1= 0, n2= 0;
        while(n1<nums1.length && n2 <nums2.length){
            if(nums1[n1]==nums2[n2])
                return nums1[n1];
            else if(nums1[n1]<nums2[n2]){
                n1+=1;
            }
            else n2+=1;
        }
        return -1;
    }
}