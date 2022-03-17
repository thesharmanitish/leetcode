class Solution {
    int max = 0;
    public int maxProfit(int K, int[] prices) {
		if (K == 0 || prices.length == 0) {
			return 0;
		}
		int T[][] = new int[K + 1][prices.length];

		for (int i = 1; i < T.length; i++) {
            max = -prices[0];
			for (int j = 1; j < T[0].length; j++) {
                
                T[i][j] = Math.max(max+prices[j], T[i][j-1]);
                max= Math.max(max,-prices[j]+ T[i-1][j]);
			}
		}
		return T[K][prices.length - 1];
    }
}