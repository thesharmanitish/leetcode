class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i]))
                res[i] = map.get(nums1[i]);
        }
        return res;
    }
    //  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int[] res = new int[nums1.length];
    //     int j;

    //     Arrays.fill(res, -1);

    //     Map<Integer, Integer> map = new HashMap<>();
    //     for(int i=0;i<nums2.length;i++)
    //         map.put(nums2[i],i);

    //     for (int i = 0; i < nums1.length; i++) {
    //         if(!map.containsKey(nums1[i]))
    //             continue;
    //         for (j = map.get(nums1[i]); j < nums2.length; j++) {
    //             if (nums2[j] > nums1[i]) {
    //                 res[i] = nums2[j];
    //                 break;
    //             }
    
    //         }
    //     }
    
    //     return res;
    // }
}