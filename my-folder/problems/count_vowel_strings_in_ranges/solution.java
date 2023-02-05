class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] isVowel = new int[words.length];
        int i= 0 ;
        for(String word:words){
            // 
            if(isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1)))
                isVowel[i] = 1;
            if(i!=0)
            isVowel[i] += isVowel[i-1];
            i++;
        }
        int[] res = new int[queries.length];
        i = 0;
        for(int[] query:queries)    {
            res[i++] = isVowel[query[1]] - (query[0]>0?isVowel[query[0]-1]:0);
        }
        return res;
    }
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u') && (c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u');
    }
}