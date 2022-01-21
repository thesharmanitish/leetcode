class Solution {
    public List<List<Integer>> fourSum(int[] n, int target) {
			long[] nums = Arrays.stream(n).mapToLong(i -> i).toArray();;
			ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
			int len = nums.length;
			if (nums == null || len < 4)
				return res;

			Arrays.sort(nums);

			long max = nums[len - 1];
			if (4 * nums[0] > target || 4 * max < target)
				return res;

			int i;
			long z;
			for (i = 0; i < len; i++) {
				z = nums[i];
				if (i > 0 && z == nums[i - 1])// avoid duplicate
					continue;
				if (z + 3 * max < target) // z is too small
					continue;
				if (4 * z > target) // z is too large
					break;
				if (4 * z == target) { // z is the boundary
					if (i + 3 < len && nums[i + 3] == z)
						res.add(Arrays.asList((int)z, (int)z, (int)z, (int)z));
					break;
				}

				threeSumForFourSum(nums, target - z, i + 1, len - 1, res, (int)z);
			}

			return res;
		}

		/*
		 * Find all possible distinguished three numbers adding up to the target
		 * in sorted array nums[] between indices low and high. If there are,
		 * add all of them into the ArrayList fourSumList, using
		 * fourSumList.add(Arrays.asList(z1, the three numbers))
		 */
		public void threeSumForFourSum(long[] nums, long target, int low, int high, ArrayList<List<Integer>> fourSumList,
				int z1) {
			if (low + 1 >= high)
				return;
            
			long max = nums[high];
			if (3 * nums[low] > target || 3 * max < target)
				return;

			int i;
			long z;
			for (i = low; i < high - 1; i++) {
				z = nums[i];
				if (i > low && z == nums[i - 1]) // avoid duplicate
					continue;
				if (z + 2 * max < target) // z is too small
					continue;

				if (3 * z > target) // z is too large
					break;

				if (3 * z == target) { // z is the boundary
					if (i + 1 < high && nums[i + 2] == z)
						fourSumList.add(Arrays.asList((int)z1, (int)z, (int)z, (int)z));
					break;
				}

				twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, (int)z);
			}

		}

		/*
		 * Find all possible distinguished two numbers adding up to the target
		 * in sorted array nums[] between indices low and high. If there are,
		 * add all of them into the ArrayList fourSumList, using
		 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
		 */
		public void twoSumForFourSum(long[] nums, long target, int low, int high, ArrayList<List<Integer>> fourSumList,
				int z1, int z2) {

			if (low >= high)
				return;

			if (2 * nums[low] > target || 2 * nums[high] < target)
				return;

			int i = low, j = high;
			long sum, x;
			while (i < j) {
				sum = nums[i] + nums[j];
				if (sum == target) {
					fourSumList.add(Arrays.asList(z1, z2, (int)nums[i], (int)nums[j]));

					x = nums[i];
					while (++i < j && x == nums[i]) // avoid duplicate
						;
					x = nums[j];
					while (i < --j && x == nums[j]) // avoid duplicate
						;
				}
				if (sum < target)
					i++;
				if (sum > target)
					j--;
			}
			return;
		}
	        
	        
	   	     
        
        
        //         Arrays.sort(nums);
//         List<List<Integer>> res = new ArrayList<>();
//         if(nums.length <4)  
//             return res;
        
//         for(int i=0;i<nums.length-3;i++){
            
//             for(int j=i+1;j<nums.length-2;j++){
//                 int temp = nums[i]+nums[j];
//                 int l =nums.length-1;
//                 int k =j+1;
//                 while(k<l){
//                     int sum = nums[i]+nums[j]+ nums[k]+ nums[l];
//                     if( sum == target){
                        
//                         List<Integer> ll = Arrays.asList(new Integer[]{nums[i],nums[j], nums[k], nums[l]});
//                         res.add(ll);
//                     }
//                     else if(sum < target) k++;
//                     else l--;
                    
                    
//                 }
//             }
//         }
//         return res;
//     }
}