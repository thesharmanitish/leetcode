class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> result = new HashSet<>();
        for(String word:words){
            StringBuilder sb = new StringBuilder();
            for(char c:word.toCharArray()){
                sb.append(codes[c-'a']);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}