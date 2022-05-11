class Solution(object):
    def minimumMountainRemovals(self, A):
        n = len(A)
        dp = [0] * n
        mono = [10**9] * n
        for i in xrange(n):
            j = bisect.bisect_left(mono, A[i])
            mono[j] = A[i]
            dp[i] += j + 1 if j else -n
        mono = [10**9] * n
        for i in xrange(n - 1, -1, -1):
            j = bisect.bisect_left(mono, A[i])
            mono[j] = A[i]
            dp[i] += j if j else -n
        return n - max(dp[1:-1])