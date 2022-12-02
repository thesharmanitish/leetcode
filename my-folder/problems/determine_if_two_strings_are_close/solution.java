class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;

        int[] freq = new int[26];
        int[] freqB = new int[26];
        for(char c:word1.toCharArray())
            freq[c-'a'] +=1;

        for(char c:word2.toCharArray())
            freqB[c-'a'] +=1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<26;i++){
            if((freqB[i] ==0 && freq[i]>0 )|| (freq[i] ==0 && freqB[i]>0 ))
                return false;
            if(freq[i]!=0)
                map.put(freq[i], map.getOrDefault(freq[i],0)+1);

            if(freqB[i]!=0)
                map.put(freqB[i], map.getOrDefault(freqB[i],0)-1);
            if(map.getOrDefault(freq[i], 0 ) ==0)
                map.remove(freq[i]);
            if(map.getOrDefault(freqB[i], 0) ==0)
                map.remove(freqB[i]);
        }
        for(int v:map.values()){
            if(v!=0)
                return false;
        }

        return true;
    }
}