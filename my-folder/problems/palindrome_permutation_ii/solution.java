class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> fMap = new HashMap<>();
        
        for(char c:s.toCharArray()){
            fMap.put(c, fMap.getOrDefault(c, 0)+1);
        }
        List<Character> cList = new ArrayList<>();
        Set<String> result =  new HashSet<String>();
        int count = 0;
        Character ind = null;
        
        for(Map.Entry<Character, Integer> entry:fMap.entrySet()){
            
            if(entry.getValue()%2 ==1){    
                count++;
                ind = entry.getKey();
                int x = entry.getValue();
                while(x>1){
                    cList.add(entry.getKey());
                    x-=2;
                }
                    
            }
            else{
                int x = entry.getValue();
                while(x>0){
                    cList.add(entry.getKey());
                    x-=2;
                }                
            }
            if(count>1)
                return new ArrayList<>();
            
            
        }

        getPerm(cList, ind, new boolean[128], new StringBuilder(),  result);
        return result.stream().collect(Collectors.toList());
    }
    
    void getPerm(List<Character> list, Character mid, boolean[] used, StringBuilder sb, Set<String> res) {
    if (sb.length() == list.size()) {
        // form the palindromic string
        if(mid ==null)
            res.add(sb.toString() + sb.reverse().toString());
        else
            res.add(sb.toString() + mid + sb.reverse().toString());
        sb.reverse();
        return;
    }

    for (int i = 0; i < list.size(); i++) {
        // avoid duplication
        if (used[i]) continue;

        used[i] = true; 
        sb.append(list.get(i));
        // recursion
        getPerm(list, mid, used, sb, res);
        // backtracking
        used[i] = false; 
        sb.deleteCharAt(sb.length() - 1);
    }
}
}