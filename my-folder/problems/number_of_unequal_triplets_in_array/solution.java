class Solution {
    /**
    Lets say we have 4 kinds of numbers in m, denote them as a, b, c, d, and their frequency m[a], m[b], m[c], m[d]
    What we want to find is
    m[a] * m[b] * m[c]
    m[a] * m[b] * m[d]
    m[a] * m[c] * m[d]
    m[b] * m[c] * m[d]
    Actually, there are nC3 kinds of combinations we have to consider.
    If you look closer, the above combinations can be reduce as

        left             cnt           right
    (0)                   * m[a] * (m[b] + m[c] + m[d])
    (m[a])                * m[b] * (m[c] + m[d])
    (m[a] + m[b])         * m[c] * (m[d])
    (m[a] + m[b] + m[c])  * m[d] * (0)

    Which is what we want.
 */
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();


        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }
        int start = 0, end = nums.length, res = 0;
        for(int f:freqMap.values()){
            end -= f;
            res += start * f * end;
            start += f;

        }
        return res;
    }
}