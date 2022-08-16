class Solution {
    public boolean isValid(String s) {
  // O(mn)
        Stack<Character> q = new Stack<>();
        Map<Character, Character> symbolMap =  new HashMap<>();
        symbolMap.put(')', '(');
        symbolMap.put('}', '{');
        symbolMap.put(']', '[');
        for(char ch:s.toCharArray()){  // O(n) n= length of String
            if(!symbolMap.containsKey(ch)) // O(m) m = size of stack
                q.push(ch);
            else{
                if(q.isEmpty()|| q.pop()!=symbolMap.get(ch))
                    return false;
            }
        }
        return q.isEmpty();
    }
}