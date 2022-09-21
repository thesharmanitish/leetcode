class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = Arrays.stream(nums).filter((a)->(a&1)==0).sum();
        // System.out.println(sum);
        int[] res = new int[queries.length];
        int i=0;
        for(int[] query:queries){
            int prev = ((nums[query[1]]&1) ==0? nums[query[1]] : 0);
            nums[query[1]] += query[0];
            // System.out.println(nums[query[1]]);
            sum = sum - prev + ((nums[query[1]] &1)==0?nums[query[1]]:0);
            res[i++] = sum;
        }
       return res; 
    }
}