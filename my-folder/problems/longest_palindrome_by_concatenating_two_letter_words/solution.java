class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> set = new HashMap<>();
        Set<String> s = new HashSet<>();
        boolean pal = false;
        int count = 0;
        for(String word:words){
            String rev = new StringBuilder(word).reverse().toString();
            if(word.equals(rev)){
                pal = true;
                s.add(rev);
            }
            if(set.containsKey(rev)){
                    count+=4;
                    set.put(rev, set.getOrDefault(rev, 0)-1);
                    if(set.get(rev)==0)
                        set.remove(rev);
            }else
                set.put(word, set.getOrDefault(word, 0)+1);
        }
        if(pal){
            for(String x:s)
                if(set.containsKey(x)){
                    count +=2;
                    break;
                }
        }
        return count;
    }
}