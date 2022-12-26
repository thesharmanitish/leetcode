class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        Arrays.sort(nums);
        for( int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        for(int i=0;i<queries.length;i++){
            if(queries[i]<nums[0])
                queries[i] = 0;
            else if(queries[i] == nums[0]) 
                queries[i] = 1;
            else{
                int ind = Arrays.binarySearch(nums, queries[i]);
                if(ind<0)
                    queries[i] = -ind-1;
                else
                    queries[i] = ind+1;
            }
        }

        return queries;
    }

}