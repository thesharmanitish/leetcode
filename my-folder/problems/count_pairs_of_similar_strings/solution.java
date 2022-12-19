class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> set = new HashMap<>();
        int n= words.length, count = 0;
        for(String word:words){
            int i=0;
            for(char c:word.toCharArray()){
                i = i| 1<<(c-'0');
            }
            set.put(i, set.getOrDefault(i, 0)+1);
        }

        for(int val:set.values())
            count = count + val*(val-1)/2;
        return count;
    }
}