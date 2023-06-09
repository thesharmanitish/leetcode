class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() <=0)
            return 0;
        return minimumTotal(triangle, 0, triangle.size(), 0);
    }
    
public int minimumTotal(List<List<Integer>> triangle, int start, int end, int sum) {
        if(start>end)
            return sum;
        int[]  dp = new int[triangle.size()+1];
        for(int j=1;j<=triangle.size();j++)
            dp[j] = triangle.get(triangle.size()-1).get(j-1);
        for(int i=triangle.size()-1;i>0;i--){
            for(int j=1;j<=i;j++){
                dp[j] = triangle.get(i-1).get(j-1) + Math.min(dp[j],dp[j+1]); ;
            }
        }
        
        return dp[1];
    
    }    
// 	public int minimumTotal(List<List<Integer>> triangle) {
// 		if (triangle.size() == 0)
// 			return 0;
// 		if (triangle.size() == 1)
// 			return triangle.get(0).get(0);
// 		int sum = 0;
// 		for (List<Integer> tr : triangle) {
// 			minimumTotal(tr, 0, tr.size() - 1);
// 			sum += tr.get(0);
// 		}
// 		return sum;
// 	}

// 	public void minimumTotal(List<Integer> triangle, int s, int n) {
// 		if (s < n) {
// 			int part = partition(triangle, s, n);
// 			minimumTotal(triangle, s, part - 1);
// 		}
// 	}

// 	public int partition(List<Integer> triangle, int s, int n) {
// 		int i = s, j = n;
// 		int pivot = triangle.get((s + n) / 2);
// 		while (i <= j) {
// 			while (triangle.get(i) < pivot)
// 				i++;
// 			while (triangle.get(j) > pivot)
// 				j--;

// 			if (i <= j) {
// 				int temp = triangle.get(i);
// 				triangle.add(i, triangle.get(j));
// 				triangle.add(j, temp);
// 				i++;
// 				j--;

// 			}

// 		}
// 		return i;

// 	}
}