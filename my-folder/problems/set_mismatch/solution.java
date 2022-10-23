class Solution {
//     public int[] findErrorNums(int[] nums) {
//         boolean[] visited = new boolean[10001];
//         int first = 0, second =0;
//         for(int i=0;i<nums.length;i++){
//             if(visited[nums[i]])
//                 first = nums[i];
//             visited[nums[i]] = true;
//         }
//         for(int i=1;i<10001;i++)
//             if(!visited[i])
//                 return new int[]{first, i};
//         return new int[]{0,0};
        
//     }
    
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }
    
//     public int[] findErrorNums(int[] nums) {
//         /** Assume m is the missing and d is the duplicate element
//          diff= m-d;
//          squareDiff= m^2-d^2;
//          sum=m+d= squareDiff/diff
//          =>sum    = (m+d)(m-d)/(m-d);
//          now m=(sum+diff)2;
//          and d= (sum-diff)2;
//         **/
//         int diff=0;
//         int sqaureDiff=0;
//         for(int i=0;i<nums.length;i++){
//             /** 
//             The order doesnot matter. keep adding the 1 to n and simultaneously subracting  corresponding array element.
//             Use i+1 to get 1 to n  since i is the index number which is zero based.
//             **/
//             diff+=(i+1)-nums[i];
//             /** squareDiff is also calculated in the same way as diff is calculated. **/
//             sqaureDiff+= (i+1)*(i+1)-nums[i]*nums[i];
//         } 
//        int sum=sqaureDiff/diff;
//       return new int[]{(sum-diff)/2,(sum+diff)/2};
//     }    
}