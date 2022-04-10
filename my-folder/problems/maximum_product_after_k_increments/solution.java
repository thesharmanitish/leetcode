class Solution {
    public int maximumProduct(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			return o1 - o2;
		});

		for (int i : nums)
			pq.offer(i);

		for (int i = 0; i < k; i++) {
			int t = pq.poll();
			t += 1;
			pq.offer(t);
		}
		int M = 1000000007;
		long res = 1;
		while (!pq.isEmpty()) {
			res = (res*pq.poll())%M;
		}
		return (int)res;
	
    }
}