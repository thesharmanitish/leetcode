class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int vowelCount =0;
        for(int i=0;i<k;i++){
            vowelCount += isVowel(arr[i])?1:0;
        }
        int start = 0, maxVowels = vowelCount;
        for(int i=k;i<arr.length;i++){
            vowelCount -= isVowel(arr[start++])?1:0;
            vowelCount += isVowel(arr[i])?1:0;
            maxVowels = Math.max(maxVowels, vowelCount);
        }
        return maxVowels;
    }
    
    
    public boolean isVowel(char c){
        return c== 'a' || c=='e' || c== 'i' || c=='o'|| c=='u';
    }
}