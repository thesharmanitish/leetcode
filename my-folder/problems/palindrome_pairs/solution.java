class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String,Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int n = words.length, i=0;
        
        for(String word:words){
            wordMap.put(word, i++);
            if(word.length()!=0)
                set.add(word.length());
        }
        List<List<Integer>> ans = new ArrayList<>();
        i = -1;
        for(String word:words){
            i++;
            int len = word.length();
            if(wordMap.containsKey("")){
                if(word.length() ==1){
                    ans.add(Arrays.asList(wordMap.get(word), wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), wordMap.get(word)));
                    continue; 
                }
                else if(isPalindrome(word, 0 , len-1)){
                    ans.add(Arrays.asList(wordMap.get(word), wordMap.get("")));
                    ans.add(Arrays.asList(wordMap.get(""), wordMap.get(word)));
                }               
            }
            
            String reverse = new StringBuilder(word).reverse().toString();        
            
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != wordMap.get(word)){
                ans.add(Arrays.asList(wordMap.get(word), wordMap.get(reverse)));
            }
            
            for(Integer k:set){
                
                
                if(k == len){
                    // if(k!=0 && wordMap.containsKey("") && isPalindrome(reverse, 0 , len)){
                    //     ans.add(Arrays.asList(wordMap.get(word), wordMap.get("")));
                    //     ans.add(Arrays.asList(wordMap.get(""), wordMap.get(word)));
                    // }
                    break;
                }                  
                if(isPalindrome(reverse,0,len-1-k)){
                    if(wordMap.containsKey(reverse.substring(len-k)))
                        ans.add(Arrays.asList( i, wordMap.get(reverse.substring(len-k))));
                }
                
                if(isPalindrome(reverse,k,len-1)){
                    if(wordMap.containsKey(reverse.substring(0,k)))
                        ans.add(Arrays.asList(wordMap.get(reverse.substring(0,k)), i));                    
                }
            }
            
        }
        
        return ans;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        if(s.length() ==0)
            return false;
        while(left<right)
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        return true;
    }
}
