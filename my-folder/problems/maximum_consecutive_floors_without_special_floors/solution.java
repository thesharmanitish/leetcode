class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max=0, cur=0, prev=0;
        Arrays.sort(special);
        // Map<Integer, Integer> al = IntStream.of(special).boxed().collect(Collectors.toMap(Function.identity(),i->i));
        prev = bottom;
        int i=0;
        for(i=0;i<special.length;i++){
            cur=special[i]-prev;
            prev = special[i]+1;
            max = Math.max(max, cur);
        }
        max = Math.max(max, top-special[i-1]);
        return max;
    }
}