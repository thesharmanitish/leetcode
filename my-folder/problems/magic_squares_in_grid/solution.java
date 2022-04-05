class Solution {
    	public int numMagicSquaresInside(int[][] grid) {
		int res = 0;
		if (grid == null)
			return 0;
		if (grid.length < 3 || grid[0].length < 3)
			return 0;          
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == 5) {
					res += isMagic(i, j, grid) ? 1 : 0;
				}
			}
		}
		return res;
	}

	public boolean isMagic(int i, int j, int[][] grid) {
		String s = "" + grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1]
				+ grid[i + 1][j] + grid[i + 1][j - 1] + grid[i][j - 1];
		return "4381672943816729".contains(s) || "9276183492761834".contains(s);
	}

//     public int numMagicSquaresInside(int[][] grid) {
// 		if (grid == null)
// 			return 0;
// 		if (grid.length < 3 || grid[0].length < 3)
// 			return 0;
// 		int sum = 0, count = 0;
// 		Set<Integer> set = new HashSet<>(10);

// 		boolean flag = false;
// 		for (int i = 0; i < grid.length - 2; i++) {
// 			for (int j = 0; j < grid[0].length - 2; j++) {

// 				for (int k = i; k <= i + 2 && !flag; k++) {
// 					for (int l = j; l <= j + 2 && !flag; l++) {
// 						if (grid[k][l] <= 0 || grid[k][l] > 9)
// 							flag = true;
// 						set.add(grid[k][l]);
// 					}
// 				}

// 				if (flag) {
// 					flag = false;
// 					set.clear();
// 					continue;
// 				}

// 				if (set.size() != 9) {
// 					set.clear();
// 					continue;
// 				}
					
// 				set.clear();

// 				sum = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];

// 				if (sum == grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1]
// 						&& sum == grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2]
// 						&& sum == grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
// 						&& sum == grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2]
// 						&& sum == grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]
// 						&& sum == grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]
// 						&& sum == grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2])
// 					count++;
// 			}
// 		}
// 		return count;
//     }
	
}